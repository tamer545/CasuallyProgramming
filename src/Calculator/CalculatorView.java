package Calculator;

import javax.swing.*;
import java.awt.event.ActionListener;

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
    private JButton piButton;
    private CalculatorPresenter presenter;
    private ActionListener actionListener;


    public CalculatorView() {
        super("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(500, 300);
        setVisible(true);


        divisionButton.addActionListener(e -> {
            if (!inputTextField2.equals("π") && !inputTextField1.equals("π")) {
                presenter.division(Double.parseDouble(inputTextField1.getText()), Double.parseDouble(inputTextField2.getText()));
            } else if (inputTextField1.equals("π")) {
                presenter.division(3.14, Double.parseDouble(inputTextField2.getText()));
            } else if (inputTextField2.equals("π")) {
                presenter.division(Double.parseDouble(inputTextField1.getText()), 3.14);
            } else {
                presenter.division(3.14, 3.14);

            }
        });

        multiplicateButton.addActionListener(e -> {
            if (!inputTextField2.equals("π") && !inputTextField1.equals("π")) {
                presenter.multiplication(Double.parseDouble(inputTextField1.getText()), Double.parseDouble(inputTextField2.getText()));
            } else if (inputTextField1.equals("π")) {
                presenter.multiplication(3.14, Double.parseDouble(inputTextField2.getText()));
            } else if (inputTextField2.equals("π")) {
                presenter.multiplication(Double.parseDouble(inputTextField1.getText()), 3.14);
            } else {
                presenter.multiplication(3.14, 3.14);

            }
        });
        plusButton.addActionListener(e -> {
            if (!inputTextField2.equals("π") && !inputTextField1.equals("π")) {
                presenter.plus(Double.parseDouble(inputTextField1.getText()), Double.parseDouble(inputTextField2.getText()));
            } else if (inputTextField1.equals("π")) {
                presenter.plus(3.14, Double.parseDouble(inputTextField2.getText()));
            } else if (inputTextField2.equals("π")) {
                presenter.plus(Double.parseDouble(inputTextField1.getText()), 3.14);
            } else {
                presenter.plus(3.14, 3.14);

            }
        });
        minusButton.addActionListener(e -> {
            if (!inputTextField2.equals("π") && !inputTextField1.equals("π")) {
                presenter.minus(Double.parseDouble(inputTextField1.getText()), Double.parseDouble(inputTextField2.getText()));
            } else if (inputTextField1.equals("π")) {
                presenter.minus(3.14, Double.parseDouble(inputTextField2.getText()));
            } else if (inputTextField2.equals("π")) {
                presenter.minus(Double.parseDouble(inputTextField1.getText()), 3.14);
            } else {
                presenter.minus(3.14, 3.14);

            }
        });
        piButton.addActionListener(e -> {
            if (inputTextField1.isEnabled()) {
                inputTextField1.setText("π");
            }
            if (inputTextField2.isEnabled()) {
                inputTextField2.setText("π");
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

}
