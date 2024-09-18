package br.com.fiap.view;

import br.com.fiap.controller.FilmeController;
import javax.swing.*;

public class FilmeView{
  public static void main(String[] args){
    String titulo,genero,produtora;
    int codigo, opcao;
    String[] escolha{"Inserir","Alterar","Excluir","Listar"};
    FilmeController filmeController = new FilmeController();
    do{
      try{
        opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular o carro", "Escolha", JOptionPane.DEFAULT_OPTION,
                                           JOptionPane.QUESTION_MESSAGE,null,escolha,escolha[0]);
        switch(opcao){
          case 0:
            titulo = JOptionPane.showInputDialog("Digite o titulo do filme: ");
            genero = JOptionPane.showInputDialog("Digite o genero do filme: ");
            produtora = JOptionPane.showInputDialog("Digite a produtora do filme: ");
            System.out.println(filmeController.inserirFilme(titulo,genero,produtora));
            break;
          case 1:
            codigo = JOptionPane.showInputDialog("Digite o código do filme: ");
            titulo = JOptionPane.showInputDialog("Digite o titulo do filme: ");
            genero = JOptionPane.showInputDialog("Digite o genero do filme: ");
            produtora = JOptionPane.showInputDialog("Digite a produtora do filme: ");
            System.out.println(filmeController.alterarFilme(codigo,tittulo,genero,produtora));
            break;
          case 2:
            codigo = JOptionPane.showInputDialog("Digite o código do filme: ");
            System.out.println(filmeController.excluirFilme(codigo));
            break;
          case 3:
            System.out.println(filmeController.listarTodosFilmes());
            break;
          default:
            System.out.println("Opção inválida");
        }
      }catch(Exception e){
        System.out.println("Erro: " + e.getMessage());
      }
    }while(JOptionPane.showConfirmDialog(null, "Deseja continuar ?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
    JOptionPane.showMessageDialog(null, "Fim do programa")
  }
}
