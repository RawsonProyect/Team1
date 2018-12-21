/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package dao;

import daoInterfaces.ITipoPermisoDao;
import java.util.List;
import modelo.Tipopermiso;
import org.hibernate.criterion.Restrictions;

/**

 @author Arlen
 */
public class TipoPermisoDao  extends GenericDao <Tipopermiso,Integer> implements ITipoPermisoDao
        
{
    @Override
    public boolean getByParameter(String parameter,String value)
    {
       
          List <Tipopermiso> result = (List<Tipopermiso>) session.createCriteria(Tipopermiso.class).add( Restrictions.like(parameter,value)).list();
    if(result.size()!=1){
        return false;
    }
    t.commit();
    return true;
    }
    
  
}
