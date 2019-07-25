package demoapp.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigMap {

    @Value("testKey")
    private String testKey;

    public String getTestKey()
    {
        return testKey;
    }

}
