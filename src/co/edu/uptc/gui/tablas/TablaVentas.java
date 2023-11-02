package co.edu.uptc.gui.tablas;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.negocio.Administrar;
import co.edu.uptc.persistencia.Producto;
import co.edu.uptc.persistencia.Venta;

public class TablaVentas  extends JPanel{
	
	public TablaVentas (Administrar administrar) {
		setBorder(new TitledBorder("Ventas"));
        setBackground(new Color(0,175,200));
        ArrayList<Venta> lista = administrar.ListaVentas();

        
        JTable tabla = new JTable();
        DefaultTableModel modelo= new DefaultTableModel();
        Object [] filas =new Object[4];
        
        modelo.addColumn("Numero de venta");
        modelo.addColumn("Nombre del producto");
        modelo.addColumn("Codigo del producto");
        modelo.addColumn("Cantidad");
        tabla.setModel(modelo);
        
        tabla.getColumn("Numero de venta").setPreferredWidth(110);
        tabla.getColumn("Nombre del producto").setPreferredWidth(150);
        tabla.getColumn("Codigo del producto").setPreferredWidth(120);
        
        
       filas[0]="Numero de venta";
       filas[1]="Nombre del producto";
       filas[2]="Codigo del producto";
       filas[3]="Cantidad";
       
       modelo.addRow(filas);
       
       for (Venta venta : lista) {
		filas[0]=venta.getId();
		filas[1]=venta.getNombreProducto();
		filas[2]=venta.getCodigo();
		filas[3]=venta.getCantidad();
		
		modelo.addRow(filas);
		
	}
       add(tabla);

        
	}

}
