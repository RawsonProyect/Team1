/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package servicios;

import serviciosInterfaces.IUsuarioService;
import controlador.HibernateUtil;
import dao.UsuarioDao;
import java.util.ArrayList;
import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**

 @author Arlen
 */
public class UsuarioService implements IUsuarioService
{
 protected Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    protected Transaction t = session.beginTransaction();
    UsuarioDao dao= new UsuarioDao();
    @Override
    public Usuario insertarUsuario(Usuario u)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void actualizar(Usuario u)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Usuario obtenerPorId(int id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public ArrayList<Usuario> getUsuarios()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
