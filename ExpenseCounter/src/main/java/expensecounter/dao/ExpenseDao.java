package expensecounter.dao;

import expensecounter.domain.Expense;
import java.util.List;

public interface ExpenseDao {

    Expense create(Expense expense) throws Exception;

    List<Expense> getAll();

}
