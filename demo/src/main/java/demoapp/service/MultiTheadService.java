package demoapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MultiTheadService {

    /*
    入参
     */
    public String multiTest(int requestInput) {
        RestTemplate restTemplate = new RestTemplate();
        String getInfo = restTemplate.getForEntity(
                "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=jdk%20jre%20jvm%E5%8C%BA%E5%88%AB%E4%B8%8E%E8%81%94%E7%B3%BB&oq=java%25208&rsv_pq=f650488900035fee&rsv_t=8b0fe5Uh2lCtH8HubIBsqWYwgLKhiUOrNeOW%2Be8%2B2Co8PF%2FyftxmHzmvXr8&rqlang=cn&rsv_enter=0&rsv_sug3=35&rsv_sug1=25&rsv_sug7=100&sug=jdk%2520jre%2520jvm%25E5%258C%25BA%25E5%2588%25AB%25E4%25B8%258E%25E8%2581%2594%25E7%25B3%25BB&rsv_n=1&bs=java%208"
                                      ,String.class).getBody();
        System.out.println(getInfo);
        System.out.println(requestInput);
        return getInfo;

    }

    public void multiThread(int count) throws InterruptedException {
        for (int i=0;i<count;i++){

            MultiThreadFactoryService thread = new MultiThreadFactoryService();
            thread.setData(i);
            Thread threadT = new Thread(thread);
            threadT.start();
            threadT.sleep(1000);



        }

    }
}
