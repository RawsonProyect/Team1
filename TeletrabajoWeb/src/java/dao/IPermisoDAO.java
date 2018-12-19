package dao;

import java.util.ArrayList;
import modelo.Permiso;

/**
 *
 * @author Ignacio
 */
public interface IPermisoDAO {

    public void insertarPermiso(Permiso permiso);
    public ArrayList<Permiso> listarPermiso();
    public Permiso obtenerPermisoPorId(int id);
    public void actualizarPermiso(Permiso permiso);
    public void eliminarPermiso(Permiso permiso);
}
