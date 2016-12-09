/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Produto;

/**
 *
 * @author Andrade
 */
public class ProdutosController {
    
    public static void adicionarProduto(int codigo, String nome, Double valor,String tipo,int qtde){
        // criei o objeto para ir para o banco
        Produto p = new Produto();
        
        // Preenchendo o objeto
        p.setCodigo(codigo);
        p.setNome(nome);
        p.setValor(valor);
        p.setTipo(tipo);
        p.setQuantidade(qtde);
        banco.BancoDadosFarmacia.getTabelaProduto().add(p);
    }
    
    public static Produto obterPorCodigo(int codigo){
        
        for(Produto a : banco.BancoDadosFarmacia.getTabelaProduto()){
            if(a.getCodigo() == codigo){
                return a;
            }
        }
        
        return null;
    }
}
