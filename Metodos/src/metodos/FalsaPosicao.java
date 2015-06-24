package metodos;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;

import org.jfree.data.category.DefaultCategoryDataset;

public class FalsaPosicao extends Funcao {

    private double erro_intervalo;
    private int max_iteracoes;
    private DefaultCategoryDataset dados;
    private JFreeChart grafico;

    public FalsaPosicao(int tam, double erro, int iteracoes) {
        super(tam);
        this.erro_intervalo = erro;
        this.max_iteracoes = iteracoes;
        this.dados = new DefaultCategoryDataset();
        this.grafico = ChartFactory.createLineChart("Falsa Posição", "Xi", "F(xi)", dados, PlotOrientation.HORIZONTAL, true, true, false);

    }

    public double calcula_x(double a, double b, double fa, double fb) {

        return ((a * fb) - (b * fa)) / (fb - fa);
    }

    public boolean verifica_erro(double a, double b) {
        return (b - a < this.erro_intervalo);
    }

    public boolean e_a(double fx, double fa) {
        return (fx < 0) && (fa < 0);
    }

    public boolean teste_inicial(double a, double b) {
        return (avaliar(a)) * (avaliar(b)) < 0;
    }

    public double falsaPosicao(double a, double b) {
        double fx = 0, fa, fb, xi, x = 0;
        MediaMovelSimples ind = new MediaMovelSimples();
        //teste de fa*fb<0  
        if (teste_inicial(a, b)) {

            for (int i = 0; i < this.max_iteracoes; i++) {

                //Verificação inicial
                if (verifica_erro(a, b)) {
                    return (a + b) / 2;
                }

                fa = avaliar(a);
                fb = avaliar(b);
                xi = calcula_x(a, b, fa, fb);
                fx = avaliar(xi);
               
                if (Math.abs(fx) < this.erro_intervalo) {
                    return xi;
                }

                x = xi;
                dados.addValue(fx, ind.toString(), Double.valueOf(xi));

                if (e_a(fx, fa)) {
                    a = xi;
                } else {
                    b = xi;
                }

            }

            return x;
        } else {
            return a;
        }
    }

    public void salva(OutputStream out) throws IOException {
        ChartUtilities.writeChartAsPNG(out, grafico, 800, 600);

    }

    public JPanel getPanel() {
        return new ChartPanel(grafico);
    }
}
