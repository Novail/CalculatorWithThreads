package de.kimsimon.calculatorwiththreads.calculator.nodes;

public abstract class UnNode implements Node {
    Node node;

    UnNode(Node node) {
        this.node = node;
    }

}
