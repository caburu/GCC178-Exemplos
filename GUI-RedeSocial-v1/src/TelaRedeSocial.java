
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 * Classe criada para implementar a interface gráfica da Rede Social.
 * O objetivo dessa implementação é didático! Exercitar e apresentar conceitos
 * de GUIs (Interfaces Gráficas de Usuário) e Tratamento de Exceções
 * 
 * @author Julio
 */
public class TelaRedeSocial {
    // Janela da nossa tela
    private JFrame janela;
    // Caixa de texto para exibir o feed de noticiai    
    private JTextArea areaTextoFeed;    
    // Botão para postar uma mensagem no feed
    private JButton botaoPostarMensagem;
    // Botão para curtir uma mensagem do feed
    private JButton botaoCurtir;
    // Botão para comentar uma mensagem do feed
    private JButton botaoComentar;
    
    // Objeto que representa a Regra de Negócios (a lógica da Rede Social em si)
    private FeedNoticias feed;
    
    /*
     * Construtor da classe: cria o feed, os componentes e monta a tela.
    */
    public TelaRedeSocial() {
        feed = new FeedNoticias();
        
        construirJanela();
    }

    /*
     * Constroi os componentes e monta a janela
    */
    private void construirJanela() throws HeadlessException {
        janela = new JFrame("GUI - Rede Social");
        janela.setSize(500, 600);
        janela.setLayout(new BoxLayout(janela.getContentPane(), BoxLayout.Y_AXIS));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        criarComponentes();
        
        montarJanela();
    }

    private void criarComponentes() {
        areaTextoFeed = new JTextArea("Feed de Notícias");
        botaoPostarMensagem = new JButton("Postar Mensagem");
        botaoCurtir = new JButton("Curtir");
        botaoComentar = new JButton("Comentar");
        
        areaTextoFeed.setEditable(false);
        
        botaoPostarMensagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postarMensagem();
            }            
        });
        
        botaoCurtir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curtirMensagem();
            }
        });
        
        botaoComentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comentarMensagem();
            }
        });
    }

    private void montarJanela() {
        janela.add(areaTextoFeed);
        janela.add(botaoPostarMensagem);
        janela.add(botaoCurtir);
        janela.add(botaoComentar);
    }
    
    /*
     * Exibe a tela da Rede Social
    */
    public void exibir() {
        janela.setVisible(true);
    }
    
    
    private void postarMensagem() {
        String autor = JOptionPane.showInputDialog("Autor da mensagem");
        String mensagem = JOptionPane.showInputDialog("Texto da mensagem");        
        feed.postarMensagemTexto(autor, mensagem);        
        atualizarFeed();
    }    

    private void atualizarFeed() {        
        areaTextoFeed.setText(feed.getConteudo());
    }
    
    private void curtirMensagem() {
        int idMensagem = Integer.parseInt(JOptionPane.showInputDialog("Id da mensagem"));
        feed.curtir(idMensagem);
        atualizarFeed();
    }
    
    private void comentarMensagem() {
        int idMensagem = Integer.parseInt(JOptionPane.showInputDialog("Id da mensagem"));
        String comentario = JOptionPane.showInputDialog("Comentario da mensagem"); 
        feed.comentar(idMensagem, comentario);
        atualizarFeed();
    }    
}
