package edu.actividad1.poo2.proyectofinal_poo2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class Application extends javafx.application.Application {

    Stage principalStage;
    Stage cursosStage;
    Stage asignacionesStage;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("principal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 280);

        stage = new Stage();
        this.principalStage = stage;
        stage.setTitle("Inicio");
        stage.setScene(scene);

        ApplicationController appC = fxmlLoader.getController();
        appC.setMain(this);

        stage.show();
    }

    public void cargarCursos() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("cursos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 520);

        CursosController cursosC = fxmlLoader.getController();
        cursosC.setMain(this);

        Stage cursosStage = new Stage();
        this.cursosStage = cursosStage;
        cursosStage.setTitle("Cursos");
        cursosStage.setScene(scene);
        cursosStage.show();
        principalStage.hide();

        cursosStage.setOnCloseRequest(e -> principalStage.show());
    }

    public void cargarAsignaciones() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("asignaciones-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 925, 550);

        AsignacionController asignacionesC = fxmlLoader.getController();
        asignacionesC.setMain(this);

        Stage asignacionesStage = new Stage();
        this.asignacionesStage = asignacionesStage;
        asignacionesStage.setTitle("Asignaciones");
        asignacionesStage.setScene(scene);
        asignacionesStage.show();
        principalStage.hide();

        asignacionesStage.setOnCloseRequest(e -> principalStage.show());
    }


    public static void main(String[] args) {
        launch();
    }
}


