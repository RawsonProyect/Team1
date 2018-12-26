/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package dao;

import daoInterfaces.ITipoPermisoDao;
import excepciones.InstanceException;
import java.util.List;
import modelo.Tipopermiso;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**

 @author Arlen
 */
public class TipoPermisoDao  extends GenericDao <Tipopermiso,Integer> implements ITipoPermisoDao
        
{
    @Override
    public List<Tipopermiso> getByParameter(String parameter,String value,Session session) throws InstanceException
    {
        return (List<Tipopermiso>) session.createCriteria(Tipopermiso.class).add(Restrictions.like(parameter,value)).list();
    }
 
  
}
