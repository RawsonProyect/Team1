/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package serviciosInterfaces;

import java.util.ArrayList;
import modelo.Archivo;
import modelo.Proyecto;
import modelo.Requisito;

/**

 @author Arlen
 */
public interface IProyectoService
{
    public ArrayList<Proyecto> listarProyectos();
    public Proyecto obtenerProyectoPorID(int id);
    public Proyecto insertarProyecto(Proyecto p);
    public void actualizarProyecto(Proyecto p);
    public void eliminarProyectoCliente(int id);
    public void asignarRequisito(Requisito r);
    public void desasignarRequisito(Requisito r);
    public void asignarArchivo(Archivo arch);
public void desasignarArchivo(Archivo arch); 
    
    
    
    
}
