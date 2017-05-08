package multitarefa;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CorpoHumano {

    private JFrame janela;
    private JButton btnIniciar;
    private JButton btnParar;
    private JTextArea taSaidaCorpoHumano;

    private List<Runnable> tarefasDoCorpo;
    private boolean vivo;

    public CorpoHumano() {
        vivo = false;
        construirTarefas();
        construirTela();
    }

    private void construirTarefas() {
        tarefasDoCorpo = new ArrayList<Runnable>();
        tarefasDoCorpo.add(new BaterCoracao(this));
        tarefasDoCorpo.add(new PiscarOlhos(this));
        tarefasDoCorpo.add(new Respirar(this));
    }

    public void nascer() {
        vivo = true;
        for (Runnable tarefa : tarefasDoCorpo) {
            Thread th = new Thread(tarefa);
            th.start();
        }
    }

    public void morrer() {
        vivo = false;
    }

    public boolean estahVivo() {
        return vivo;
    }

    private void construirTela() {
        janela = new JFrame("Corpo Humano");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new BorderLayout(3, 3));

        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nascer();
            }
        });

        btnParar = new JButton("Parar");
        btnParar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                morrer();
            }
        });

        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 5, 5));
        painelBotoes.add(btnIniciar);
        painelBotoes.add(btnParar);

        taSaidaCorpoHumano = new JTextArea(10, 35);
        taSaidaCorpoHumano.setEditable(false);

        janela.add(painelBotoes, BorderLayout.NORTH);
        janela.add(new JScrollPane(taSaidaCorpoHumano),
                BorderLayout.SOUTH);

        janela.pack();
    }

    public void exibir() {
        janela.setVisible(true);
    }
    
    public void realizarAcao(String msg) {
        taSaidaCorpoHumano.append(msg + "\n");
    }

    public static void main(String[] args) {
        new CorpoHumano().exibir();
    }

}
