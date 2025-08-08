import java.time.LocalDate;

public class RecurringExpense extends Expense {
    private String recurrence;

    public RecurringExpense(String label, double amount, LocalDate date, String recurrence) {
        super(label, amount, date);
        if (!recurrence.equals("monthly") && !recurrence.equals("yearly")) {
            System.out.println("Doit seulement etre 'monthly' ou yearly");
        }
        this.recurrence = recurrence;
    }

    public String getRecurrence() {
        return recurrence;
    }

    @Override
    public String toString() {
        return super.toString() + " (recurring: " + recurrence + ")";
    }
}