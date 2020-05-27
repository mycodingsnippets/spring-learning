package com.thenerdyaditya.testing.javaconcepts;

import com.thenerdyaditya.testing.Models.Number;

public class RefVsValue {

    public static void incrementNumber(Number x){
        x.value += 1;
    }

    public static void incrementInt(int x){
        x += 1;
    }

}
