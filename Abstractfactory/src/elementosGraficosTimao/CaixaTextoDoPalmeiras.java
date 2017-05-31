/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosGraficosTimao;

import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author Paulo
 */
public class CaixaTextoDoPalmeiras extends JTextField {

    @Override
    public Font getFont() {
        return new Font(Font.SANS_SERIF, Font.ITALIC, 14);
    }
    
}
