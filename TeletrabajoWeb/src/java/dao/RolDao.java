/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package dao;

import daoInterfaces.IRolDao;
import excepciones.InstanceException;
import java.util.List;
import modelo.Rol;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**

 @author Arlen
 */
public class RolDao extends GenericDao <Rol,Integer> implements IRolDao
{
    @Override
    public List<Rol> getByParameter(String parameter,String value,Session session) throws InstanceException
    {
        return (List<Rol>) session.createCriteria(Rol.class).add( Restrictions.like(parameter,value)).list();
    }
   
    
}
