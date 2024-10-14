import javax.swing.*;

public class PizzaTopping extends JCheckBox implements OrderItem {
    private String name;
    private double cost;

    public PizzaTopping(String name, double cost) {
        super(name);
        this.name = name;
        this.cost = cost;
    }

    public PizzaTopping(String name) {
        super(name);
        this.name = name;
        this.cost = 1;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }
}
