package de.kimsimon.calculatorwiththreads.calculator.nodes;


import de.kimsimon.calculatorwiththreads.calculator.Threads;

public abstract class BiNode implements Node {
    Node node1;
    Node node2;

    BiNode(Node node1, Node node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    Pair BiValue() {
        Threads calc1 = new Threads(node1);
        Threads calc2 = new Threads(node2);
        calc1.start();
        calc2.start();
        try {
            calc1.join();
            calc2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Pair(calc1.getValue(), calc2.getValue());
    }
}
