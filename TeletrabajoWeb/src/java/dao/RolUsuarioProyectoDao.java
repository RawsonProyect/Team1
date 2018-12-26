/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package dao;

import daoInterfaces.IRolUsuarioProyectoDao;
import excepciones.InstanceException;
import java.util.List;
import modelo.RolUsuarioProyecto;
import modelo.RolUsuarioProyectoId;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**

 @author Arlen
 */
public class RolUsuarioProyectoDao extends GenericDao<RolUsuarioProyecto,RolUsuarioProyectoId> implements IRolUsuarioProyectoDao

{
    @Override
    public List<RolUsuarioProyecto> getByParameter(String parameter,String value,Session session) throws InstanceException
    {
        return (List<RolUsuarioProyecto>)session.createCriteria(RolUsuarioProyecto.class).add(Restrictions.like(parameter,value)).list();
    }

}
