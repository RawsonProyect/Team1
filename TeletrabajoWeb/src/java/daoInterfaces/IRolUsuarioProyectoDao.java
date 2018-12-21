package daoInterfaces;

import modelo.RolUsuarioProyecto;
import modelo.RolUsuarioProyectoId;

/**
 *
 * @author Ignacio
 */
public interface IRolUsuarioProyectoDao extends IGenericDao<RolUsuarioProyecto,RolUsuarioProyectoId> {

 public boolean getByParameter(String parameter, String value);
}
