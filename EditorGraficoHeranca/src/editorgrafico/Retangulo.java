package editorgrafico;

public class Retangulo extends FormaGeometrica {

    private double altura;
    private double largura;

    public Retangulo(double altura, double largura, double posX, double posY, String cor) {
        super(posX, posY, cor);
        this.altura = altura;
        this.largura = largura;
    }

    // Atenção: esse System.out.printf aqui é só
    // para simular a impressão da posição de um retângulo
    // na tela. Portanto, continua valendo aquela
    // regra de não se misturar código de saída de
    // informações em suas classes de negócio.
    @Override
    public void exibir() {
        System.out.printf("Retângulo (%.2f x %.2f) -> ",
                altura, largura);
        super.exibir();
    }
    
    @Override
    public double obterArea() {
        return largura * altura;
    }
    
    public double obterAltura() {
        return altura;
    }

    public double obterLargura() {
        return largura;
    }
}
