package com.metersbonwe.stock.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.ExceptionConstants;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.PageThreadLocal;
import com.metersbonwe.stock.utils.CommonUtil;
import com.metersbonwe.stock.utils.DateTimeConverter;
import com.metersbonwe.stock.utils.ReflectUtil;
import com.metersbonwe.stock.utils.imexcel.ImportExportDataUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

/**
 * TODO controller 层通用方法
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年4月5日 下午2:57:00
 * @since V1.0
 * @version V1.0
 */
public class BaseController {

    public static final JsonConfig jsonConfig = new JsonConfig();

    static {
        ConvertUtils.register(new DateTimeConverter(), java.util.Date.class);
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new JsonDateValueProcessor());
        jsonConfig.registerJsonValueProcessor(Timestamp.class, new JsonDateValueProcessor());
        jsonConfig.registerJsonValueProcessor(TIMESTAMPLTZ.class, new JsonDateValueProcessor());
        jsonConfig.registerJsonValueProcessor(TIMESTAMP.class, new JsonDateValueProcessor());
        jsonConfig.registerJsonValueProcessor(TIMESTAMPTZ.class, new JsonDateValueProcessor());
    }

    @Resource MultiTableService multiTableServiceImpl;

    /**
     * TODO 组装查询入参
     * 
     * @param request
     * @return
     */
    protected Map<String, String> assembleSelectParam(HttpServletRequest request) {
        Map<String, String> paraMap = new ConcurrentHashMap<>();
        paraMap = assembleRequestParam(request);
        String isCollSearch = paraMap.get("_search");
        String multipleSearchStr = paraMap.get("filters");
        // 如果不是条件查询则直接返回
        if (!Boolean.valueOf(isCollSearch)) {
            return paraMap;
        }
        if (StringUtils.isNotBlank(multipleSearchStr)) {
            com.alibaba.fastjson.JSONObject multipleJson = com.alibaba.fastjson.JSONObject
                    .parseObject(multipleSearchStr, com.alibaba.fastjson.JSONObject.class);
            List<JSONObject> multipleSubJsons = JSON.parseArray(multipleJson.get("rules").toString(), JSONObject.class);
            for (JSONObject jsonObject : multipleSubJsons) {
                String op = jsonObject.get("op").toString();
                String field = jsonObject.get("field").toString();
                if ("ew".equals(op)) { //结束时间
                    field = "end" + field;
                }
                try {
                    paraMap.put(field, URLDecoder.decode(jsonObject.get("data").toString(), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                //paraMap.put(field, jsonObject.get("data").toString());
            }
        }
        return paraMap;
    }

    /**
     * TODO 组装允许一个key多个参数的查询
     * 
     * @param paraMap
     * @return
     */
    protected Map<String, List<String>> assembleSelectListParam(Map<String, String> paraMap) {
        Map<String, List<String>> paraListMap = new ConcurrentHashMap<>();
        List<String> multipleList = new ArrayList<>();
        for (Entry<String, String> entry : paraMap.entrySet()) {
            List<String> list = new ArrayList<>();
            String key = entry.getKey();
            String value = entry.getValue();
            if (StringUtils.isBlank(value)) {
                continue;
            }
            if (value.contains(",")) {
                multipleList.add(key);
                String[] values = value.split(",");
                for (String data : values) {
                    list.add(data.trim());
                }
            } else {
                list.add(value.trim());
            }
            paraListMap.put(key, list);
        }
        if (multipleList.size() > 0) {
            paraListMap.put(Constants.MULTIPLE_FLAG, multipleList);
        }
        return paraListMap;
    }

    /**
     * TODO 组装非查询入参
     * 
     * @param request
     * @return
     */
    @SuppressWarnings({ "unchecked" })
    protected Map<String, String> assembleUnSelectParam(HttpServletRequest request) {
        Map<String, String> paraMap = new ConcurrentHashMap<>();
        Enumeration<String> eles = request.getParameterNames();
        while (eles.hasMoreElements()) {
            //String key = eles.nextElement();
            String key = null;
            try {
                key = URLDecoder.decode(eles.nextElement(), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            paraMap.putAll(JSON.parseObject(key, HashMap.class));
        }
        return paraMap;
    }

    /**
     * TODO 组装Request参数
     * 
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    protected Map<String, String> assembleRequestParam(HttpServletRequest request) {
        Map<String, String> paraMap = new ConcurrentHashMap<>();
        Enumeration<String> eles = request.getParameterNames();
        while (eles.hasMoreElements()) {
            String key = eles.nextElement();
            paraMap.put(key, request.getParameter(key));
        }
        return paraMap;
    }

    /**
     * TODO 组装查询时返回结果格式
     * 
     * @param obj
     * @param page
     * @return
     */
    protected String assembleSelectResult(Object obj, Page<?> page) {
        JSONObject resultObj = new JSONObject();
        JSONObject innerObj = new JSONObject();
        innerObj.put("totalPages", page == null ? 1 : page.getTotalPage());
        innerObj.put("totalElements", page == null ? 0 : page.getTotalRecord());
        innerObj.put("size", page == null ? 0 : page.getPageSize());
        if (obj != null && obj instanceof Collection) {
            innerObj.put("content", JSONArray.fromObject(obj, jsonConfig));
        } else {
            innerObj.put("content", JSONObject.fromObject(obj, jsonConfig));
        }
        resultObj.put("message", innerObj);
        return resultObj.toString();
    }

    protected String assembleSelectResult(Object obj) {
        return assembleSelectResult(obj, null);
    }

    /**
     * TODO 组装非查询时返回结果格式
     * 
     * @param obj
     * @param page
     * @return
     */
    protected String assembleUnSelectResult(int succCount) {
        return assembleUnSelectResult(succCount, null);
    }

    /**
     * TODO 组装非查询时返回结果格式
     *
     * @param succCount
     *            成功操作的数据量（大于0说明成功）
     * @param code
     *            返回给前台的消息CODE
     * @return
     */
    protected String assembleUnSelectResult(int succCount, String code) {
        JSONObject resultObj = new JSONObject();
        if (succCount > 0) {
            resultObj.put("status", "success");
            resultObj.put("message", code != null ? code : ExceptionConstants.SUCCESS_MESSAGE);
        } else {
            resultObj.put("status", "error");
            resultObj.put("message", code == null ? ExceptionConstants.ERROR_MESSAGE : code);
        }
        return resultObj.toString();
    }

    /**
     * TODO 组装非查询时返回结果格式
     *
     * @param code
     *            成功失败标识 ExceptionConstants.SUCCESS_CODE ExceptionConstants.ERROR_CODE
     * @param message
     *            返回给前台的消息文本
     * @return
     */
    protected String assembleUnSelectResult(String code, String message) {
        JSONObject resultObj = new JSONObject();
        if (ExceptionConstants.SUCCESS_CODE.equals(code)) {
            resultObj.put("status", ExceptionConstants.SUCCESS_CODE);
            resultObj.put("message", message != null ? message : ExceptionConstants.SUCCESS_MESSAGE);
        } else {
            resultObj.put("status", ExceptionConstants.ERROR_CODE);
            resultObj.put("message", message != null ? message : ExceptionConstants.ERROR_MESSAGE);
        }
        return resultObj.toString();
    }

    /**
     * TODO 组装非查询时返回结果格式
     *
     * @param messgae
     *            返回给前台的成功时提示的消息
     * @return
     */
    protected String assembleUnSelectResult(String message) {
        JSONObject resultObj = new JSONObject();
        resultObj.put("status", "success");
        resultObj.put("message", message);
        return resultObj.toString();
    }

    /**
     * TODO 组装分页查询
     * 
     * @param request
     * @return
     */
    protected Page<?> assemblePageSelect(Map<String, String> paraMap) {
        String pageNo = paraMap.get(Constants.PAGE_OBJECT);
        String rows = paraMap.get(Constants.ROWS_OBJECT);
        return assemblePageSelect(pageNo, rows);
    }

    protected Page<?> assemblePageSelect(Integer pageNo, Integer rows) {
        Page<?> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(rows);
        PageThreadLocal.setThreadLocalPage(page);
        return page;
    }

    protected Page<?> assemblePageSelect(String pageNo, String rows) {
        return assemblePageSelect(CommonUtil.toInt(pageNo), CommonUtil.toInt(rows));
    }

    /**
     * TODO 文件上传，获取所有上传的文件对象 (多个文件)
     * 
     * @param request
     * @return
     * @throws Exception
     */
    protected List<File> fileUploadList(HttpServletRequest request) throws Exception {
        List<File> files = new ArrayList<>();
        MultipartHttpServletRequest muRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> multipartFiles = muRequest.getFiles(Constants.FILE_UPLOAD_FLAG);
        if (CollectionUtils.isNotEmpty(multipartFiles)) {
            for (MultipartFile multipartFile : multipartFiles) {
                if (multipartFiles.isEmpty()) {
                    continue;
                }
                CommonsMultipartFile mfile = (CommonsMultipartFile) multipartFile;
                DiskFileItem diskFile = (DiskFileItem) mfile.getFileItem();
                File file = diskFile.getStoreLocation();
                diskFile.write(file);
                files.add(file);
            }
        }
        return files;
    }

    /**
     * TODO 文件上传，获取所有上传的文件对象 (单个文件)
     * 
     * @param request
     * @return
     * @throws Exception
     */
    protected File fileUploadSingle(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest muRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = muRequest.getFile(Constants.FILE_UPLOAD_FLAG);
        if (multipartFile.isEmpty()) {
            return null;
        }
        CommonsMultipartFile mfile = (CommonsMultipartFile) multipartFile;
        DiskFileItem diskFile = (DiskFileItem) mfile.getFileItem();
        File file = diskFile.getStoreLocation();
        diskFile.write(file);
        return file;
    }

    /**
     * TODO 文件下载
     * 
     * @param fileName
     *            文件名
     * @param fileContext
     *            如果为空说明没有数据 文件内容 eg: aaa,bbb,ccc \n 111,222,333 \n
     * @param response
     * @throws IOException
     */
    protected void fileDownload(String fileName, String fileContext, HttpServletResponse response) throws IOException {
        fileDownload(fileName, fileContext, response, true);
    }

    /**
     * 文件下载
     *
     * @param fileName
     *            文件名
     * @param fileContext
     *            如果为空说明没有数据 文件内容 eg: aaa,bbb,ccc \n 111,222,333 \n
     * @param response
     *            response
     * @param flushFlg
     *            下载的文件是否结束标识
     * @throws IOException
     */
    protected void fileDownload(String fileName, String fileContext, HttpServletResponse response, boolean flushFlg) throws IOException {
        if (StringUtils.isBlank(fileContext)) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().write("<script>alert('查询不到需要下载的数据！');window.history.go(-1);</script>");
        } else {
            response.setCharacterEncoding("gbk");
            response.setContentType("application/vnd.ms-excel;charset=gbk");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes(), "ISO-8859-1") + ".csv");
            response.getWriter().write(fileContext);
        }
        if (flushFlg) {
            response.getWriter().flush();
        }
    }

    /**
     * TODO 文件下载时将对象转换成string 方便下载
     * 
     * @param objects
     * @param clazz
     * @return
     */
    protected String converFileDownStr(List<Object> objs, Map<String, String> titalMap) {
        StringBuffer buffer = new StringBuffer();
        for (Entry<String, String> entry : titalMap.entrySet()) {
            buffer.append(entry.getValue()).append(",");
        }
        buffer.append("\n");
        for (Object obj : objs) {
            for (Entry<String, String> entry : titalMap.entrySet()) {
                Object obja = ReflectUtil.getFieldValue(obj, entry.getKey());
                buffer.append(obja).append(",");
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }

    /**
     * TODO 获取分表的最大表数据量的集合 （表后缀）
     * 
     * @return
     */
    protected List<String> getMaxTableSeqs() {
        List<String> seqs = new ArrayList<>();
        int maxTableSeq = multiTableServiceImpl.getMaxTableSeq();
        for (int i = 0; i <= maxTableSeq; i++) {
            seqs.add(multiTableServiceImpl.getMappingSuffix(i));
        }
        return seqs;
    }

    protected void getDownFileTempLate(HttpServletResponse response, Class<?> clazz) {
        try {
            String firstLine = ImportExportDataUtil.getExportTempleter(clazz, null);
            fileDownload(clazz.getSimpleName(), firstLine, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
