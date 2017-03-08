/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploJFreeChart;

import java.awt.Dimension;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author julio
 */
public class TelaGrafico {
    private ApplicationFrame janela;
    
    public TelaGrafico() {
        janela = new ApplicationFrame("Exemplo JFreeChart");
        janela.setDefaultCloseOperation(ApplicationFrame.EXIT_ON_CLOSE);
        
        JFreeChart graficoLinha = ChartFactory.createLineChart(
                "Titulo do Grafico",
                "Nome do eixo X","Nome do eixo Y",
                criarDataset(), // método que cria os dados do gráfico
                PlotOrientation.VERTICAL,
                true,true,false); // legenda, tooltips, urls
        
        ChartPanel painelGrafico = new ChartPanel(graficoLinha);
        painelGrafico.setPreferredSize(new Dimension(600, 400));
        
        janela.setContentPane(painelGrafico);      
        janela.pack( );
        RefineryUtilities.centerFrameOnScreen(janela);
    }
    
    public void exibir() {
        janela.setVisible(true);
    }

   private DefaultCategoryDataset criarDataset( ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
      
      dataset.addValue(20, "cidade", "07h");
      dataset.addValue(24, "cidade", "08h");
      dataset.addValue(23, "cidade", "09h");
      dataset.addValue(25, "cidade", "10h");
      dataset.addValue(22, "cidade", "11h");
      dataset.addValue(18, "cidade", "12h");
      
      return dataset;
   }
}
