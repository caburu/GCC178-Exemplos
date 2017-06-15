package editorgrafico;

public class Imagem implements ObjetoDesenhavel {

    private double posX;
    private double posY;
    private double altura;
    private double largura;
    private String caminhoArquivo;    

    public Imagem(double posX, double posY, double altura, double largura, String caminhoArquivo) {
        this.posX = posX;
        this.posY = posY;
        this.altura = altura;
        this.largura = largura;
        this.caminhoArquivo = caminhoArquivo;
    }
    
    @Override
    public void exibir() {
        System.out.printf("Imagem \"%s\" (%.2f x %.2f) -> [%.2f; %.2f]\n",
                caminhoArquivo, altura, largura, posX, posY);        
    }

    @Override
    public double obterArea() {
        return altura * largura;
    }

}
