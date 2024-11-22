package edu.actividad1.poo2.proyectofinal_poo2.controladores;

import edu.actividad1.poo2.proyectofinal_poo2.Application;
import edu.actividad1.poo2.proyectofinal_poo2.modelos.Cursos;
import edu.actividad1.poo2.proyectofinal_poo2.modelos.PruebaAsignacion;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.time.LocalDate;


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
    private ListView<?> listCursos;

    public ObservableList listaCursos = Cursos.listaCursos.listaCursos;

    @FXML
    private ListView<String> listAsignados;

    public ObservableList<String> listaAsignados = FXCollections.observableArrayList();
//    public ObservableList listaAsignados = this.app.listaAsignados;

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

    ValidacionTextFields vtxtF = new ValidacionTextFields();

    @FXML
    void clicAsignar(ActionEvent event) {
        if(datos && !btnAsignar.isDisable())
        {
            String txtpago = "No realizo pago";
            String fechaAsignacion = app.formatearFecha(LocalDate.now());
            String solvecnia = "no";
            if(pago)
            {
                txtpago = "Realizo el pago";
                System.out.println("Se asgino el estudiante: " + txtFieldNombre.getText() + " el dia " + fechaAsignacion + " y " + txtpago);
                solvecnia = "si";
            }
            else {
                System.out.println("Se asgino el estudiante: " + txtFieldNombre.getText() + " el dia " + fechaAsignacion + " y " + txtpago);
            }
            asignacionEstudiante(solvecnia);
            limpiarDatos();
        }
        else{
            System.out.println("Debe llenar todos los campos");
        }
    }


    @FXML
    void clicCancelar(ActionEvent event) {
        limpiarDatos();
        validarDatosEstudiante();
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

    private void validarCamposEstudiante(Integer opcion){
        boolean valido = false;

        switch (opcion) {
            case 1:
                // Código a ejecutar si expresión == valor1
                break;
            case 2:
                // Código a ejecutar si expresión == valor2
                break;
            case 3:
                // Código a ejecutar si expresión == valor1
                break;
            case 4:
                // Código a ejecutar si expresión == valor2
                break;
            case 5:
                valido = vtxtF.validarString(txtFieldCorreo.getText(), 5);
                if(valido){
                    validarDatosEstudiante();
                }
                break;
            default:
                System.out.println("Opcion invalida!");
        }

    }


    private  void validarDatosEstudiante(){

        boolean txtFNombre = txtFieldNombre.getText() == null;
//        System.out.println(txtFNombre);
        boolean txtFCarnet = txtFieldCarnet.getText() == null;
        boolean txtFTel = txtFieldTel.getText() == null;
        boolean txtFDireccion = txtFieldDireccion.getText() == null;
        boolean txtFCorrero = txtFieldCorreo.getText() == null;
        boolean listaCursosAsig = listaCursos.isEmpty();


        pagar = (txtFNombre || txtFCarnet || txtFTel || txtFDireccion || txtFCorrero || listaCursosAsig) ? true : false;
        datos = !pagar;
        setCheckBPagar(pagar);
        setBotonAsignar();
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

    private void setCheckBPagar(boolean valor){
        checkBPagar.setDisable(valor);
    }


    public void asignacionEstudiante(String solvencia){

        for (String curso : listaAsignados)
        {
            PruebaAsignacion pAsignacion = new PruebaAsignacion();
            pAsignacion.setCarnet(txtFieldCarnet.getText());
            pAsignacion.setNombre(txtFieldNombre.getText());
            pAsignacion.setCorreo(txtFieldCorreo.getText());
            pAsignacion.setFechaAsignacion(app.formatearFecha(LocalDate.now()));
            pAsignacion.setSolvencia(solvencia);
            pAsignacion.setCurso(curso);
            app.listaAsignaciones.add(pAsignacion);
        }
        System.out.println(app.listaAsignaciones.toArray());
    }


    private void setBCancelar(boolean valor){
        btnCancelar.setDisable(valor);
    }

    private void limpiarDatos() {
        txtFieldNombre.setText(null);
        txtFieldCarnet.setText(null);
        txtFieldDireccion.setText(null);
        txtFieldTel.setText(null);
        txtFieldCorreo.setText(null);
        txtFielNTarjeta.setText(null);
        txtFieldTitular.setText(null);
        txtFieldExpiracionT.setText(null);
        txtFieldCVC.setText(null);
        listaAsignados.clear();
    }



    public void initialize(){

        limpiarDatos();

        // Deshabilitar boton Asingar
        setBotonAsignar();
        setCheckBPagar(true);
//        setBCancelar(true);

        // Añadir listener al CheckBox
        checkBPagar.selectedProperty().addListener((observable, antValue, nueValue) -> {
            setElementosPago(!nueValue);
            validarDatosPago();
            //System.out.println("Valor anterior: " + antValue);
            //System.out.println("Nuevo valor: " + nueValue);
        });


        txtFieldNombre.focusedProperty().addListener((observable, antValue, nueValue) -> {
//            validarDatosEstudiante();
//            boolean txtFNombre = !txtFieldNombre.getText().trim().isEmpty();
//            System.out.println(txtFNombre);
            validarCamposEstudiante(1);
            });


        txtFieldCarnet.focusedProperty().addListener((observable, antValue, nueValue) ->
//                validarDatosEstudiante()
            validarCamposEstudiante(2)
        );

        txtFieldTel.focusedProperty().addListener((observable, antValue, nueValue) ->
//                validarDatosEstudiante();
                validarCamposEstudiante(3)
        );

        txtFieldDireccion.focusedProperty().addListener((observable, antValue, nueValue) ->
//                validarDatosEstudiante();
                validarCamposEstudiante(4)
        );

        txtFieldCorreo.focusedProperty().addListener((observable, antValue, nueValue) ->
                {
                    if(txtFieldCorreo.getText() != null && !nueValue){
                        if(!txtFieldCorreo.getText().equals("")){
//                            validarDatosEstudiante();
                            validarCamposEstudiante(5);
                        }
                        else {
                            txtFieldCorreo.setText(null);
                            validarDatosEstudiante();
                        }
                    }
                }
        );

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
        Label placehAsignaciones = new Label("No hay Cursos Seleccionados");
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
//                    System.out.println("Curso seleccionado: " + curso);
                    listaAsignados.add(curso);
                    listAsignados.setItems(listaAsignados);
                } else {
//                    System.out.println("El curso ya está asignado: " + curso);
                }
                curso = null;
                listCursos.getSelectionModel().clearSelection();
                validarDatosEstudiante();
            }
        });

        listAsignados.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.SINGLE);

        listAsignados.setOnMouseClicked(event -> {
            curso = (String) listAsignados.getSelectionModel().getSelectedItem();
            if (curso != null){
//                System.out.println("Curso seleccionado " + curso);
                if(listaAsignados.size() == 1)
                {
                    listaAsignados.clear();
                }
                else {
                    listaAsignados.remove(curso);
                }
                listAsignados.setItems(listaAsignados);

                curso = null;
                listAsignados.getSelectionModel().clearSelection();
                validarDatosEstudiante();
            }
        });

    }

}