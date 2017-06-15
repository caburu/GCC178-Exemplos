package editorgrafico;

public class Principal {

    public static void main(String[] args) {
        Painel meuPainel = new Painel();
        meuPainel.adicionarElemento(new Retangulo(2, 3, 5.2, 3.8, "Azul"));
        meuPainel.adicionarElemento(new Circulo(2, 0, 0, "Verde"));
        meuPainel.adicionarElemento(new Imagem(2, 3, 2, 2, "c:\\teste.png"));
        meuPainel.exibirObjetos();
        System.out.printf("Área total: %.2f\n", meuPainel.calcularAreaTotal());
       
    }
    
    
    
}
