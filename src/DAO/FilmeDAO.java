/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Filme;
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
public class FilmeDAO extends ExecuteSQL{
    
    public FilmeDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Filme(Filme a){
        String sql = "insert into filme values(0, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getTitulo());
            ps.setInt(2, a.getAno());
            ps.setString(3, a.getDuracao());
            ps.setInt(4, a.getCod_categoria());
            ps.setInt(5, a.getCod_classificacao());
            ps.setDouble(6, a.getPreco_compra());
            ps.setString(7, a.getData_compra());
            ps.setInt(8, a.getQtdEstoque());
            ps.setString(9, a.getCapa());
            
            if(ps.executeUpdate() > 0){
                return "Inserido com Sucesso.";
            }else{
                return "Erro ao Inserir.";
            }
            
        } catch (Exception e) {
            return e.getMessage();
        }
        
    }
    
    public List<Filme> ConsultaCodigoFilme(String titulo){
        String sql = "select id_filme from filme where titulo = '" + titulo + "'";
        List<Filme> lista = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
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
    
    public String Excluir_Filme(Filme a){
        String sql = "delete from filme where id_filme = ? and titulo = ?";
        
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            ps.setString(2, a.getTitulo());
            
            if(ps.executeUpdate() > 0){
                return "Excluido com Sucesso.";
            }else{
                return "Erro ao Excluir.";
            }
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<Filme> ListarComboFilme(){
        String sql = "select titulo from filme order by titulo";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    a.setTitulo(rs.getString(1));
                    
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
    
    public boolean Testar_Filme(int codigo){
        boolean resultado = false;
        
        try {
            String sql = "select * from filme where id_filme = " + codigo + "";
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
    
    public List<Filme> CapturarFilme(int codigo){
        String sql = "select * from filme where id_filme = " + codigo + "";
        List<Filme> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificacao(rs.getInt(6));
                    a.setPreco_compra(rs.getDouble(7));
                    a.setData_compra(rs.getString(8));
                    a.setQtdEstoque(rs.getInt(9));
                    a.setCapa(rs.getString(10));
                    
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
    
    public String Alterar_Filme(Filme a){
        String sql = "update filme set titulo = ?, ano = ?, duracao = ?, "
                + "id_categoria = ?, id_classificacao = ?, preco_compra = ?, "
                + "data_compra = ?, qtd_estoque = ?, capa = ? where id_filme = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getTitulo());
            ps.setInt(2, a.getAno());
            ps.setString(3, a.getDuracao());
            ps.setInt(4, a.getCod_categoria());
            ps.setInt(5, a.getCod_classificacao());
            ps.setDouble(6, a.getPreco_compra());
            ps.setString(7, a.getData_compra());
            ps.setInt(8, a.getQtdEstoque());
            ps.setString(9, a.getCapa());
            ps.setInt(10, a.getCodigo());
            
            if(ps.executeUpdate() > 0){
                return "Alterado com Sucesso.";
            }else{
                return "Erro ao Alterar.";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    
    public String Atualizar_Qtd_Filme(int cod, int qtd){
        String sql = "update filme set qtd_estoque = ? where id_filme = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, qtd);
            ps.setInt(2, cod);
            
            if(ps.executeUpdate() > 0){
                return "Alterado com Sucesso.";
            }else{
                return "Erro ao Alterar.";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }
        
    }
    
    public List<Filme> ListarFilme(){
        String sql = "select id_filme, titulo, ano, duracao, id_categoria, id_classificacao, "
                + "preco_compra, data_compra, qtd_estoque from filme";
        List<Filme> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificacao(rs.getInt(6));
                    a.setPreco_compra(rs.getDouble(7));
                    a.setData_compra(rs.getString(8));
                    a.setQtdEstoque(rs.getInt(9));
                    
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
    
    public List<Filme> Pesquisar_Titulo_Filme(String titulo){
        String sql = "select id_filme, titulo, ano, duracao, id_categoria, id_classificacao, "
                + "preco_compra, data_compra, qtd_estoque from filme where titulo "
                + "Like '" + titulo + "%'";
        List<Filme> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificacao(rs.getInt(6));
                    a.setPreco_compra(rs.getDouble(7));
                    a.setData_compra(rs.getString(8));
                    a.setQtdEstoque(rs.getInt(9));
                    
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
    
    public List<Filme> Pesquisar_Cod_Filme(int cod){
        String sql = "select id_filme, titulo, ano, duracao, id_categoria, id_classificacao, "
                + "preco_compra, data_compra, qtd_estoque from filme where id_filme = " + cod +"";
        List<Filme> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificacao(rs.getInt(6));
                    a.setPreco_compra(rs.getDouble(7));
                    a.setData_compra(rs.getString(8));
                    a.setQtdEstoque(rs.getInt(9));
                    
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
    
    public boolean Testar_Quantidade(int cod){
        boolean teste = false;
        
        try {
            String sql = "select id_filme from filme where id_filme = " + cod + "" +
                    " and qtd_estoque > 0";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    teste = true;
                }
            }
        } catch (Exception e) {
        }
        return teste;
    }
    
}
