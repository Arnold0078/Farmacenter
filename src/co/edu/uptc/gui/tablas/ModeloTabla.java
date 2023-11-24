package co.edu.uptc.gui.tablas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;
    private Object[] filas;
    private JScrollPane scrollPane;
    private String[] filasp= {"Nombre", "Marca", "Cantidad", "Precio", "Codigo"};

    public ModeloTabla(){
        tabla = new JTable();
        modelo = new DefaultTableModel(filasp,0);
        scrollPane = new JScrollPane(tabla);
        filas = new Object[5];

        tabla.setModel(modelo);

        tabla.getColumn("Nombre").setPreferredWidth(150);
    }

    public void guardarDatos(String d1, String d2, int d3, int d4, int d5){
        filas[0] = d1;
        filas[1] = d2;
        filas[2] = d3;
        filas[3] = d4;
        filas[4] = d5;
        modelo.addRow(filas);
    }

    public void borrar(int posicion){
        modelo.removeRow(posicion);
    }

    public void añadir(){
        add(scrollPane);
    }
}
