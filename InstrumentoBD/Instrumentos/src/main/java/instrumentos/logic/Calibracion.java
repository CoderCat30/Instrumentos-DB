/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.logic;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Calibracion {
    String numero;
    Instrumento instrumento;
    Date fecha;
    int mediciones;
    List<Medida> medidas;

    public Calibracion() {
        this("",new Instrumento(), new Date(),0);
    }    

    public Calibracion(String numero, Instrumento instrumento, Date fecha, int mediciones) {
        this.numero=numero;
        this.instrumento = instrumento;
        this.fecha = fecha;
        this.mediciones = mediciones;
        this.medidas=new ArrayList<Medida>();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMediciones() {
        return mediciones;
    }

    public void setMediciones(int mediciones) {
        this.mediciones = mediciones;
    }

    public List<Medida> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<Medida> medidas) {
        this.medidas = medidas;
    }

    
}
