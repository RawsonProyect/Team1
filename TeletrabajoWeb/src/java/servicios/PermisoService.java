/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package servicios;

import controlador.HibernateUtil;
import dao.PermisoDao;
import excepciones.DuplicateInstance;
import excepciones.InstanceException;
import java.util.ArrayList;
import modelo.Permiso;
import org.hibernate.Session;
import org.hibernate.Transaction;
import serviciosInterfaces.IPermisoService;

/**

 @author Arlen
 */
public class PermisoService implements IPermisoService
{
    protected Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    protected Transaction t = session.beginTransaction();
    private PermisoDao dao = new PermisoDao();
    @Override
    public ArrayList<Permiso> listarPermisos() throws InstanceException
    {
        try
        {
            return (ArrayList)dao.findAll();
        }
        catch(Exception e)
        {
            throw new InstanceException();
        }
    }
    @Override
    public Permiso obtenerPermisoPorID(int id) throws InstanceException
    {
        try
        {
          return  dao.findbyId(id);
           
        }
        catch(Exception e)
        {
            throw new InstanceException();
        }
    }
    @Override
    public void insertarPermiso(Permiso p) throws DuplicateInstance,InstanceException
    {
         try
        {
            dao.save(p);
           
        }
        catch(Exception e)
        {
            throw new InstanceException();
        }
      
    }
    @Override
    public void actualizarPermiso(Permiso p) throws DuplicateInstance,InstanceException
    {
       try
        {
         dao.update(p);
           
        }
        catch(Exception e)
        {
            throw new InstanceException();
        }
    }
    @Override
    public void eliminarPermiso(int id) throws InstanceException
    {
        try
        {
          dao.remove(obtenerPermisoPorID(id));
           
        }
        catch(Exception e)
        {
            throw new InstanceException();
        }
    }

}
