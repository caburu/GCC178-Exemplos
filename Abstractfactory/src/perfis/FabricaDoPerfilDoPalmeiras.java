/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package perfis;

import elementosGraficosTimao.BotaoDoPalmeiras;
import elementosGraficosTimao.CaixaTextoDoPalmeiras;
import elementosGraficosTimao.PainelDoPalmeiras;
import elementosGraficosTimao.RotuloDoPalmeiras;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Paulo
 */
public class FabricaDoPerfilDoPalmeiras extends FabricaDePerfis {

    @Override
    public JPanel criarPainel() {        
        return new PainelDoPalmeiras();
    }

    @Override
    public JLabel criarRotulo() {
        return new RotuloDoPalmeiras();
    }

    @Override
    public JButton criarBotao() {
        return new BotaoDoPalmeiras();
    }

    @Override
    public JTextField criarCaixaDeTexto() {
       return new CaixaTextoDoPalmeiras();
    }
    
}
