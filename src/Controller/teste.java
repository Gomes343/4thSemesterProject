/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Clima;
import Classes.Planta;
import Classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cg3002624
 */
public class teste {
    public static void main(String[] args) {
        Planta p = new Planta();
        p.setImagem_planta("....");
        p.setNome_planta("Rucula");
        p.setRegiao_planta("Centro-sul");
        Clima c = new Clima();
        c.setDescricao_clima("ISSO AI");
        c.setImagem_clima(".....");
        p.setClima_planta(c);
        p.Cadastrar();
    }
}
