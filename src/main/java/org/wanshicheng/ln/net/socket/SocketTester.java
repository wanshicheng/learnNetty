package org.wanshicheng.ln.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Timothy Wan
 */
public class SocketTester {
    public static void main(String[] args) {
        try {
            // 不止创建对象，而且建立连接
            Socket socket = new Socket("time.nist.gov", 13);
            socket.setSoTimeout(15000);
            InputStream is = socket.getInputStream();
            StringBuilder sb = new StringBuilder();
            InputStreamReader isr = new InputStreamReader(is, "ASCII");
            for (int c = isr.read(); c != -1; c=isr.read()) sb.append((char) c);
            System.out.println(sb);
            System.out.println(parseDate(sb.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Date parseDate(String s) {
        String[] strings = s.split(" ");
        String dateTime = strings[1] + " " + strings[2] + " UTC";
        DateFormat df = new SimpleDateFormat("yy-MM-dd hh:mm:ss z");
        Date date = null;
        try {
            date = df.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
