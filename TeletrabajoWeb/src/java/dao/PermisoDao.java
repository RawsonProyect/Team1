/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Permiso;
import org.hibernate.criterion.Restrictions;
import daoInterfaces.IPermisoDao;

/**

 @author Arlen
 */
public class PermisoDao extends GenericDao<Permiso,Integer> implements IPermisoDao
{
    @Override
    public boolean getByParameter(String parameter,String value)
    {
         List <Permiso> result = (List<Permiso>) session.createCriteria(Permiso.class).add( Restrictions.like(parameter,value)).list();
    if(result.size()!=1){
        return false;
    }
    t.commit();
    return true;
    }



}
