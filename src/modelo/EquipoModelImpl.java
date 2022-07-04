/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.EquipoController;
import java.util.List;
import modelo.persistencia.EquipoDAO;
import modelo.persistencia.JDBC.EquipoDAOJDBC;

/**
 *
 * @author CliPPer
 */
public class EquipoModelImpl implements EquipoModel {

    private String nombre;
    private EquipoController controller;
    private Equipo contacto;
    private List<Equipo> equipos;

    @Override
    public EquipoController getController() {
        return controller;
    }

    @Override
    public void setController(EquipoController controller) {
        this.controller = controller;
    }

    @Override
    public void nuevoEquipo(Equipo contacto) {
         EquipoDAO e = crearEquipoDao();
         e.create(contacto);
        //Avisamos cada vez que cambiamos la base de datos
        this.controller.fireDataModelChanged();
    }

    @Override
    public Equipo obtenerEquipo(String nombre) {
        EquipoDAO e = crearEquipoDao();
        return e.read(nombre);   
    }

    @Override
    public void eliminarEquipo(Equipo contacto) {
        EquipoDAO e = crearEquipoDao();
        e.delete(contacto);
         //Avisamos cada vez que cambiamos la base de datos
        this.controller.fireDataModelChanged();
    }

    @Override
    public void actualizarEquipo(Equipo contacto) {
        EquipoDAO e = crearEquipoDao();
        e.update(contacto);
        this.controller.fireDataModelChanged();
    }

    @Override
    public List<Equipo> obtenerEquipos() {
        EquipoDAO e = crearEquipoDao();
        return e.list();
    }

    public static EquipoDAOJDBC crearEquipoDao() {
        EquipoDAOJDBC e = new EquipoDAOJDBC();
        return e;
    }
;

    @Override
    public int validaciones(String nombre, String pais, String pos_grupo, String grupo) {
       int i = 0;
       String g = "";
       int suma = 0;
       int index = 0;
       EquipoDAO e = crearEquipoDao();
       this.equipos = e.list();
       
       //Dos equipos por grupo
        while (suma < 2 && index < equipos.size()-1){
             index++;
             this.contacto = equipos.get(index);   
             g = contacto.getGrupo();
             if (g.equals(grupo) ) {
                suma++;
            }
        }
        if (suma == 2 ) {
            i = 1;
        }
        
        
       return i;
    }

}
