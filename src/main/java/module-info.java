module edu.actividad1.poo2.proyectofinal_poo2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.actividad1.poo2.proyectofinal_poo2 to javafx.fxml;
    exports edu.actividad1.poo2.proyectofinal_poo2;
}