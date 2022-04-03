package de.kimsimon.calculatorwiththreads.calculator.nodes;


public class UnPowOp extends UnNode{

    public UnPowOp (Node node) {
        super(node);
    }

    @Override
    public int getValue() {
        return (int) Math.pow(node.getValue(), 2);
    }
}
