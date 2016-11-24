package org.wanshicheng.ln.thread.callback;

import javax.xml.bind.*; // for DatatypeConverter; requires Java 6 or JAXB 1.0

public class InstanceCallbackDigestUserInterface {
  
  private String filename;
  private byte[] digest;
  
  public InstanceCallbackDigestUserInterface(String filename) {
    this.filename = filename;
  }
  
  public void calculateDigest() {
    InstanceCallbackDigest cb = new InstanceCallbackDigest(filename, this);
    Thread t = new Thread(cb);
    t.start(); 
  }
  
  void receiveDigest(byte[] digest) {  
    this.digest = digest;
    System.out.println(this);
  }
  
  @Override
  public String toString() {
    String result = filename + ": ";
    if (digest != null) {
      result += DatatypeConverter.printHexBinary(digest);
    } else {
      result += "digest not available";
    }
    return result;
  }
  
  public static void main(String[] args) {
    for (String filename : args) {    
      // Calculate the digest
      InstanceCallbackDigestUserInterface d
          = new InstanceCallbackDigestUserInterface(filename);
      d.calculateDigest();
    } 
  }
}
/**
 * 与CallbackDigestUserIntrface相比，稍微复杂一些
 * 优点：
 * 1、主类的实例只映射至一个文件，可以
 *
 */

