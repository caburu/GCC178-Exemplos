/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadscorredores;

/**
 *
 * @author julio
 */
public class Corredor implements Runnable {
    private String nome;
    private int velocidade;
    private int distancia;
    private int posicaoAtual;
    
    public Corredor(String nome, int velocidade, int distancia) {
        this.nome = nome;
        this.velocidade = velocidade;
        this.distancia = distancia;
        posicaoAtual = 0;
    }
    
    public String obterNome() {
        return nome;
    }
    
    public int obterPosicaoAtual() {
        return posicaoAtual;
    }
    
    public boolean terminouCorrida() {
        return posicaoAtual >= distancia;
    }

    @Override
    public void run() {
        posicaoAtual = 0;
        
        try {
            while (posicaoAtual < distancia) {
                posicaoAtual += 1;
                Thread.sleep(1000/velocidade);
            }
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
