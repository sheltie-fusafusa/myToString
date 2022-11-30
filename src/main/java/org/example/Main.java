package org.example;

public class Main {
    public static void main(String[] args) {

        Sample s = new Sample();
        s.setSampleInt(1);
        s.setSampleStr("test");
        s.setSampleDouble(1.1);
        s.setSample2(new Sample2());

        System.out.println("Original toString Method.");
        System.out.println(Util.myToString(s));
    }
}