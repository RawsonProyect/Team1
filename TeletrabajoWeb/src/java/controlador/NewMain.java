/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package controlador;

import org.hibernate.Session;

/**

 @author Arlen
 */
public class NewMain
{

    /**
     @param args the command line arguments
     */
    public static void main(String[] args)
    {
       Session s = HibernateUtil.getSessionFactory().getCurrentSession();
       s.beginTransaction();
       
        
        
        
    }
    
}
