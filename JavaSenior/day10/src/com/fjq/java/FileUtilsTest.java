package com.fjq.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author EnvyFL
 * @create 2021-04-22-11:10 下午
 * @class
 */
public class FileUtilsTest {

    public static void main(String[] args) {
        File srcFile = new File("a.jpg");
        File destFile = new File("b.jpg");
        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
