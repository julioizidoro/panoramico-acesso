/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.panoramico.acesso.Dao;

import br.com.panoramico.acesso.model.Medico;
import javax.ejb.Stateless;

@Stateless
public class MedicoDao extends AbstractDao<Medico>{
    
    public MedicoDao() {
        super(Medico.class);
    }
    
}
