package demoapp.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class  StartThread {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ArrayBlockingQueue<Future<String>> resultss = new ArrayBlockingQueue<>(20);
        //LinkedBlockingQueue<Future<String>> results = new LinkedBlockingQueue<>(20);
        List<String> stringList = new ArrayList<String>();
        ExecutorService executor = Executors.newFixedThreadPool(20);
        CountDownLatch downLatch = new CountDownLatch(20);
        try
        {for(int i =0 ; i<20 ; ++i)
        {
            System.out.println(i);
            Future<String> a =  executor.submit(new MyThread("projectCode_" + i,downLatch));
            stringList.add(a.get());
            resultss.add(a);
            System.out.println(a.get());
        }
            downLatch.await();
        }
        catch(Exception ex)
        {}
        finally {
            executor.shutdown();
        }

        System.out.println( resultss.size());

//        for (Future<String> aaa :resultss)
//        {
//            System.out.println(aaa.get());
//        }
        System.out.println("start output");
        System.out.println("start output");
        for (int i =0;i<stringList.size(); ++i)
        {

            //String aaa = resultss.poll().get();

            System.out.println(stringList.get(i));
        }



    }





}
