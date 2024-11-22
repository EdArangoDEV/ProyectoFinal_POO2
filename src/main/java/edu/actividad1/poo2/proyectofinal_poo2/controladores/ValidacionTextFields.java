package edu.actividad1.poo2.proyectofinal_poo2.controladores;

import javafx.scene.control.Alert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionTextFields {


    private String expresionReg(Integer opcion){
         String expresion = "";

        switch (opcion) {
            case 1:
                // expresion nombre

                break;
            case 2:
                // expresion carnet

                break;
            case 3:
                // expresion tel

                break;
            case 4:
                // Direccion
                break;
            case 5:
                // Correo
                expresion = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
                break;
            default:
                System.out.println("Opcion invalida!");
        }

        return  expresion;
    }


    public boolean validarString(String string, Integer opcion){
        boolean salida = true;

        String texto = "Correo electrónico inválido.";
        String regex = expresionReg(5); // Expresión regular para validar correos

        Pattern pattern = Pattern.compile(regex); // Compila el regex
        Matcher matcher = pattern.matcher(string); // Crea un matcher para el email

        if(!matcher.matches()){
            salida = false;
            System.out.println(texto);
            alertError(texto);
        }else {
            texto = "Correo electrónico válido.";
            System.out.println(texto);
        }

        return salida;
    }




    private void alertError(String texto) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(texto);
        // Cargar el archivo CSS
//        alert.getDialogPane().getStylesheets().add(getClass().getResource("edu.actividad1.poo2.proyectofinal_poo2.Estilos.css").toExternalForm());
        alert.showAndWait();
    }



}
