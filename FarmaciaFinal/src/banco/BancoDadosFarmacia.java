/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;
import java.util.List;
import models.Produto;
import models.Venda;

public class BancoDadosFarmacia {
     private static List<Produto> tabelaProduto;
     private static List<Venda> tabelaVenda;

    /**
     * @return the tabelaProduto
     */
    public static List<Produto> getTabelaProduto() {
        return tabelaProduto;
    }
    
    public static List<Venda> getTabelaVenda() {
        return tabelaVenda;
    }

    public static void inicializarBanco(){
        tabelaProduto = new ArrayList<Produto>();
        tabelaVenda = new ArrayList<Venda>();
    }
}
