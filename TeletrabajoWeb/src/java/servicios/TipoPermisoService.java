/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package servicios;

import controlador.HibernateUtil;
import dao.TipoPermisoDao;
import excepciones.DuplicateInstance;
import excepciones.InstanceException;
import java.util.ArrayList;
import modelo.Tipopermiso;
import org.hibernate.Session;
import org.hibernate.Transaction;
import serviciosInterfaces.ITipoPermisoService;

/**

 @author Arlen
 */
public class TipoPermisoService implements ITipoPermisoService
{
     protected Session session  = HibernateUtil.getSessionFactory().getCurrentSession();
    protected Transaction t = session.beginTransaction();
  private TipoPermisoDao dao= new TipoPermisoDao();
    @Override
    public ArrayList<Tipopermiso> listarTipopermisos() throws InstanceException
    {
         try
        {
          return  (ArrayList)dao.findAll();
           
        }
        catch(Exception e)
        {
            throw new InstanceException();
        }
    }
    @Override
    public Tipopermiso obtenerTipopermisoPorID(int id) throws InstanceException
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
    public void insertarTipopermiso(Tipopermiso tipo) throws DuplicateInstance,InstanceException
    {
        try
        {
          dao.save(tipo);
           
        }
        catch(Exception e)
        {
            throw new InstanceException();
        }
    }
    @Override
    public void actualizarTipopermiso(Tipopermiso tipo) throws DuplicateInstance,InstanceException
    {
         try
        {
         dao.update(tipo);
           
        }
        catch(Exception e)
        {
            throw new InstanceException();
        }
    }
    @Override
    public void eliminarTipopermiso(int id) throws InstanceException
    {
       try
        {
        dao.remove(obtenerTipopermisoPorID(id));
           
        }
        catch(Exception e)
        {
            throw new InstanceException();
        }
    }
   
}
