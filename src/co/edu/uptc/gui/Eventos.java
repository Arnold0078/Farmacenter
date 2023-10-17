package co.edu.uptc.gui;

import co.edu.uptc.negocio.Administrar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eventos implements ActionListener {

    public static final String REGISTRAR = "REGISTRAR";
    public static final String BUSCAR = "BUSCAR";
    public static final String AGREGARUNIDADES = "AGREGAR UNIDADES";


    private VentanaPrincipal ventanaPrincipal;
    private Administrar administrar;

    public Eventos(VentanaPrincipal ventanaPrincipal, Administrar administrar){
        this.ventanaPrincipal = ventanaPrincipal;
        this.administrar = administrar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object decision = e.getActionCommand();

        if (decision.equals(REGISTRAR)){

        }else if (decision.equals(BUSCAR)){

        }else if(decision.equals(AGREGARUNIDADES)){
            
        }
    }
}
