package org.wanshicheng.learnNetty.net.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Timothy Wan
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.baidu.com");
            System.out.println("port: " + url.getPort());
            System.out.println("default port: " + url.getDefaultPort());
            System.out.println("protocol: " + url.getProtocol());
            InputStream is = url.openStream();
            int c;
            while ((c = is.read()) != -1) System.out.write(c);
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
