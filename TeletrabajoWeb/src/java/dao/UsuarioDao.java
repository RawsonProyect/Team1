/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package dao;

import daoInterfaces.IUsuarioDao;
import java.util.List;
import modelo.Usuario;
import org.hibernate.criterion.Restrictions;

/**

 @author Arlen
 */
public class UsuarioDao extends GenericDao <Usuario,Integer> implements IUsuarioDao
{

    
    public boolean getByParameter(String parameter, String value) {
    List<Usuario> result = (List<Usuario>) session.createCriteria(Usuario.class).add(Restrictions.like(parameter,value)).list();
    if(result.size()!=1){
        return false;
    }
    t.commit();
    return true;
    }
 
}  
   