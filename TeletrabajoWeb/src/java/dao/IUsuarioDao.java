/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Usuario;

/**

 @author LUCIA
 */
public interface IUsuarioDao
{

    public ArrayList<Usuario> listarUsuarios();
    public Usuario obtenerUsuarioPorID(int id);
    public Usuario crearUsuario(Usuario u);
    public void actualizarUsuario(Usuario u);
    public void eliminarUsuario(int id);
  

}
