package org.javiersian.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.javiersian.controller.VehiculoController;
import org.javiersian.model.VehiculoLavado;
import org.javiersian.model.ReparacionMecanica;
import org.javiersian.model.RevisionFrenos;
import org.javiersian.model.Vehiculo;

public class VehiculoView extends Application {

    private VehiculoController controller = new VehiculoController();

    @Override
    public void start(Stage stage) {

        TabPane tabPane = new TabPane();

        Tab tabRegistro = new Tab("Registro de Servicios");
        tabRegistro.setClosable(false);

        ComboBox<String> cmbTipo = new ComboBox<>();
        cmbTipo.getItems().addAll(
                "Lavado",
                "Reparacion Mecanica",
                "Revision Frenos"
        );

        TextField txtDescripcion = new TextField();

        ComboBox<String> cmbTamanoVehiculo = new ComboBox<>();
        cmbTamanoVehiculo.getItems().addAll("Pequeño", "Mediano", "Grande/SUV");

        TextField txtCostoRepuestos = new TextField();
        TextField txtHorasManoObra = new TextField();
        TextField txtPrecioHora = new TextField();

        TextField txtNumeroEjes = new TextField();
        TextField txtCostoPorEje = new TextField();

        Label lblTamanoVehiculo = new Label("Tamaño Vehículo:");
        Label lblCostoRepuestos = new Label("Costo Repuestos:");
        Label lblHorasManoObra = new Label("Horas Mano Obra:");
        Label lblPrecioHora = new Label("Precio por Hora:");
        Label lblNumeroEjes = new Label("Número de Ejes:");
        Label lblCostoPorEje = new Label("Costo por Eje:");

        Button btnAgregar = new Button("Agregar Servicio");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Tipo Servicio:"), 0, 0);
        grid.add(cmbTipo, 1, 0);

        grid.add(new Label("Descripción:"), 0, 1);
        grid.add(txtDescripcion, 1, 1);

        grid.add(lblTamanoVehiculo, 0, 2);
        grid.add(cmbTamanoVehiculo, 1, 2);

        grid.add(lblCostoRepuestos, 0, 2);
        grid.add(txtCostoRepuestos, 1, 2);
        grid.add(lblHorasManoObra, 0, 3);
        grid.add(txtHorasManoObra, 1, 3);
        grid.add(lblPrecioHora, 0, 4);
        grid.add(txtPrecioHora, 1, 4);

        grid.add(lblNumeroEjes, 0, 2);
        grid.add(txtNumeroEjes, 1, 2);
        grid.add(lblCostoPorEje, 0, 3);
        grid.add(txtCostoPorEje, 1, 3);

        grid.add(btnAgregar, 1, 5);

        Runnable ocultarTodo = () -> {
            lblTamanoVehiculo.setVisible(false);
            cmbTamanoVehiculo.setVisible(false);
            lblCostoRepuestos.setVisible(false);
            txtCostoRepuestos.setVisible(false);
            lblHorasManoObra.setVisible(false);
            txtHorasManoObra.setVisible(false);
            lblPrecioHora.setVisible(false);
            txtPrecioHora.setVisible(false);
            lblNumeroEjes.setVisible(false);
            txtNumeroEjes.setVisible(false);
            lblCostoPorEje.setVisible(false);
            txtCostoPorEje.setVisible(false);
        };

        ocultarTodo.run();

        cmbTipo.setOnAction(e -> {
            ocultarTodo.run();
            if ("Lavado".equals(cmbTipo.getValue())) {
                lblTamanoVehiculo.setVisible(true);
                cmbTamanoVehiculo.setVisible(true);
            } else if ("Reparacion Mecanica".equals(cmbTipo.getValue())) {
                lblCostoRepuestos.setVisible(true);
                txtCostoRepuestos.setVisible(true);
                lblHorasManoObra.setVisible(true);
                txtHorasManoObra.setVisible(true);
                lblPrecioHora.setVisible(true);
                txtPrecioHora.setVisible(true);
            } else if ("Revision Frenos".equals(cmbTipo.getValue())) {
                lblNumeroEjes.setVisible(true);
                txtNumeroEjes.setVisible(true);
                lblCostoPorEje.setVisible(true);
                txtCostoPorEje.setVisible(true);
            }
        });

        Tab tabResumen = new Tab("Resumen del Día");
        tabResumen.setClosable(false);

        ListView<Vehiculo> listView = new ListView<>();
        Button btnCalcular = new Button("Calcular Total Ingresos");
        Label lblTotal = new Label("Total del Día: Q0.00");

        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(listView, btnCalcular, lblTotal);

        btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    if (cmbTipo.getValue() == null) {
                        Alert alerta = new Alert(Alert.AlertType.WARNING);
                        alerta.setHeaderText(null);
                        alerta.setContentText("Seleccione un tipo de servicio.");
                        alerta.showAndWait();
                        return;
                    }
                    
                    String descripcion = txtDescripcion.getText();
                    Vehiculo vehiculo = null;
                    
                    switch (cmbTipo.getValue()) {
                        case "Lavado":
                            String tamano = cmbTamanoVehiculo.getValue();
                            vehiculo = new VehiculoLavado(descripcion, tamano);
                            break;
                            
                        case "Reparacion Mecanica":
                            double repuestos = Double.parseDouble(txtCostoRepuestos.getText());
                            double horas = Double.parseDouble(txtHorasManoObra.getText());
                            double precioHora = Double.parseDouble(txtPrecioHora.getText());
                            vehiculo = new ReparacionMecanica(descripcion, repuestos, horas, precioHora);
                            break;
                            
                        case "Revision Frenos":
                            int ejes = Integer.parseInt(txtNumeroEjes.getText());
                            double costoEje = Double.parseDouble(txtCostoPorEje.getText());
                            vehiculo = new RevisionFrenos(descripcion, ejes, costoEje);
                            break;
                    }
                    
                    controller.agregarVehiculo(vehiculo);
                    
                    listView.setItems(
                            FXCollections.observableArrayList(
                                    controller.getListaVehiculo()
                            )
                    );
                    
                    txtDescripcion.clear();
                    cmbTamanoVehiculo.setValue(null);
                    txtCostoRepuestos.clear();
                    txtHorasManoObra.clear();
                    txtPrecioHora.clear();
                    txtNumeroEjes.clear();
                    txtCostoPorEje.clear();
                    
                } catch (Exception ex) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setHeaderText(null);
                    alerta.setContentText("Datos incorrectos.");
                    alerta.showAndWait();
                }
            }
        });

        btnCalcular.setOnAction(e -> {
            double total = controller.calcularTotalIngresos();
            lblTotal.setText("Total del Día: Q" + String.format("%.2f", total));
        });

        tabRegistro.setContent(grid);
        tabResumen.setContent(vbox);

        tabPane.getTabs().addAll(tabRegistro, tabResumen);

        Scene scene = new Scene(tabPane, 450, 600);

        stage.setScene(scene);
        stage.setTitle("Facturación Taller Mecánico");
        stage.show();
    }
}
