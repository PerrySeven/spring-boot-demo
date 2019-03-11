package demoapp.common.ExcelPlugin;

import java.util.List;


public class ExcelObjectJSON {
    private String sheetName;
    private List<Object> data;

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
