package br.ufla.dcc.ppoo.temcafe.gui;

import br.ufla.dcc.ppoo.temcafe.tarefas.VerificarGarrafaCafe;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import static org.quartz.JobBuilder.newJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import org.quartz.Trigger;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class TelaMonitorGarrafaCafe {

    private JFrame janela;
    private JLabel lbTitulo;
    private JLabel lbUltimaAtualizacao;    
    private JProgressBar pbSituacaoGarrafa;
    private Scheduler agendadorDeTarefas;
    
    private static TelaMonitorGarrafaCafe instancia;

    private TelaMonitorGarrafaCafe() {
        construirTela();
        criarTarefa();
    }

    private void criarTarefa() {
        try {
            agendadorDeTarefas = StdSchedulerFactory.getDefaultScheduler();

            JobDetail job = newJob(VerificarGarrafaCafe.class)
                    .withIdentity("job", "group")
                    .build();

            Trigger trigger = newTrigger()
                    .withIdentity("trigger", "group")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(20)
                            .repeatForever())
                    .build();

            agendadorDeTarefas.scheduleJob(job, trigger);
            agendadorDeTarefas.start();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void construirTela() {
        janela = new JFrame("Monitor da Garrafa de Café da Copa");
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        lbTitulo = new JLabel("Volume da Garrafa de Café", SwingConstants.CENTER);
        lbUltimaAtualizacao = new JLabel("", SwingConstants.CENTER);
        
        pbSituacaoGarrafa = new JProgressBar(JProgressBar.HORIZONTAL);
        pbSituacaoGarrafa.setMaximum(1000);
        pbSituacaoGarrafa.setMinimum(0);
        pbSituacaoGarrafa.setStringPainted(true);

        janela.setLayout(new GridLayout(3, 1, 5, 5));

        janela.add(lbTitulo);
        janela.add(pbSituacaoGarrafa);
        janela.add(lbUltimaAtualizacao);
        janela.setSize(450, 200);

        janela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    agendadorDeTarefas.shutdown();
                    System.exit(0);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

    }

    public void exibirTela() {
        janela.setVisible(true);
    }

    public void alterarSituacaoGarrafa(int volume) {
        pbSituacaoGarrafa.setValue(volume);
    }
    
    public void alterarUltimaAtualizacao(String atualizacao) {
        lbUltimaAtualizacao.setText("Última atualização: " + atualizacao);
    }

    public static TelaMonitorGarrafaCafe obterInstancia() {
        if (instancia == null) {
            instancia = new TelaMonitorGarrafaCafe();
        }
        return instancia;
    }

    public static void main(String[] args) {
        TelaMonitorGarrafaCafe.obterInstancia().exibirTela();
    }
}
