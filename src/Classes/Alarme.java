/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author cg3002624
 */

public class Alarme {
    
    private int idAlarme;
    private String horario_alarme;
    private Plantio Plantio;

    public Plantio getPlantio() {
        return Plantio;
    }

    public void setPlantio(Plantio plantio) {
        this.Plantio = plantio;
    }

    public int getIdAlarme() {
        return idAlarme;
    }

    public void setIdAlarme(int idAlarme) {
        this.idAlarme = idAlarme;
    }

    public String getHorario_alarme() {
        return horario_alarme;
    }

    public void setHorario_alarme(String horario_alarme) {
        this.horario_alarme = horario_alarme;
    }
    
    public void Avisar(){
        
    }
    
    public void AdicionarAlarme() {
        
    }
    
    public void ExcluirAlarme(){
        
    }
}
