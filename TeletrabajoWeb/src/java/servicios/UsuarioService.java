/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package servicios;

import controlador.HibernateUtil;
import dao.UsuarioDao;
import excepciones.DuplicateInstance;
import excepciones.InstanceException;
import java.util.ArrayList;
import modelo.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import serviciosInterfaces.IUsuarioService;

/**

 @author Arlen
 */
public class UsuarioService implements IUsuarioService
{
    protected Session session  = HibernateUtil.getSessionFactory().getCurrentSession();
    protected Transaction t = session.beginTransaction();
    UsuarioDao dao = new UsuarioDao();
    @Override
    public void insertarUsuario(Usuario u) throws DuplicateInstance,InstanceException
    {
        try
        {
            if((dao.getByParameter("login",u.getLogin(),session)).size()!=0||(dao.getByParameter("email",u.getEmail(),session).size()!=0||dao.exist(u))){
               throw  new DuplicateInstance(); 
            }
            
            dao.save(u);
            
            
        }
        catch(HibernateException e)
        {
          throw new InstanceException();
                   
        }
        
    }
    @Override
    public void actualizar(Usuario u) throws InstanceException, DuplicateInstance
    {
       try{
             if((dao.getByParameter("login",u.getLogin(),session)).size()!=0||(dao.getByParameter("email",u.getEmail(),session).size()!=0)){
               throw  new DuplicateInstance(); 
            }
            
            
        }
        catch(HibernateException e)
        {
           throw new InstanceException();
        }
       
    }
    
    
    
    
    @Override
    public Usuario obtenerPorId(int id)  throws InstanceException
    {
     
        
        
        try
        {
            return   dao.findbyId(id);
        }
        catch(Exception e)
        {
          throw new InstanceException();
        }
        
            
     
    }
    @Override
    public ArrayList<Usuario> getUsuarios()  throws InstanceException
    {
        ArrayList list=null;
        try{
       list=(ArrayList)dao.findAll();
        }catch(HibernateException ex){
            new InstanceException();
        }
        return list;
    }

}
