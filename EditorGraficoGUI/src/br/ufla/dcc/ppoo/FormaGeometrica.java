package br.ufla.dcc.ppoo;

public abstract class FormaGeometrica {

    private double posX;
    private double posY;
    private String cor;

    public FormaGeometrica(double posX, double posY, String cor) {
        this.posX = posX;
        this.posY = posY;
        this.cor = cor;
    }

    public void exibir() {
        System.out.printf("[%.2f; %.2f]\n",
                obterPosX(), obterPosY());
    }
    
    public abstract double obterArea();
    
    public double obterPosX() {
        return posX;
    }

    public double obterPosY() {
        return posY;
    }
}
