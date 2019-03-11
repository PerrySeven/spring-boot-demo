package demoapp.common.ExcelPlugin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.json.Json;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelDataCalUtil {

    /*
    通过 Excel获取头部信息
    根据头部信息构建出对应的数据格式
    [{
    header:["header1","header2"],
    data:[["data1","data2"],[]]
    },...]
     */

    public List<ExcelDataResultJson> getJsonDataFromExcel(String path, int column, int rows, int headerIndex,
                                                          int[] requirelist) throws IOException {

        List<ExcelDataResultJson> excelDataResultJson = new ArrayList<>();
        Workbook workbook = this.readExcel(path);
        //Workbook workbook1 = new XSSFWorkbook(excel);
        for (int i = 0; i < workbook.getNumberOfSheets(); ++i) {
            Sheet sheetObj = workbook.getSheetAt(i);
            ExcelDataResultJson sheetData = new ExcelDataResultJson();
            sheetData.setSheetName(sheetObj.getSheetName());
            List<String> header = new ArrayList<>();
            List<List<String>> data = new ArrayList<>();
            for (int j = 0; j < sheetObj.getPhysicalNumberOfRows(); ++j) {
                Row rowObj = sheetObj.getRow(j);
                List<String> rowData = new ArrayList<>();
                // 单例构造器
//                if(j==0) {
//                    header = new String[rowObj.getPhysicalNumberOfCells()];
//                    data = new String[sheetObj.getPhysicalNumberOfRows() - headerIndex][rowObj.getPhysicalNumberOfCells()];
//                }
                for (int k = 0; k < rowObj.getPhysicalNumberOfCells(); ++k) {
//                    data[j][k] = rowObj.getCell(k).toString();
                    rowData.add(rowObj.getCell(k).toString());
                }
                if (j < headerIndex) {
                    header = rowData;
                    continue;
                }
                data.add(rowData);
            }

            sheetData.setData(data);
            sheetData.setHeader(header);
            excelDataResultJson.add(sheetData);
        }

        System.out.println(JSONObject.toJSONString(excelDataResultJson));
        return excelDataResultJson;
    }

    /*
    回去对应的Excel中的数据
    通过反射按照header为字节实现数据重组并且返回
     */
    public Object getObjectByExcelData(String path, int column, int rows, int headerIndex,
                                       int[] requirelist, String returnJson) {
        Workbook workbook = this.readExcel(path);
        List<ExcelObjectJSON> objectJSONS = new ArrayList<>();
        //JSONObject obj = (JSONObject) getObject(returnJson);
        JSONArray strObj =  (JSONArray)getObject(returnJson);
        /// 通过header 实例化出来一个对应的 jsonObject,然后给这个对象里面塞值
        for (int i = 0; i < workbook.getNumberOfSheets(); ++i) {
            Sheet sheetObj = workbook.getSheetAt(i);
            ExcelObjectJSON sheetData = new ExcelObjectJSON();
            sheetData.setSheetName(sheetObj.getSheetName());
            List<Object> data = new ArrayList<>();
            for (int j = 0; j < sheetObj.getPhysicalNumberOfRows(); ++j) {
                Row rowObj = sheetObj.getRow(j);
                JSONObject obj = new JSONObject();
                for (int k = 0; k < rowObj.getPhysicalNumberOfCells(); ++k) {
                   String tempStr =  strObj.get(k).toString();
                    obj.put(tempStr,rowObj.getCell(k).toString());
                }
                if (j < headerIndex) {
                    continue;
                }
                data.add(obj);
            }

            sheetData.setData(data);
            objectJSONS.add(sheetData);
        }
        // header 只是一个由逗号隔开的String对象
        // 如何将header 的简单数组转化为一个对象提供使用
        JSONObject.parse("");
        return JSONObject.toJSON(objectJSONS);
    }

    private Workbook readExcel(String path) {
        try {
            InputStream excel = new FileInputStream(path);
            String suffix = path.substring(path.lastIndexOf('.') + 1, path.length());
            Workbook workbook = null;
            if ("xlsx" == suffix) {
                workbook = new XSSFWorkbook(excel);
            } else {
                workbook = new HSSFWorkbook(excel);
            }
            return workbook;
        } catch (Exception ex) {
            return null;
        }
    }

    private Object getObject(String returnJson)
    {
        return JSON.parse(returnJson);
    }

    public Object getObjectByClassAndData(String path, int column, int rows, int headerIndex,
                                          int[] requirelist, String returnJson)
    {
        // 获取到类中所有的的属性
        // 通过反射注册使用
        // 通过fileName 字段和header 字段匹配获取到对应数据的填写
    }
}
