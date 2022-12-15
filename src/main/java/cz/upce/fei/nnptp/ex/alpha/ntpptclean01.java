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
        MyList<String> strings = new MyList<>();
        strings.add("hello");
        strings.add("world");
        strings.add("!");
        strings.add("java");
        
        for (String string : strings) {
            System.out.print(string + " ");
        }
        System.out.println();
        
        Handle<String> hworld = strings.getReference("world");
        System.out.println(hworld.getData());
        
        Handle<String> hexcl = hworld.getNext();
        System.out.println(hexcl.getData());
        
        strings.remove(hexcl.getPrevious());
        
        for (String string : strings) {
            System.out.print(string + " ");
        }
        System.out.println();
    }
    
}
