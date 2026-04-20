import javax.swing.*;
import java.awt.*;

public class AnalyzerGUI extends JFrame {
    private JTextArea input = new JTextArea(20, 60);
    private JTextArea output = new JTextArea(20, 60);
    private JButton checkBtn = new JButton("Проверить код");
    private JButton gotoBtn = new JButton("Перейти к ошибке");
    private int lastErrPos = -1;

    public AnalyzerGUI() {
        setTitle("Анализатор+Семантика");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1000, 1000);
        input.setFont(new Font("TimesNewRoman", Font.PLAIN, 18));
        input.setTabSize(4);
        output.setEditable(false);

        checkBtn.addActionListener(e -> check());
        gotoBtn.addActionListener(e -> goError());
        gotoBtn.setEnabled(false);

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(checkBtn);
        topPanel.add(gotoBtn);

        add(new JScrollPane(input), BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(output), BorderLayout.SOUTH);
        setVisible(true);
    }

    private void check() {
        String code = input.getText();
        SemanticAnalizator.clear();

        Result r = Result.CheckFunctionDef.Check(code);
        lastErrPos = r.ErrPosition();

        String msg = "Позиция ошибки: " + lastErrPos + "\nСообщение: " + r.ErrMessage();
        if (lastErrPos < 0) {
            msg += "\n\n" + SemanticAnalizator.getTablesString();
        }

        output.setText(msg);
        gotoBtn.setEnabled(lastErrPos >= 0);
        if (lastErrPos >= 0) {
            goError();
        }
    }

    private void goError() {
        if (lastErrPos < 0) return;
        try {
            String text = input.getText();
            int line = 1, col = 1;
            for (int i = 0; i < lastErrPos && i < text.length(); i++) {
                if (text.charAt(i) == '\n') {
                    line++;
                    col = 1;
                } else {
                    col++;
                }
            }
            input.setCaretPosition(lastErrPos);
            input.moveCaretPosition(Math.min(lastErrPos + 1, text.length()));
            input.requestFocusInWindow();
            try {
                Rectangle rect = input.modelToView(lastErrPos);
                if (rect != null) input.scrollRectToVisible(rect);
            } catch (Exception ignored) {}
            output.append("\n Курсор перемещён к ошибочке (строка " + line + ", колонка " + col + ")");
        } catch (Exception ex) {
            output.append("\n Не удалось перейти к позиции");
        }
    }

    public static void main(String[] args) {
        new AnalyzerGUI();
    }
}