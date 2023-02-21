package br.com.dio.bean;

import br.com.dio.Session.SessionContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import br.com.dio.model.User;

@Named
@RequestScoped
public class UserUtils implements Serializable {
    private static User user = SessionContext.getInstance().getUsuarioLogado();
    public static int typeUser(){
        String tipo = user.getTypeUser().toString();
        if("ADMINISTRADOR".contentEquals(tipo)){
            return 1;
        }
        if("VENDEDOR".contentEquals(tipo)){
            return 2;
        }
        return 3;
    }
    public static int getAppId(){
        return user.getAppId();
    }
}
