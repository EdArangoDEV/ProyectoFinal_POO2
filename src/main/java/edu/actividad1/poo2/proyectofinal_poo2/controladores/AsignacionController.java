package edu.actividad1.poo2.proyectofinal_poo2.controladores;

import edu.actividad1.poo2.proyectofinal_poo2.Application;
import edu.actividad1.poo2.proyectofinal_poo2.modelos.Cursos;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.event.ChangeEvent;
import java.util.ArrayList;
import java.util.Objects;

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

    public ObservableList listaAsignados = FXCollections.observableArrayList();
//    public ObservableList listaAsignados = this.app.listaAsignados;

    @FXML
    private ListView<?> listCursos;

//    ArrayList<String> listaCursos = new ArrayList<String>();
//    public ObservableList listaCursos = FXCollections.observableArrayList("Matematica I",
//        "Algoritmos I",
//        "Logica de programacion I",
//        "Ingles I",
//        "UML",
//        "Base de Datos I",
//        "POO I");
    public ObservableList listaCursos = Cursos.listaCursos;

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


    // referencia al archivo de aplicacion para comunicacion
    Application app;

    public void setMain(Application main){
        this.app = main;
    }

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
        listaAsignados.clear();
    }

    @FXML
    void clicRegresar(ActionEvent event) {
        app.principalStage.show();
        app.asignacionesStage.hide();
    }

    boolean datos = false;
    boolean pagar = false;
    boolean pago = false;
    String curso;


    private  void validarDatosEstudiante(){
        boolean txtFNombre = txtFieldNombre.getText().trim().isEmpty();
//        System.out.println(txtFNombre);
        boolean txtFCarnet = txtFieldCarnet.getText().trim().isEmpty();
        boolean txtFTel = txtFieldTel.getText().trim().isEmpty();
        boolean txtFDireccion = txtFieldDireccion.getText().trim().isEmpty();
        boolean txtFCorrero = txtFieldCorreo.getText().trim().isEmpty();
        boolean listaCursosAsig = listaCursos.isEmpty();

        pagar = (txtFNombre || txtFCarnet || txtFTel || txtFDireccion || txtFCorrero || listaCursosAsig) ? true : false;
        datos = !pagar;
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

        pago = (txtFTarjeta || txtFTitular || txtFExpiracion || txtFCVC) ? false : true;
        setBotonAsignar();
    }


    private void setBotonAsignar(){
        if (datos && !listaAsignados.isEmpty()) {
//            setBCancelar(false);
            if(!checkBPagar.isSelected()) {
                btnAsignar.setDisable(false);
            }
            else if (checkBPagar.isSelected() && pago) {
                btnAsignar.setDisable(false);
            }
            else {
                btnAsignar.setDisable(true);
            }
        }
        else {
            btnAsignar.setDisable(true);
            checkBPagar.setSelected(false);
            setCheckBPagar(true);
//            setBCancelar(true);
        }
    }

    private void setBCancelar(boolean valor){
        btnCancelar.setDisable(valor);
    }

    private void limpiarTextFields() {
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
        setBotonAsignar();
        setCheckBPagar(true);
//        setBCancelar(true);

        // Añadir listener al CheckBox
        checkBPagar.selectedProperty().addListener((observable, antValue, nueValue) -> {
            setElementosPago(!nueValue);
            validarDatosPago();
//            setBotonAsignar();
            //System.out.println("Valor anterior: " + antValue);
            //System.out.println("Nuevo valor: " + nueValue);
        });


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

        Label placehCursos = new Label("No hay Cursos para mostrar");
        placehCursos.setId(".placeholder-label");
        Label placehAsignaciones = new Label("No hay Cursos asignados");
        placehAsignaciones.setId(".placeholder-label");

        listCursos.setPlaceholder(placehCursos);
        listAsignados.setPlaceholder(placehAsignaciones);

        listCursos.setItems(listaCursos);



//        listCursos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){
//            @Override
//            public void changed(ObservableValue ov, Object oa, Object on) {
//                curso = (String) listCursos.getSelectionModel().getSelectedItem();
//                System.out.println("Curso seleccionado" + curso);
//                listaAsignados.add(curso);
//                listAsignados.setItems(listaAsignados);
//                curso = "";
//            }
//        });

//        listAsignados.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){
//            @Override
//            public void changed(ObservableValue ov, Object oa, Object on) {
//                curso = (String) listAsignados.getSelectionModel().getSelectedItem();
//                System.out.println("Curso seleccionado" + curso);
//                if(listaAsignados.size() == 1)
//                {
//                    listaAsignados.clear();
//                }
//                else {
//                    listaAsignados.remove(curso);
//                }
//                listAsignados.setItems(listaAsignados);
//
//                curso = "";
//            }
//        });

        listCursos.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.SINGLE);

        listCursos.setOnMouseClicked(event -> {
            curso = (String) listCursos.getSelectionModel().getSelectedItem();
            if(curso != null) {
                if (!listaAsignados.contains(curso)) {
                    System.out.println("Curso seleccionado: " + curso);
                    listaAsignados.add(curso);
                    listAsignados.setItems(listaAsignados);
                } else {
                    System.out.println("El curso ya está asignado: " + curso);
                }
                curso = "";
                listCursos.getSelectionModel().clearSelection();
                validarDatosEstudiante();
            }
        });

        listAsignados.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.SINGLE);

        listAsignados.setOnMouseClicked(event -> {
            curso = (String) listAsignados.getSelectionModel().getSelectedItem();
            if (curso != null){
                System.out.println("Curso seleccionado " + curso);
                if(listaAsignados.size() == 1)
                {
                    listaAsignados.clear();
                }
                else {
                    listaAsignados.remove(curso);
                }
                listAsignados.setItems(listaAsignados);

                curso = "";
                listAsignados.getSelectionModel().clearSelection();
                validarDatosEstudiante();
            }
        });



    }

}