
package org.javiersian.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage escenarioPrincipal) throws Exception{
       //nodo raiz
       Pane raiz = new Pane();
       //escenario(nodoRaiz, ancho, largo)
       Scene escena = new Scene(raiz, 450, 600);
       //cargamos escenas en escenario y mostramos escenario
       escenarioPrincipal.setScene(escena);
       escenarioPrincipal.show();
       
       
    }
    
}
