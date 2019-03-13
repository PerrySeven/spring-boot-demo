package demoapp;

import demoapp.common.ExcelPlugin.ExcelDataCalUtil;
import demoapp.common.ExcelPlugin.ReturnModel;

public class DemoApplication
{
    //private ThreadLocal<Objn            cccnx         ect> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ReturnModel returnModel = new ReturnModel();
        //SpringApplication.run(DemoApplication.class,args);
            //new ExcelDataCalUtil().getJsonDataFromExcel("E:\\余培\\javaLearn\\bbb.xls",0,0,1,null);
System.out.println(
            new ExcelDataCalUtil().getObjectByClassAndData(
                    "E:\\余培\\javaLearn\\bbb.xls",
                    0,
                    0,
                    1,
                    null,
                    returnModel)
            );
    }

}
