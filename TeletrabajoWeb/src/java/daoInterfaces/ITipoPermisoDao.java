/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package daoInterfaces;

import excepciones.InstanceException;
import java.util.List;
import modelo.Tipopermiso;
import org.hibernate.Session;

/**

 @author Arlen
 */
public interface ITipoPermisoDao extends IGenericDao<Tipopermiso,Integer>
{
 public List<Tipopermiso> getByParameter(String parameter, String value, Session session) throws InstanceException;
    
    
}
