/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiTemperatuta;

import java.util.Random;
import java.util.TimerTask;
import telaExemplo.TelaMonitoramentoSimples;

/**
 *
 * @author julio
 */
public class Termometro extends TimerTask {    
    private int temperaturaAtual;
    private String local;
    private int posicaoX;
    private int posicaoY;
    
    private int temperaturaMinima;
    private int temperaturaMaxima;
    private Random aleatorio;
    
    private TelaMonitoramentoSimples telaMS;
    
    public Termometro(String local, int posX, int posY, int tempMin, 
                              int tempMax) {
        this.local = local;
        this.posicaoX = posX;
        this.posicaoY = posY;
        this.temperaturaMinima = tempMin;
        this.temperaturaMaxima = tempMax;
        this.temperaturaAtual = tempMin;
        this.telaMS = null;
        aleatorio = new Random();
    }
    
    public void definirTela(TelaMonitoramentoSimples telaMS) {
        this.telaMS = telaMS;
    }
    
    public int obterTemperaturaAtual() {
        return temperaturaAtual;
    }
    
    public String obterLocal() {
        return local;
    }
    
    public int obterPosicaoX() {
        return posicaoX;
    }
    
    public int obterPosicaoY() {
        return posicaoY;
    }
    
    @Override
    public void run() {
        temperaturaAtual = 
                aleatorio.nextInt((temperaturaMaxima - temperaturaMinima) + 1) + temperaturaMinima;
        
        if (telaMS != null) {
            telaMS.atualizarTemperatura(local, temperaturaAtual);
        }
    }
    
    @Override
    public String toString() {
        return local + ": " + temperaturaAtual + " ºC";
    }
}
