/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.Scanner;
import controllers.ProdutosController;
import farmaciafinal.FarmaciaFinal;
import models.Produto;

/**
 *
 * @author Andrade
 */
public class ProdutoView {
    Scanner scan = new Scanner(System.in);
    
    public void exibirMenuProduto() {
         while (true) {
            System.out.println("Digite:");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Exibir Estoque do Produto");
            System.out.println("4 - Voltar");
            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    exibirProdutoEstoque();
                    break;
                case 4:
                    FarmaciaFinal.exibirMenuPrincipal();
            }
        }
    }
    
    private void adicionarProduto() {
        System.out.print("Digite o codigo do prdduto: ");
        int cod = scan.nextInt();
        scan.nextLine();

        System.out.print("Digite o nome do produto: ");
        String nome = scan.nextLine();
        
        System.out.print("Digite o tipo do produto: ");
        String tipo = scan.nextLine();

        System.out.print("Digite o valor do produto: ");
        Double valor = scan.nextDouble();
        
        System.out.print("Digite o quantidade do produto: ");
        int qtde = scan.nextInt();

        ProdutosController.adicionarProduto(cod, nome,valor,tipo,qtde);
    }
    
    private void listarProdutos() {

        System.out.println("---");

        for (Produto a : banco.BancoDadosFarmacia.getTabelaProduto()) {

            System.out.println("Codigo: " + a.getCodigo());
            System.out.println("  Nome: " + a.getNome());
            System.out.println("  Tipo: " + a.getTipo());
            System.out.println(" Valor: " + a.getValor());
            System.out.println("");
        }
        System.out.println("---");
    }
    
    private void exibirProdutoEstoque() {
        System.out.print("Digite o codigo do produto: ");
        int cod = scan.nextInt();
        scan.nextLine();

        Produto z = ProdutosController.obterPorCodigo(cod);

        if (z != null) {
            System.out.println("      Codigo: " + z.getCodigo());
            System.out.println("        Nome: " + z.getNome());
            System.out.println("Qtde Estoque:" + z.getQuantidade());
            System.out.println("");
        } else {
            System.out.println("Produto não encontrado");
        }
    }
}
