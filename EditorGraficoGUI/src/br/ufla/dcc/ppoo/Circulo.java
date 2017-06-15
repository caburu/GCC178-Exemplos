package br.ufla.dcc.ppoo;


public class Circulo extends FormaGeometrica {

    private final double PI = 3.1415;
    private double raio;

    public Circulo(double raio, double posX, double posY, String cor) {
        super(posX, posY, cor);
        this.raio = raio;
    }

    // Atenção: esse System.out.printf aqui é só
    // para simular a impressão da posição de um círculo
    // na tela. Portanto, continua valendo aquela
    // regra de não se misturar código de saída de
    // informações em suas classes de negócio.
    @Override
    public void exibir() {
        System.out.printf("Círculo (r = %.2f) -> ",
                raio);
        super.exibir();
    }
    
    @Override
    public double obterArea() {
        return PI * raio * raio;
    }
    
    public double obterRaio() {
        return raio;
    }
}
