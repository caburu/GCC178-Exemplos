/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APITemperatura;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

/**
 *
 * @author julio
 */
public class ControladorTemperatura {
    private List<TermometroSimulado> termometros;
    private Timer temporizador;
    
    private Random aleatorio;
    
    public ControladorTemperatura() {
        termometros = new ArrayList<>();
        temporizador = new Timer();
        aleatorio = new Random();
        
        criarTermometros();
        definirAtualizacoesTermometros();
    }
    
    private void criarTermometros() {
        termometros.add(new TermometroSimulado("Lavras", 50, 50, 7, 36));
        termometros.add(new TermometroSimulado("Ijaci", 45, 40, 5, 32));
        termometros.add(new TermometroSimulado("Ingaí", 70, 60, 12, 30));
        termometros.add(new TermometroSimulado("Itutinga", 90, 48, 5, 30));
    }
    
    private void definirAtualizacoesTermometros() {
        for (TermometroSimulado termometro : termometros) {
            
            temporizador.schedule(termometro, 0, 1000);
        }
    }
}
