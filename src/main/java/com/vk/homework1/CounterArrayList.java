package com.vk.homework1;

import java.util.ArrayList;

public class CounterArrayList extends ArrayList<String> {
    private static int counter = 0;
    private int id = counter++;

    public CounterArrayList() {
        System.out.println("Counter List id = " + id);
    }

    public int getId() {
        return id;
    }
}