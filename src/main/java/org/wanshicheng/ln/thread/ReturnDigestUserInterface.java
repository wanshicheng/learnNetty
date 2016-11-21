package org.wanshicheng.ln.thread;

import javax.xml.bind.DatatypeConverter;

/**
 * @author Timothy Wan
 * @date 2016/11/21 14:40
 */
// 主线程有机会摘要初始化之前就获取并使用摘要
public class ReturnDigestUserInterface {
    public static void main(String[] args) {
        String filename = "test.txt";
        ReturnDigest rd = new ReturnDigest(filename);
        rd.start();

        StringBuilder result = new StringBuilder(filename);
        result.append(": ");
        byte[] digest = rd.getDigest();
        result.append(DatatypeConverter.printHexBinary(digest));
        System.out.println(result);
    }
}
