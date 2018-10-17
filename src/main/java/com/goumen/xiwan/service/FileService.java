package com.goumen.xiwan.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
    public void write(final String text) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/wangwenjun.txt"));
            bw.write(text);
            bw.flush();
            System.out.println("content write successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
