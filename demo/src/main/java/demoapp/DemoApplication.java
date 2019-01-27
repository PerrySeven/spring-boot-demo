package demoapp;

import demoapp.service.MultiTheadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {





    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }

}
