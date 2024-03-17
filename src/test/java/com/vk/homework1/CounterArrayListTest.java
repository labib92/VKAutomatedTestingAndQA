package com.vk.homework1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CounterArrayListTest {
    private CounterArrayList counterList;

    @BeforeAll
    static void beforeAllMessage() {
        System.out.println("##Starting CounterArrayListTest##");
        System.out.println("_________________________________________");
    }

    @AfterAll
    static void afterAllMessage() {
        System.out.println("##Finished CounterArrayListTest##");
    }

    @BeforeEach
    public void initialize() {
        counterList = new CounterArrayList();
        System.out.println("Set up for " + counterList.getId());
        for (int i = 0; i < 4; i++) {
            counterList.add(Integer.toString(i));
        }
    }

    @AfterEach
    public void cleanup() {
        System.out.println("Cleaning up " + counterList.getId());
        System.out.println("_________________________________________");
    }

    @Test
    public void testListIsNotEmpty() {
        System.out.println("Running testListIsNotEmpty()");
        assertFalse(counterList.isEmpty());
    }

    @Test
    public void testInsertList() {
        System.out.println("Running testInsertList()");
        assertEquals(counterList.size(), 4);
        counterList.add(2, "new value");
        assertEquals(counterList.size(), 5);
        assertEquals(counterList.get(2), "new value");
    }
}
