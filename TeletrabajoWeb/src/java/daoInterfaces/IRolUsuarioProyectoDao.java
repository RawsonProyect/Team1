package daoInterfaces;

import excepciones.InstanceException;
import java.util.List;
import modelo.RolUsuarioProyecto;
import modelo.RolUsuarioProyectoId;
import org.hibernate.Session;

/**
 *
 * @author Ignacio
 */
public interface IRolUsuarioProyectoDao extends IGenericDao<RolUsuarioProyecto,RolUsuarioProyectoId> {

 public List<RolUsuarioProyecto> getByParameter(String parameter, String value, Session session) throws InstanceException;
}
