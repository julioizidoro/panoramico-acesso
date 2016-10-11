package br.com.panoramico.acesso.Dao;

import br.com.panoramico.acesso.model.Notificacao;
import javax.ejb.Stateless;

@Stateless
public class NotificacaoDao extends AbstractDao<Notificacao>{
    
    public NotificacaoDao() {
        super(Notificacao.class);
    }
    
}
