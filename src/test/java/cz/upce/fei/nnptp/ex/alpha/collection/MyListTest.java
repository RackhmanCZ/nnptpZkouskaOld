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

        Handle<String> firstReference = collection.getReference("first");
        collection.remove(firstReference);

        assertEquals("second third", serialize(collection));

        Handle<String> nextReference = firstReference.getNext();
        Handle<String> previousReference = firstReference.getPrevious();

        assertNull(nextReference);
        assertNull(previousReference);
    }

    @Test
    public void testRemoveSecond() {
        MyList<String> collection = new MyList<>();

        collection.add("first");
        collection.add("second");
        collection.add("third");

        Handle<String> secondReference = collection.getReference("second");
        collection.remove(secondReference);

        assertEquals("first third", serialize(collection));

        Handle<String> nextReference = secondReference.getNext();
        Handle<String> previousReference = secondReference.getPrevious();

        assertNull(nextReference);
        assertNull(previousReference);
    }

    @Test
    public void testRemoveThird() {
        MyList<String> collection = new MyList<>();

        collection.add("first");
        collection.add("second");
        collection.add("third");

        Handle<String> thirdReference = collection.getReference("third");
        collection.remove(thirdReference);

        assertEquals("first second", serialize(collection));

        Handle<String> nextReference = thirdReference.getNext();
        Handle<String> previousReference = thirdReference.getPrevious();

        assertNull(nextReference);
        assertNull(previousReference);
    }

    private <A> String serialize(MyList<A> list) {
        String output = "";
        for (A a : list) {
            output += (a.toString() + " ");
        }
        return output.trim();
    }

}
