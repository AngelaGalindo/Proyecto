/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viaja.colombia.resources;

import com.viaja.colombia.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author GuerreroGomez
 */
@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long>{
    
}
