import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ColorfulRockPaperScissorsGame extends JFrame {

    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;
    private JLabel resultLabel;

    public ColorfulRockPaperScissorsGame() {
        setTitle("Rock, Paper, Scissors Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null); // Center the window on the screen
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 230, 255)); // Light Violet Background

        rockButton = createButton("Rock", Color.RED);
        paperButton = createButton("Paper", Color.GREEN);
        scissorsButton = createButton("Scissors", Color.BLUE);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10)); // Centered buttons with some spacing
        buttonPanel.setBackground(new Color(255, 182, 193)); // Light Pink Background
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);

        add(buttonPanel, BorderLayout.CENTER);

        resultLabel = new JLabel("Choose Rock, Paper, or Scissors");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setForeground(new Color(148, 0, 211)); // Violet Text Color
        resultLabel.setHorizontalAlignment(JLabel.CENTER);

        add(resultLabel, BorderLayout.SOUTH);
    }

    private JButton createButton(String label, Color buttonColor) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font
        button.setBackground(buttonColor);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(120, 50)); // Larger button size
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userChoice = label;
                String computerChoice = getRandomChoice();
                String result = determineWinner(userChoice, computerChoice);
                resultLabel.setText("You chose " + userChoice + ". Computer chose " + computerChoice + ". " + result);
            }
        });
        return button;
    }

    private String getRandomChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int index = random.nextInt(choices.length);
        return choices[index];
    }

    private String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                   (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                   (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ColorfulRockPaperScissorsGame().setVisible(true);
            }
        });
    }
}
