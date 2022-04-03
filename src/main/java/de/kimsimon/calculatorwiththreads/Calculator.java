package de.kimsimon.calculatorwiththreads;
import de.kimsimon.calculatorwiththreads.calculator.Parser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Calculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Calculator.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load(), 150, 250);
        stage.setTitle("Calculator 'Thready'");
        stage.setScene(scene);
        stage.show();

        Parser formula = new Parser();
    }

    public static void main(String[] args) {
       launch();
    }

    public static int calculate(String formula){
        Parser thready = new Parser();
        return thready.calc(formula);
    }
}
