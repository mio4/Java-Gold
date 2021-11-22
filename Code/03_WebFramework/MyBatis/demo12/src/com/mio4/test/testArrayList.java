package com.mio4.test;

import java.util.ArrayList;
import java.util.List;

public class testArrayList {
    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        for(int i=0; i < 100;i++){
            list.add(String.valueOf(i));
        }
        for(String s : list){
            System.out.println(s);
        }
    }
}
