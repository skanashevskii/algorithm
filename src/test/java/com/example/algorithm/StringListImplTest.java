package com.example.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    private StringList stringList;

    @BeforeEach
    void setUp() {
        stringList = new StringListImpl();
    }

    @Test
    void add() {
        stringList.add("Проверка раз");
        stringList.add("Проверка два");
        assertEquals("Проверка раз",stringList.get(0));
        assertEquals("Проверка два",stringList.get(1));
    }

    @Test
    void testAdd() {
        stringList.add("Проверка три");
        stringList.add("Проверка четыре");
        stringList.add(1, "Прелесть");

        assertEquals("Проверка три", stringList.get(0));
        assertEquals("Прелесть", stringList.get(1));
        assertEquals("Проверка четыре", stringList.get(2));
    }

    @Test
    void set() {
        stringList.add("Проверка три");
        stringList.add("Проверка четыре");
        stringList.set(1, "Прелесть");

        assertEquals("Проверка три", stringList.get(0));
        assertEquals("Прелесть", stringList.get(1));
    }
    @Test
    public void testRemoveByIndex() {
        stringList.add("Проверка три");
        stringList.add("Проверка четыре");
        stringList.add("Прелесть");

        String removedItem = stringList.remove(1);

        assertEquals("Проверка четыре", removedItem);
        assertEquals("Проверка три", stringList.get(0));
        assertEquals("Прелесть", stringList.get(1));
        assertEquals(2, stringList.size());
    }

    @Test
    public void testRemoveByItem() {
        stringList.add("Проверка три");
        stringList.add("Проверка четыре");
        stringList.add("Прелесть");

        String removedItem = stringList.remove("Проверка четыре");

        assertEquals("Проверка четыре", removedItem);
        assertEquals("Проверка три", stringList.get(0));
        assertEquals("Прелесть", stringList.get(1));
        assertEquals(2, stringList.size());
        assertFalse(stringList.contains("Проверка четыре"));
    }

    @Test
    void contains() {
        stringList.add("Проверка три");
        stringList.add("Прелесть");

        assertTrue(stringList.contains("Проверка три"));
        assertFalse(stringList.contains("Проверка четыре"));
    }

    @Test
    void indexOf() {
        stringList.add("Проверка три");
        stringList.add("Проверка четыре");

        assertEquals(0, stringList.indexOf("Проверка три"));
        assertEquals(1, stringList.indexOf("Проверка четыре"));
        assertEquals(-1, stringList.indexOf("Прелесть"));
    }

    @Test
    void lastIndexOf() {
        stringList.add("Проверка три");
        stringList.add("Проверка четыре");
        stringList.add("Проверка три");


        assertEquals(2, stringList.lastIndexOf("Проверка три"));
        assertEquals(1, stringList.lastIndexOf("Проверка четыре"));
        assertEquals(-1, stringList.lastIndexOf("Прелесть"));
    }
    @Test
    void testEquals() {
        stringList.add("Проверка три");
        stringList.add("Проверка четыре");

        StringList otherList = new StringListImpl();
        otherList.add("Проверка три");
        otherList.add("Проверка четыре");

        assertTrue(stringList.equals(otherList));
    }


    @Test
    void size() {
        stringList.add("Проверка три");
        stringList.add("Проверка четыре");

        assertEquals(2, stringList.size());
    }

    @Test
    void isEmpty() {
        assertTrue(stringList.isEmpty());

        stringList.add("Проверка три");

        assertFalse(stringList.isEmpty());
    }

    @Test
    void clear() {
        stringList.add("Проверка три");
        stringList.add("Проверка четыре");

        stringList.clear();

        assertTrue(stringList.isEmpty());
        assertEquals(0, stringList.size());
    }

    @Test
    void toArray() {
        stringList.add("Проверка три");
        stringList.add("Проверка четыре");

        String[] array = stringList.toArray();

        assertEquals("Проверка три", array[0]);
        assertEquals("Проверка четыре", array[1]);
    }
    }
