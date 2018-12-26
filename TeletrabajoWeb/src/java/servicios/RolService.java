/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package servicios;

import controlador.HibernateUtil;
import dao.RolDao;
import excepciones.DuplicateInstance;
import excepciones.InstanceException;
import java.util.ArrayList;
import javax.management.InstanceNotFoundException;
import modelo.Permiso;
import modelo.Rol;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import serviciosInterfaces.IRolService;

/**
 *
 * @author Arlen
 */
public class RolService implements IRolService {

    protected Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    protected Transaction t = session.beginTransaction();
    RolDao dao = new RolDao();
    @Override
    public void insertarRol(Rol r) throws DuplicateInstance, InstanceException {
        try {
            if (!(dao.getByParameter("nombre", r.getNombre(), session)).isEmpty()) {
                throw new DuplicateInstance();
            }
            dao.save(r);
        } catch (HibernateException e) {
            throw new InstanceException();
        }
    }
    @Override
    public void actualizarRol(Rol r) throws InstanceException {
        try {
            dao.save(r);
            dao.update(r);
        } catch (HibernateException e) {
            throw new InstanceException();
        }
    }
    @Override
    public Rol obtenerRolPorId(int id) throws InstanceNotFoundException {

        try {
            return dao.findbyId(id);
        } catch (Exception e) {
            throw new InstanceNotFoundException();
        }

    }
    @Override
    public ArrayList<Rol> getRoles() throws InstanceException {
        ArrayList list = null;
        try {
            list = (ArrayList) dao.findAll();
        } catch (HibernateException ex) {
            new InstanceException();
        }
        return list;
    }
    @Override
    public void asignarPermisoaRol(Rol r, Permiso p) throws InstanceNotFoundException, InstanceException {
        try {
            if ((dao.findbyId(r.getIdRol()))!=null) {
                throw new InstanceNotFoundException();
            }
            r.getPermisos().add(p);            
            dao.save(r);
            dao.update(r);
        } catch (HibernateException e) {
            throw new InstanceException();
        }
    }
    @Override
    public void desasignarPermisoaRol(Rol r, Permiso p) throws InstanceNotFoundException, InstanceException {
        try {
            if ((dao.findbyId(r.getIdRol()))!=null) {
                throw new InstanceNotFoundException();
            }
            r.getPermisos().remove(p);            
            dao.save(r);
            dao.update(r);
        } catch (HibernateException e) {
            throw new InstanceException();
        }
    }

}
