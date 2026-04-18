import javax.swing.*;
import java.awt.*;

public class AnalyzerGUI extends JFrame {
    private JTextArea input = new JTextArea(15, 60);
    private JTextArea output = new JTextArea(5, 60);

    public AnalyzerGUI() {
        setTitle("Анализатор функций");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        input.setFont(new Font("Monospaced", Font.PLAIN, 14));
        output.setEditable(false);
        JButton btn = new JButton("Проверить");
        btn.addActionListener(e -> {
            Result r = Result.CheckFunctionDef.Check(input.getText());
            output.setText("Позиция: " + r.ErrPosition() + "\nОшибка: " + r.ErrMessage());
        });
        add(new JScrollPane(input), BorderLayout.CENTER);
        add(btn, BorderLayout.NORTH);
        add(new JScrollPane(output), BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AnalyzerGUI();
    }
}