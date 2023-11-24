package co.edu.uptc.gui.paneles;

import co.edu.uptc.negocio.Administrar;
import co.edu.uptc.persistencia.Usuario;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelUsuarios extends JPanel {

    private JTextField txCedula;
    private JTextField txNombre;
    private JTextField txContraseña;
    private JTextField txCorreo;
    private JTextField txCelular;
    private Administrar administrar;

    public PanelUsuarios(Administrar administrar){
        this.administrar = administrar;

        setLayout(new GridLayout(5,2));
        setBorder(new TitledBorder("Registro de usuarios"));
        setOpaque(false);

        //Inicialisando los JLabel
        JLabel jlCedula = new JLabel("* Cedula:");
        JLabel jlNombre = new JLabel("* Nombre:");
        JLabel jlContraseña = new JLabel("* Contraseña:");
        JLabel jlCorreo = new JLabel("* Correo:");
        JLabel jlCelular = new JLabel("Celular:");

        //Inicialisando los JTextField
        txCedula = new JTextField();
        txNombre = new JTextField();
        txContraseña = new JTextField();
        txCorreo = new JTextField();
        txCelular = new JTextField();

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

    public Usuario nuevoUsuario(){
        try {
            Usuario nuevo = new Usuario();
            if (validarDatos()){
                nuevo.setCedula(Integer.parseInt(txCedula.getText()));
                nuevo.setNombre(txNombre.getText());
                nuevo.setContraseña(txContraseña.getText());
                nuevo.setCorreo(txCorreo.getText().toLowerCase());
                if (!txCelular.getText().isEmpty()){
                    nuevo.setCelular(Integer.parseInt(txCelular.getText()));
                }
                limpiar();
                return nuevo;
            }

            return null;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Por favor ingrese unicamente numeros en (Cedula, Celular)", null, JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private boolean validarDatos(){
        boolean verificar = true;
        String cedula = txCedula.getText();
        String nombre = txNombre.getText();
        String contraseña = txContraseña.getText();
        String correo = txCorreo.getText();

        if (cedula.isEmpty() || nombre.isEmpty() || contraseña.isEmpty() || correo.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor rellene los espacios con el *", null, JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        else if (administrar.buscarUsuario(Integer.parseInt(cedula), null) != null) {
            JOptionPane.showMessageDialog(null, "Cedula ya registrada", null, JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        else if (contraseña.length() < 7) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener una longitud minima de 7", null, JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        else if (cedula.length() < 7) {
            JOptionPane.showMessageDialog(null, "La cedula debe tener una longitud minima de 7", null, JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        return verificar;
    }

    private void limpiar(){
        txCedula.setText("");
        txNombre.setText("");
        txContraseña.setText("");
        txCorreo.setText("");
        txCelular.setText("");
    }

}
