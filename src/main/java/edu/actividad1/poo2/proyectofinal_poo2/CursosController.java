package edu.actividad1.poo2.proyectofinal_poo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CursosController {

    @FXML
    private DatePicker DatePAsignacion;

    @FXML
    private AnchorPane PaneCursos;

    @FXML
    private Button btnRegresar;

    @FXML
    private ComboBox<?> comboBCursos;

    @FXML
    private Label lbCursos;

    @FXML
    private Label lbFechaAsignacion;

    @FXML
    private Label lbGrafSolvencia;

    @FXML
    private Label lbSelecCursos;

    @FXML
    private Label lbTablaAlumnos;

    // referencia al archivo de aplicacion para comunicacion
    Application app;

    public void setMain(Application main){
        this.app = main;
    }


    @FXML
    void clicRegresar(ActionEvent event) throws IOException {
        app.principalStage.show();
        app.cursosStage.hide();
    }

    @FXML
    void seleccionCurso(ActionEvent event) {

    }

    @FXML
    void seleccionFecha(ActionEvent event) {

    }

}
