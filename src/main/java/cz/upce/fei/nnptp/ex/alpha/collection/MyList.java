/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.upce.fei.nnptp.ex.alpha.collection;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/**
 * LList represents double sided linked list for storing of data. It also
 * provides interface for exposing handles to list elements. Handles must
 * provide safe way to ensure that element is still in linked list. When
 * removing data from linked list, you must invalidate all handles to that
 * element. Handle must be position invariant. We expect many operations
 * involving adding/removing and reording of list elements.
 *
 * TODO: cleanup code, add missing unit tests (test if all handles to list
 * element are invalidated on element removal),
 */
public class MyList<A> implements Iterable<A> {
    static class Node<A> {
        public A data;
        public Node<A> next;
        public Node<A> previous;
        public Node(A data) {
            this.data = data;
        }
    }

    Node<A> firstNode;
    Node<A> lastNode;
    WeakHashMap<A, List<WeakReference<Handle<A>>>> weakHashMap;

    public MyList() {
        weakHashMap = new WeakHashMap<>();
    }

    public void add(A data) {
        if (firstNode == null) {
            firstNode = lastNode = new Node<>(data);
            return;
        }

        Node<A> node = new Node<>(data);
        node.previous = lastNode;
        lastNode.next = node;
        lastNode = node;
    }

    private Node<A> find(A data) {
        Node<A> node = firstNode;
        while (node != null) {
            if (node.data.equals(data)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public boolean hasA(A data) {
        return !(find(data) == null);
    }

    public Handle<A> getReference(A data) {
        Node<A> node = find(data);
        Handle<A> handler = new Handle<>(node, this);

        if (weakHashMap.containsKey(data)) {
            weakHashMap.get(data).add(new WeakReference<>(handler));
        } else {
            ArrayList<WeakReference<Handle<A>>> value = new ArrayList<>();
            value.add(new WeakReference<>(handler));
            weakHashMap.put(data, value);
        }
        return handler;
    }

    public void remove(Handle<A> handle) {
        if (handle.list.get() != this) {
            throw new RuntimeException("f");
        }

        Node<A> nodeToRemove = handle.node;

        if (weakHashMap.containsKey(nodeToRemove.data)) {
            for (WeakReference<Handle<A>> weakReference :  weakHashMap.get(nodeToRemove.data)) {
                Handle<A> handler = weakReference.get();
                if (handler != null) {
                    handler.invalidate();
                }
            }
            weakHashMap.remove(nodeToRemove.data);
        }

        if (firstNode == nodeToRemove) {
            firstNode = nodeToRemove.next;
            nodeToRemove.next.previous = null;
        } else {
            nodeToRemove.previous.next = nodeToRemove.next;
        }

        if (nodeToRemove == lastNode) {
            lastNode = nodeToRemove.previous;
            nodeToRemove.previous.next = null;
        } else {
            nodeToRemove.next.previous = nodeToRemove.previous;
        }
    }

    @Override
    public Iterator<A> iterator() {
        return new MyListIterator(firstNode);
    }

    Handle<A> getReference(Node<A> data) {
        Handle<A> handler = new Handle<>(data, this);

        if (weakHashMap.containsKey(data.data)) {
            weakHashMap.get(data.data).add(new WeakReference<>(handler));
        } else {
            ArrayList<WeakReference<Handle<A>>> value = new ArrayList<>();
            value.add(new WeakReference<>(handler));
            weakHashMap.put(data.data, value);
        }

        return handler;
    }

    class MyListIterator implements Iterator<A> {

        private Node<A> node;

        public MyListIterator(Node<A> node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public A next() {
            A nextValue = node.data;
            node = node.next;
            return nextValue;

        }
    }
}
