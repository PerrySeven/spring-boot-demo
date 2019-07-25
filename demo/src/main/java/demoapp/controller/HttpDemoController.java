package demoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/http-demo/")
public class HttpDemoController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get")
    public Object tryDemo()
    {
        return restTemplate.getForEntity("http://baidu.com",String.class).getBody();
    }
}
