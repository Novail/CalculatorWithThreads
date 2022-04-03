package de.kimsimon.calculatorwiththreads.calculator.nodes;

public class VaNode implements Node {
    private int x;
    public VaNode(int x) {
        this.x = x;
    }
    @Override
    public int getValue() {
        return x;
    }

}
