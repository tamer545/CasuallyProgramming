package Calculator;

import javax.swing.*;
import java.awt.event.*;

public class CalculatorView extends JFrame {


    private JPanel mainPanel;
    private JButton divisionButton;
    private JButton plusButton;
    private JButton multiplicateButton;
    private JButton minusButton;
    private JTextField inputTextField1;
    private JTextField inputTextField2;
    private JLabel setSignLabel;
    private JLabel totalLabel;
    private JLabel errorLabel;
    private JButton a9Button;
    private JButton a8Button;
    private JButton a7Button;
    private JButton a6Button;
    private JButton a5Button;
    private JButton a4Button;
    private JButton a3Button;
    private JButton a2Button;
    private JButton a1Button;
    private JButton a0Button;
    private JButton pointButton;
    private JButton clearButton;
    private JButton moduloButton;
    private CalculatorPresenter presenter;

    private boolean textField1isFocused = false;
    private boolean textField2isFocused = false;
    private String textField1String = "";
    private String textField2String = "";


    public CalculatorView() {
        super("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(550, 350);
        setVisible(true);

        divisionButton.addActionListener(e -> {
            presenter.division(Double.parseDouble(inputTextField1.getText()), Double.parseDouble(inputTextField2.getText()));
        });

        multiplicateButton.addActionListener(e -> {
            presenter.multiplication(Double.parseDouble(inputTextField1.getText()), Double.parseDouble(inputTextField2.getText()));
        });
        plusButton.addActionListener(e -> {
            presenter.plus(Double.parseDouble(inputTextField1.getText()), Double.parseDouble(inputTextField2.getText()));
        });
        minusButton.addActionListener(e -> {
            presenter.minus(Double.parseDouble(inputTextField1.getText()), Double.parseDouble(inputTextField2.getText()));
        });
        moduloButton.addActionListener(e -> {
            presenter.modulo(Double.parseDouble(inputTextField1.getText()), Double.parseDouble(inputTextField2.getText()));
        });

        pointButton.addActionListener(e -> {
            clearTotalField();
            if (textField1isFocused) {
                textField1String += ".";

            } else {
                textField2String += ".";
            }
            inputTextField1.setText(textField1String);
            inputTextField2.setText(textField2String);
        });
        a0Button.addActionListener(e -> {
            clearTotalField();
            if (textField1isFocused) {
                textField1String += "0";

            } else {
                textField2String += "0";
            }
            inputTextField1.setText(textField1String);
            inputTextField2.setText(textField2String);
        });
        a1Button.addActionListener(e -> {
            clearTotalField();
            if (textField1isFocused) {
                textField1String += "1";

            } else {
                textField2String += "1";
            }
            inputTextField1.setText(textField1String);
            inputTextField2.setText(textField2String);
        });
        a2Button.addActionListener(e -> {
            clearTotalField();
            if (textField1isFocused) {
                textField1String += "2";

            } else {
                textField2String += "2";
            }
            inputTextField1.setText(textField1String);
            inputTextField2.setText(textField2String);
        });
        a3Button.addActionListener(e -> {
            clearTotalField();
            if (textField1isFocused) {
                textField1String += "3";

            } else {
                textField2String += "3";
            }
            inputTextField1.setText(textField1String);
            inputTextField2.setText(textField2String);
        });
        a4Button.addActionListener(e -> {
            clearTotalField();
            if (textField1isFocused) {
                textField1String += "4";

            } else {
                textField2String += "4";
            }
            inputTextField1.setText(textField1String);
            inputTextField2.setText(textField2String);
        });
        a5Button.addActionListener(e -> {
            clearTotalField();
            if (textField1isFocused) {
                textField1String += "5";

            } else {
                textField2String += "5";
            }
            inputTextField1.setText(textField1String);
            inputTextField2.setText(textField2String);
        });
        a6Button.addActionListener(e -> {
            clearTotalField();
            if (textField1isFocused) {
                textField1String += "6";

            } else {
                textField2String += "6";
            }
            inputTextField1.setText(textField1String);
            inputTextField2.setText(textField2String);
        });
        a7Button.addActionListener(e -> {
            clearTotalField();
            if (textField1isFocused) {
                textField1String += "7";

            } else {
                textField2String += "7";
            }
            inputTextField1.setText(textField1String);
            inputTextField2.setText(textField2String);
        });
        a8Button.addActionListener(e -> {
            clearTotalField();
            if (textField1isFocused) {
                textField1String += "8";

            } else {
                textField2String += "8";
            }
            inputTextField1.setText(textField1String);
            inputTextField2.setText(textField2String);
        });
        a9Button.addActionListener(e -> {
            clearTotalField();
            if (textField1isFocused) {
                textField1String += "9";

            } else {
                textField2String += "9";
            }
            inputTextField1.setText(textField1String);
            inputTextField2.setText(textField2String);
        });


        inputTextField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textField2isFocused = false;
                textField1isFocused = true;
            }
        });
        inputTextField2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textField1isFocused = false;
                textField2isFocused = true;
            }
        });
        clearButton.addActionListener(e -> {
            clearAll();
        });

        inputTextField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    inputTextField2.requestFocus();
                }
            }
        });
        inputTextField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    inputTextField1.requestFocus();
                }
            }
        });
    }


    public void setPresenter(CalculatorPresenter presenter) {
        this.presenter = presenter;
    }

    public void setSign(String text) {
        setSignLabel.setText(text);
    }

    public void setTotalLabel(double resultat) {
        totalLabel.setText(String.valueOf(resultat));
    }

    public void setErrorLabel(String text) {
        errorLabel.setText(text);
    }

    public void clearAll() {
        inputTextField1.setText("");
        inputTextField2.setText("");
        totalLabel.setText("");
    }

    public void clearTotalField() {
        totalLabel.setText("");
    }

}
