package demoapp;

import com.alibaba.fastjson.parser.JSONReaderScanner;
import demoapp.common.ExcelPlugin.ExcelDataCalUtil;
import demoapp.common.ExcelPlugin.ReturnModel;
import demoapp.entity.ConfigMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import com.alibaba.fastjson.*;

@EnableSwagger2
@SpringBootApplication
public class DemoApplication
{
    //private ThreadLocal<Objn            cccnx         ect> threadLocal = new ThreadLocal<>();

public static Object getJsonObject()
{
    JSONReader reader = null;
    try {
        reader = new JSONReader(new FileReader("E:\\jsonFile\\123.txt"));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    reader.startArray();
    while(reader.hasNext()) {
        reader.startObject();
        while (reader.hasNext())
        {
            System.out.println("key:"+reader.readString());
            System.out.println("value:" +reader.readString());
        }
        reader.endObject();
        // handle vo ...
    }
    reader.endArray();
    reader.close();
    return null;
}


    public static Object getJsonObjectTo()
    {
        JSONReader reader = null;
        try {
            reader = new JSONReader(new FileReader("E:\\jsonFile\\123.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        reader.startArray();
        while(reader.hasNext()) {
            System.out.println(reader.readString());;
            System.out.println(reader.readObject());;
        }
        reader.endArray();
        reader.close();
        return null;
    }


    public static void main(String[] args) throws FileNotFoundException {

        getJsonObject();
        getJsonObjectTo();
        //SpringApplication application = new SpringApplication(DemoApplication.class);
        //application.setApplicationContextClass(ConfigMap.class);
//        ReturnModel returnModel = new ReturnModel();
//        //SpringApplication.run(DemoApplication.class,args);
//            //new ExcelDataCalUtil().getJsonDataFromExcel("E:\\余培\\javaLearn\\bbb.xls",0,0,1,null);
//System.out.println(
//            new ExcelDataCalUtil().getObjectByClassAndData(
//                    "E:\\余培\\javaLearn\\bbb.xls",
//                    0,
//                    0,
//                    1,
//                    null,
//                    returnModel)
//            );

        //System.out.println(new ConfigMap().getTestKey());

    }

}
