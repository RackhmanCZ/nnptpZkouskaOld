/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cz.upce.fei.nnptp.ex.alpha.collection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class MyListTest {

    @Test
    public void testAddToEmpty() {
        MyList<String> collection = new MyList<>();

        collection.add("first");

        assertTrue(collection.hasA("first"));
    }

    @Test
    public void testAddToNonEmpty() {
        MyList<String> collection = new MyList<>();

        collection.add("first");
        collection.add("second");

        assertTrue(collection.hasA("second"));
    }

    @Test
    public void testGetReferenceToFirst() {
        MyList<String> collection = new MyList<>();

        collection.add("first");
        Handle<String> reference = collection.getReference("first");

        assertEquals("first", reference.getData());
    }

    @Test
    public void testRemoveFirst() {
        MyList<String> collection = new MyList<>();

        collection.add("first");
        collection.add("second");
        collection.add("third");

        Handle<String> reference = collection.getReference("first");
        collection.remove(reference);

        assertEquals("second third", serialize(collection));
    }

    @Test
    public void testRemoveSecond() {
        MyList<String> collection = new MyList<>();

        collection.add("first");
        collection.add("second");
        collection.add("third");

        Handle<String> reference = collection.getReference("second");
        collection.remove(reference);

        assertEquals("first third", serialize(collection));
    }

    @Test
    public void testRemoveThird() {
        MyList<String> collection = new MyList<>();

        collection.add("first");
        collection.add("second");
        collection.add("third");

        Handle<String> reference = collection.getReference("third");
        collection.remove(reference);

        assertEquals("first second", serialize(collection));
    }

    private <A> String serialize(MyList<A> list) {
        String output = "";
        for (A a : list) {
            output += (a.toString() + " ");
        }
        return output.trim();
    }

}
