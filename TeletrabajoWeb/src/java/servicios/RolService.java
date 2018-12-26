/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package servicios;


import excepciones.InstanceException;
import java.util.ArrayList;
import javax.management.InstanceNotFoundException;
import modelo.Rol;
import serviciosInterfaces.IRolService;

/**

 @author Arlen
 */
public class RolService implements IRolService
{
    @Override
    public Rol insertarRol(Rol r) throws InstanceException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void actualizarRol(Rol r) throws InstanceException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Rol obtenerRolPorId(int id) throws InstanceNotFoundException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public ArrayList<Rol> getRoles() throws InstanceException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
