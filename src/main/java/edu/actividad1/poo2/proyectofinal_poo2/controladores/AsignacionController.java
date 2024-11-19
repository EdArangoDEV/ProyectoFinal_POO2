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
        if(datos && !btnAsignar.isDisable())
        {
            System.out.println("Se asigno correctamente");
            limpiarTextFields();
        }
        else{
            System.out.println("Debe llenar todos los campos");
        }
    }

    @FXML
    void clicCancelar(ActionEvent event) {
        limpiarTextFields();
        validarDatosEstudiante();
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

    boolean datos = false;
    boolean pagar = false;
    boolean pago = false;


    private  void validarDatosEstudiante(){
        boolean txtFNombre = txtFieldNombre.getText().trim().isEmpty();
//        System.out.println(txtFNombre);
        boolean txtFCarnet = txtFieldCarnet.getText().trim().isEmpty();
        boolean txtFTel = txtFieldTel.getText().trim().isEmpty();
        boolean txtFDireccion = txtFieldDireccion.getText().trim().isEmpty();
        boolean txtFCorrero = txtFieldCorreo.getText().trim().isEmpty();


        if(txtFNombre || txtFCarnet || txtFTel || txtFDireccion || txtFCorrero){
            pagar = true;
            datos = false;
        }
        else
        {
            pagar = false;
            datos = true;
        }
            setCheckBPagar(pagar);
            setBotonAsignar();
    }

    private void setCheckBPagar(boolean valor){
        checkBPagar.setDisable(valor);
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


    private  void validarDatosPago(){
        boolean txtFTarjeta = txtFielNTarjeta.getText().trim().isEmpty();
//        System.out.println(txtFNombre);
        boolean txtFTitular = txtFieldTitular.getText().trim().isEmpty();
        boolean txtFExpiracion = txtFieldExpiracionT.getText().trim().isEmpty();
        boolean txtFCVC = txtFieldCVC.getText().trim().isEmpty();


        if(txtFTarjeta || txtFTitular || txtFExpiracion || txtFCVC){
            pago = false;
        }
        else
        {
            pago = true;
        }
        setBotonAsignar();
    }

    public void setBotonAsignar(){
        if (datos)
        {
            if(!checkBPagar.isSelected()) {
                btnAsignar.setDisable(false);
            }
            else if (checkBPagar.isSelected() && pago){
                btnAsignar.setDisable(false);
            }
            else {
                btnAsignar.setDisable(true);
            }
        }
        else{
            btnAsignar.setDisable(true);
            checkBPagar.setSelected(false);
        }


    }

    public  void limpiarTextFields(){
        txtFieldNombre.setText("");
        txtFieldCarnet.setText("");
        txtFieldDireccion.setText("");
        txtFieldTel.setText("");
        txtFieldCorreo.setText("");
        txtFielNTarjeta.setText("");
        txtFieldTitular.setText("");
        txtFieldExpiracionT.setText("");
        txtFieldCVC.setText("");
    }

    public void initialize(){
        // Deshabilitar boton Asingar
        btnAsignar.setDisable(true);
        setCheckBPagar(true);


        // Añadir listener al CheckBox
        checkBPagar.selectedProperty().addListener((observable, antValue, nueValue) -> {
            setElementosPago(!nueValue);
            validarDatosPago();
//            setBotonAsignar();
            //System.out.println("Valor anterior: " + antValue);
            //System.out.println("Nuevo valor: " + nueValue);
        });

//        btnAsignar.sceneProperty().addListener((observable, antValue, nueValue) -> {
//            setBotonAsignar();
//        });


        txtFieldNombre.focusedProperty().addListener((observable, antValue, nueValue) -> {
                    validarDatosEstudiante();
//                    boolean txtFNombre = !txtFieldNombre.getText().trim().isEmpty();
//                    System.out.println(txtFNombre);
                }
            );


        txtFieldCarnet.focusedProperty().addListener((observable, antValue, nueValue) ->
                validarDatosEstudiante());

        txtFieldTel.focusedProperty().addListener((observable, antValue, nueValue) ->
                validarDatosEstudiante());

        txtFieldDireccion.focusedProperty().addListener((observable, antValue, nueValue) ->
                validarDatosEstudiante());

        txtFieldCorreo.focusedProperty().addListener((observable, antValue, nueValue) ->
                validarDatosEstudiante());

        txtFielNTarjeta.focusedProperty().addListener((observable, antValue, nueValue) ->
                validarDatosPago());

        txtFieldTitular.focusedProperty().addListener((observable, antValue, nueValue) ->
                validarDatosPago());

        txtFieldExpiracionT.focusedProperty().addListener((observable, antValue, nueValue) ->
                validarDatosPago());

        txtFieldCVC.focusedProperty().addListener((observable, antValue, nueValue) ->
                validarDatosPago());

        listCursos.setPlaceholder(new Label("No hay informacion para mostrar"));
        listAsignados.setPlaceholder(new Label("No hay informacion para mostrar"));

        //        listaCursos.add("");
        // Agregar nombres de cursos a la lista
        listaCursos.add("Matematica I");
        listaCursos.add("Algoritmos I");
        listaCursos.add("Logica de programacion I");
        listaCursos.add("Ingles I");
        listaCursos.add("UML");
        listaCursos.add("Base de Datos I");
        listaCursos.add("POO I");


        listCursos.setItems(listaCursos);

        setBotonAsignar();
    }

}