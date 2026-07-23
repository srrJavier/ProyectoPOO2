
package org.javiersian.view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class VehiculoView {
    
    private TabPane panelPestana = new TabPane();
    
    public VehiculoView() {
        iniciarVista();
    }
    
    private void iniciarVista(){
        //formulario registro
        Tab tabRegistro = new Tab("Registro");
        
        //Formulario lista resumen
        Tab tabResumen = new Tab("Lista resumen");
        
    }
}