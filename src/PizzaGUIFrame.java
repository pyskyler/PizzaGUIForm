import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PizzaGUIFrame extends JFrame {

    private ArrayList<JRadioButton> crustsButtons = new ArrayList<>();
    private JComboBox<PizzaSize> sizeBox;
    private ArrayList<JCheckBox> toppingsCheckBoxes = new ArrayList<>();
    private JTextArea receiptArea;
    private ButtonGroup crustGroup;

    public PizzaGUIFrame() {
        setTitle("Pizza Order");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(1, 2));

        JPanel pizzaOrderPanel = CreatePizzaOrderPanel();
        add(pizzaOrderPanel);
        JPanel printReceiptPanel = CreatePrintReceiptPanel();
        add(printReceiptPanel);

    }

    private JPanel CreateButtonsPanel() {
        JPanel buttonsPanel = new JPanel();

        JButton orderButton = new JButton("Order");
        JButton clearButton = new JButton("Clear");
        JButton quitButton = new JButton("Quit");
        
        orderButton.addActionListener(e -> generateOrder());
        clearButton.addActionListener(e -> clearOrder());
        quitButton.addActionListener(e -> createExitDialogue());

        buttonsPanel.add(orderButton);
        buttonsPanel.add(clearButton);
        buttonsPanel.add(quitButton);

        return buttonsPanel;
    }

    private void createExitDialogue() {
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void generateOrder() {
        Receipt orderReceipt = new Receipt();
        OrderItem crust = null;
        OrderItem size;
        for (JRadioButton crustButton : crustsButtons) {
            if (crustButton.isSelected()) {
                crust = (OrderItem) crustButton;
            }
        }
        size = (OrderItem) sizeBox.getSelectedItem();
        try {
            OrderItem crustAndSize = new PizzaSize(crust.getName() + " " + size.getName(), crust.getCost() + size.getCost());
            orderReceipt.addItem(crustAndSize);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select a crust and size.");
        }

        for (JCheckBox topping : toppingsCheckBoxes) {
            if (topping.isSelected()) {
                orderReceipt.addItem((OrderItem) topping);
            }

        }

        receiptArea.setText(orderReceipt.getReceipt());
    }

    private void clearOrder() {
        for (JCheckBox topping : toppingsCheckBoxes) {
            topping.setSelected(false);
        }
        crustGroup.clearSelection();
        sizeBox.setSelectedIndex(0);
        receiptArea.setText("");
    }

    private JPanel CreatePrintReceiptPanel() {
        JPanel printReceiptPanel = new JPanel();

        receiptArea = new JTextArea(20, 40);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        receiptArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(receiptArea);

        printReceiptPanel.add(scrollPane);

        return printReceiptPanel;
    }

    private JPanel CreatePizzaOrderPanel() {
        JPanel pizzaOrderPanel = new JPanel();
        pizzaOrderPanel.setLayout(new BoxLayout(pizzaOrderPanel, BoxLayout.Y_AXIS));

        // Create a JPanel with a button group for the crust size
        JPanel crustPanel = createCrustPanel();
        pizzaOrderPanel.add(crustPanel);

        // Create a JPanel with a JComboBox for the size
        JPanel sizePanel = createSizePanel();
        pizzaOrderPanel.add(sizePanel);

        // Create a JPanel with a JCheckBox for each topping
        JPanel toppingPanel = createToppingPanel();
        pizzaOrderPanel.add(toppingPanel);

        JPanel buttonsPanel = CreateButtonsPanel();
        pizzaOrderPanel.add(buttonsPanel);

        return pizzaOrderPanel;
    }

    private JPanel createToppingPanel() {
        JPanel toppingPanel = new JPanel();
        toppingPanel.setBorder(BorderFactory.createTitledBorder("Toppings"));

        JCheckBox batWings = new PizzaTopping("Bat Wings");
        JCheckBox hellhoundSausage = new PizzaTopping("Hellhound Sausage");
        JCheckBox cursedCapers = new PizzaTopping("Cursed Capers");
        JCheckBox impEars = new PizzaTopping("Imp Ears");
        JCheckBox demonTail = new PizzaTopping("Demon Tail");
        JCheckBox angelTears = new PizzaTopping("Angel Tears");
        JCheckBox ghostPeppers = new PizzaTopping("Ghost Peppers");

        toppingPanel.add(batWings);
        toppingPanel.add(hellhoundSausage);
        toppingPanel.add(cursedCapers);
        toppingPanel.add(impEars);
        toppingPanel.add(demonTail);
        toppingPanel.add(angelTears);
        toppingPanel.add(ghostPeppers);

        toppingsCheckBoxes.add(batWings);
        toppingsCheckBoxes.add(hellhoundSausage);
        toppingsCheckBoxes.add(cursedCapers);
        toppingsCheckBoxes.add(impEars);
        toppingsCheckBoxes.add(demonTail);
        toppingsCheckBoxes.add(angelTears);
        toppingsCheckBoxes.add(ghostPeppers);

        return toppingPanel;
    }

    private JPanel createSizePanel() {
        JPanel sizePanel = new JPanel();
        sizePanel.setBorder(BorderFactory.createTitledBorder("Size"));

        sizeBox = new JComboBox<>();
        sizeBox.addItem(new PizzaSize("Small", 8.00));
        sizeBox.addItem(new PizzaSize("Medium", 12.00));
        sizeBox.addItem(new PizzaSize("Large", 16.00));
        sizeBox.addItem(new PizzaSize("Super", 20.00));

        sizePanel.add(sizeBox);
        return sizePanel;
    }

    private JPanel createCrustPanel() {
        JPanel crustPanel = new JPanel();
        crustPanel.setBorder(BorderFactory.createTitledBorder("Crust"));

        crustGroup = new ButtonGroup();

        JRadioButton thinCrust = new CrustType("Thin Crust");
        JRadioButton regularCrust = new CrustType("Regular Crust");
        JRadioButton deepDish = new CrustType("Deep Dish");

        crustGroup.add(thinCrust);
        crustGroup.add(regularCrust);
        crustGroup.add(deepDish);

        crustPanel.add(thinCrust);
        crustPanel.add(regularCrust);
        crustPanel.add(deepDish);

        crustsButtons.add(thinCrust);
        crustsButtons.add(regularCrust);
        crustsButtons.add(deepDish);

        return crustPanel;
    }
}
