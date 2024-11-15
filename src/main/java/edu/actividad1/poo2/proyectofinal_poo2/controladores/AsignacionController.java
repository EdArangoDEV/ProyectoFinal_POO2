package edu.actividad1.poo2.proyectofinal_poo2.controladores;

import edu.actividad1.poo2.proyectofinal_poo2.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class AsignacionController {

    @FXML
    private Button btnAsignar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnRegresar;

    @FXML
    private CheckBox checkBPagar;

    @FXML
    private Label lbAsignaciones;

    @FXML
    private Label lbAsignaciones1;

    @FXML
    private Label lbCVC;

    @FXML
    private Label lbCarnet;

    @FXML
    private Label lbCorreo;

    @FXML
    private Label lbCursosA;

    @FXML
    private Label lbCursosD;

    @FXML
    private Label lbDireccion;

    @FXML
    private Label lbExpiracionT;

    @FXML
    private Label lbNTarjeta;

    @FXML
    private Label lbNombre;

    @FXML
    private Label lbPagoCursos;

    @FXML
    private Label lbTel;

    @FXML
    private Label lbTitular;


    @FXML
    private ListView<?> listAsignados;

    @FXML
    private ListView<?> listCursos;

//    ArrayList<String> listaCursos = new ArrayList<String>();
    ObservableList listaCursos = FXCollections.observableArrayList();

    @FXML
    private TextField txtFieldCorreo;

    @FXML
    private TextField txtFielNTarjeta;

    @FXML
    private TextField txtFieldCVC;

    @FXML
    private TextField txtFieldCarnet;

    @FXML
    private TextField txtFieldDireccion;

    @FXML
    private TextField txtFieldExpiracionT;

    @FXML
    private TextField txtFieldNombre;

    @FXML
    private TextField txtFieldTel;

    @FXML
    private TextField txtFieldTitular;

    @FXML
    void clicAsignar(ActionEvent event) {

    }

    @FXML
    void clicCancelar(ActionEvent event) {

    }

    @FXML
    void clicRegresar(ActionEvent event) {
        app.principalStage.show();
        app.asignacionesStage.hide();
    }

    // referencia al archivo de aplicacion para comunicacion
    Application app;

    public void setMain(Application main){
        this.app = main;
    }

    private void setElementosPago(boolean valor) {
        lbNTarjeta.setDisable(valor);
        txtFielNTarjeta.setDisable(valor);
        lbTitular.setDisable(valor);
        txtFieldTitular.setDisable(valor);
        lbExpiracionT.setDisable(valor);
        txtFieldExpiracionT.setDisable(valor);
        lbCVC.setDisable(valor);
        txtFieldCVC.setDisable(valor);
    }

    private  void setBotonAsignar(){
        boolean txtFNombre = !txtFieldNombre.getText().trim().isEmpty();
        System.out.println(txtFNombre);
//        boolean txtFCarnet = !txtFieldCarnet.getText().trim().isEmpty();
//        boolean txtFTel = !txtFieldTel.getText().trim().isEmpty();
//        boolean txtFDireccion = !txtFieldDireccion.getText().trim().isEmpty();
//        boolean txtFCorrero = !txtFieldCorreo.getText().trim().isEmpty();



//        btnAsignar.setDisable();
    }

    public void initialize(){
        // Deshabilitar boton Asingar
        btnAsignar.setDisable(true);

        // Añadir listener al CheckBox
        checkBPagar.selectedProperty().addListener((observable, antValue, nueValue) -> {
            setElementosPago(!nueValue);
            setBotonAsignar();
            //System.out.println("Valor anterior: " + antValue);
            //System.out.println("Nuevo valor: " + nueValue);
        });

        txtFieldNombre.selectedTextProperty().addListener((observable, antValue, nueValue) -> {
                    setBotonAsignar();
//                    boolean txtFNombre = !txtFieldNombre.getText().trim().isEmpty();
//                    System.out.println(txtFNombre);
                }
            );


//        txtFieldCarnet.selectedTextProperty().addListener((observable, antValue, nueValue) ->
//            setBotonAsignar());
//
//        txtFieldTel.selectedTextProperty().addListener((observable, antValue, nueValue) ->
//            setBotonAsignar());
//
//        txtFieldDireccion.selectedTextProperty().addListener((observable, antValue, nueValue) ->
//            setBotonAsignar());
//
//        txtFieldCorreo.selectedTextProperty().addListener((observable, antValue, nueValue) ->
//            setBotonAsignar());

        listCursos.setPlaceholder(new Label("No hay informacion para mostrar"));
        listAsignados.setPlaceholder(new Label("No hay informacion para mostrar"));

        //        listaCursos.add("");
        // Agregar nombres de cursos a la lista
        listaCursos.add("Matemáticas");
        listaCursos.add("Física");
        listaCursos.add("Química");
        listaCursos.add("Biología");
        listaCursos.add("Programación");

        listCursos.setItems(listaCursos);
    }

}