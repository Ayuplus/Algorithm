package com.zhouhao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test02 {
    public static void main(String[] args)  throws IOException {
        FileInputStream fis = new FileInputStream("Test/application.properties");
        Properties p = new Properties();
        p.load(fis);
        fis.close();
        System.out.println(p);
    }
}
