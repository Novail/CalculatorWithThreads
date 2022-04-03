package de.kimsimon.calculatorwiththreads;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UiController {
    @FXML
    private TextField textBox;
    private String formula = "";

    //Buttons
    //##################################################################################################################
    @FXML
    protected void on0Click(){
        numCheck("0");
    }
    @FXML
    protected void on1Click(){
        numCheck("1");
    }
    @FXML
    protected void on2Click(){
        numCheck("2");
    }
    @FXML
    protected void on3Click(){
        numCheck("3");
    }
    @FXML
    protected void on4Click(){
        numCheck("4");
    }
    @FXML
    protected void on5Click(){
        numCheck("5");
    }
    @FXML
    protected void on6Click(){
        numCheck("6");
    }
    @FXML
    protected void on7Click(){
        numCheck("7");
    }
    @FXML
    protected void on8Click(){
        numCheck("8");
    }
    @FXML
    protected void on9Click(){
        numCheck("9");
    }

    @FXML
    protected void onAddClick(){
        binCheck("+");
    }
    @FXML
    protected void onSubClick(){
        binCheck("-");
    }
    @FXML
    protected void onMulClick(){
        binCheck("*");
    }
    @FXML
    protected void onDivClick(){
        binCheck("/");
    }

    @FXML
    protected void onOpenClick(){
        textBox.appendText("(");
    }
    @FXML
    protected void onCloseClick(){
        textBox.appendText(")");
    }
    @FXML
    protected void onExpClick() {
        textBox.appendText("p");
    }
    @FXML
    protected void onInvClick(){
        textBox.appendText("-");
    }
    @FXML
    protected void onDelClick(){
        if (!textBox.getCharacters().isEmpty()){
            textBox.setText( textBox.getText().substring(0, textBox.getText().length()-1));
        }
    }
    @FXML
    protected void onACClick(){
        textBox.clear();
    }
    @FXML
    public void onResultClick() {
        if (!textBox.getCharacters().isEmpty() && !isBinOp()){
            String result = "" + Calculator.calculate(textBox.getText());
            textBox.clear();
            textBox.appendText(result);
        }
    }

    //Help-Methods
    //##################################################################################################################
    private void binCheck(String s) {
        if (isBinOp()){
        } else if (!textBox.getCharacters().isEmpty()) {
            if (textBox.getCharacters().charAt(textBox.getLength()-1) >= '0' &&
                    textBox.getCharacters().charAt(textBox.getLength()-1) <= '9'){
                textBox.appendText(s);
            } else if (textBox.getCharacters().charAt(textBox.getLength()-1) <= ')'){
                textBox.appendText(s);
            }
        } else {
            textBox.appendText("");
        }
    }
    private boolean isBinOp() {
        return textBox.getCharacters().charAt(textBox.getLength() - 1) == '+' ||
                textBox.getCharacters().charAt(textBox.getLength() - 1) == '-' ||
                textBox.getCharacters().charAt(textBox.getLength() - 1) == '*' ||
                textBox.getCharacters().charAt(textBox.getLength() - 1) == '/' ||
                textBox.getCharacters().charAt(textBox.getLength() - 1) == '%';
    }
    private void numCheck(String s) {
        if (textBox.getCharacters().isEmpty()){
            textBox.appendText(s);
        } else if (textBox.getCharacters().charAt(textBox.getLength()-1) != ')') {
            textBox.appendText(s);
        }
    }
}
