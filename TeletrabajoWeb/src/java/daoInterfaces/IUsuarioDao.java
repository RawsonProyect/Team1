/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package daoInterfaces;

import modelo.Usuario;

/**

 @author LUCIA
 */
public interface IUsuarioDao extends IGenericDao<Usuario,Integer>
{
 public boolean getByParameter(String parameter, String value);
  

}
