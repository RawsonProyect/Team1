/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package dao;

import daoInterfaces.IProyectoDao;
import java.util.List;
import modelo.Proyecto;
import org.hibernate.criterion.Restrictions;

/**

 @author Arlen
 */
public class ProyectoDao extends GenericDao <Proyecto,Integer> implements IProyectoDao
{
    @Override
    public boolean getByParameter(String parameter,String value)
    {
        List<Proyecto> result = (List<Proyecto>) session.createCriteria(Proyecto.class).add(Restrictions.like(parameter,value)).list();
    if(result.size()!=1){
        return false;
    }
    t.commit();
    return true;
    }
    

    
}
