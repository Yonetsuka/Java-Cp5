package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.FilmeDAO;
import br.com.fiap.model.dto.Filme;

public class FilmeController{
  public String inserirFilme(String titulo, String genero, String produtora)
  throws ClassNotFoundException, SQLException{
    String resultado;
    Connection con = ConnectionFactory.abrirConexao();
    Filme filme = new Filme();
    filme.setTitulo(titulo);
    filme.setGenero(genero);
    filme.setProdutora(produtora);
    FilmeDAO filmeDAO = new FilmeDAO(con);
    resultado = filmeDAO.inserir(medico);
    ConnectionFactory.fecharConexao(con);
    return resultado;
  }

  public String alterarFilme(int codigo,String titulo, String genero, String produtora)
  throws ClassNotFoundException, SQLException{
    String resultado;
    Connection con = ConnectionFactory.abrirConexao();
    Filme filme = new Filme();
    filme.setCodigo(codigo);
    filme.setTitulo(titulo);
    filme.setGenero(genero);
    filme.setProdutora(produtora);
    FilmeDAO filmeDAO = new FilmeDAO(con);
    resultado = filmeDAO.alterar(medico);
    ConnectionFactory.fecharConexao(con);
    return resultado;
  }

  public String excluirFilme(int codigo)
  throws ClassNotFoundException, SQLException{
    String resultado;
    Connection con = ConnectionFactory.abrirConexao();
    Filme filme = new Filme();
    filme.setCodigo(codigo);
    FilmeDAO filmeDAO = new FilmeDAO(con);
    resultado = filmeDAO.excluir(filme);
    ConnectionFactory.fecharConexao(con);
    return resultado;
  }

  public String listarTodosFilmes()
  throws ClassNotFoundException, SQLException{
    Connection con = ConnectionFactory.abrirConexao();
    FilmeDAO filmeDAO = new FilmeDAO(con);
    ArrayList<Filme> resultado = FilmeDAO.listarTodos();
    ConnectionFactory.fecharConexao(con);
    return resultado;
  }
}
