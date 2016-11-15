package org.wanshicheng.learnNetty.net.url;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author Timothy Wan
 */
public class URLEncoderTest {
    public static void main(String[] args) {
        try {
            System.out.println(URLEncoder.encode("阳光宅男", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
