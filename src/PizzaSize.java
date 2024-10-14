public class PizzaSize implements OrderItem {
    private String name;
    private double cost;

    public PizzaSize(String size, double cost) {
        this.name = size;
        this.cost = cost;
    }

    public PizzaSize(String size) {
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

    @Override
    public String toString() {
        return "%s - $%.2f".formatted(name, cost);
    }
}
