/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viaja.colombia.control;

import com.viaja.colombia.model.Destino;
import com.viaja.colombia.model.Reserva;
import com.viaja.colombia.model.SystemMessage;
import com.viaja.colombia.model.Usuario;
import com.viaja.colombia.resources.ViajaColombiaService;
import com.viaja.colombia.resources.exception.CreateResourceException;
import com.viaja.colombia.resources.exception.DeleteResourceException;
import com.viaja.colombia.resources.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GuerreroGomez
 */
@RestController
@CrossOrigin( origins = "*" )
@RequestMapping( "/" )
public class ViajaColombiaController {

    private ViajaColombiaService colombiaService;

    @Autowired
    public ViajaColombiaController(ViajaColombiaService colombiaService) {
        this.colombiaService = colombiaService;
    }

    
    @PostMapping( value="/crearusuario", consumes = MediaType.APPLICATION_JSON_VALUE, 
                                         produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ResponseEntity<SystemMessage> createOrUpdateUsuario( @RequestBody Usuario usuario ) throws CreateResourceException{
       return colombiaService.crearUsuario( usuario );
    }
    
    @GetMapping( value="/buscarusuario", produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ResponseEntity<SystemMessage> buscarUsuarioPorIdentificacion( @RequestParam( name="identificacion" ) String identificacion ) 
                                                                throws ResourceNotFoundException{
       return colombiaService.buscarUsuario(identificacion);
    }
    
    @PostMapping( value="/eliminarusuario", consumes = MediaType.APPLICATION_JSON_VALUE, 
                                            produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ResponseEntity<SystemMessage> eliminarUsuario( @RequestBody Usuario usuario ) throws DeleteResourceException{
       return colombiaService.eliminarUsuario( usuario );
    }
    
    @PostMapping( value="/crearreserva", consumes = MediaType.APPLICATION_JSON_VALUE, 
                                         produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ResponseEntity<SystemMessage> crearOActualizarReserva( @RequestBody Reserva reserva ) throws CreateResourceException{
       return colombiaService.crearReservacion( reserva );
    }
    
    
    @PostMapping( value="/creardestino", consumes = MediaType.APPLICATION_JSON_VALUE, 
                                         produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ResponseEntity<SystemMessage> crearOActualizarDestino( @RequestBody Destino destino ) throws CreateResourceException{
       return colombiaService.crearDestino( destino );
    }
    
    @PostMapping( value="/eliminarreserva", consumes = MediaType.APPLICATION_JSON_VALUE, 
                                            produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ResponseEntity<SystemMessage> eliminarReservacion( @RequestBody Reserva reserva ) throws DeleteResourceException{
       return colombiaService.eliminarReserva( reserva );
    }
    
    @GetMapping( value="/consultarreserva", produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public  List<Reserva> consultarReservacionPorIdentificacion( @RequestParam( name = "identificacion" ) String identificacion ){
       return colombiaService.buscarReservaPorIdentificacion( identificacion );
    }
    
    @GetMapping( value="/consultardestinos", produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public  List<Destino> consultarDestinos(){
       return colombiaService.buscarDestinos();
    }
}
