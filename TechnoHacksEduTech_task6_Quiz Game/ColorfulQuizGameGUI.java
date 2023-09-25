import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorfulQuizGameGUI extends JFrame {

    private JLabel questionLabel;
    private JRadioButton optionButton1;
    private JRadioButton optionButton2;
    private JRadioButton optionButton3;
    private JRadioButton optionButton4;
    private ButtonGroup optionGroup;
    private JButton nextButton;
    private JLabel resultLabel;

    private int currentQuestionIndex = 0;
    private int score = 0;

    private String[] questions = {
        "What is the capital of France?",
        "Which planet is known as the 'Red Planet'?",
        "What is 2 + 2?",
        "Who wrote 'Romeo and Juliet'?",
        "What is the largest mammal on Earth?",
        "Which gas do plants absorb from the atmosphere?",
        "Who painted the Mona Lisa?",
        "What is the currency of Japan?"
    };

    private String[][] options = {
        {"London", "Paris", "Berlin", "Madrid"},
        {"Mars", "Earth", "Venus", "Jupiter"},
        {"3", "5", "4", "2"},
        {"Jane Austen", "William Shakespeare", "Leo Tolstoy", "Charles Dickens"},
        {"Elephant", "Giraffe", "Blue Whale", "Hippopotamus"},
        {"Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"},
        {"Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Michelangelo"},
        {"Yen", "Won", "Dollar", "Euro"}
    };

    private int[] correctAnswers = {1, 0, 2, 1, 2, 2, 2, 0}; // Index of the correct answer for each question

    public ColorfulQuizGameGUI() {
        setTitle("Colorful Quiz Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 230, 255)); // Light Violet Background

        questionLabel = new JLabel("");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        questionLabel.setForeground(Color.BLUE);
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        optionsPanel.setBackground(new Color(255, 182, 193)); // Light Pink Background

        optionButton1 = createOptionButton();
        optionButton2 = createOptionButton();
        optionButton3 = createOptionButton();
        optionButton4 = createOptionButton();

        optionsPanel.add(optionButton1);
        optionsPanel.add(optionButton2);
        optionsPanel.add(optionButton3);
        optionsPanel.add(optionButton4);

        add(optionsPanel, BorderLayout.CENTER);

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setForeground(new Color(148, 0, 211)); // Violet Text Color
        add(resultLabel, BorderLayout.SOUTH);

        nextButton = new JButton("Next");
        nextButton.setBackground(new Color(255, 20, 147)); // Deep Pink Button Color
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });
        add(nextButton, BorderLayout.EAST);

        optionGroup = new ButtonGroup();
        optionGroup.add(optionButton1);
        optionGroup.add(optionButton2);
        optionGroup.add(optionButton3);
        optionGroup.add(optionButton4);

        showNextQuestion();
    }

    private JRadioButton createOptionButton() {
        JRadioButton button = new JRadioButton();
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(255, 240, 245)); // Lavender Blush Background
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Enable the Next button when an option is selected
                nextButton.setEnabled(true);
            }
        });
        return button;
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < questions.length) {
            questionLabel.setText(questions[currentQuestionIndex]);
            optionButton1.setText(options[currentQuestionIndex][0]);
            optionButton2.setText(options[currentQuestionIndex][1]);
            optionButton3.setText(options[currentQuestionIndex][2]);
            optionButton4.setText(options[currentQuestionIndex][3]);
            resultLabel.setText("");
            optionGroup.clearSelection(); // Clear the selected option
            nextButton.setEnabled(false); // Disable Next button until an option is selected
        } else {
            showFinalScore();
        }
    }

    private void checkAnswer() {
        int selectedAnswerIndex = -1;

        if (optionButton1.isSelected()) selectedAnswerIndex = 0;
        else if (optionButton2.isSelected()) selectedAnswerIndex = 1;
        else if (optionButton3.isSelected()) selectedAnswerIndex = 2;
        else if (optionButton4.isSelected()) selectedAnswerIndex = 3;

        if (selectedAnswerIndex == correctAnswers[currentQuestionIndex]) {
            score++;
            resultLabel.setText("Correct!");
        } else {
            resultLabel.setText("Wrong! The correct answer is: " + options[currentQuestionIndex][correctAnswers[currentQuestionIndex]]);
        }

        currentQuestionIndex++;
        showNextQuestion();
    }

    private void showFinalScore() {
        questionLabel.setText("Quiz Complete");
        optionButton1.setVisible(false);
        optionButton2.setVisible(false);
        optionButton3.setVisible(false);
        optionButton4.setVisible(false);
        nextButton.setVisible(false);
        resultLabel.setText("Final Score: " + score + "/" + questions.length);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ColorfulQuizGameGUI().setVisible(true);
            }
        });
    }
}
