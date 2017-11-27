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
public class Cartao extends Conta{
    int dia;
    int mes;
    private int diaV = 30;
    private int mesV = 4;
    private double fatura = 5000;
    
    void verificaRotativo(double dia, double mes){
        if(this.dia > this.getDiaV() && this.mes > this.getMesV()){
            double valor = this.getFatura() * 0.14;
            this.setFatura(this.getFatura() + valor);
            
            //mostra a messagem 
            System.out.println("VOCÊ FICOU NO ROTATIVO!");
            
            //mostra o valor no rotativo
            System.out.printf("Valor a pagar " + "R$: %.2f\n", this.getFatura());
        }else{
            
            //mostra a mensagem
            System.out.println("VOCÊ NÃO FICOU NO ROTATIVO!");
        }
    
    }

    /**
     * @return the diaV
     */
    public int getDiaV() {
        return diaV;
    }

    /**
     * @param diaV the diaV to set
     */
    public void setDiaV(int diaV) {
        this.diaV = diaV;
    }

    /**
     * @return the mesV
     */
    public int getMesV() {
        return mesV;
    }

    /**
     * @param mesV the mesV to set
     */
    public void setMesV(int mesV) {
        this.mesV = mesV;
    }

    /**
     * @return the fatura
     */
    public double getFatura() {
        return fatura;
    }

    /**
     * @param fatura the fatura to set
     */
    public void setFatura(double fatura) {
        this.fatura = fatura;
    }
}