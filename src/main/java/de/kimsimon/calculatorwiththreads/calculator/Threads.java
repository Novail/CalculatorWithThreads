package de.kimsimon.calculatorwiththreads.calculator;


import de.kimsimon.calculatorwiththreads.calculator.nodes.Node;

public class Threads extends Thread{
    private Node node;
    private int result;

    public Threads(Node node) {
        this.node = node;
    }

    @Override
    public void run() {
        result = node.getValue();
    }

    public int getValue(){
        return result;
    }
}
