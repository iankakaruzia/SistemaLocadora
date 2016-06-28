/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ianka
 */
public class CaixaDAO extends ExecuteSQL{
    
    public CaixaDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Caixa(Caixa c){
        String sql = "insert into caixa values(0, ?, ?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setDouble(1, c.getValor());
            java.sql.Date d = new java.sql.Date(c.getData_entrada().getTime());
            ps.setDate(2, d);
            
            if(ps.executeUpdate() > 0){
                return "Inserido com Sucesso";
            }else{
                return "Erro ao inserir";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
}
