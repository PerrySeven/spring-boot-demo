package demoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiThreadFactoryService implements Runnable{

    @Autowired
    private MultiTheadService multiTheadService;

    private int data;
    public void setData(int datau)
    {
        data = datau;
    }

    public void run()
    {
        multiTheadService = new MultiTheadService();
        multiTheadService.multiTest(data);
    }




}
