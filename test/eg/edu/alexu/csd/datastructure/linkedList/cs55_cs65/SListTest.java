package eg.edu.alexu.csd.datastructure.linkedList.cs55_cs65;

import org.junit.Test;

import static org.junit.Assert.*;

public class SListTest {
 SList l=new SList();
    @Test
    public void add() {
        l.add(0,3);
        l.add(1,7);
        l.add(5);
        assertEquals(7,l.get(1));
        assertEquals(3,l.get(0));
        l.set(1,9);
        assertEquals(9,l.get(1));
        l.remove(0);
        assertEquals(9,l.get(0));
    }

    @Test
    public void add1() {
        l.add(4);
        assertEquals(4,l.get(0));
        l.add(8);
        l.add(2);
        assertEquals(4,l.get(0));
        assertEquals(2,l.get(2));
        l.add(1,5);
        assertEquals(8,l.get(2));
    }

    @Test
    public void get() {
        l.add(0,3);
        l.add(1,7);
        l.add(5);
        assertEquals(7,l.get(1));
        assertEquals(3,l.get(0));
        l.set(1,9);
        assertEquals(9,l.get(1));
        l.remove(0);
        assertEquals(9,l.get(0));
    }

    @Test
    public void set() {
        l.add(0,3);
        l.add(1,6);
        l.set(0,7);
        l.set(1,1);
        assertEquals(7,l.get(0));
        assertEquals(1,l.get(1));
        l.set(1,9);
        assertEquals(9,l.get(1));
        l.remove(0);
        assertEquals(9,l.get(0));
    }

    @Test
    public void clear() {
        l.add(4);
        l.add(7);
        l.add(8);
        assertEquals(3,l.size());
        l.clear();
        assertTrue(l.isEmpty());
    }

    @Test
    public void isEmpty() {
        assertTrue(l.isEmpty());
        l.add(4);
        l.add(7);
        l.add(8);
        assertFalse(l.isEmpty());
        l.remove(1);
        assertFalse(l.isEmpty());
        l.clear();
        assertTrue(l.isEmpty());
    }

    @Test
    public void remove() {
        l.add(0,3);
        l.add(1,7);
        l.add(5);
        assertEquals(7,l.get(1));
        assertEquals(3,l.get(0));
        l.remove(0);
        assertEquals(7,l.get(0));
        l.set(1,9);
        assertEquals(9,l.get(1));
        l.remove(0);
        assertEquals(9,l.get(0));
    }

    @Test
    public void size() {
        l.add(4);
        l.add(7);
        l.add(8);
        assertEquals(3,l.size());
        l.clear();
        assertEquals(0,l.size());
        l.add(1);
        l.add(2);
        assertEquals(2,l.size());
        l.remove(0);
        assertEquals(1,l.size());
    }

    @Test
    public void contains() {
        l.add(4);
        l.add(2);
        l.add(7);
        assertTrue(l.contains(2));
        assertFalse(l.contains(10));
        l.remove(1);
        assertTrue(l.contains(7));
        l.add(3);
        assertTrue(l.contains(3));
        assertFalse(l.contains(8));
    }
}