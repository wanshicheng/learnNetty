package org.wanshicheng.ln.thread;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.Pipe;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/**
 * @author Timothy Wan
 * @date 2016/11/21 9:56
 */
public class DigestThread extends Thread {
    private String filename;

    public DigestThread(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in,sha);
            while(din.read() != -1) ;
            din.close();
            byte[] digest = sha.digest();

            StringBuilder result = new StringBuilder(filename);
            result.append(": ");
            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File directory	= new File(".");
        try {
            System.out.println(directory.getCanonicalPath());

        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread t = new DigestThread("test.txt");
        t.start();
    }
}
