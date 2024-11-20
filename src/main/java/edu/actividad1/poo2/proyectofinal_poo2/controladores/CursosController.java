package edu.actividad1.poo2.proyectofinal_poo2.controladores;

import edu.actividad1.poo2.proyectofinal_poo2.Application;
import edu.actividad1.poo2.proyectofinal_poo2.modelos.Asignacion;
import edu.actividad1.poo2.proyectofinal_poo2.modelos.Cursos;
import edu.actividad1.poo2.proyectofinal_poo2.modelos.PruebaAsignacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class CursosController {

    @FXML
    private AnchorPane PaneCursos;

    @FXML
    private Label lbSelecCursos;

    @FXML
    private Label lbCursos;

    @FXML
    private ComboBox<?> comboBCursos;

    @FXML
    private Label lbFechaAsignacion;

    @FXML
    private DatePicker datePAsignacion;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Label lbTablaAlumnos;

    @FXML
    private TableView<PruebaAsignacion> tablaAsignaciones;

    @FXML
    private TableColumn<?, ?> colCarnet;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colCorreo;

    @FXML
    private TableColumn<?, ?> colFechaInsc;

    @FXML
    private TableColumn<?, ?> colSolvencia;

    @FXML
    private Label lbGrafSolvencia;

    @FXML
    private PieChart graficoSolvencia;

    @FXML
    private Button btnRegresar;


    // referencia al archivo de aplicacion para comunicacion
    Application app;

    public void setMain(Application main){
        this.app = main;
    }

    ObservableList listaCursos = Cursos.listaCursos.listaCursos;
//    public ObservableList listaAsignaciones = FXCollections.observableArrayList();
    ObservableList<PruebaAsignacion> listaAsignaciones = app.listaAsignaciones;

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

    private void llenarTablaAsignados(String curso){
        if (!listaAsignaciones.isEmpty()) {
            ObservableList listaFiltrados = FXCollections.observableArrayList();

            for (PruebaAsignacion asignados : listaAsignaciones) {
                String cursoA = asignados.getCurso();
                if (cursoA.equals(curso) && cursoA != null)
                    listaFiltrados.add(asignados);

                if (!listaFiltrados.isEmpty())
                    tablaAsignaciones.setItems(listaFiltrados);
                else
                    tablaAsignaciones.setItems(null);
                    tablaAsignaciones.setPlaceholder(new Label("No hay Estudiantes asignados al curso: " + curso));
            }
        }
        else {
            tablaAsignaciones.setPlaceholder(new Label("No hay Estudiantes asignados al curso: " + curso));
        }
    }

    private void limpiarCampos(){
        comboBCursos.getSelectionModel().clearSelection();
        comboBCursos.setPlaceholder(new Label("Seleccione curso"));
        datePAsignacion.setValue(null);
        listaAsignaciones.clear();
        tablaAsignaciones.setItems(listaAsignaciones);
        tablaAsignaciones.setPlaceholder(new Label("No ha seleccionado ningun curso."));
    }

    public void initialize(){
        comboBCursos.setItems(listaCursos);

        colCarnet.setCellValueFactory(new PropertyValueFactory<>("carnet"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colFechaInsc.setCellValueFactory(new PropertyValueFactory<>("fechaAsignacion"));
        colSolvencia.setCellValueFactory(new PropertyValueFactory<>("solvencia"));
        tablaAsignaciones.setItems(listaAsignaciones);
        tablaAsignaciones.setPlaceholder(new Label("No ha seleccionado ningun curso."));

//        tablaAsignaciones.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.);

//        comboBCursos.setOnMouseClicked(event -> {
////            curso = (String) listCursos.getSelectionModel().getSelectedItem();
//            String cursoSeleccionado = (String) comboBCursos.getValue();
//            if (cursoSeleccionado != null) {
//                llenarTablaAsignados(cursoSeleccionado);
//            }
//        });


         //Añadir listener al ComboBox
        comboBCursos.setOnAction(event -> {
            String cursoSeleccionado = (String) comboBCursos.getValue();
            if (cursoSeleccionado != null) {
                llenarTablaAsignados(cursoSeleccionado);
            }
        });

        datePAsignacion.setOnAction(actionEvent -> {
            if(datePAsignacion.getValue() != null){
                // Definir el formato deseado
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                // Formatear la fecha
                String fechaFormateada = (String) datePAsignacion.getValue().format(formato);
                if (fechaFormateada != null)
                {
                    System.out.println(fechaFormateada);
                }
            }

        });

    }

}
