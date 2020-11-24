package Calculator;

public class CalculatorPresenter {

    private CalculatorView view;
    private double total = 0;


    public CalculatorPresenter(CalculatorView view){
        this.view = view;
        this.view.setPresenter(this);

    }
    public void division(double number1, double number2){
        view.setSign("/");
        total = number1 / number2;
        setTotal();

    }
    public void multiplication(double number1, double number2){
        view.setSign("*");
        total = number1 * number2;
        setTotal();
    }
    public void plus(double number1, double number2){
        view.setSign("+");
        total = number1 + number2;
        setTotal();
    }
    public void minus(double number1, double number2){
        view.setSign("-");
        total = number1 - number2;
        setTotal();
    }
    public void setTotal(){
        view.setTotalLabel(total);
    }
}