/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viaja.colombia.resources;

import com.viaja.colombia.model.Reserva;
import com.viaja.colombia.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author GuerreroGomez
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{
    
    @Transactional
    public List<Reserva> findByUsuario( Usuario usuario );
    
}
