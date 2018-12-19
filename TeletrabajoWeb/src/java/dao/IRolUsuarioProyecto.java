package dao;

import java.util.ArrayList;
import modelo.RolUsuarioProyecto;

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
