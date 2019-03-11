package demoapp.service;

public class TestLocalThreadService {

    private ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    public Object addData()
    {
        this.threadLocal.set("123455666");
        return "";
    }
}
