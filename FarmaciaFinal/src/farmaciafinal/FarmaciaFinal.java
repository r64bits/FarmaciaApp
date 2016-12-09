package farmaciafinal;

import java.util.InputMismatchException;
import java.util.Scanner;
import views.ProdutoView;
import views.RelatorioView;
import views.VendaView;

public class FarmaciaFinal {
   private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        banco.BancoDadosFarmacia.inicializarBanco();
        exibirMenuPrincipal();
    }
    
    public static void exibirMenuPrincipal() {
      
        while (true) {
            System.out.println("Digite:");
            System.out.println("1 - Produtos");
            System.out.println("2 - Vender");
            System.out.println("3 - Relatório Vendas");
                    

           try{

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
               case 1:
                    ProdutoView pView = new ProdutoView();
                    pView.exibirMenuProduto();
                   break;
               case 2:
                   VendaView view = new VendaView();
                   view.exibirMenuVendas();
                   break;
               case 3:
                   RelatorioView rView = new RelatorioView();
                   rView.exibirMenuRelatorio();
                   break;   

           }

            }catch(InputMismatchException e){
                System.out.println("Informe a opção do menu");
                scan.nextLine();
            }
         }
    }
    
}
