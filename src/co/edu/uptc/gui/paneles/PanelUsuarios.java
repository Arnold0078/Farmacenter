package co.edu.uptc.gui.paneles;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelUsuarios extends JPanel {

    private JTextArea txCedula;
    private JTextArea txNombre;
    private JTextArea txContraseña;
    private JTextArea txCorreo;
    private JTextArea txCelular;

    public PanelUsuarios(){
        setLayout(new GridLayout(5,2));
        setBorder(new TitledBorder("Registro de usuarios"));
        setOpaque(false);

        //Inicialisando los JLabel
        JLabel jlCedula = new JLabel("* Cedula:");
        JLabel jlNombre = new JLabel("* Nombre:");
        JLabel jlContraseña = new JLabel("* Contraseña:");
        JLabel jlCorreo = new JLabel("* Correo:");
        JLabel jlCelular = new JLabel("Celular:");

        //Inicialisando los JTextArea
        txCedula = new JTextArea();
        txNombre = new JTextArea();
        txContraseña = new JTextArea();
        txCorreo = new JTextArea();
        txCelular = new JTextArea();

        //Añadimos al Panel
        add(jlCedula);
        add(txCedula);
        add(jlNombre);
        add(txNombre);
        add(jlContraseña);
        add(txContraseña);
        add(jlCorreo);
        add(txCorreo);
        add(jlCelular);
        add(txCelular);
    }
}
