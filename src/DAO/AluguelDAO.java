/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Aluguel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ianka
 */
public class AluguelDAO extends ExecuteSQL{
    
    public AluguelDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Aluguel(Aluguel a){
        String sql = "insert into aluguel values(0, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod_filme());
            ps.setInt(2, a.getCod_cliente());
            ps.setString(3, a.getHorario());
            ps.setString(4, a.getData_aluguel());
            ps.setString(5, a.getData_devolucao());
            
            if(ps.executeUpdate() > 0){
                return "Inserido com Sucesso.";
            }else{
                return "Erro ao Inserir.";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public int qtdFilmesAlugados(){
        String sql = "select count(*) from aluguel";
        int qtd = 0;
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs!=null){
                while(rs.next()){
                    qtd = rs.getInt(1);
                }
            }
        } catch (Exception e) {
        }
        return qtd;
    }
    
    public List<Aluguel> ListarAluguel(){
        String sql = "select id_aluguel, id_filme, id_cliente, hora_aluguel, data_aluguel, " +
                "data_devolucao from aluguel";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setCod_cliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Aluguel> Pesquisar_Aluguel_Cliente(int codCliente){
        String sql = "select id_aluguel, id_filme, id_cliente, hora_aluguel, data_aluguel, " +
                "data_devolucao from aluguel where id_cliente = " + codCliente + "";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setCod_cliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Aluguel> Pesquisar_Aluguel_Codigo(int cod){
        String sql = "select id_aluguel, id_filme, id_cliente, hora_aluguel, data_aluguel, " +
                "data_devolucao from aluguel where id_cliente = " + cod + "";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setCod_cliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Aluguel> Pesquisar_Aluguel_Filme(int codFilme){
        String sql = "select id_aluguel, id_filme, id_cliente, hora_aluguel, data_aluguel, " +
                "data_devolucao from aluguel where id_cliente = " + codFilme + "";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setCod_cliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public String Excluir_Aluguel(Aluguel a){
        String sql = "delete from aluguel where id_aluguel = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod());
            
            if(ps.executeUpdate() > 0){
                return "Excluido com Sucesso.";
            }else{
                return "Erro ao Excluir.";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    public int Pesquisar_Cod_Filme(int cod){
        int codigo = 0;
        String sql = "select id_filme from aluguel where id_aluguel = " + cod + "";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    codigo = rs.getInt(1);
                }
            }
        } catch (Exception e) {
        }
        return codigo;
    }
    
}
