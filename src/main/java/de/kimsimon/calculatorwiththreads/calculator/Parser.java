package de.kimsimon.calculatorwiththreads.calculator;

import de.kimsimon.calculatorwiththreads.calculator.nodes.*;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    //private String x = new String("p2+3*2");
    private boolean expectOperand = true;

    //Node node = new BiAddOp(
    //new BiDivOp(new VaNode(4), new UnPowOp(new VaNode(2))),
    //new BiMulOp(new UnCompOp(new VaNode(4)), new VaNode(5)));

    List<Node> formula = new ArrayList<>();
    List<String> opStack = new ArrayList<>();

    public int calc (String x) {
        List<String> temp = token(x);
        for (String s : temp) {
            if (s.equals("+") | s.equals("*") | s.equals("/") | s.equals("%")) {
                expectOperand = true;
                pop(getPrio(s), true);
                opStack.add(s);
            } else if (s.equals("-")) {
                if (expectOperand) { //Inverted Minus
                    opStack.add("I");
                } else {
                    expectOperand = true;
                    pop(getPrio(s), true);
                    opStack.add(s);
                }
            } else if (s.equals("p")) {
                    expectOperand = true;
                    opStack.add(s);
            }
            else if (s.equals("(")) {
                expectOperand = true;
                opStack.add(s);
            } else if (s.equals(")")) {
                expectOperand = false;
                pop(getPrio(s), false);
                opStack.remove(opStack.size() - 1);
            } else {
                expectOperand = false;
                formula.add(new VaNode(Integer.parseInt(s)));
            }
        }
        pop(-3, false);
        return formula.get(0).getValue();
    }

    public void pop (int prio, boolean leftAlig) {
        int lastPrio;
        while (!opStack.isEmpty()){
            lastPrio = getPrio(opStack.get(opStack.size()-1));
            if (leftAlig) {
                if (lastPrio < prio) {
                    break;
                }
            }
            else {
                if (lastPrio <= prio) {
                    break;
                }
            }
            String op = opStack.remove(opStack.size()-1);
            Node right = formula.remove(formula.size()-1);
            if (op.equals("I")){
                formula.add(new UnCompOp(right));
                continue;
            }
            if (op.equals("p")){
                formula.add(new UnPowOp(right));
                continue;
            }
            Node left = formula.remove(formula.size()-1);
            switch (op) {
                case "+" -> formula.add(new BiAddOp(left, right));
                case "-" -> formula.add(new BiSubOp(left, right));
                case "*" -> formula.add(new BiMulOp(left, right));
                case "/" -> formula.add(new BiDivOp(left, right));
                default -> {
                }
            }
        }
    }

    public int getPrio (String op) {
        if (op.equals("+") || op.equals("-")){
            return 0;
        }
        if (op.equals("*") || op.equals("/") || op.equals("%")){
            return 1;
        }
        if (op.equals("I") || op.equals("p")){
            return 2;
        }
        if (op.equals("(") || op.equals(")")){
            return -1;
        }
        return -2;
    }

    public List<String> token (String input){
        String temp = "";
        List<String> ret = new ArrayList<>();
        for (char c : input.toCharArray()){
            if (c >= '0' && c <= '9'){
                temp += c;
            } else if (c == ' '){
                if (!temp.isEmpty()) {
                    ret.add(temp);
                    temp = "";
                }
            } else if (c == 'p' || c == '+' || c == '-' || c == '*' || c == '/' || c == '%'){
                if (!temp.isEmpty()) {
                    ret.add(temp);
                    temp = "";
                }
                ret.add("" + c);
            }
        }
        if (!temp.isEmpty()) {
            ret.add(temp);
            temp = "";
        }
        return ret;
    }

    /*
    public static void main(String[] args) {
        Parser test = new Parser();
        System.out.println(test.calc());
    }
    */

}
