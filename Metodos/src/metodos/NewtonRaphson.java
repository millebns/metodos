package metodos;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Camille
 */
public class NewtonRaphson extends Funcao {

    private double erro_intervalo;
    private int max_iteracoes;
    double[] aux;
    private DefaultCategoryDataset dados;
    private JFreeChart grafico;

    public NewtonRaphson(int tam, double erro, int iteracoes) {
        super(tam);
        erro_intervalo = erro;
        max_iteracoes = iteracoes;
        aux = new double[coef.length - 1];
        this.dados = new DefaultCategoryDataset();
        this.grafico = ChartFactory.createLineChart("Newton Raphson", "Xi", "F'(xi)", dados, PlotOrientation.HORIZONTAL, true, true, false);
    }

    public double derivada(double x) {
        double r = 0;
        for (int i = 0; i < aux.length; i++) {
            aux[i] = coef[i + 1] * (i + 1);
        }
        for (int i = 0; i < aux.length; i++) {
            r += (aux[i]) * (Math.pow(x, i));
        }

        return r;
    }

    public double calcula_xi(double a, double f, double df) {
        return a - (f / df);
    }

    public double newton_raphosn(double a) {
        double resp = 0, xi = 0, fi;
        MediaMovelSimples ind = new MediaMovelSimples();
        for (int i = 0; i < max_iteracoes; i++) {
            if (Math.abs((avaliar(a))) < erro_intervalo) {
                resp = a;
            }

            xi = calcula_xi(a, avaliar(a), derivada(a));
            fi = avaliar(xi);
            dados.addValue(fi, ind.toString(), Double.valueOf(xi));
            if (((Math.abs(fi)) < erro_intervalo) || Math.abs(xi - a) < erro_intervalo) {
                resp = xi;
            }
            a = xi;
        }
        return resp;
    }

    @Override
    public String toString() {
        String resp = "";
        for (int i = 0; i < aux.length; i++) {
            resp = "(" + aux[i] + "x^" + i + ") + " + resp;
        }
        return resp;
    }

    public void salva(OutputStream out) throws IOException {
        ChartUtilities.writeChartAsPNG(out, grafico, 800, 600);

    }

    public JPanel getPanel() {
        return new ChartPanel(grafico);
    }

}
