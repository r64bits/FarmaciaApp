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
public class VendaView {
    Scanner scan = new Scanner(System.in);
    
    public void exibirMenuProduto() {
         while (true) {
            System.out.println("Informe o código do produto ou 0 para voltar:");
            int cod = scan.nextInt();
            scan.nextLine();

            if(cod != 0){
                Produto z = ProdutosController.obterPorCodigo(cod);

                if (z != null) {
                    System.out.println("      Produto: " + z.getNome());
                    System.out.println("        Valor: R$ " + z.getValor());
                    System.out.println(" Qtde Estoque:" + z.getQuantidade());
                    System.out.println("");
                } else {
                    System.out.println("Produto não encontrado");
                }
            
            }
            
          
        }
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
