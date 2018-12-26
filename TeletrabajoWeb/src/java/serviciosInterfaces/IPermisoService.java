/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package serviciosInterfaces;

import excepciones.DuplicateInstance;
import excepciones.InstanceException;
import java.util.ArrayList;
import modelo.Permiso;

/**

 @author Arlen
 */
public interface IPermisoService
{
     public ArrayList<Permiso> listarPermisos()throws InstanceException;
    public Permiso obtenerPermisoPorID(int id)throws InstanceException;
    public void insertarPermiso(Permiso c) throws DuplicateInstance,InstanceException;
    public void actualizarPermiso(Permiso c)throws DuplicateInstance,InstanceException;
    public void eliminarPermiso(int id)throws InstanceException;
  
}
