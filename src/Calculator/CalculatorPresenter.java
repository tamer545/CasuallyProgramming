package Calculator;

public class CalculatorPresenter {

    private CalculatorView view;

    public CalculatorPresenter(CalculatorView view) {
        this.view = view;
        this.view.setPresenter(this);

    }

    public void division(double number1, double number2) {
        view.setSign("/");
        view.setTotalLabel(number1 / number2);


    }

    public void multiplication(double number1, double number2) {
        view.setSign("*");
        view.setTotalLabel(number1 * number2);

    }

    public void plus(double number1, double number2) {
        view.setSign("+");
        view.setTotalLabel(number1 + number2);

    }

    public void minus(double number1, double number2) {
        view.setSign("-");
        view.setTotalLabel(number1 - number2);

    }

    public void modulo(double number1, double number2) {
        view.setSign("%");
        view.setTotalLabel(number1 % number2);
    }

}
