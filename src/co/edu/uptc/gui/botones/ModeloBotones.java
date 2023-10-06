package co.edu.uptc.gui.botones;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ModeloBotones extends JPanel {

    public JButton boton1(String evento, ActionListener actionListener){
        JButton boton1 = new JButton(evento);
        boton1.setActionCommand(evento);
        boton1.addActionListener(actionListener);
        return boton1;
    }
}
