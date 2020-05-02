package com.jbt.microserviceapplication;

public class deleteMe {

  public static void main(String[] args) {
    String str = "Hello";
    String str1 = new String("Hello").intern();
//    str1.intern();

    if(str == str1){
      System.out.println("Same");
    } else {
      System.out.println("diff");
    }
  }
}
