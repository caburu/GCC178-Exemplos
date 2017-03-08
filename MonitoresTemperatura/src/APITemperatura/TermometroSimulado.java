/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APITemperatura;

import java.util.Random;
import java.util.TimerTask;

/**
 *
 * @author julio
 */
public class TermometroSimulado extends TimerTask {    
    private int temperaturaAtual;
    private String local;
    private int posicaoX;
    private int posicaoY;
    
    private int temperaturaMinima;
    private int temperaturaMaxima;
    private Random aleatorio;
    
    public TermometroSimulado(String local, int posX, int posY, int tempMin, int tempMax) {
        this.local = local;
        this.posicaoX = posX;
        this.posicaoY = posY;
        this.temperaturaMinima = tempMin;
        this.temperaturaMaxima = tempMax;
        this.temperaturaAtual = tempMin;
        aleatorio = new Random();
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
    }
}
