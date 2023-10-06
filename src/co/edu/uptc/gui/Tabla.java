package co.edu.uptc.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

import static java.awt.Transparency.TRANSLUCENT;

public class Tabla extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;

    public Tabla(){
        setBorder(new TitledBorder("Productos"));
        tabla = new JTable();
        modelo = new DefaultTableModel();
        Object[] filas = new Object[6];

        modelo.addColumn("Nombre");
        modelo.addColumn("Marca");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Codigo");
        modelo.addColumn("Tipo");
        tabla.setModel(modelo);

        filas[0] = "Nombre";
        filas[1] = "Marca";
        filas[2] = "Cantidad";
        filas[3] = "Precio";
        filas[4] = "Codigo";
        filas[5] = "Tipo";
        modelo.addRow(filas);

        add(tabla);
    }
}
