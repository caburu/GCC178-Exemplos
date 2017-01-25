import java.util.*;

/**
 * Classe que define o Feed de Noticias da Rede Social.
 * Possui uma lista de mensagens que pode ser de texto ou com foto e metodos
 para postar as mensagens e getTextoExibicao todo o Feed.
 
 Esse eh um exemplo do livro: Programacao Orientada a Objetos com Java - uma 
 introducao pratica utilizando BlueJ.
      Traduzido e adaptado por Julio Cesar Alves
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016-10-26
 */
public class FeedNoticias {
    // lista de mensagens publicadas no Feed
    private ArrayList<Mensagem> mensagens;

    /**
     * Cria o Feed de Noticias (apenas inicializa a lista de mensagens)
     */
    public FeedNoticias() {
        mensagens = new ArrayList<Mensagem>();
    }

    /**
     * Metodo para postar uma mensagem de texto no feed. Cria a mensagem e a
     * adiciona na lista de mensagens.
     * 
     * @param autor Nome do autor da mensagem.
     * @param texto Texto da mensagem em si.
     */
    public void postarMensagemTexto(String autor, String texto) {
        int id = mensagens.size();
        mensagens.add(new MensagemTexto(autor, id, texto));
    }

    /**
     * Metodo para postar uma mensagem com foto no feed. Cria a mensagem e a
     * adiciona na lista de mensagens.
     * 
     * @param autor Nome do autor da mensagem.
     * @param arquivoFoto Nome do arquivo da foto.
     * @param legenda Legenda da foto.
     */
    public void postarMensagemFoto(String autor, String arquivoFoto, 
            String legenda) {
        int id = mensagens.size();
        mensagens.add(new MensagemFoto(autor, id, arquivoFoto, legenda));
    }

    /**
     * Metodo de obtenção do conteúdo do Feed de Noticiais. Percorre a lista de 
     * mensagens e monta uma string com os textos de exibição de cada mensagem.
     * IMPORTANTE: geralmente não se retorna texto formato para usar interfaces
     *             gráficas. São retornados os próprios objetos.
     * 
     * @return O conteúdo do feed
     */
    public String getConteudo() {
        String conteudo = "Feed de Noticias\n";
        
        for (Mensagem mensagem : mensagens) {
            conteudo += "\n" + mensagem.getTextoExibicao();
        }
        
        return conteudo;
    }
    
    /**
     * Método para curtir uma mensagem no Feed de notícias (a partir do 
     * identificador da mensagem).
     * 
     * @param idMensagem Identificador da mensagem
     */
    public void curtir(int idMensagem) {
        Mensagem mensagem = buscarMensagemPeloId(idMensagem);
        mensagem.curtir();
    }
    
    /**
     * Método para comentar uma mensagem do Feed de notícias (a partir do
     * identificador da mensagem)
     * 
     * @param idMensagem Identificador da mensagem
     * @param comentario Comentário a ser acrescentado
     */
    public void comentar(int idMensagem, String comentario) {
        Mensagem mensagem = buscarMensagemPeloId(idMensagem);
        mensagem.comentar(comentario);
    }
    
    /**
     * Retorna a mensagem correspondente ao identificador passado. Retorna null
     * se não existir mensagem com esse identificador no feed. Obs: realiza
     * busca simples (percorrendo a lista).
     * 
     * @param idMensagem Identificador da mensagem
     * @return Mensagem correspondente ao identificador
     */
    private Mensagem buscarMensagemPeloId(int idMensagem) {
        for (Mensagem mensagem : mensagens) {
            if (mensagem.getId() == idMensagem) {
                return mensagem;
            }
        }
        return null;
    }
}