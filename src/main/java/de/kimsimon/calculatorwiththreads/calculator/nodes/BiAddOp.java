package de.kimsimon.calculatorwiththreads.calculator.nodes;


public class BiAddOp extends BiNode{
    public BiAddOp(Node node1, Node node2) {
        super(node1, node2);
    }

    @Override
    public int getValue() {
        Pair pair = BiValue();
        return pair.getX() + pair.getY();
    }
}
