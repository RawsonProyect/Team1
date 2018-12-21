package daoInterfaces;

import modelo.Permiso;

/**
 *
 * @author Ignacio
 */
public interface IPermisoDao extends IGenericDao<Permiso,Integer> {

  public boolean getByParameter(String parameter, String value);
}
