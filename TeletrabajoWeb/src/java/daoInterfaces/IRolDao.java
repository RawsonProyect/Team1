package daoInterfaces;

import excepciones.InstanceException;
import java.util.List;
import modelo.Rol;
import org.hibernate.Session;

/**
 *
 * @author Ignacio
 */
public interface IRolDao extends IGenericDao<Rol,Integer>{
 public List<Rol> getByParameter(String parameter, String value, Session session) throws InstanceException;
}
