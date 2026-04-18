import javax.swing.*;
import java.awt.*;

public class AnalyzerGUI extends JFrame {
    private JTextArea input = new JTextArea(15, 60);
    private JTextArea output = new JTextArea(5, 60);
    private JButton checkBtn = new JButton("Проверить");
    private JButton gotoBtn = new JButton("Перейти к ошибке");
    private int lastErrPos = -1;

    public AnalyzerGUI() {
        setTitle("Анализатор функций");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        input.setFont(new Font("Monospaced", Font.PLAIN, 14));
        input.setTabSize(4);
        output.setEditable(false);

        checkBtn.addActionListener(e -> check());
        gotoBtn.addActionListener(e -> gotoError());
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
        Result r = Result.CheckFunctionDef.Check(code);
        lastErrPos = r.ErrPosition();
        String msg = "Позиция ошибки: " + lastErrPos + "\nСообщение: " + r.ErrMessage();
        output.setText(msg);
        gotoBtn.setEnabled(lastErrPos >= 0);
        if (lastErrPos >= 0) {
            gotoError(); // автоматически перейти (опционально)
        }
    }

    private void gotoError() {
        if (lastErrPos < 0) return;
        try {
            // Определяем строку и колонку по позиции в тексте
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
            // Устанавливаем курсор и выделяем проблемный символ
            input.setCaretPosition(lastErrPos);
            input.moveCaretPosition(Math.min(lastErrPos + 1, text.length()));
            input.requestFocusInWindow();
            // Дополнительно прокручиваем к видимой позиции
            try {
                Rectangle rect = input.modelToView(lastErrPos);
                if (rect != null) input.scrollRectToVisible(rect);
            } catch (Exception ignored) {}
            output.append("\n→ Курсор перемещён к ошибке (строка " + line + ", колонка " + col + ")");
        } catch (Exception ex) {
            output.append("\nНе удалось перейти к позиции");
        }
    }

    public static void main(String[] args) {
        new AnalyzerGUI();
    }
}