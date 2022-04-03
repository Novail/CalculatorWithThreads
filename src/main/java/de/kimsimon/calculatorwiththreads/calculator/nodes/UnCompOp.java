package de.kimsimon.calculatorwiththreads.calculator.nodes;

public class UnCompOp extends UnNode{
    public UnCompOp(Node node) {
        super(node);
    }

    @Override
    public int getValue() {
        return node.getValue() * -1;
    }
}
