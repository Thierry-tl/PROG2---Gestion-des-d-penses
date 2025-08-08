import java.time.LocalDate;

public class Expense {
    private String label;
    private double amount;
    private LocalDate date;

    public Expense(String label, double amount, LocalDate date) {
        this.label = label;
        this.amount = amount;
        this.date = date;
    }

    public String getLabel() {
        return label;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }


    //Ajoute du methode IsrLargeExpense
    public boolean isLargeExpense() {
        return amount > 100.0;
    }

    //ffichage du depense
    @Override
    public String toString() {
        return "Expense: label= " + label + ", amount= " + amount + ", date= " + date;
    }
}