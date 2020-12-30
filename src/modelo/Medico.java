package modelo;

import java.io.Serializable;

public class Medico implements Serializable{
	
	private int me_id;
    private String me_especialidad;
    private String me_sueldo;
    
    public Medico(int me_id,String me_especialidad,String me_sueldo){
        this.me_id=me_id;
        this.me_especialidad= me_especialidad;
        this.me_sueldo= me_sueldo;
    }

    public Medico() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public int getMe_id() {
        return me_id;
    }

    public String getMe_especialidad() {
        return me_especialidad;
    }

    public String getMe_sueldo() {
        return me_sueldo;
    }

    public void setMe_id(int me_id) {
        this.me_id = me_id;
    }

    public void setMe_especialidad(String me_especialidad) {
        this.me_especialidad = me_especialidad;
    }

    public void setMe_sueldo(String me_sueldo) {
        this.me_sueldo = me_sueldo;
    }

    @Override
    public String toString() {
        return "Medico{" + "me_id=" + me_id + ", me_especialidad=" + me_especialidad + ", me_sueldo=" + me_sueldo + '}';
    }
    
}
