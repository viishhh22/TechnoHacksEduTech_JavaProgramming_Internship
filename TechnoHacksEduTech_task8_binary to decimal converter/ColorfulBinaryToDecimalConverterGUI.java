import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorfulBinaryToDecimalConverterGUI extends JFrame {

    private JTextField binaryTextField;
    private JLabel resultLabel;

    public ColorfulBinaryToDecimalConverterGUI() {
        // Set up the JFrame
        setTitle("Colorful Binary to Decimal Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        getContentPane().setBackground(new Color(255, 230, 230)); // Set background color

        // Create components with custom styles
        JLabel binaryInputLabel = new JLabel("Enter Binary Number:");
        binaryInputLabel.setFont(new Font("Arial", Font.BOLD, 16));
        binaryInputLabel.setForeground(Color.BLUE); // Text color
        binaryTextField = new JTextField(20);
        binaryTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton convertButton = new JButton("Convert");
        convertButton.setBackground(Color.GREEN); // Button background color
        convertButton.setForeground(Color.WHITE); // Button text color
        resultLabel = new JLabel("Decimal Result:");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setForeground(Color.RED); // Text color

        // Add components to the JFrame
        add(binaryInputLabel);
        add(binaryTextField);
        add(convertButton);
        add(resultLabel);

        // Add an ActionListener to the Convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String binaryInput = binaryTextField.getText();
                try {
                    // Convert binary to decimal
                    int decimalResult = Integer.parseInt(binaryInput, 2);
                    resultLabel.setText("Decimal Result: " + decimalResult);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid Binary Input");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ColorfulBinaryToDecimalConverterGUI().setVisible(true);
            }
        });
    }
}
