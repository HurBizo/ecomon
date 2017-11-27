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
public class Conta {
    String sobrenome;
    String nome;
    double Agua;
    double Luz;
    double Telefone;
    
    //double fatura = card.getFatura();
    
    void verificaPagar(){
        if (this.Luz != 0 || this.Telefone != 0) {
            System.out.println("Nome: " + nome + " " + sobrenome);
            System.out.println("\n --------- \n");
            //System.out.println(card.getFatura() + "Fatura do cartão de crédito: ");
            System.out.println("Telefone: " + Telefone);
            System.out.println("Agua: " + Agua);
        } else {
            
        }
    }

    
    
}

    
    
    
    
    
    

