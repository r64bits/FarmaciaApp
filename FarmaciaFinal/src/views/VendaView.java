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
import java.util.UUID;
import models.Produto;

/**
 *
 * @author Andrade
 */
public class VendaView {
    Scanner scan = new Scanner(System.in);
    
    public void exibirMenuVendas() {
        UUID uuid = UUID.randomUUID();
        String vendaId = uuid.toString();
        try{
            while (true) {
            System.out.println("Informe o código do produto ou 0 para fechar a compra:");
            int cod = scan.nextInt();
            scan.nextLine();

            if(cod != 0){
                Produto z = ProdutosController.obterPorCodigo(cod);
                if (z != null) {
                    VendasController.vender(cod,vendaId);
                    System.out.println("------------------------------------");
                    System.out.println("      Produto: " + z.getNome());
                    System.out.println("        Valor: R$ " + z.getValor());
                    System.out.println("------------------------------------");
                } else {
                    System.out.println("**********************");
                    System.out.println("Produto não encontrado");
                    System.out.println("**********************");
                }
            }else{
                System.out.println("**********************");
                System.out.println("   Compra Finalizada  ");
                System.out.println("**********************");
                System.out.println("");
                
                Double total = VendasController.obterValorTotal(vendaId);
                System.out.println("TOTAL: R$ "+ total);
                
                System.out.println("Informe o valor pago pelo cliente");
                Double vlrPago = scan.nextDouble();
                scan.nextLine();
                
                System.out.println(" PAGO: R$ "+ vlrPago);
                System.out.println(" TROCO: R$ "+ (vlrPago-total));
                
                System.out.println("*************************");
                System.out.println("Obrigado Volte Sempre !!!  ");
                System.out.println("*************************");
                farmaciafinal.FarmaciaFinal.exibirMenuPrincipal();
            }
          }
        }catch(InputMismatchException e){
            System.out.println("Informe um inteiro valido");
            scan.nextLine();
        }
    }
    

}
