package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeDAO{
  private Connection con;

  public Connection getCon(){
    return con;
  }

  public FilmeDAO(Connection con){
    this.con = con;
  }

  public String inserir(Filme filme){
    String sql = "insert into ddd_filme(titulo,genero,produtora) values(?,?,?)";
    try(PreparedStatement ps = getCon().prepareStatement(sql);){
      ps.setString(1, filme.getTitulo());
      ps.setString(2,filme.getGenero());
      ps.setString(3, filme.getProdutora());
      if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
      }else{
        return "Erro ao inserir";
      }
    }catch(SQLException e){
      return "Erro de sql: " + e.getMessage();
    }
  }

  public String alterar(Filme filme){
    String sql = "update ddd_filme set titulo = ?,genero = ?,produtora = ? where codigo = ?";
    try(PreparedStatement ps = getCon().prepareStatement(sql);){
      ps.setString(1, filme.getTitulo());
      ps.setString(2, filme.getGenero());
      ps.setString(3, filme.getProdutora());
      ps.setInt(4, filme.getCodigo());
      if(ps.executeUpdate()){
        return "Inserido com sucesso";
      }else{
        return "Erro ao alterar";
      }
    }catch(SQLException e){
      return "Erro de SQL: " + e.getMessage();
    }
  }

  public String excluir(Filme filme){
    String sql = "delete from ddd_filme where codigo = ?";
    try (PreparedStatement ps = getCon().prepareStatement(sql);){
      ps.setInt(1, filme.getCodigo());
      if(ps.excuteUpdate() > 0) {
        return "Excluido com sucesso";
      }else{
        return "Erro ao excluir";
      }
    }catch(SQLExcpetion e){
      return "Erro de SQL: " + e.getMessage();
    }
  }

  public ArrayList<Filme> listarTodos(){
    String sql = "select * from ddd_carro order by placa";
    ArrayList<Filme> listaFilme = new ArrayList<Filme>();
    try (PreparedStatement ps = getCon().prepareStatement(sql);ResultSet rs = ps.executeQuery();){
      if(rs != null){
        while(rs.next()){
          Filme filme = new Filme();
          filme.setCodigo(rs.getInt(1));
          filme.setTitulo(rs.getString(2));
          filme.setGenero(rs.getString(3));
          filme.setProdutora(rs.getString(4));
          listaFilme.add(filme);
        }
        return listaFilme;
      }else{
        return null
      }
    }catch(SQLException e){
      System.out.println("Erro de SQL: " + e.getMessage());
      return null;
    }
  }
}
