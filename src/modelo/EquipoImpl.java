/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author CliPPer
 */
public class EquipoImpl implements Equipo {

    private String nombre;
    private String pais;
    private String pos_grupo;
    private String grupo;

    public EquipoImpl(String nombre) {
        this.nombre = nombre;
    }

    public EquipoImpl(String nombre, String pais, String pos_grupo, String grupo) {
        this.nombre = nombre;
        this.pais = pais;
        this.pos_grupo = pos_grupo;
        this.grupo = grupo;
    }

    @Override
    public String getPos_grupo() {
        return this.pos_grupo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getPais() {
        return pais;
    }

    @Override
    public String getGrupo() {
        return grupo;
    }

    @Override
    public void setPos_grupo(String pos_grupo) {
        this.pos_grupo = pos_grupo;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

}
