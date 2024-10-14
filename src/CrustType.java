import javax.swing.*;

public class CrustType extends JRadioButton implements OrderItem {
    private String name;
    private double cost;

    public CrustType(String size, double cost) {
        super(size);
        this.name = size;
        this.cost = cost;
    }

    public CrustType(String size) {
        super(size);
        this.name = size;
        this.cost = 0;

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
