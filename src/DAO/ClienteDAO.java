/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ianka
 */
public class ClienteDAO extends ExecuteSQL{

    public ClienteDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Cliente(Cliente a){
        String sql = "insert into cliente values(0,?,?,?,?,?,?,?,?,?,?)";
        try {
                PreparedStatement ps = getCon().prepareStatement(sql);
                
                ps.setString(1, a.getNome());
                ps.setString(2, a.getNascimento());
                ps.setString(3, a.getRG());
                ps.setString(4, a.getCPF());
                ps.setString(5, a.getEmail());
                ps.setString(6, a.getTelefone());
                ps.setString(7, a.getBairro());
                ps.setString(8, a.getRua());
                ps.setInt(9, a.getNumero());
                ps.setString(10, a.getCEP());
                
                if(ps.executeUpdate() > 0){
                    return "Inserido com Sucesso.";
                }else{
                    return "Erro ao inserir.";
                }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public List<Cliente> ListarCliente(){
       String sql = "select id_cliente, nome, rg, cpf, telefone, email from cliente";
       List<Cliente> lista = new ArrayList<>();
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs!=null){
                while(rs.next()){
                    Cliente a = new Cliente();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setRG(rs.getString(3));
                    a.setCPF(rs.getString(4));
                    a.setTelefone(rs.getString(5));
                    a.setEmail(rs.getString(6));
                    
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
    
    //EXCLUIR CLIENTE
    public List<Cliente> ConsultaCodigoCliente(String nome){
        String sql = "select id_cliente from cliente where nome = '" + nome + "'";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
             
            if(rs != null){
                while(rs.next()){
                    Cliente a = new Cliente();
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
    
    public String Excluir_Cliente(Cliente a){
        String sql = "delete from cliente where id_cliente = ? and nome = ?";
        
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            ps.setString(2, a.getNome());
            
            if(ps.executeUpdate() > 0){
                return "Excluido com sucesso.";
            }else{
                return "Erro ao Excluir.";
            }
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<Cliente> ListarComboCliente(){
       String sql = "select nome from cliente order by nome";
       List<Cliente> lista = new ArrayList<>();
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs!=null){
                while(rs.next()){
                    Cliente a = new Cliente();
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
    
    //ALTERAR CLIENTE
    public boolean Testar_Cliente(int codigo){
        boolean resultado = false;
        
        try {
            String sql = "select * from cliente where id_cliente = " + codigo + "";
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
    
    public List<Cliente> CapturarCliente(int codigo){
        String sql = "select * from cliente where id_cliente = " + codigo + "";
        List<Cliente> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while(rs.next()){
                    Cliente a = new Cliente();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setNascimento(rs.getString(3));
                    a.setRG(rs.getString(4));
                    a.setCPF(rs.getString(5));
                    a.setEmail(rs.getString(6));
                    a.setTelefone(rs.getString(7));
                    a.setBairro(rs.getString(8));
                    a.setRua(rs.getString(9));
                    a.setNumero(rs.getInt(10));
                    a.setCEP(rs.getString(11));
                    
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
    
    public String Alterar_Cliente(Cliente a){
        String sql = "update cliente set nome = ?, data_nasc = ?, rg = ? "
                + ",cpf = ?, email = ?, telefone = ?, bairro = ?, rua = ? "
                + ",numero = ?, cep = ? where id_cliente = ? ";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getNascimento());
            ps.setString(3, a.getRG());
            ps.setString(4, a.getCPF());
            ps.setString(5, a.getEmail());
            ps.setString(6, a.getTelefone());
            ps.setString(7, a.getBairro());
            ps.setString(8, a.getRua());
            ps.setInt(9, a.getNumero());
            ps.setString(10, a.getCEP());
            ps.setInt(11, a.getCodigo());
            
            if(ps.executeUpdate() > 0){
                return "Atualizado com Sucesso.";
            }else{
                return "Erro ao Atualizar";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    
    public List<Cliente> Pesquisar_Nome_Cliente(String nome){
       String sql = "select id_cliente, nome, rg, cpf, telefone, email from cliente "
               + "where nome Like '" + nome + "%'";
       List<Cliente> lista = new ArrayList<>();
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs!=null){
                while(rs.next()){
                    Cliente a = new Cliente();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setRG(rs.getString(3));
                    a.setCPF(rs.getString(4));
                    a.setTelefone(rs.getString(5));
                    a.setEmail(rs.getString(6));
                    
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
    
    public List<Cliente> Pesquisar_Cod_Cliente(int cod){
       String sql = "select id_cliente, nome, rg, cpf, telefone, email from cliente "
               + "where id_cliente = " + cod + "";
       List<Cliente> lista = new ArrayList<>();
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs!=null){
                while(rs.next()){
                    Cliente a = new Cliente();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setRG(rs.getString(3));
                    a.setCPF(rs.getString(4));
                    a.setTelefone(rs.getString(5));
                    a.setEmail(rs.getString(6));
                    
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
