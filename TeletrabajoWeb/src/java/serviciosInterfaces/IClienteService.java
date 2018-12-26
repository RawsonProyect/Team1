/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package serviciosInterfaces;

import excepciones.DuplicateInstance;
import excepciones.InstanceException;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Proyecto;
import modelo.Usuario;

/**
 *
 * @author Arlen
 */
public interface IClienteService {

    public ArrayList<Cliente> listarClientes()throws InstanceException;
    public Cliente obtenerClientePorID(int id)throws InstanceException;
    public void insertarCliente(Cliente c) throws DuplicateInstance,InstanceException;
    public void actualizarCliente(Cliente c)throws DuplicateInstance,InstanceException;
    public void eliminarCliente(int id)throws InstanceException;
    public void asignarUsuario(Cliente c,Usuario u)throws InstanceException;
    public void desasignarUsuario(Cliente c,Usuario u)throws InstanceException;
    public void asignarProyecto(Cliente c,Proyecto p)throws InstanceException;
    public void desasignarProyecto(Cliente c,Proyecto p)throws InstanceException;
}
