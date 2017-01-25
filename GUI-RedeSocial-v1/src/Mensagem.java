import java.util.*;

/**
 * Classe que representa uma mensagem em uma rede social.
 * 
 * Uma mensagem possui um autor, hora da postagem, número de curtidas e 
 * comentários. O conteudo da mensagem em si deve ser tratado em subclasses.
 * 
 * Esse eh um exemplo do livro: Programacao Orientada a Objetos com Java - uma 
 * introducao pratica utilizando BlueJ.
 *      Traduzido e adaptado por Julio Cesar Alves
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016-10-26
 */
public abstract class Mensagem
{
    // Nome do autor da mensagem
    private String autor;
    // Quantidade de curtidas que a mensagem recebeu
    private int nroCurtidas;
    // Identificador da mensagem
    private int id;
    // Hora na qual a mensagem foi postada (em milissegundos)
    private long horaPostagem;
    // Lista de comentários que a mensagem recebeu
    private ArrayList<String> comentarios;        

    /**
     * Constroi uma mensagem a partir do nome do autor. 
     * Define automaticamente a hora da postagem; inicializa as curtidas com
     * zero e cria a lista de comentarios vazia.
     * 
     * @param autor Nome do autor da mensagem
     * @param id Identificador da mensagem
     */
    public Mensagem(String autor, int id) {
        this.autor = autor;
        this.id = id;
        nroCurtidas = 0;
        horaPostagem = System.currentTimeMillis();
        comentarios = new ArrayList<String>();		
    }

    /**
     * Retorna o id da mensagem
     * 
     * @return Id da mensagem
     */
    public int getId() {
        return id;
    }    
    
    /**
     * Realiza a ação de curtir uma mensagem. Na pratica apenas conta mais
     * uma curtida.
     */
    public void curtir() {
        nroCurtidas++;
    }

    /**
     * Adiciona um comentario a mensagem, recebendo apenas o texto do 
     * comentario
     * 
     * @param comentario Texto do comentario
     */
    public void comentar(String comentario) {
        comentarios.add(comentario);
    }

    /**
     * Retorna a mensagem formatada para aparecer no Feed de
     * Noticias. Inclui ha quanto tempo a mensagem foi publicada.
     * 
     * @return A mensagem formada para o Feed
     */
    public String getTextoExibicao() {
        String texto = "  [" + id + "]   " + autor + ": " + getConteudoTextoExibicao();
        texto += "\n" + exibirTempo() + " - " + nroCurtidas + " pessoas curtiram isso!";
        texto += "\n" + getTextoComentarios();
        
        return texto;
    }

    /**
     * Metodo auxiliar usado no metodo getTextoExibicao para que seja exibido ha 
     * quanto tempo a mensagem foi postada.
     * 
     * @return Texto com a informacao formatada
     */
    private String exibirTempo() {
        long tempoAtual = System.currentTimeMillis();
        long diferenca = (tempoAtual - horaPostagem);

        long diferencaSeg = diferenca/1000;
        long diferencaMin = diferencaSeg/60;

        if (diferencaMin < 1) {
                return "\tHa " + diferencaSeg + " segundos atras";
        }
        else {
                return "\tHa " + diferencaMin + " minutos atras";
        }
    }

    /**
     * Metodo auxiliar usado pelo metodo getTextoExibicao para obter os 
     * comentarios da mensagem.
     */
    private String getTextoComentarios() {
        String texto = "";
        if (comentarios.isEmpty()) {
            texto += "\tNao ha comentarios...\n";
        }
        else {            
            for (String comentario : comentarios) {	
                texto += "\t" + comentario + "\n";
            }            
        }
        return texto;
    }
    
    /**
     * Retorna o conteúdo da mensagem (a ser sobrescrito nas subclasses)
     * 
     * @return O conteúdo da mensagem
    */
    protected abstract String getConteudoTextoExibicao();


}