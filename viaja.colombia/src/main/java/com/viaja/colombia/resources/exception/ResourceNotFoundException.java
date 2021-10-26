/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viaja.colombia.resources.exception;

/**
 *
 * @author GuerreroGomez
 */
public class ResourceNotFoundException extends Exception{
    
    public ResourceNotFoundException(){
    }
    
    public ResourceNotFoundException( String error ){
        super( error );
    }
    
}
