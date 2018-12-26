/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package servicios;

import controlador.HibernateUtil;
import dao.ClienteDao;
import excepciones.DuplicateInstance;
import excepciones.InstanceException;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Proyecto;
import modelo.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import serviciosInterfaces.IClienteService;



/**

 @author Arlen
 */

public class ClienteService implements IClienteService
{
  protected Session session  = HibernateUtil.getSessionFactory().getCurrentSession();
    protected Transaction t = session.beginTransaction();
  private ClienteDao dao= new ClienteDao();
    @Override
   
    public void actualizarCliente(Cliente c) throws InstanceException,DuplicateInstance
    {
        try
        {
             if((dao.getByParameter("cif",c.getCif(),session)).size() != 0 )
            {
                throw new DuplicateInstance();
            }
        }
        catch(HibernateException e)
        {
            throw new InstanceException();
        }
    }

    @Override
    public Cliente obtenerClientePorID(int id) throws InstanceException
    {
        try
        {
            return dao.findbyId(id);
        }
        catch(Exception e)
        {
            throw new InstanceException();
        }
    }
    @Override
    public ArrayList<Cliente> listarClientes() throws InstanceException
    {
        ArrayList list = null;
        try
        {
            list = (ArrayList)dao.findAll();
        }
        catch(HibernateException ex)
        {
            new InstanceException();
        }
        return list;
    }
    @Override
      
    public void eliminarCliente(int id) throws InstanceException
    {
        try
        {
            dao.remove(dao.findbyId(id));
        }
        catch(Exception ex)
        {
            new InstanceException();
        }
    }
    @Override
    
    public void asignarUsuario(Cliente c,Usuario u) throws InstanceException
    {
        try
        {
            c.getUsuarios().add(u);
        
        }
        catch(HibernateException ex)
        {
            new InstanceException();
        }
    }
    @Override
     
    public void desasignarUsuario(Cliente c,Usuario u) throws InstanceException
    {
        try
        {
            c.getUsuarios().remove(u);
        }
        catch(HibernateException e)
        {
           new InstanceException();
        }
    }
    @Override
    public void asignarProyecto(Cliente c,Proyecto p) throws InstanceException
    {
         try
        {
            c.getProyectos().add(p);
        }
        catch(HibernateException e)
        {
           new InstanceException();
        }
       
    }
    @Override
    
    public void desasignarProyecto(Cliente c,Proyecto p) throws InstanceException
    {
         try
        {
            c.getProyectos().remove(p);
        }
        catch(HibernateException e)
        {
           new InstanceException();
        }
    }
    @Override
    
    public void insertarCliente(Cliente c) throws InstanceException,DuplicateInstance
    {
        try
        {
            if((dao.getByParameter("cif",c.getCif(),session)).size() != 0 ||  dao.exist(c))
            {
                throw new excepciones.DuplicateInstance();
            }
            dao.save(c);
        }
        catch(HibernateException e)
        {
            new excepciones.InstanceException();
        }
    }
    

}
