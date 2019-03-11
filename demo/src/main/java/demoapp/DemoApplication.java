package demoapp;

import demoapp.common.ExcelPlugin.ExcelDataCalUtil;
import demoapp.service.MultiTheadService;
import demoapp.service.TestLocalThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DemoApplication
{
    //private ThreadLocal<Objn            cccnx         ect> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class,args);
            //new ExcelDataCalUtil().getJsonDataFromExcel("E:\\余培\\javaLearn\\bbb.xls",0,0,1,null);
System.out.println(
            new ExcelDataCalUtil().getObjectByExcelData(
                    "E:\\余培\\javaLearn\\bbb.xls",
                    0,
                    0,
                    1,
                    null,
                    "[\"key1\",\"key2\",\"key3\",\"key4\",\"key5\",\"key6\"]")
            );
    }

}
