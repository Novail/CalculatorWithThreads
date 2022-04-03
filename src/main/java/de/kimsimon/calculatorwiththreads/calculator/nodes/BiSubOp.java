package de.kimsimon.calculatorwiththreads.calculator.nodes;

public class BiSubOp extends BiNode{
    public BiSubOp(Node node1, Node node2) {
        super(node1, node2);
    }

    @Override
    public int getValue() {
        Pair pair = BiValue();
        return pair.getX() - pair.getY();
    }
}
