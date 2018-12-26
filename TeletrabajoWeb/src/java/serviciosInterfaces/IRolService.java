package serviciosInterfaces;

import excepciones.InstanceException;
import java.util.ArrayList;
import javax.management.InstanceNotFoundException;
import modelo.Rol;

/**

 @author Arlen
 */
public interface IRolService
{
    public Rol insertarRol(Rol r) throws InstanceException;
    public void actualizarRol(Rol r) throws InstanceException;
    public Rol obtenerRolPorId(int id) throws InstanceNotFoundException;
    public ArrayList<Rol> getRoles() throws InstanceException;
}
