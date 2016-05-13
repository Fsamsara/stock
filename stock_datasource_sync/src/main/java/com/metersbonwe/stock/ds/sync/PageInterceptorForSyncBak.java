package com.metersbonwe.stock.ds.sync;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMapping.Builder;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.PageThreadLocal;
import com.metersbonwe.stock.utils.BeanUtil;
import com.metersbonwe.stock.utils.ReflectUtil;

/**
 * 分页拦截器
 * 
 * @author zhangfeng
 */
@Intercepts({ @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class }) }) public class PageInterceptorForSyncBak
        implements Interceptor {
    private final static StockLog LOGGER = StockLogFactory.getLogger(PageInterceptorForSyncBak.class);

    /**
     * 拦截后要执行的方法
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Page<?> page = PageThreadLocal.getThreadLocalPage();
        if (page == null) {
            return invocation.proceed();
        }
        PageThreadLocal.removeThreadLocalPage();
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
        // 通过反射获取到当前RoutingStatementHandler对象的delegate属性
        StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(handler, "delegate");
        BoundSql boundSql = delegate.getBoundSql();
        MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(delegate, "mappedStatement");
        // 获取当前要执行的Sql语句，也就是我们直接在Mapper映射语句中写的Sql语句
        String sql = boundSql.getSql();
        // 是否查询总页数和总数据 默认为TRUE
        if (page.getTotalFlag()) {
            // 给当前的page参数对象设置总记录数
            this.setTotalRecord(page, mappedStatement, boundSql, sql);
        }

        Configuration configuration = (Configuration) ReflectUtil.getFieldValue(mappedStatement, "configuration");

        Object parameterObject = boundSql.getParameterObject();
        Map<String, Object> params;
        if (parameterObject == null) {
            params = new HashMap<String, Object>();
        } else {
            if (parameterObject instanceof Map) {
                params = (Map<String, Object>) boundSql.getParameterObject();
            } else {
                params = BeanUtil.transBean2Map(parameterObject);
            }
        }
        ReflectUtil.setFieldValue(delegate, "parameterHandler", configuration.newParameterHandler(mappedStatement, params, boundSql));

        String pageSql = this.getPageSql(sql, page, params);
        // 利用反射设置当前BoundSql对应的sql属性为我们建立好的分页Sql语句
        ReflectUtil.setFieldValue(boundSql, "sql", pageSql);

        List<ParameterMapping> originMappings = boundSql.getParameterMappings();
        List<ParameterMapping> mappings = new ArrayList<ParameterMapping>();
        if (originMappings != null && !originMappings.isEmpty()) {
            mappings.addAll(originMappings);
        }
        ParameterMapping start = new Builder(configuration, "page_p1", Integer.class).build();
        ParameterMapping pageSize = new Builder(configuration, "page_p2", Integer.class).build();
        mappings.add(start);
        mappings.add(pageSize);

        ReflectUtil.setFieldValue(boundSql, "parameterObject", params);
        ReflectUtil.setFieldValue(boundSql, "parameterMappings", mappings);

        return invocation.proceed();
    }

    /**
     * 拦截器对应的封装原始对象的方法
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * 设置注册拦截器时设定的属性
     */
    @Override
    public void setProperties(Properties properties) {}

    /**
     * 根据page对象获取对应的分页查询Sql语句，这里只做了两种数据库类型，Mysql和Oracle 其它的数据库都 没有进行分页
     * 
     * @param page
     *            分页对象
     * @param sql
     *            原sql语句
     * @return
     */
    private String getPageSql(String sql, Page<?> page, Map<String, Object> params) {
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(sql);
        String sqlPre = "select * from (select u.*, rownum r from (";
        params.put("page_p1", (page.getPageNo()) * page.getPageSize());
        params.put("page_p2", (page.getPageNo() - 1) * page.getPageSize());
        sqlBuffer.insert(0, sqlPre).append(" ) u where rownum <= ?) where r >?");
        return sqlBuffer.toString();
    }

    /**
     * 给当前的参数对象page设置总记录数
     * 
     * @param page
     * @param mappedStatement
     * @param boundSql
     */
    private void setTotalRecord(Page<?> page, MappedStatement mappedStatement, BoundSql boundSql, String sql) {
        String countSql = this.getCountSql(sql);
        // 通过BoundSql获取对应的参数映射
        ReflectUtil.setFieldValue(boundSql, "sql", countSql);
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), boundSql);
        // 通过connection建立一个countSql对应的PreparedStatement对象。
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
            pstmt = connection.prepareStatement(countSql);
            // 通过parameterHandler给PreparedStatement对象设置参数
            parameterHandler.setParameters(pstmt);
            // 之后就是执行获取总记录数的Sql语句和获取结果了。
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int totalRecord = rs.getInt(1);
                // 给当前的参数page对象设置总记录数
                page.setTotalRecord(totalRecord);
            }
        } catch (SQLException e) {
            LOGGER.error("set total count error, sql is: " + countSql, e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                LOGGER.error("set total count error", e);
            }
        }
    }

    /**
     * 根据原Sql语句获取对应的查询总记录数的Sql语句
     * 
     * @param sql
     * @return
     */
    private String getCountSql(String sql) {
        StringBuffer buffer = new StringBuffer("select count(*) from (");
        buffer.append(sql).append(") cnt ");
        return buffer.toString();
    }
}
