/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package serviciosInterfaces;

import java.util.ArrayList;
import modelo.Usuario;

/**

 @author Arlen
 */
public interface IUsuarioService
{
    public Usuario insertarUsuario(Usuario u);
    public void actualizar(Usuario u) ;
    public Usuario obtenerPorId(int id) ;
    public ArrayList<Usuario> getUsuarios() ;  
}
