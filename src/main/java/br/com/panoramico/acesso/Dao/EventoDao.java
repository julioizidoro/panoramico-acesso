/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.panoramico.acesso.Dao;

import br.com.panoramico.acesso.model.Evento;
import javax.ejb.Stateless;

/**
 *
 * @author Kamilla Rodrigues
 */

@Stateless
public class EventoDao extends AbstractDao<Evento>{
    
    public EventoDao() {
        super(Evento.class);
    }
    
}
