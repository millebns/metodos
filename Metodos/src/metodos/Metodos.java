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
          FalsaPosicao f = new FalsaPosicao(5, 0.00005, 20);
        f.set(6.08, 0);
        f.set(-5.66, 1);
        f.set(-2.92, 2);
        f.set(3.06, 3);
        f.set(-1.28, 4);
        f.set(2.02, 5);

        System.out.println(f.toString());

        System.out.println(f.falsaPosicao(-1.3, 1.7));
        f.salva(new FileOutputStream("grafico.png"));
      /*  JFrame frame = new JFrame("Falsa Posição");
        frame.add(f.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);*/
        
        NewtonRaphson g = new NewtonRaphson(5, 0.00005, 20);
        g.set(6.08, 0);
        g.set(-5.66, 1);
        g.set(-2.92, 2);
        g.set(3.06, 3);
        g.set(-1.28, 4);
        g.set(2.02, 5);
        
       
        System.out.println(g.newton_raphosn(-1));
        g.salva(new FileOutputStream("graficoNR.png"));
    
    }
    
}
