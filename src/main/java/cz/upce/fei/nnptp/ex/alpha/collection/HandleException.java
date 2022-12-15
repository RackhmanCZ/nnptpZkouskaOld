/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.upce.fei.nnptp.ex.alpha.collection;

/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */
public class HandleException extends RuntimeException {

    public HandleException() {
    }

    public HandleException(String message) {
        super(message);
    }

    public HandleException(String message, Throwable cause) {
        super(message, cause);
    }

    public HandleException(Throwable cause) {
        super(cause);
    }

    public HandleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
