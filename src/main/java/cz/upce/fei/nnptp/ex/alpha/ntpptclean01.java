/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.upce.fei.nnptp.ex.alpha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cz.upce.fei.nnptp.ex.alpha.collection.Handle;
import cz.upce.fei.nnptp.ex.alpha.collection.MyList;

/**
 *
 */
public class ntpptclean01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyList<String> helloWorldValues = new MyList<>();
        helloWorldValues.add("hello");
        helloWorldValues.add("world");
        helloWorldValues.add("!");
        helloWorldValues.add("java");
        
        for (String string : helloWorldValues) {
            System.out.print(string + " ");
        }
        System.out.println();
        
        Handle<String> handler = helloWorldValues.getReference("world");
        System.out.println(handler.getData());
        
        handler = handler.getNext();
        System.out.println(handler.getData());
        
        helloWorldValues.remove(handler.getPrevious());
        
        for (String string : helloWorldValues) {
            System.out.print(string + " ");
        }
        System.out.println();
    }
    
}
