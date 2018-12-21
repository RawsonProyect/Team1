package daoInterfaces;

import modelo.Rol;

/**
 *
 * @author Ignacio
 */
public interface IRolDao extends IGenericDao<Rol,Integer>{
 public boolean getByParameter(String parameter, String value);
}
