/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaExemplo;

import apiTemperatuta.ControladorTemperatura;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author julio
 */
public class TelaMonitoramentoSimples {
    private JFrame janela;
    private Map<String, JLabel> rotulos;
    private Map<String, Integer> temperaturas;
    
    private ControladorTemperatura contTemp;
    
    
    public TelaMonitoramentoSimples(ControladorTemperatura contTemp) {
        this.contTemp = contTemp;
        janela = new JFrame("Monitor Simples");
        janela.setSize(600, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new BoxLayout(janela.getContentPane(), BoxLayout.Y_AXIS));
                        
        temperaturas = new HashMap<>();                
        
        criarRotulos();
    }
    
    private void criarRotulos() {
        rotulos = new HashMap<>();
        
        List<String> locaisTerm = contTemp.getLocaisTermometros();
        
        for (String local : locaisTerm) {
            adicionarRotulo(local);
        }
    }
    
    public void exibir() {
        janela.setVisible(true);
    }
    
    public void atualizarTemperatura(String local, int temperatura) {
        temperaturas.put(local, temperatura);
        
        atualizarTela();
    }
    
    private void atualizarTela() {
        for (String local : temperaturas.keySet()) {           
            rotulos.get(local).setText(local + ": " + temperaturas.get(local));
        }
    }
    
    private void adicionarRotulo(String texto) {
        JLabel rotulo = new JLabel(texto);
        rotulos.put(texto, rotulo);
        janela.add(rotulo);
    }
}
