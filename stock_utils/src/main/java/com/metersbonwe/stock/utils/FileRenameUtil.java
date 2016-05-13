package com.metersbonwe.stock.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * 文件操作，修改文件名 和文件里面某些字段 部分字段和路径自行修改
 * @author Feng
 */
public class FileRenameUtil {
    public static void fileRename() throws IOException {
        String fileDir = "C:/workspace_two/unitstock/unitstock-dao/src/main/java/com/mtsbw/stock/dao/mapper/mysql/stockread";
        String fileDir1 = "C:/workspace_two/unitstock/unitstock-dao/src/main/resources/com/mtsbw/stock/dao/mapper/mysql/stockread";
        File files = new File(fileDir);
        if (files.isDirectory()) {
            File[] files2 = files.listFiles();
            for (File file : files2) {
                String name = file.getName();
                String[] names = name.split("[.]");
                String aname = names[0];
                String bakAname = aname;
                aname = aname.replaceAll("Mapper", "ReadMapper");
                String string = FileUtils.readFileToString(file);
                string = string.replaceAll(bakAname, aname);
                FileUtils.writeStringToFile(file, string);
                file.renameTo(new File(file.getAbsolutePath().replace(bakAname, aname)));
            }
        }

        File files1 = new File(fileDir1);
        if (files1.isDirectory()) {
            File[] files2 = files1.listFiles();
            for (File file : files2) {
                String name = file.getName();
                String[] names = name.split("[.]");
                String aname = names[0];
                String bakAname = aname;
                aname = aname.replaceAll("Mapper", "ReadMapper");
                String string = FileUtils.readFileToString(file);
                string = string.replaceAll(bakAname, aname);
                FileUtils.writeStringToFile(file, string);
                file.renameTo(new File(file.getAbsolutePath().replace(bakAname, aname)));
            }
        }
    }

    public static void creatFile(String filePath) throws IOException {
        String serverPath = "C:/workspace_two/unitstock/unitstock-provider/src/main/java/com/mtsbw/stock/provide/umpcache/";
        String serverImplPath = "C:/workspace_two/unitstock/unitstock-provider/src/main/java/com/mtsbw/stock/provide/umpcache/impl/";
        String beginInfo = "unit_stock$$unit_stock_";
        String endInfo = "={\"cachetype\":\"REDIS\",\"cacheaddress\":\"10.100.200.41:6379\"}$${\"cachetimeout\":60,\"remoteaccess\":true,\"remotetype\":\"DUBBO\"}";
        String endInfo2 = "={\"zookeeper\":\"10.100.200.11:2181,10.100.200.12:2181,10.100.200.13:2181\",\"service\":\"com.banggo.stockcenter.service.CacheFor"; 
        String endInfo3 = "Service\",\"group\":\"unitestock_test\",\"methods\":\"getData$$getDatas\"}";
        File file = new File(filePath);
        List<String> strs = FileUtils.readLines(file);
        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer1 = new StringBuffer();
        for (String str : strs) {
            buffer.append(beginInfo).append(str).append(endInfo).append("\n");
            buffer1.append(beginInfo).append(str).append(endInfo2).append(CamelUtil.beCamel(str, true)).append(endInfo3).append("\n");
            
            StringBuffer buffer2 = new StringBuffer();
            buffer2.append("package com.mtsbw.stock.provide.umpcache;").append("\n").append("import java.util.List;").append("\n").append("import com.mtsbw.stock.provide.exception.CacheServiceException;").append("\n");
            buffer2.append("public interface CacheFor").append(CamelUtil.beCamel(str, true)).append("Service {").append("\n");
            buffer2.append("String getData(String key) throws CacheServiceException;").append("\n").append("String getDatas(List<String> keys) throws CacheServiceException;").append("\n").append("}");
            File toFilebuffer2 = new File(serverPath+"CacheFor"+CamelUtil.beCamel(str, true)+"Service.java");
            FileUtils.writeStringToFile(toFilebuffer2, buffer2.toString());
            
            StringBuffer buffer3 = new StringBuffer();
            buffer3.append("package com.mtsbw.stock.provide.umpcache.impl;").append("\n").append("import java.util.List;").append("\n").append("import com.mtsbw.stock.provide.exception.CacheServiceException;").append("\n");
            buffer3.append("import java.util.ArrayList;").append("\n").append("import org.slf4j.Logger;").append("\n").append("import org.slf4j.LoggerFactory;").append("\n").append("import com.mtsbw.stock.provide.umpcache.CacheServiceBase;").append("\n");
            buffer3.append("import com.mtsbw.stock.provide.umpcache.CacheFor").append(CamelUtil.beCamel(str, true)).append("Service;").append("\n");
            buffer3.append("import com.alibaba.dubbo.config.annotation.Service;").append("\n").append("import org.springframework.stereotype.Component;").append("\n");
            buffer3.append("import com.mtsbw.stock.common.Constant;").append("\n");
            buffer3.append("@Component").append("\n");
            buffer3.append("@Service(version=Constant.DUBBO_VERSION)").append("\n");
            buffer3.append("public class CacheFor").append(CamelUtil.beCamel(str, true)).append("ServiceImpl extends CacheServiceBase implements CacheFor").append(CamelUtil.beCamel(str, true)).append("Service {").append("\n");
            buffer3.append("private static final Logger LOGGER = LoggerFactory.getLogger(CacheFor").append(CamelUtil.beCamel(str, true)).append("ServiceImpl.class);").append("\n");
            buffer3.append("// 当前服务对应的表名").append("\n");
            buffer3.append("private String tableName = \"").append(str).append("\";").append("\n");
            buffer3.append("@Override").append("\n");
            buffer3.append("public String getData(String key) throws CacheServiceException {").append("\n");
            buffer3.append("List<String> keys = new ArrayList<String>(1);").append("\n");
            buffer3.append("keys.add(key);").append("\n");
            buffer3.append("return getDatas(keys);").append("\n");
            buffer3.append("}").append("\n");
            buffer3.append("@Override").append("\n");
            buffer3.append("public String getDatas(List<String> keys) throws CacheServiceException {").append("\n");
            buffer3.append("String resultData = getReturnDatas(keys, tableName);").append("\n");
            buffer3.append("LOGGER.info(\"表名:{},入参:{},出参:{}\", tableName, keys, resultData);").append("\n");
            buffer3.append("return resultData;").append("\n");
            buffer3.append("}").append("\n");
            buffer3.append("}").append("\n");
            
            File toFilebuffer3 = new File(serverImplPath+"CacheFor"+CamelUtil.beCamel(str, true)+"ServiceImpl.java");
            FileUtils.writeStringToFile(toFilebuffer3, buffer3.toString());
        }
        File toFile = new File(filePath.replace("-.txt", "/business.properties"));
        FileUtils.writeStringToFile(toFile, buffer.toString());
        File toFile1 = new File(filePath.replace("-.txt", "/key_dubbo.properties"));
        FileUtils.writeStringToFile(toFile1, buffer1.toString());
        
    }

    public static void main(String[] args) throws IOException {
    }

    public static void installScUmpCacheInfo() throws IOException {
        String fileDir = "C:/Users/Feng/Desktop/oracle-.txt";
        File file = new File(fileDir);
        String instStr = "insert into sc_ump_cache_info (BUSINESS_CODE,BUSINESS_TYPE,BUSINESS_TYPE_FLAG,TABLE_NAME,DATA_SOURCE,DATA_DICTIONARY) values (";
        List<String> strings = FileUtils.readLines(file);
        int index = 0;
        StringBuffer buffer = new StringBuffer();
        String dataSour = "ORACLE_STOCK";
        for (String string : strings) {
            if (index > 29) {
                dataSour = "MYSQL_STOCK_READ";
            }
            buffer.append(instStr).append("'unit_stock',").append("'unit_stock_").append(string).append("','','").append(string).append("','").append(dataSour).append("','ump');").append("\n");
            index++;
        }
        System.out.println(buffer.toString());
    }
}
