package br.com.dio.bean;

import br.com.dio.Session.SessionContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import br.com.dio.model.User;

@Named()
@RequestScoped
public class UserUtils implements Serializable {

    public static int typeUser(){
        String tipo = SessionContext.getInstance().getUsuarioLogado().getTypeUser().toString();
        if("ADMINISTRADOR".contentEquals(tipo)){
            return 1;
        }
        if("VENDEDOR".contentEquals(tipo)){
            return 2;
        }
        return 3;
    }
}
