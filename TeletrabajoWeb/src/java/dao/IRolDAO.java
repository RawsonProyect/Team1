package dao;

import java.util.ArrayList;
import modelo.Permiso;
import modelo.Rol;

/**
 *
 * @author Ignacio
 */
public interface IRolDAO {

    public void insertarRol(Rol rol);
    public ArrayList<Rol> listarRol();
    public Rol obtenerRolPorId(int id);
    public void actualizarRol(Rol rol);
    public void eliminarRol(Rol rol);
    public void asignarPermisoARol(Rol r, Permiso p);
    public void desasignarPermisoARol(Rol r, Permiso p);
    public ArrayList<Permiso> listarPermisoRol(Rol r);
}
