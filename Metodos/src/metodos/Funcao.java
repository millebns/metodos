/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

/**
 *
 * @author Camille
 */
public class Funcao {
    protected double coef[];
    
    
    public Funcao(int tam){
        coef= new double[tam+1];
    }
    
    public void set(double valor, int pos){
            coef[pos]=valor;
            
    }
    
    public double get(int pos){
        return coef[pos];
    }
    
    public int tamanho(){
        return coef.length;
    }
    
    @Override
    public String toString(){
        String resp="";
        for (int i =0; i<coef.length;i++) {
           resp = "(" + coef[i] + "x^" + i + ") + " + resp;
        }
        return resp;
    }
    
    public double avaliar(double x){
        double resp=0;
        for (int i = 0; i < coef.length; i++) {
            resp += (coef[i])*(Math.pow(x, i));
        }
        return resp;
    }
}
