/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cg3002624
 */
public class Planta {

    private int idPlanta;
    private String nome_planta;
    private String regiao_planta;
    private String imagem_planta;
    private Clima clima_planta;
    private Irrigacao irrigacao_planta;
    private Colheita colheita_planta;
    private Luminosidade luminosidade_planta;
    private Solo solo_planta;
    private TratosCulturais tratos_culturais_planta;

    public Planta() {
        this.clima_planta = new Clima();
        this.irrigacao_planta = new Irrigacao();
        this.colheita_planta = new Colheita();
        this.luminosidade_planta = new Luminosidade();
        this.solo_planta = new Solo();
        this.tratos_culturais_planta = new TratosCulturais();
    }

    public int getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(int idPlanta) {
        this.idPlanta = idPlanta;
    }

    public String getNome_planta() {
        return nome_planta;
    }

    public void setNome_planta(String nome_planta) {
        this.nome_planta = nome_planta;
    }

    public String getRegiao_planta() {
        return regiao_planta;
    }

    public void setRegiao_planta(String regiao_planta) {
        this.regiao_planta = regiao_planta;
    }

    public String getImagem_planta() {
        return imagem_planta;
    }

    public void setImagem_planta(String imagem_planta) {
        this.imagem_planta = imagem_planta;
    }

    public Clima getClima_planta() {
        return clima_planta;
    }

    public void setClima_planta(Clima clima_planta) {
        this.clima_planta = clima_planta;
    }

    public Irrigacao getIrrigacao_planta() {
        return irrigacao_planta;
    }

    public void setIrrigacao_planta(Irrigacao irrigacao_planta) {
        this.irrigacao_planta = irrigacao_planta;
    }

    public Colheita getColheita_planta() {
        return colheita_planta;
    }

    public void setColheita_planta(Colheita colheita_planta) {
        this.colheita_planta = colheita_planta;
    }

    public Luminosidade getLuminosidade_planta() {
        return luminosidade_planta;
    }

    public void setLuminosidade_planta(Luminosidade luminosidade_planta) {
        this.luminosidade_planta = luminosidade_planta;
    }

    public Solo getSolo_planta() {
        return solo_planta;
    }

    public void setSolo_planta(Solo solo_planta) {
        this.solo_planta = solo_planta;
    }

    public TratosCulturais getTratos_culturais_planta() {
        return tratos_culturais_planta;
    }

    public void setTratos_culturais_planta(TratosCulturais tratos_culturais_planta) {
        this.tratos_culturais_planta = tratos_culturais_planta;
    }

    public void Cadastrar() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("call cadastrarPlanta('" + this.nome_planta + "','" + this.regiao_planta + "','" + this.imagem_planta + "')");
            if (stmt.execute() == true) {
                rs = stmt.getResultSet();
                rs.next();
                this.idPlanta = rs.getInt("idPlanta");
                /* VERIFICA SE EXISTE INFORMAÇÕES SOBRE O CLIMA DA PLANTA, SE EXISTIR REALIZA CADASTRO NO BD */
                if (!this.clima_planta.getDescricao_clima().equals("")) {
                    stmt = con.prepareStatement("INSERT INTO clima(idPlanta, descricao_clima, imagem_clima) values (" + this.idPlanta + ",'" + this.clima_planta.getDescricao_clima() + "','" + this.clima_planta.getImagem_clima() + "')");
                    stmt.executeUpdate();
                }
                /* VERIFICA SE EXISTE INFORMAÇÕES SOBRE A COLHEITA, SE EXISTIR REALIZA CADASTRO NO BD */
                if (!this.colheita_planta.getDescricao_colheita().equals("")) {
                    stmt = con.prepareStatement("INSERT INTO colheita(idPlanta, descricao_colheita, imagem_colheita) values (" + this.idPlanta + ",'" + this.colheita_planta.getDescricao_colheita() + "','" + this.colheita_planta.getImagem_colheita() + "')");
                    stmt.executeUpdate();
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Planta.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Id da planta cadastrada: " + this.idPlanta);
    }

    public void Modificar() {

    }

    public void Listar() {

    }

    public void Buscar() {

    }

    public void Excluir() {

    }

}
