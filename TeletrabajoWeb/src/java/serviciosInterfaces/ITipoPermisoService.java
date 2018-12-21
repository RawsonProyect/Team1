/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package serviciosInterfaces;

import java.util.ArrayList;
import modelo.Tipopermiso;

/**

 @author Arlen
 */
public interface ITipoPermisoService
{
   public ArrayList<Tipopermiso>listarTipopermisos();
    public Tipopermiso obtenerTipopermisoPorID(int id);
    public Tipopermiso insertarTipopermiso(Tipopermiso c);
    public void actualizarTipopermiso(Tipopermiso c);
    public void eliminarTipopermiso(int id);
  
}
