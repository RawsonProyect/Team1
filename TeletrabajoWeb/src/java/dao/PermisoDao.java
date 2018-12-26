package dao;

import daoInterfaces.IPermisoDao;
import excepciones.InstanceException;
import java.util.List;
import modelo.Permiso;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**

 @author Arlen
 */
public class PermisoDao extends GenericDao<Permiso,Integer> implements IPermisoDao
{

    @Override
    public List<Permiso> getByParameter(String parameter,String value,Session session) throws InstanceException
    {
        List<Permiso> result = (List<Permiso>)session.createCriteria(Permiso.class).add(Restrictions.like(parameter,value)).list();
        return (List<Permiso>)session.createCriteria(Permiso.class).add(Restrictions.like(parameter,value)).list();
    }

}
