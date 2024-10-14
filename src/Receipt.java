import java.util.ArrayList;

public class Receipt {
    double subtotalCost = 0;
    double TAX_RATE = 0.07;
    double totalCost = 0;
    ArrayList<OrderItem> items = new ArrayList<OrderItem>();
    String receipt = "";

    public Receipt() {

    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public String getReceipt() {
        receipt = "=======================================\n";
        for (OrderItem item : items) {
            receipt += "%-30s$%.2f\n".formatted(item.getName(), item.getCost());
            subtotalCost += item.getCost();
        }
        receipt += "\n";
        receipt += "%-30s$%.2f\n".formatted("Subtotal:", subtotalCost);
        receipt += "%-30s$%.2f\n".formatted("Tax:", subtotalCost * TAX_RATE);
        totalCost = subtotalCost + (subtotalCost * TAX_RATE);
        receipt += "---------------------------------------\n";
        receipt += "%-30s$%.2f\n".formatted("Total:", totalCost);
        receipt += "=======================================\n";
        return receipt;
    }

}
