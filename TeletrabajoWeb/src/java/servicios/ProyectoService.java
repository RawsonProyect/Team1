/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package servicios;

import controlador.HibernateUtil;
import dao.ProyectoDao;
import excepciones.DuplicateInstance;
import excepciones.InstanceException;
import java.util.ArrayList;
import modelo.Archivo;
import modelo.Proyecto;
import modelo.Requisito;
import org.hibernate.Session;
import org.hibernate.Transaction;
import serviciosInterfaces.IProyectoService;

/**

 @author Arlen
 */
public class ProyectoService implements IProyectoService
{
    protected Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    protected Transaction t = session.beginTransaction();
    ProyectoDao dao = new ProyectoDao();
    public ArrayList<Proyecto> listarProyectos() throws InstanceException
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
    public Proyecto obtenerProyectoPorID(int id) throws InstanceException
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

    public void insertarProyecto(Proyecto p) throws InstanceException,DuplicateInstance
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

    public void actualizarProyecto(Proyecto p) throws InstanceException,DuplicateInstance
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

    public void eliminarProyectoCliente(int id) throws InstanceException
    {
        try
        {
            dao.remove(obtenerProyectoPorID(id));
        }
        catch(Exception e)
        {
            throw new InstanceException();
        }
    }
    @Override

    public void asignarRequisito(Proyecto p,Requisito r) throws InstanceException
    {
        p.getRequisitos().add(r);
    }
    @Override

    public void desasignarRequisito(Proyecto p,Requisito r) throws InstanceException
    {
        try
        {
            p.getRequisitos().remove(r);
        }
        catch(Exception e)
        {
            throw new InstanceException();
        }
    }
    @Override

    public void asignarArchivo(Proyecto p,Archivo arch) throws InstanceException
    {
        try
        {
            p.getArchivos().add(arch);
        }
        catch(Exception e)
        {
            throw new InstanceException();
        }
    }
    @Override
    public void desasignarArchivo(Proyecto p,Archivo arch) throws InstanceException
    {
        try
        {
            p.getArchivos().remove(arch);
        }
        catch(Exception e)
        {
            throw new InstanceException();
        }
    }

}
