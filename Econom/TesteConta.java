/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pct;

/**
 *
 * @author EtecMorato
 */
public class TesteConta {
    public static void main(String[] args) {
        Conta conta = new Conta();
        Cartao card = new Cartao();
        System.out.println(card.getFatura());
        conta.nome = "Lenilson";
        conta.sobrenome = "Sousa";
        conta.Agua = 123;
        conta.Luz = 140;
        
        card.dia = 316541;
        card.mes = 554;
        
        card.verificaRotativo(card.dia, card.mes);
        
        conta.verificaPagar();
        
        
        
        
        
        
        //System.out.println("R$: " + conta.card.fatura);
        
        
                
    }
}
