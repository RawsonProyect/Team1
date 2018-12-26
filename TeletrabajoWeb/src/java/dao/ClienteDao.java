/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package dao;

import daoInterfaces.IClienteDao;
import excepciones.InstanceException;
import java.util.List;
import modelo.Cliente;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**

 @author Arlen
 */
public class ClienteDao extends GenericDao<Cliente,Integer> implements IClienteDao

{
  @Override
    public List<Cliente> getByParameter(String parameter,String value,Session session) throws InstanceException
    {
        return (List<Cliente>) session.createCriteria(Cliente.class).add( Restrictions.like(parameter,value)).list();
    }
}
