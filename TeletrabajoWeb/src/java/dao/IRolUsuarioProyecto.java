package dao;

import java.util.ArrayList;
import modelo.Proyecto;
import modelo.Rol;
import modelo.RolUsuarioProyecto;
import modelo.Usuario;

/**
 *
 * @author Ignacio
 */
public interface IRolUsuarioProyecto {

    public void insertarRolUsuarioProyecto(RolUsuarioProyecto rup);
    public ArrayList<RolUsuarioProyecto> listarRolUsuarioProyecto();
    public RolUsuarioProyecto obtenerRolUsuarioProyectoporID(int id);
    public void actualizarRolUsuarioProyecto(RolUsuarioProyecto permiso);
    public void eliminarRolUsuarioProyecto(RolUsuarioProyecto permiso);
}
