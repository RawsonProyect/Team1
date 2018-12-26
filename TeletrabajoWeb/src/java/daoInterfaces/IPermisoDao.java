package daoInterfaces;

import excepciones.InstanceException;
import java.util.List;
import modelo.Permiso;
import org.hibernate.Session;

/**
 *
 * @author Ignacio
 */
public interface IPermisoDao extends IGenericDao<Permiso,Integer> {

 public List<Permiso> getByParameter(String parameter, String value, Session session) throws InstanceException;
}
