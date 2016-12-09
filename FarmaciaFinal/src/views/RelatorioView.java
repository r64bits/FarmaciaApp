/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.Scanner;
import controllers.ProdutosController;
import controllers.VendasController;
import farmaciafinal.FarmaciaFinal;
import java.util.InputMismatchException;
import models.Produto;
import models.Venda;

/**
 *
 * @author Andrade
 */
public class RelatorioView {
    Scanner scan = new Scanner(System.in);
    
    public void exibirMenuRelatorio() {
        try{
            while (true) {
            System.out.println("Digite:");
            System.out.println("1 - Relatório Vendas Geral");
            System.out.println("2 - Relatório Vendas Por Produto");
            System.out.println("4 - Voltar");
            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    vendasGeral();
                    break;
                case 2:
                    vendasPorProduto();
                    break;
                case 4:
                    FarmaciaFinal.exibirMenuPrincipal();
            }
        }
            
        }catch(InputMismatchException e){
             System.out.println("Informe um número inteiro");
             scan.nextLine();
        }
    }
    
    private void vendasGeral() {
        String oldVendaId = "";
        Double total = 0.0;
        
        for(Venda a : VendasController.obterRelatorioVendasGeral()){
            Produto p = ProdutosController.obterPorCodigo(a.getCodigoProduto());
            
            if(oldVendaId != a.getIDVenda()){
                oldVendaId = a.getIDVenda();
                System.out.println("----- VENDA "+oldVendaId+" -----");
            }
            
            System.out.println("");
            System.out.println("Codigo: " + p.getCodigo());
            System.out.println("  Nome: " + p.getNome());
            System.out.println("  Tipo: " + p.getTipo());
            System.out.println(" Valor: " + p.getValor());
            System.out.println("");
            
            total = total +p.getValor();
        }

       System.out.println("**************************");
       System.out.println("TOTAL: "+ total);
       System.out.println("**************************");
    }
    
    private void vendasPorProduto() {
        System.out.println("Informe o tipo do produto:");
        String tipoProduto = scan.nextLine();      
       
        String oldTipoProduto = "";
        Double total = 0.0;
        
        for(Venda a : VendasController.obterRelatorioPorTipo(tipoProduto)){
            Produto p = ProdutosController.obterPorCodigo(a.getCodigoProduto());
            
            if(oldTipoProduto != p.getTipo()){
                oldTipoProduto = p.getTipo();
                System.out.println("----- TIPO PRODUTO "+tipoProduto+" -----");
            }
            
            System.out.println("");
            System.out.println("Codigo: " + p.getCodigo());
            System.out.println("  Nome: " + p.getNome());
            System.out.println("  Tipo: " + p.getTipo());
            System.out.println(" Valor: " + p.getValor());
            System.out.println("");
            
            total = total +p.getValor();
        }

       System.out.println("**************************");
       System.out.println("TOTAL: "+ total);
       System.out.println("**************************");
    }

}
