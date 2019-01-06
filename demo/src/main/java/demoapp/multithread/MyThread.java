package demoapp.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

public class MyThread implements Callable<String> {

    private String projectCode;
    private CountDownLatch latch;

    public  MyThread(String projectCode,CountDownLatch latch)
    {
        this.projectCode = projectCode;
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        //System.out.println("input_" +projectCode);
        String aaa = this.getProjectCode();
        latch.countDown();
        return aaa;
    }

    public String getProjectCode()
    {
        return projectCode;
    }
}
