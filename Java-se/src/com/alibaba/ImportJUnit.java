package com.alibaba;

import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportJUnit {


    public static void main(String...args){


        System.out.println(System.currentTimeMillis());
    }


    @Test
    public void test(){

//        System.out.println("Test Import JUnit");
//        Date d = new Date();

//        java.sql.Date d2 = new java.sql.Date(System.currentTimeMillis());
//        System.out.print("Date:"+d+"\nd:"+d2);

        SimpleDateFormat date = new SimpleDateFormat();
        String str = date.format(new Date());
        System.out.print("\nDate:"+str+"\n");

        date = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        str = date.format(new Date());
        System.out.print("\nDate:"+str+"\n");

    }

}
