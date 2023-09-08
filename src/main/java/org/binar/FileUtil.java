package org.binar;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUtil {
    public static void simpanStruk(String struk) {
        try {
            FileWriter fileWriter = new FileWriter("struk_pembayaran.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(struk);
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan struk.");
        }
    }
}
