package edu.actividad1.poo2.proyectofinal_poo2.controladores;

import edu.actividad1.poo2.proyectofinal_poo2.Application;
import edu.actividad1.poo2.proyectofinal_poo2.modelos.Cursos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private Button btnLimpiar;

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

    @FXML
    private TableView<?> tablaAlumnos;

    // referencia al archivo de aplicacion para comunicacion
    Application app;

    public void setMain(Application main){
        this.app = main;
    }

    public ObservableList listaCursos = Cursos.listaCursos;


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

    @FXML
    void clicLimpiar(ActionEvent actionEvent) {
        limpiarCampos();
    }

    private void limpiarCampos(){
        comboBCursos.getSelectionModel().clearSelection();
        DatePAsignacion.setValue(null);
    }

    public void initialize(){
        comboBCursos.setItems(listaCursos);
    }


}
