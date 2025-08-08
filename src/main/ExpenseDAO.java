
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseDAO {
    private List<Expense> expenses;

    public ExpenseDAO(List<Expense> expenses) {
        this.expenses = expenses;
    }

    //Retourner uniquement les dépenses remboursables non remboursées.
    public List<RefundableExpense> getUnrefundedExpenses() {
        return expenses.stream()
                .filter(exp -> exp instanceof RefundableExpense)
                .map(exp -> (RefundableExpense) exp)
                .filter(exp -> !exp.isRefunded())
                .collect(Collectors.toList());
    }


    //Retourner le montant total de toutes les dépenses récurrentes.
    public double getTotalRecurringExpenses() {
        return expenses.stream()
                .filter(exp -> exp instanceof RecurringExpense)
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public List<String> getLargeExpenseLabels() {
        return expenses.stream()
                .filter(Expense::isLargeExpense)
                .map(Expense::getLabel)
                .collect(Collectors.toList());
    }

    //Retourner le montant total de toutes les dépenses (les remboursables, et les dépenses récurrentes, sans notion de durée ou de date).
    public double getTotalExpenses() {
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }
}