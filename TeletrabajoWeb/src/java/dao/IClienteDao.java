/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.Proyecto;
import modelo.Usuario;

/**

 @author LUCIA
 */
public interface IClienteDao
{
    public ArrayList<Cliente>listarClientes();
    public Cliente obtenerClientePorID(int id);
    public Cliente insertarCliente(Cliente c);
    public void actualizarCliente(Cliente c);
    public void eliminarCliente(int id);
    public void asignarUsuario(Usuario u);
    public void desasignarUsuario(Usuario u);
    public void asignarProyecto(Proyecto p);
    public void desasignarProyecto(Proyecto p);
    
}
