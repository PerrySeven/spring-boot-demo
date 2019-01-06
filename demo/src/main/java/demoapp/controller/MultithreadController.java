package demoapp.controller;

import demoapp.service.MultiTheadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("thread")
public class MultithreadController {
     @Autowired
     private MultiTheadService multiTheadService;

     @RequestMapping("get")
     public String getMultiThreadData() throws InterruptedException {
         multiTheadService.multiThread(2);
         return  "true";
     }

}
