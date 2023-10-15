package com.example.BookingMovieTicket.Common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFile {
    public static String readJSon(String fileName) throws Exception{
        File file=new File(fileName);
        FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
        }

        // Đóng các luồng
        bufferedReader.close();
        fileReader.close();

        // Trả về chuỗi kết quả
        return stringBuffer.toString();
    }
}
