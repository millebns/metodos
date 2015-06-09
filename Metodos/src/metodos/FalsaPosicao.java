package metodos;

import metodos.Funcao;

public class FalsaPosicao extends Funcao {
    
    private double erro_intervalo;
    private int max_iteracoes;

    public FalsaPosicao(int tam, double erro, int iteracoes) {
        super(tam);
        this.erro_intervalo = erro;
        this.max_iteracoes = iteracoes;
    }
    
    public double calcula_x(double a, double b, double fa, double fb){
        return ((a*fb)-(b*fa))/(fb-fa);
    }
    
    public boolean verifica_erro(double a, double b){
        return (b-a < this.erro_intervalo);
    }
    
    public boolean e_a(double fx, double fa){
        return fx*fa > 0;
    }
    
    public double falsaPosicao(double a, double b){
        double fx=0, fa, fb, xi, x=0;
        
        
       
        for (int i = 0; i < this.max_iteracoes; i++) {
            //Verificação inicial
            if(verifica_erro(a, b)) return (a+b)/2;
        
            fa = avaliar(a);
            fb = avaliar(b);
            xi = calcula_x(a, b, fa, fb);
            
            
            if(Math.abs(avaliar(xi))< this.erro_intervalo){
                return xi;
            }
            
            x = xi;
            fx = avaliar(xi);
            
            if(e_a(fx, fa))
                a = xi;
            else
                b = xi;
            
        }
       return x;
    }
}
