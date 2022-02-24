package com.springboot.mysqlconnection.app;

import static java.lang.Math.*;
import static java.lang.System.out;

public class HelloMath {
    public static void main(String[] args) {
        out.println("Hello World!");
        out.println("Considering a circle with a diameter of 5 cm, it has");
        out.println("a circumference of " + (PI * 5) + " cm");
        out.println("and an area of " + (PI * pow(2.5, 2)) + " sq. cm");
    }
}
