package co.edu.uptc.gui.paneles;

import javax.swing.*;

public class ModeloPaneles extends JPanel{

    public JLabel jl1(String nombre){ return new JLabel(nombre);}

    public JTextField jx1(int longuitud){
        return new JTextField(longuitud);
    }
}
