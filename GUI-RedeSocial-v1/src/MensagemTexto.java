/**
 * Subclasse da classe Mensagem que define uma Mensagem de Texto.
 * Acrescenta apenas o texto da mensagem em si
 * 
 * Esse eh um exemplo do livro: Programacao Orientada a Objetos com Java - uma 
 * introducao pratica utilizando BlueJ.
 *      Traduzido e adaptado por Julio Cesar Alves
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016-10-26
 */
public class MensagemTexto extends Mensagem {
    // texto da mensagem    
    private String texto;
	
    /**
     * Cria uma mensagem de texto a partir do seu autor e do proprio texto
     * 
     * @param autor Autor da mensagem
     * @param id Identificador da mensagem
     * @param texto Texto da mensagem
     */    
    public MensagemTexto(String autor, int id, String texto) {
        super(autor, id);
        this.texto = texto;
    }

    @Override
    /**
     * Retorna o conteúdo da mensagem (nesse caso o texto da mensagem)
     * 
     * @return O conteúdo da mensagem
    */
    protected String getConteudoTextoExibicao() {
        return texto;
    }
}