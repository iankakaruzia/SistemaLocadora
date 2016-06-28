/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ianka
 */
public class CategoriaDAO extends ExecuteSQL{
    
    public CategoriaDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Categoria(Categoria c){
        String sql = "insert into categoria values(0, ?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, c.getNome());
            
            if(ps.executeUpdate() > 0){
                return "Inserido com Sucesso";
            }else{
                return "Erro ao Inserir";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<Categoria> ConsultaCodigoCategoria(String nome){
        String sql = "select id_categoria from categoria where nome = '" + nome + "'";
        List<Categoria> lista = new ArrayList<>();
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Categoria c = new Categoria();
                    c.setCodigo(rs.getInt(1));
                    lista.add(c);
                }
                return lista;
            }else{
                return null;
            }
            
        } catch (Exception e) {
            return null;
        }
    }
    
    public String Exluir_Categoria(Categoria a){
        String sql = "delete from categoria where id_categoria = ? and nome = ?";
        
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            ps.setString(2, a.getNome());
            
            if(ps.executeUpdate() > 0){
                return "Excluido com Sucesso.";
            }else{
                return "Erro ao Excluir.";
            }
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<Categoria> ListarComboCategoria(){
        String sql = "select nome from categoria order by nome";
        List<Categoria> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Categoria a = new Categoria();
                    a.setNome(rs.getString(1));
                    
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
    
    public boolean Testar_Categoria(int codigo){
        boolean resultado = false;
        
        try {
            String sql = "select * from categoria where id_categoria = " + codigo + "";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    resultado = true;
                }
            }
            
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return resultado;
    }
    
    public List<Categoria> CapturarCategoria(int codigo){
        String sql = "select * from categoria where id_categoria = " + codigo + "";
        List<Categoria> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    
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
    
    public String Alterar_Categoria(Categoria a){
        String sql = "update categoria set nome = ? where id_cliente = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setInt(2, a.getCodigo());
            
            if(ps.executeUpdate() > 0){
                return "Atualizado com Sucesso.";
            }else{
                return "Erro ao Atualizar.";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<Categoria> ListarCategoria(){
        String sql = "select id_categoria, nome from categoria";
        List<Categoria> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    
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
    
    public List<Categoria> Pesquisar_Nome_Categoria(String nome){
        String sql = "select id_categoria, nome from categoria "
                + "where nome Like '" + nome + "%'";
        List<Categoria> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    
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
    
    public List<Categoria> Pesquisar_Cod_Categoria(int cod){
        String sql = "select id_categoria, nome from categoria "
                + "where id_categoria = " + cod + "";
        List<Categoria> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    
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
    
}
