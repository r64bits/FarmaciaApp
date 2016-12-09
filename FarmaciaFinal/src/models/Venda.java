/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import util.IProduto;

/**
 *
 * @author Andrade
 */
public class Venda{
    private String id;
    private int CodigoProduto;

    public Venda(String id){
        this.id =  id;
    }
    public int getCodigoProduto() {
        return CodigoProduto;
    }

    public void setCodigoProduto(int codigo) {
        this.CodigoProduto = codigo;
    }
    
    public String getIDVenda() {
        return id;
    }
}
