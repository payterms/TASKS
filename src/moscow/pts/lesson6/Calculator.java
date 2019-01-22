package moscow.pts.lesson6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        super("Calculator");
        setSize(320, 480);
        setLocation(100, 100);
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        //pack();
    }
}

class CalculatorPanel extends JPanel {
    private JButton display;// экран для отображения результата
    private JPanel panel;   // панель с кнопками для ввода
    private double result;  // результат вычислений
    private String lastCommand; // последняя арифм.операция
    private boolean start; // признак начала ввода нового числа

    public CalculatorPanel() {
        setLayout(new BorderLayout());

        result = 0;
        lastCommand = "=";
        start = true;

        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 48);
        display = new JButton("0");
        display.setFont(BigFontTR);
        display.setBackground(Color.BLACK);
        display.setEnabled(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        //display.setAlignmentX(display.RIGHT_ALIGNMENT);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 0, 0));

        addButton("C", command);    // сброс результата
        addButton("+/-", command);  // поменять знак числа
        addButton("^", command);    // возведение в степень
        addButton("DEL", command);  // удаление последнего символа справа

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);
    }

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 20);
        button.setFont(BigFontTR);
        button.addActionListener(listener);
        panel.add(button);
    }

    private class InsertAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            /*if (start) {
                display.setText("0");
                start = false;
            }else {*/
            if (start) {
                display.setText("0");
                start = false;
            }
            if (display.getText().equals("0")) {
                display.setText("" + input);
            } else {
                display.setText(display.getText() + input);
            }

            //}
        }
    }

    private class CommandAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();

            switch (command) {
                case "C":// переводим в первоначальное состояние - чистим
                    lastCommand = "=";
                    result = 0;
                    display.setText("0");
                    break;
                case "+/-": {// меняем знак у текущего значения в редакторе
                    char c = display.getText().charAt(0);
                    if (c != '-')
                        display.setText("-" + display.getText());
                    else {
                        display.setText(display.getText().substring(1));
                    }
                }
                break;
                case "DEL": {// удаляем 1 символ значения справа
                    int len = display.getText().length();
                    char c = '0';
                    if (len > 0) {
                        c = display.getText().charAt(len - 1);// считываем предпоследний символ для анализа на -
                        if (c != '.')
                            display.setText(display.getText().substring(0, len - 1));
                        else {// если точка - удаляем 2 символа
                            display.setText(display.getText().substring(0, len - 2));
                        }
                        len = display.getText().length();// считаем новую длинну
                        if (len > 0) {
                            c = display.getText().charAt(len - 1);// получаем предпоследний сисмвол для анализа на -
                        }
                        if ((len == 0) || ((c == '-') && (len == 1))) {
                            display.setText("0");// чистим значение
                        }
                    } else {
                        display.setText("0");// чистим значение
                    }
                }
                break;
                default:
                    calculate(Double.parseDouble(display.getText()));
                    lastCommand = command;
                    start = true;
            }
        }
    }
    public void calculate(double x) {
        switch (lastCommand) {
            case "+":
                result += x;
                break;
            case "-":
                result -= x;
                break;
            case "*":
                result *= x;
                break;
            case "/":
                if (x != 0) {
                    result /= x;
                } else {
                    System.out.println("Деление на 0 запрещено!");
                }
                break;
            case "=":
                result = x;
                break;
            case "C":
                start = true;
                result = 0;
                break;
            case "+/-":
                result *= (-1);
                break;
            case "^":
                result = Math.pow(result, x);// возведение в степень
                break;
        }
        // TODO Отображение без лишних нулей
        display.setText("" + result);
    }
}

