package co.edu.uptc.gui.ventanas;

import javax.swing.*;
import java.awt.*;

public class ModeloVentana extends JFrame {

    public ModeloVentana(){
        setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/logo.png"));
        setLayout(new BorderLayout());
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
