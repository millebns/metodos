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
public class Metodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FalsaPosicao f = new FalsaPosicao(3, 0.0005, 4);
        f.set(3, 0);
        f.set(-9, 1);
        f.set(0, 2);
        f.set(1, 3);
    
        System.out.println(f.toString());
        System.out.println(f.falsaPosicao(0, 1));
       
    }
    
}
