package Calculator;

import javax.swing.*;
import java.awt.*;
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
    private int posX = 0;
    private int posY = 0;


    public CalculatorView() {
        setUndecorated(true);
        settingButtons();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(950, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        pointButton.setBorderPainted(false);
        pointButton.setContentAreaFilled(false);
        pointButton.setOpaque(true);


        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent evt) {
                //sets frame position when mouse dragged
                setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);

            }

            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });

        inputTextField1.requestFocus();

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
            appendNumber(".");

        });
        a0Button.addActionListener(e -> {
            appendNumber("0");
        });
        a1Button.addActionListener(e -> {
            appendNumber("1");
        });
        a2Button.addActionListener(e -> {
            appendNumber("2");
        });
        a3Button.addActionListener(e -> {
            appendNumber("3");
        });
        a4Button.addActionListener(e -> {
            appendNumber("4");
        });
        a5Button.addActionListener(e -> {
            appendNumber("5");
        });
        a6Button.addActionListener(e -> {
            appendNumber("6");
        });
        a7Button.addActionListener(e -> {
            appendNumber("7");
        });
        a8Button.addActionListener(e -> {
            appendNumber("8");

        });
        a9Button.addActionListener(e -> {
            appendNumber("9");
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
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
            }
            return false;
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

    public void clearAll() {
        inputTextField1.setText("");
        textField1String = "";
        inputTextField2.setText("");
        textField2String = "";
        totalLabel.setText("");
    }

    public void clearTotalField() {
        totalLabel.setText("");
    }

    private void appendNumber(String number) {
        clearTotalField();
        if (textField1isFocused) {
            textField1String += number;

        } else if (textField2isFocused) {
            textField2String += number;
        }
        inputTextField1.setText(textField1String);
        inputTextField2.setText(textField2String);
    }
    private void settingButtons(){

        Image clearButtonIcon = new ImageIcon("ClearButtonImage.png").getImage();
        Image pointButtonIcon = new ImageIcon("pointButtonImage.png").getImage();
        Image zeroButtonIcon = new ImageIcon("0ButtonImage.png").getImage();
        Image oneButtonIcon = new ImageIcon("1ButtonImage.png").getImage();
        Image twoButtonIcon = new ImageIcon("2ButtonImage.png").getImage();
        Image threeButtonIcon = new ImageIcon("3ButtonImage.png").getImage();
        Image fourButtonIcon = new ImageIcon("4ButtonImage.png").getImage();
        Image fiveButtonIcon = new ImageIcon("5ButtonImage.png").getImage();
        Image sixButtonIcon = new ImageIcon("6ButtonImage.png").getImage();
        Image sevenButtonIcon = new ImageIcon("7ButtonImage.png").getImage();
        Image eightButtonIcon = new ImageIcon("8ButtonImage.png").getImage();
        Image nineButtonIcon = new ImageIcon("9ButtonImage.png").getImage();
        Image divisionButtonIcon = new ImageIcon("divisionButtonImage.png").getImage();
        Image multiplicationButtonIcon = new ImageIcon("multiplicationButtonImage.png").getImage();
        Image subtractionButtonIcon = new ImageIcon("subtractionButtonImage.png").getImage();
        Image additionButtonIcon = new ImageIcon("additionButtonImage.png").getImage();
        Image moduloButtonIcon = new ImageIcon("moduloButtonImage.png").getImage();

        setButton(clearButton, clearButtonIcon);
        setButton(pointButton, pointButtonIcon);
        setButton(a0Button, zeroButtonIcon);
        setButton(a1Button, oneButtonIcon);
        setButton(a2Button, twoButtonIcon);
        setButton(a3Button, threeButtonIcon);
        setButton(a4Button, fourButtonIcon);
        setButton(a5Button, fiveButtonIcon);
        setButton(a6Button, sixButtonIcon);
        setButton(a7Button, sevenButtonIcon);
        setButton(a8Button, eightButtonIcon);
        setButton(a9Button, nineButtonIcon);
        setButton(divisionButton, divisionButtonIcon);
        setButton(multiplicateButton, multiplicationButtonIcon);
        setButton(minusButton, subtractionButtonIcon);
        setButton(plusButton, additionButtonIcon);
        setButton(moduloButton, moduloButtonIcon);

    }
    public void setButton(JButton button, Image icon){
        button.setIcon(new ImageIcon(icon));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);

    }

}
