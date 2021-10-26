/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viaja.colombia.resources;

import com.viaja.colombia.model.SystemMessage;
import com.viaja.colombia.resources.exception.CreateResourceException;
import com.viaja.colombia.resources.exception.DeleteResourceException;
import com.viaja.colombia.resources.exception.ResourceNotFoundException;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author GuerreroGomez
 */
@RestControllerAdvice
public class AdviceExceptionHandler {
    
    
    @ResponseStatus( value=HttpStatus.NOT_FOUND, reason = "ResourceNotFound" )
    @ExceptionHandler( ResourceNotFoundException.class )
    public ResponseEntity<SystemMessage> createResourceNotFoundException( ResourceNotFoundException exception ){
        SystemMessage message = new SystemMessage( "No fue posible encontrar el recurso solicitado" , 
                                                 exception.getMessage(), 
                                                 new Date(), 
                                                 HttpStatus.NOT_FOUND.value() );
        return new ResponseEntity( message, HttpStatus.NOT_FOUND );
    }
    
    @ResponseStatus( value=HttpStatus.BAD_REQUEST, reason = "CreateOrUpdateResource" )
    @ExceptionHandler( CreateResourceException.class )
    public ResponseEntity<SystemMessage> createCreateResourceException( CreateResourceException exception ){
        SystemMessage message = new SystemMessage( "No fue posible crear o actualizar el recurso solicitado" , 
                                                 exception.getMessage(), 
                                                 new Date(), 
                                                 HttpStatus.BAD_REQUEST.value() );
        return new ResponseEntity( message, HttpStatus.BAD_REQUEST );
    }
    
    @ResponseStatus( value=HttpStatus.BAD_REQUEST, reason = "DeleteResource" )
    @ExceptionHandler( DeleteResourceException.class )
    public ResponseEntity<SystemMessage> createDeleteResourceException( DeleteResourceException exception ){
        SystemMessage message = new SystemMessage( "No fue posible eliminar el recurso solicitado" , 
                                                 exception.getMessage(), 
                                                 new Date(), 
                                                 HttpStatus.BAD_REQUEST.value() );
        return new ResponseEntity( message, HttpStatus.BAD_REQUEST );
    }
    
}
