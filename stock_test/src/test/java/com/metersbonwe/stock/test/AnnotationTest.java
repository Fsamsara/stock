package com.metersbonwe.stock.test;

import java.util.ArrayList;
import java.util.List;

import com.metersbonwe.stock.pojo.imexcel.CompanyBean;
import com.metersbonwe.stock.utils.imexcel.ImportExportDataUtil;

public class AnnotationTest {

    public static void main(String[] args) {
        List<String> fileStrs = new ArrayList<String>();
        fileStrs.add("公司ID,公司编码,公司名称,序号,是否男性,创建时间");
        fileStrs.add("1,0001,美特斯邦威,1,true,2016-04-20 12:00:00");
        fileStrs.add("2,0002,华邦科创,2,false,2016-04-20 12:00:00");
        List<CompanyBean> list = ImportExportDataUtil.getImportData(fileStrs, CompanyBean.class);
        System.out.println("导入记录数:");
        System.out.println(list.size());
        String headers = ImportExportDataUtil.getExportTempleter(CompanyBean.class, null);
        System.out.println("导出模板:");
        System.out.println(headers);
        String s = ImportExportDataUtil.getExportData(list, CompanyBean.class);
        System.out.println("导出数据:");
        System.out.println(s);
    }
}
