/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viaja.colombia.resources;

import com.viaja.colombia.model.Destino;
import com.viaja.colombia.model.Reserva;
import com.viaja.colombia.model.SystemMessage;
import com.viaja.colombia.model.Usuario;
import com.viaja.colombia.resources.exception.CreateResourceException;
import com.viaja.colombia.resources.exception.DeleteResourceException;
import com.viaja.colombia.resources.exception.ResourceNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author GuerreroGomez
 */
@Service
public class ViajaColombiaService {
    
    private ReservaRepository reservaRepository;
    private UsuarioRepository usuarioRepository;
    private DestinoRepository destinoRepository;

    @Autowired
    public ViajaColombiaService(ReservaRepository reservaRepository, UsuarioRepository usuarioRepository, 
                                DestinoRepository destinoRepository) {
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
        this.destinoRepository = destinoRepository;
    }
    
    
    public ResponseEntity<SystemMessage> crearUsuario( Usuario usuario ) throws CreateResourceException{
       try{
          usuarioRepository.save( usuario );
          SystemMessage message = new SystemMessage( "Operacion realizada de forma exitosa" , 
                                                 "", 
                                                 new Date(), 
                                                 HttpStatus.OK.value() );
          return new ResponseEntity(message, HttpStatus.OK);
       }
       catch( Exception error ){
           System.out.println( error.toString() );
           throw new CreateResourceException( "Fallo la creacion del usuario por " + error.toString() );
           
       }
    }
    
    
    public ResponseEntity<SystemMessage> crearReservacion( Reserva reserva ) throws CreateResourceException{
       try{
          reservaRepository.save( reserva );
          SystemMessage message = new SystemMessage( "Operacion realizada de forma exitosa" , 
                                                 "", 
                                                 new Date(), 
                                                 HttpStatus.OK.value() );
          return new ResponseEntity(message, HttpStatus.OK);
       }
       catch( Exception error ){
          throw new CreateResourceException( "Fallo la creacion de la reserva causado por " + error.toString() );
       }
    }
    
    public ResponseEntity<SystemMessage> crearDestino( Destino destino ) throws CreateResourceException{
       try{
          destinoRepository.save( destino );
          SystemMessage message = new SystemMessage( "Operacion realizada de forma exitosa" , 
                                                 "", 
                                                 new Date(), 
                                                 HttpStatus.OK.value() );
          return new ResponseEntity(message, HttpStatus.OK);
       }
       catch( Exception error ){
          throw new CreateResourceException( "Fallo la creacion del destino causado por " + error.toString() );
       }
    }
    
    public ResponseEntity<SystemMessage> eliminarUsuario( Usuario usuario ) throws DeleteResourceException{
       try{
          usuarioRepository.delete( usuario );
          SystemMessage message = new SystemMessage( "Operacion realizada de forma exitosa" , 
                                                 "", 
                                                 new Date(), 
                                                 HttpStatus.OK.value() );
          return new ResponseEntity(message, HttpStatus.OK);
       }
       catch( Exception error ){
          throw new DeleteResourceException( "Fallo la eliminacion del usuario por " + error.toString() );
       }
    }
    
    public ResponseEntity<SystemMessage> eliminarReserva( Reserva reserva ) throws DeleteResourceException{
       try{
          reservaRepository.delete( reserva );
          SystemMessage message = new SystemMessage( "Operacion realizada de forma exitosa" , 
                                                 "", 
                                                 new Date(), 
                                                 HttpStatus.OK.value() );
          return new ResponseEntity(message, HttpStatus.OK);
       }
       catch( Exception error ){
          throw new DeleteResourceException( "Fallo la eliminacion de la reserva por " + error.toString() );
       }
    }
    
    public ResponseEntity<SystemMessage> eliminarDestino( Destino destino ) throws DeleteResourceException{
       try{
          destinoRepository.delete( destino );
          SystemMessage message = new SystemMessage( "Operacion realizada de forma exitosa" , 
                                                 "", 
                                                 new Date(), 
                                                 HttpStatus.OK.value() );
          return new ResponseEntity(message, HttpStatus.OK);
       }
       catch( Exception error ){
          throw new DeleteResourceException( "Fallo la eliminacion del destino por " + error.toString() );
       }
    }
    
    public ResponseEntity<SystemMessage> buscarUsuario( String identificacion ) throws ResourceNotFoundException{
          Optional<Usuario> optional = usuarioRepository.findById( identificacion );
          if( optional.isEmpty() ){
             throw new ResourceNotFoundException( "No se encontro el recurso solicitado" );
          }else{
          SystemMessage message = new SystemMessage( "Operacion realizada de forma exitosa" , 
                                                 "", 
                                                 new Date(), 
                                                 HttpStatus.OK.value() );
          return new ResponseEntity(message, HttpStatus.OK);
          }
    }
    
    public List<Destino> buscarDestinos() {
          return destinoRepository.findAll();
    }
    
    public List<Reserva> buscarReservaPorIdentificacion( String identificacion ){
       Usuario usuario = new Usuario();
       usuario.setIdentificacion( identificacion );
      return reservaRepository.findByUsuario( usuario );
    }
    
}
