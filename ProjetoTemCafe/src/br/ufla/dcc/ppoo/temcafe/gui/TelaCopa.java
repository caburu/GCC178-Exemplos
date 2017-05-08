package br.ufla.dcc.ppoo.temcafe.gui;

import br.ufla.dcc.ppoo.temcafe.sensor.SensorGarrafaCafe;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaCopa {

    private JFrame janela;
    private JButton btnCafeSimples;
    private JButton btnCafeDuplo;
    private JButton btnEncherGarrafa;

    private SensorGarrafaCafe sensorGarrafa;

    public TelaCopa() {
        construirTela();
        sensorGarrafa = SensorGarrafaCafe.obterInstancia();
        atualizarComponentesTela();
    }

    public void exibir() {
        janela.setVisible(true);
    }

    private void construirTela() {
        janela = new JFrame("Copa do DCC");
        janela.setLayout(new GridLayout(3, 1, 5, 5));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnEncherGarrafa = new JButton("Encher garrafa",
                new ImageIcon(getClass().getResource("encher-garrafa.png")));
        btnEncherGarrafa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sensorGarrafa.encherGarrafa();
                atualizarComponentesTela();
            }
        });

        btnCafeSimples = new JButton("Tomar café simples",
                new ImageIcon(getClass().getResource("cafe-simples.png")));
        btnCafeSimples.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sensorGarrafa.tomarCafeSimples();
                atualizarComponentesTela();
            }
        });

        btnCafeDuplo = new JButton("Tomar café duplo",
                new ImageIcon(getClass().getResource("cafe-duplo.png")));
        btnCafeDuplo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sensorGarrafa.tomarCafeDuplo();
                atualizarComponentesTela();
            }
        });

        janela.add(btnCafeSimples);
        janela.add(btnCafeDuplo);
        janela.add(btnEncherGarrafa);

        janela.setSize(300, 400);
    }

    private void atualizarComponentesTela() {
        if (sensorGarrafa.obterVolume() == SensorGarrafaCafe.VOL_GARRAFA_VAZIA) {
            btnCafeDuplo.setEnabled(false);
            btnCafeSimples.setEnabled(false);
            btnEncherGarrafa.setEnabled(true);
        } else if (sensorGarrafa.obterVolume() == SensorGarrafaCafe.VOL_GARRAFA_CHEIA) {
            btnCafeDuplo.setEnabled(true);
            btnCafeSimples.setEnabled(true);
            btnEncherGarrafa.setEnabled(false);
        } else {
            btnCafeDuplo.setEnabled(true);
            btnCafeSimples.setEnabled(true);
            btnEncherGarrafa.setEnabled(true);
        }
    }
    
    public static void main(String[] args) {
        new TelaCopa().exibir();
    }

}
