package org.wanshicheng.ln.net.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Timothy Wan
 * @date 2016/11/17 8:56
 */
public class LowPortScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String host = scanner.nextLine();
            if(host.equals("q") || host.equals("Q")) {
               break;
            }else {
                for(int i=1; i<1024; i++) {
                    try {
                        Socket socket = new Socket(host, i);
                        System.out.println("主机：" + host + " 端口号：" + i);
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        }

    }
}
