/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package daoInterfaces;

import modelo.Proyecto;

/**

 @author LUCIA
 */
public interface IProyectoDao extends IGenericDao<Proyecto,Integer>
{
    public boolean getByParameter(String parameter, String value);
    
}
