/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package perfis;

import elementosGraficosTimao.BotaoDoTimao;
import elementosGraficosTimao.CaixaTextoDoTimao;
import elementosGraficosTimao.PainelDoTimao;
import elementosGraficosTimao.RotuloDoTimao;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Paulo
 */
public class FabricaDoPerfilDoTimao extends FabricaDePerfis {

    @Override
    public JPanel criarPainel() {        
        return new PainelDoTimao();
    }

    @Override
    public JLabel criarRotulo() {
        return new RotuloDoTimao();
    }

    @Override
    public JButton criarBotao() {
        return new BotaoDoTimao();
    }

    @Override
    public JTextField criarCaixaDeTexto() {
       return new CaixaTextoDoTimao();
    }
    
}
