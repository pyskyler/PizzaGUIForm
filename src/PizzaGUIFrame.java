import javax.swing.*;

public class PizzaGUIFrame extends JFrame {
    public PizzaGUIFrame() {
        setTitle("Pizza Order");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel pizzaOrderPanel = CreatePizzaOrderPanel();
        add(pizzaOrderPanel);
        JPanel printReceiptPanel = CreatePrintReceiptPanel();
        add(printReceiptPanel);
        CreateExitButton();

    }

    private void CreateExitButton() {
    }

    private JPanel CreatePrintReceiptPanel() {
        JPanel printReceiptPanel = new JPanel();

        JTextArea receiptArea = new JTextArea(10, 30);
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


        return pizzaOrderPanel;



    }

    private JPanel createToppingPanel() {
        JPanel toppingPanel = new JPanel();
        toppingPanel.setBorder(BorderFactory.createTitledBorder("Toppings"));

        JCheckBox batWings = new JCheckBox("Bat Wings");
        JCheckBox hellhoundSausage = new JCheckBox("Hellhound Sausage");
        JCheckBox cursedCapers = new JCheckBox("Cursed Capers");
        JCheckBox impEars = new JCheckBox("Imp Ears");
        JCheckBox demonTail = new JCheckBox("Demon Tail");
        JCheckBox angelTears = new JCheckBox("Angel Tears");
        JCheckBox ghostPeppers = new JCheckBox("Ghost Peppers");

        toppingPanel.add(batWings);
        toppingPanel.add(hellhoundSausage);
        toppingPanel.add(cursedCapers);
        toppingPanel.add(impEars);
        toppingPanel.add(demonTail);
        toppingPanel.add(angelTears);
        toppingPanel.add(ghostPeppers);

        return toppingPanel;
    }

    private JPanel createSizePanel() {
        JPanel sizePanel = new JPanel();
        sizePanel.setBorder(BorderFactory.createTitledBorder("Size"));

        JComboBox<String> sizeBox = new JComboBox<>();
        sizeBox.addItem("Small - $8.00");
        sizeBox.addItem("Medium - $12.00");
        sizeBox.addItem("Large - $16.00");
        sizeBox.addItem("Super - $20.00");

        sizePanel.add(sizeBox);
        return sizePanel;
    }

    private JPanel createCrustPanel() {
        JPanel crustPanel = new JPanel();
        crustPanel.setBorder(BorderFactory.createTitledBorder("Crust"));

        ButtonGroup crustGroup = new ButtonGroup();

        JRadioButton thinCrust = new JRadioButton("Thin Crust");
        JRadioButton regularCrust = new JRadioButton("Regular Crust");
        JRadioButton deepDish = new JRadioButton("Deep Dish");

        crustGroup.add(thinCrust);
        crustGroup.add(regularCrust);
        crustGroup.add(deepDish);

        crustPanel.add(thinCrust);
        crustPanel.add(regularCrust);
        crustPanel.add(deepDish);

        return crustPanel;
    }
}
