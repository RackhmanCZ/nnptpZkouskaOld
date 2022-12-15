/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.upce.fei.nnptp.ex.alpha.collection;

import java.lang.ref.WeakReference;

/**
 * Handle class holds handles for data stored in {@link MyList}. It should
 * provide easy and safe interface for accessing data in linked list. Operations
 * on invalidated handle should throw {@link HandleException}.
 *
 * TODO: cleanup code, fix exceptions, write unit tests to test normal and
 * exceptional behaviour
 */
public class Handle<B> {
    MyList.Node<B> node;
    WeakReference<MyList<B>> list;

    Handle(MyList.Node<B> ref, MyList<B> list) {
        this.node = ref;
        this.list = new WeakReference<>(list);
    }

    public B getData() {
        return node.data;
    }

    public Handle<B> getNext() {
        return list.get().getReference(node.next);
    }

    public Handle<B> getPrevious() {
        return list.get().getReference(node.previous);
    }

    void setHandlerEmpty() {
        node = null;
        list = null;
    }

}
