/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package controlador;

import excepciones.DuplicateInstance;
import excepciones.InstanceException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import servicios.UsuarioService;

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
    
       UsuarioService user= new UsuarioService();
        try
        {
            user.insertarUsuario(new Usuario("pepito","asa","sas","ssa","ssdd"));
        }
        catch(DuplicateInstance ex)
        {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE,null,ex);
        }
        catch(InstanceException ex)
        {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        
        
    }
    
}
