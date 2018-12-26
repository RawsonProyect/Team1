/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package serviciosInterfaces;

import excepciones.DuplicateInstance;
import excepciones.InstanceException;
import java.util.ArrayList;
import modelo.Archivo;
import modelo.Proyecto;
import modelo.Requisito;

/**

 @author Arlen
 */
public interface IProyectoService
{
    public ArrayList<Proyecto> listarProyectos() throws InstanceException;
    public Proyecto obtenerProyectoPorID(int id) throws InstanceException;
    public void insertarProyecto(Proyecto p) throws InstanceException,DuplicateInstance;
    public void actualizarProyecto(Proyecto p) throws InstanceException,DuplicateInstance;
    public void eliminarProyectoCliente(int id) throws InstanceException;
    public void asignarRequisito(Proyecto p,Requisito r) throws InstanceException;
    public void desasignarRequisito(Proyecto p,Requisito r) throws InstanceException;
    public void asignarArchivo(Proyecto p,Archivo arch) throws InstanceException;
    public void desasignarArchivo(Proyecto p,Archivo arch) throws InstanceException;

}
