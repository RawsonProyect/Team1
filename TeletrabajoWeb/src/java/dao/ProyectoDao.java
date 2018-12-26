/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package dao;

import daoInterfaces.IProyectoDao;
import excepciones.InstanceException;
import java.util.List;
import modelo.Proyecto;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**

 @author Arlen
 */
public class ProyectoDao extends GenericDao <Proyecto,Integer> implements IProyectoDao
{
    @Override
    public List<Proyecto> getByParameter(String parameter,String value,Session session) throws InstanceException
    {
       return (List<Proyecto>) session.createCriteria(Proyecto.class).add(Restrictions.like(parameter,value)).list();
    }
    

    
}
