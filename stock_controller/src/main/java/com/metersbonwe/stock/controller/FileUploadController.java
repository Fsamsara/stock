package com.metersbonwe.stock.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metersbonwe.stock.FileConstants;

@Controller public class FileUploadController extends BaseController {

    @ResponseBody
    @RequestMapping(value = "/getFileUploadTempLate")
    public void getFileUploadTempLate(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map<String, String> paraMap = assembleRequestParam(request);
            StringBuffer firstLine = new StringBuffer();
            //预售明细模板下载
            if (FileConstants.Template.PRESALEDETAIL.equalsIgnoreCase(paraMap.get(FileConstants.TEMPLATE_FLAG))) {
                for (@SuppressWarnings("rawtypes")
                Map.Entry entry : FileConstants.TEMPLATE_MAP.get(FileConstants.Template.PRESALEDETAIL).entrySet()) {
                    firstLine.append(entry.getValue()).append(",");
                }
                fileDownload(FileConstants.Template.PRESALEDETAIL, firstLine.substring(0, firstLine.length() - 1), response);
            }
            // 污损值文件上传模板下载
            if (FileConstants.Template.SHOPDAMEDETAIL.equalsIgnoreCase(paraMap.get(FileConstants.TEMPLATE_FLAG))) {
                for (@SuppressWarnings("rawtypes")
                Map.Entry entry : FileConstants.TEMPLATE_MAP.get(FileConstants.Template.SHOPDAMEDETAIL).entrySet()) {
                    firstLine.append(entry.getValue()).append(",");
                }
                fileDownload(FileConstants.Template.SHOPDAMEDETAIL, firstLine.substring(0, firstLine.length() - 1), response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
