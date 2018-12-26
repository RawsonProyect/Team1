/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package serviciosInterfaces;

import excepciones.DuplicateInstance;
import excepciones.InstanceException;
import java.util.ArrayList;
import modelo.Usuario;

/**

 @author Arlen
 */
public interface IUsuarioService
{
    public void insertarUsuario(Usuario u)throws DuplicateInstance, InstanceException;
    public void actualizar(Usuario u) throws InstanceException, DuplicateInstance;
    public Usuario obtenerPorId(int id) throws InstanceException;
    public ArrayList<Usuario> getUsuarios()throws InstanceException ;  
}
