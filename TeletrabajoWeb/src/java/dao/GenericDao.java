/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import controlador.HibernateUtil;
import daoInterfaces.IGenericDao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.management.InstanceNotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author LUCIA
 */
public class GenericDao<E, PK extends Serializable> implements IGenericDao<E, PK> {

    private Class<E> entityClass;
    protected Session session = HibernateUtil.getSessionFactory().getCurrentSession();
   // protected Transaction t = session.beginTransaction();

    public GenericDao() {
        entityClass = (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    

    @Override
    public void save(E entity) {

        try{
        int id = (int) session.save(entity);
       
        }catch(HibernateException e){
            throw new HibernateException(e);
        }
        
    }

    @Override
    public void update(Object entity) {
        try{
             session.update(entity);
      
        }catch(HibernateException e){
            throw new HibernateException(e);
        }
        
       

    }

    @Override
    public boolean exist(Serializable id) {
        return session.createCriteria(entityClass).add(Restrictions.idEq(id)).setProjection(Projections.id()).uniqueResult() != null;
    }

    @Override
    public List findAll() {
        try{
            return session.createCriteria(this.entityClass).list();
        }catch(HibernateException e){
            throw new HibernateException(e);
        }
        
    }


    @Override
    public void remove(E entity) {
        session.delete(entity);
      

    }

    @Override
    public E findbyId(PK id) throws InstanceNotFoundException {
        
        E  entidad= (E) session.get(entityClass, id);
        if(entidad==null){
            throw new InstanceNotFoundException();
        }
        return entidad;

    }

}
