package farmaciafinal;

import java.util.Scanner;
import views.ProdutoView;

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

             int opcao = scan.nextInt();
             scan.nextLine();
             
            ProdutoView pView = new ProdutoView();

            switch (opcao) {
                case 1:
                     pView.exibirMenuProduto();
                    break;
                case 2:

                    break;
                case 3:

            }
        }
    }
    
    private void teste(){}
    
}
