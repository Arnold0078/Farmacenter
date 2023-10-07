package co.edu.uptc.gui.tablas;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;
    private Object[] filas;

    public ModeloTabla(){

        tabla = new JTable();
        modelo = new DefaultTableModel();
        filas = new Object[5];

        modelo.addColumn("Nombre");
        modelo.addColumn("Marca");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Codigo");
        tabla.setModel(modelo);

        filas[0] = "Nombre";
        filas[1] = "Marca";
        filas[2] = "Cantidad";
        filas[3] = "Precio";
        filas[4] = "Codigo";
        modelo.addRow(filas);
    }

    public void guardarDatos(String d1, String d2, int d3, int d4, int d5){
        filas[0] = d1;
        filas[1] = d2;
        filas[2] = d3;
        filas[3] = d4;
        filas[4] = d5;
        modelo.addRow(filas);
    }

    public void añadirTabla(){
        add(tabla);
    }
}
