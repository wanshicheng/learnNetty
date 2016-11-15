package org.wanshicheng.learnNetty.net;

import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Timothy Wan
 */
public class URLConnectionTester {
    @Test
    public void testURLConnection() {
        try {
            URL u = new URL("http://www.wanshicheng.org");
            URLConnection uc = u.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
