/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package dao;

import daoInterfaces.IRolDao;
import java.util.List;
import modelo.Rol;
import org.hibernate.criterion.Restrictions;

/**

 @author Arlen
 */
public class RolDao extends GenericDao <Rol,Integer> implements IRolDao
{
    @Override
    public boolean getByParameter(String parameter,String value)
    {
        List <Rol> result = (List<Rol>) session.createCriteria(Rol.class).add( Restrictions.like(parameter,value)).list();
    if(result.size()!=1){
        return false;
    }
    t.commit();
    return true;
    }
    
    
}
