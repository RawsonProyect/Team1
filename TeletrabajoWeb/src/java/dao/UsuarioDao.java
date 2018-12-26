/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package dao;

import daoInterfaces.IUsuarioDao;
import excepciones.InstanceException;
import java.util.List;
import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**

 @author Arlen
 */
public class UsuarioDao extends GenericDao <Usuario,Integer> implements IUsuarioDao
{

    
     public List<Usuario> getByParameter(String parameter, String value, Session session) throws InstanceException{
    return (List<Usuario>) session.createCriteria(Usuario.class).add(Restrictions.like(parameter,value)).list();
    }
 
}  
   