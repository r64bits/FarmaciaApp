/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import models.Produto;
import models.Venda;

/**
 *
 * @author Andrade
 */
public class VendasController {
    
    public static void vender(int codigo,String idVenda){
        // criei o objeto para ir para o banco
        Venda v = new Venda(idVenda);
        v.setCodigoProduto(codigo);
        banco.BancoDadosFarmacia.getTabelaVenda().add(v);
    }
    
    public static List<Venda> obterVendasPorID(String idVenda){
        List<Venda> list =  new ArrayList<Venda>();
        for(Venda a : banco.BancoDadosFarmacia.getTabelaVenda()){
            if(a.getIDVenda()== idVenda){
                list.add(a);
            }
        }
        return list;
    }
    
    public static List<Venda> obterRelatorioVendasGeral(){
        return  banco.BancoDadosFarmacia.getTabelaVenda();
    }
    
    public static List<Venda> obterRelatorioPorTipo(String tipoProduto){
        List<Venda> list =  new ArrayList<Venda>();
        for(Venda a : banco.BancoDadosFarmacia.getTabelaVenda()){
            Produto p = ProdutosController.obterPorCodigo(a.getCodigoProduto());
              
            if(tipoProduto.equals(p.getTipo())){
                list.add(a);
            }
        }
        return list;
    }
    
    public static Double obterValorTotal(String idVenda){
        Double total = 0.0;
        for(Venda a : banco.BancoDadosFarmacia.getTabelaVenda()){
            if(a.getIDVenda()== idVenda){
                total = total + ProdutosController.obterPorCodigo(a.getCodigoProduto()).getValor();
            }
        }
        return total;
    }
}
