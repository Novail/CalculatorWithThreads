module de.kimsimon.calculatorwiththreads {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.kimsimon.calculatorwiththreads to javafx.fxml;
    exports de.kimsimon.calculatorwiththreads;
}