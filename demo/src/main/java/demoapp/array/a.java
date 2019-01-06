package demoapp.array;


import java.util.Scanner;

public class a  {

    public  static void main(String[] args)
    {

       // Integer.parseInt()
        Scanner scanner = new Scanner(System.in);
        do {
            String aaa = scanner.next();
            Integer aaai = new Integer(222);
            int inta = Integer.parseInt(aaa);
            System.out.println("你的输入是："+ aaa);
            if (aaai.equals(aaa))
            {
                System.out.println("你的输入是："+ aaa);
                System.out.println("你的输入是aaa内存地址是："+ System.identityHashCode(aaa));
                System.out.println("你的输入是222："+ 222);
                System.out.println("你的输入是222："+ System.identityHashCode("222"));
            }

            if (222 == inta)
            {
                System.out.println("你的输入是==："+ aaa);
                System.out.println("你的输入是aaa内存地址是==："+ System.identityHashCode(aaa));
                System.out.println("你的输入是222==："+ 222);
                System.out.println("你的输入是222==："+ System.identityHashCode("222"));
            }
        }while (true);
//        int aaa1 = 10;
//        int aaa2 = 10;
//        int aaa3 = 10;
//        int aaa4 = 10;
//        String aaStr = new String();
//        aaStr = "123456578";
//        String aaStr1 = new String();
//        aaStr1 = "123456578";
//        System.out.println(System.identityHashCode(aaStr));
//        System.out.println(aaStr);
//        System.out.println(System.identityHashCode(aaStr1));
//        System.out.println(aaStr1);
//        System.out.println(System.identityHashCode(aaa1));
//        System.out.println(aaa1);
//        System.out.println(System.identityHashCode(aaa2));
//        System.out.println(aaa2);
//        System.out.println(System.identityHashCode(aaa3));
//        System.out.println(aaa3);
//        System.out.println(System.identityHashCode(aaa4));
//        System.out.println(aaa4);
//        int aar[] = {1,2,1};
//        String aarStr[] = {"12312;3","123123","123123"};
//        for (int i =0 ;i<aarStr.length;  ++i)
//         {
//            System.out.println(System.identityHashCode(aarStr[i]));
//            System.out.println(aarStr[i]);
//        }
//        for (int i =0 ;i<aar.length;  ++i)
//        {
//            System.out.println(System.identityHashCode(aar[i]));
//            System.out.println(aar[i]);
//        }



    }

}
