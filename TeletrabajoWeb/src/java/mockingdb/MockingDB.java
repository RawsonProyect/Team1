package mockingdb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import modelo.*;

/**
 *
 * @author Ignacio
 */
public class MockingDB {

    private static final ArrayList<Cliente> CLIENTELIST = new ArrayList<>();
    private static final ArrayList<Tipopermiso> TIPOPERMISOLIST = new ArrayList<>();
    private static final ArrayList<Permiso> PERMISOLIST = new ArrayList<>();
    private static final ArrayList<Proyecto> PROYECTOLIST = new ArrayList<>();
    private static final ArrayList<Rol> ROLLIST = new ArrayList<>();
    private static final ArrayList<Usuario> USUARIOLIST = new ArrayList<>();
    private static final ArrayList<RolUsuarioProyecto> ROLUSUARIOPROYECTOLIST = new ArrayList<>();
    private static final ArrayList<RolUsuarioProyectoId> ROLUSUARIOPROYECTOIDLIST = new ArrayList<>();

    // Instance
    public static void instanceClientes() {
        Cliente c1 = new Cliente("Cliente Falso", "98765432X");
        Cliente c2 = new Cliente("Cliente De Mentira", "87654322Y");
        Cliente c3 = new Cliente("Cliente Cutre", "76543210Z");
        Cliente c4 = new Cliente("Cliente Muy Cutre", "65432109U");
        Cliente c5 = new Cliente("Cliente Muy Falso", "54321098V");
        addCliente(c1);
        addCliente(c2);
        addCliente(c3);
        addCliente(c4);
        addCliente(c5);
    }
    public static void instanceTipoPermisos() {
        Tipopermiso crear = new Tipopermiso("crear");
        Tipopermiso modificar = new Tipopermiso("modificar");
        Tipopermiso ver = new Tipopermiso("ver");
        Tipopermiso eliminar = new Tipopermiso("eliminar");
        addTipoPermiso(crear);
        addTipoPermiso(modificar);
        addTipoPermiso(ver);
        addTipoPermiso(eliminar);
    }
    public static void instancePermisos() {
        Permiso p1 = new Permiso("usuario");
        Permiso p2 = new Permiso("usuario");
        Permiso p3 = new Permiso("usuario");
        Permiso p4 = new Permiso("usuario");
        Permiso p5 = new Permiso("proyecto");
        p1.setTipopermiso(TIPOPERMISOLIST.get(0));
        p2.setTipopermiso(TIPOPERMISOLIST.get(1));
        p3.setTipopermiso(TIPOPERMISOLIST.get(2));
        p4.setTipopermiso(TIPOPERMISOLIST.get(3));
        p5.setTipopermiso(TIPOPERMISOLIST.get(0));
        addPermiso(p1);
        addPermiso(p2);
        addPermiso(p3);
        addPermiso(p4);
        addPermiso(p5);
    }
    public static void instanceProyectos() {
        Proyecto p1 = new Proyecto(CLIENTELIST.get(0), "Proyecto 0", false);
        Proyecto p2 = new Proyecto(CLIENTELIST.get(1), "Proyecto 1", false);
        Proyecto p3 = new Proyecto(CLIENTELIST.get(2), "Proyecto 2", false);
        Proyecto p4 = new Proyecto(CLIENTELIST.get(2), "Proyecto 3", false);
        Proyecto p5 = new Proyecto(CLIENTELIST.get(3), "Proyecto 4", false);
        addProyecto(p1);
        addProyecto(p2);
        addProyecto(p3);
        addProyecto(p4);
        addProyecto(p5);
    }
    public static void instanceRoles() {
        Rol rol1 = new Rol("administrador");
        Rol rol2 = new Rol("clientejefe");
        Rol rol3 = new Rol("clienteprogramador");
        Rol rol4 = new Rol("programador");
        Rol rol5 = new Rol("gestor");
        addRol(rol1);
        addRol(rol2);
        addRol(rol3);
        addRol(rol4);
        addRol(rol5);
    }
    public static void instanceUsuarios() {
        Usuario u1 = new Usuario("Usuario Numero1", "12345678A", "1234", "user1@mail.com", "user1");
        Usuario u2 = new Usuario("Usuario Numero2", "23456789B", "123456", "user2@mail.com", "user2");
        Usuario u3 = new Usuario("Usuario Numero3", "34567890C", "1234", "user3@mail.com", "user3");
        Usuario u4 = new Usuario("Usuario Numero4", "45678901D", "1234", "user4@mail.com", "user4");
        Usuario u5 = new Usuario("Usuario Numero5", "56789012E", "123456", "user5@mail.com", "user5");
        addUsuario(u1);
        addUsuario(u2);
        addUsuario(u3);
        addUsuario(u4);
        addUsuario(u5);
    }
    public static void instanceRolUsuarioProyecto() {
        // Usuario gestor a Proyecto 0        
        Rol r = null;
        Proyecto p = null;
        Usuario u = null;
        for (Rol rol : ROLLIST) {
            if (rol.getNombre().equals("gestor")) {
                r = rol;
            }
        }
        for (Proyecto proy : PROYECTOLIST) {
            if (proy.getNombre().equals("Proyecto 0")) {
                p = proy;
            }
        }
        for (Usuario user : USUARIOLIST) {
            if (user.getLogin().equals("User1")) {
                u = user;
            }
        }
        assignRolUsuarioProyecto(r, u, p);

        // Usuario cliente a Proyectos 1 y 2 
        for (Rol rol : ROLLIST) {
            if (rol.getNombre().equals("clientejefe")) {
                r = rol;
            }
        }
        for (Proyecto proy : PROYECTOLIST) {
            if (proy.getNombre().equals("Proyecto 1")) {
                p = proy;
            }
        }
        for (Usuario user : USUARIOLIST) {
            if (user.getLogin().equals("User2")) {
                u = user;
            }
        }
        assignRolUsuarioProyecto(r, u, p);
        for (Proyecto proy : PROYECTOLIST) {
            if (proy.getNombre().equals("Proyecto 2")) {
                p = proy;
            }
        }
        assignRolUsuarioProyecto(r, u, p);

        // Usuario programador a Proyectos 2 y 3
        for (Rol rol : ROLLIST) {
            if (rol.getNombre().equals("programador")) {
                r = rol;
            }
        }
        for (Proyecto proy : PROYECTOLIST) {
            if (proy.getNombre().equals("Proyecto 2")) {
                p = proy;
            }
        }
        for (Usuario user : USUARIOLIST) {
            if (user.getLogin().equals("User3")) {
                u = user;
            }
        }
        assignRolUsuarioProyecto(r, u, p);
        for (Proyecto proy : PROYECTOLIST) {
            if (proy.getNombre().equals("Proyecto 3")) {
                p = proy;
            }
        }
        assignRolUsuarioProyecto(r, u, p);
    }

    // List
    public static ArrayList<Cliente> getCLIENTELIST() { // Arlen
        return CLIENTELIST;
    }
    public static ArrayList<Permiso> getPERMISOLIST() { // Arlen
        return PERMISOLIST;
    }
    public static ArrayList<Proyecto> getPROYECTOLIST() {
        return PROYECTOLIST;
    }
    public static ArrayList<Rol> getROLLIST() {
        ArrayList<Rol> lista = new ArrayList<>();
        Rol r;
        for (Rol rol : ROLLIST) {
            r = new Rol(rol.getNombre(), rol.getPermisos(), rol.getRolUsuarioProyectos());
            lista.add(r);
        }
        return lista;
    }
    public static ArrayList<Usuario> getUSUARIOLIST() {
        ArrayList<Usuario> lista = new ArrayList<>();
        Usuario usuario;
        for (Usuario u : USUARIOLIST) {
            usuario = new Usuario(u.getNombre(), u.getDni(), u.getPassword(),
                    u.getEmail(), u.getLogin(), u.getVersions(), u.getUsuarioAlertas(),
                    u.getChatgrupos(), u.getRequisitos(), u.getClientes(), u.getTareas(),
                    u.getMensajes(), u.getInformes(), u.getRolUsuarioProyectos());
            lista.add(usuario);
        }
        return lista;
    }
    public static ArrayList<Tipopermiso> getTIPOPERMISOLIST() {
        return TIPOPERMISOLIST;
    } // Arlen
    public static ArrayList<RolUsuarioProyecto> getROLUSUARIOPROYECTOLIST() {
        
        return ROLUSUARIOPROYECTOLIST;
    }
    public static ArrayList<RolUsuarioProyectoId> getROLUSUARIOPROYECTOIDLIST() {
        return ROLUSUARIOPROYECTOIDLIST;
    }

    // Add
    public static void addCliente(Cliente c) {
        int maxId = 1;
        for (Cliente cliente : CLIENTELIST) {
            if (cliente.getIdCliente() > maxId) {
                maxId = cliente.getIdCliente();
            }
        }
        c.setIdCliente(maxId + 1);
        CLIENTELIST.add(c);
    }
    public static void addPermiso(Permiso p) {
        int maxId = 1;
        for (Permiso permiso : PERMISOLIST) {
            if (permiso.getIdPermiso() > maxId) {
                maxId = permiso.getIdPermiso();
            }
        }
        p.setIdPermiso(maxId + 1);
        PERMISOLIST.add(p);
    }
    public static void addProyecto(Proyecto p) {
        int maxId = 1;
        for (Proyecto proyecto : PROYECTOLIST) {
            if (proyecto.getIdProyecto() > maxId) {
                maxId = proyecto.getIdProyecto();
            }
        }
        p.setIdProyecto(maxId + 1);
        PROYECTOLIST.add(p);
    }
    public static void addRol(Rol r) {
        int maxId = 1;
        for (Rol rol : ROLLIST) {
            if (rol.getIdRol() > maxId) {
                maxId = rol.getIdRol();
            }
        }
        r.setIdRol(maxId + 1);
        ROLLIST.add(r);
    }
    public static void addTipoPermiso(Tipopermiso tipoP) {
        int maxId = 1;
        for (Tipopermiso tipopermiso : TIPOPERMISOLIST) {
            if (tipopermiso.getIdTipoPermiso() > maxId) {
                maxId = tipopermiso.getIdTipoPermiso();
            }
        }
        tipoP.setIdTipoPermiso(maxId + 1);
        TIPOPERMISOLIST.add(tipoP);
    }
    public static void addUsuario(Usuario u) {
        int maxId = 1;
        for (Usuario usuario : USUARIOLIST) {
            if (usuario.getIdUsuario() > maxId) {
                maxId = usuario.getIdUsuario();
            }
        }
        u.setIdUsuario(maxId + 1);
        USUARIOLIST.add(u);
    }

    // Assign
    public static void assignRolUsuarioProyecto(Rol r, Usuario u, Proyecto p) {
        RolUsuarioProyectoId rupi1 = new RolUsuarioProyectoId(r.getIdRol(), u.getIdUsuario(), p.getIdProyecto());
        RolUsuarioProyecto rup1 = new RolUsuarioProyecto(rupi1, p, r, u);
        ROLUSUARIOPROYECTOIDLIST.add(rupi1);
        ROLUSUARIOPROYECTOLIST.add(rup1);
    }
    public static void assignPermisoRol(Permiso p, Rol r) {
        Set roles = p.getRols();
        roles.add(r);
        p.setRols(roles);
        Set permisos = r.getPermisos();
        permisos.add(p);
        r.setPermisos(permisos);
    }

    // Remove
    public static void removeCliente(Cliente c) {
        CLIENTELIST.remove(c);
    }
    public static void removePermiso(Permiso p) {
        PERMISOLIST.remove(p);
    }
    public static void removeProyecto(Proyecto p) {
        PROYECTOLIST.remove(p);
    }
    public static void removeRol(Rol r) {
        ROLLIST.remove(r);
    }
    public static void removeUsuario(Usuario u) {
        USUARIOLIST.remove(u);
    }
    public static void removeTipoPermiso(Tipopermiso tipoP) {
        TIPOPERMISOLIST.remove(tipoP);
    }

    // Update  
    public static void updateCliente(Cliente c) {
        for (Cliente client : CLIENTELIST) {
            if (client.getIdCliente() == c.getIdCliente()) {
                CLIENTELIST.remove(client);
            }
        }
        CLIENTELIST.add(c);
    }
    public static void updatePermiso(Permiso p) {
        for (Permiso permiso : PERMISOLIST) {
            if (permiso.getIdPermiso() == p.getIdPermiso()) {
                PERMISOLIST.remove(permiso);
            }
        }
        PERMISOLIST.add(p);
    }
    public static void updateProyecto(Proyecto p) {
        for (Proyecto proyecto : PROYECTOLIST) {
            if (proyecto.getIdProyecto() == p.getIdProyecto()) {
                PROYECTOLIST.remove(proyecto);
            }
        }
        PROYECTOLIST.add(p);
    }
    public static void updateRol(Rol r) {
        for (Rol rol : ROLLIST) {
            if (rol.getIdRol() == r.getIdRol()) {
                ROLLIST.remove(rol);
            }
        }
        ROLLIST.add(r);
    }
    public static void updateUsuario(Usuario u) {
        for (Usuario user : USUARIOLIST) {
            if (user.getIdUsuario() == u.getIdUsuario()) {
                USUARIOLIST.remove(user);
            }
        }
        USUARIOLIST.add(u);
    }
    public static void updateTipoPermiso(Tipopermiso tipoP) {
        for (Tipopermiso tipo : TIPOPERMISOLIST) {
            if (tipo.getIdTipoPermiso() == tipoP.getIdTipoPermiso()) {
                PERMISOLIST.remove(tipo);
            }
        }
        TIPOPERMISOLIST.add(tipoP);
    }
}
