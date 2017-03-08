/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiTemperatuta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import telaExemplo.TelaMonitoramentoSimples;

/**
 *
 * @author julio
 */
public class ControladorTemperatura {
    private List<Termometro> termometros;
    private Timer temporizador;
    
    private Random aleatorio;
    
    public ControladorTemperatura() {
        termometros = new ArrayList<>();
        temporizador = new Timer();
        aleatorio = new Random();
        
        criarTermometros();
        definirAtualizacoesTermometros();
    }
    
    public void definirTela(TelaMonitoramentoSimples telaMS) {
        for (Termometro termometro : termometros) {
            termometro.definirTela(telaMS);
        }
    }
    
    public List<String> getLocaisTermometros() {        
        List<String> locaisTerm = new ArrayList<>();
        
        for (Termometro termometro : termometros) {
            locaisTerm.add(termometro.obterLocal());
        }
        
        return locaisTerm;
    }
    
    private void criarTermometros() {
        termometros.add(new Termometro("Lavras", 50, 50, 7, 36));
        termometros.add(new Termometro("Ijaci", 45, 40, 5, 32));
        termometros.add(new Termometro("Ingaí", 70, 60, 12, 30));
        termometros.add(new Termometro("Itutinga", 90, 48, 5, 30));
    }
    
    private void definirAtualizacoesTermometros() {
        for (Termometro termometro : termometros) {            
            temporizador.schedule(termometro, 0, aleatorio.nextInt(5000)+3000);
        }
    }
}
