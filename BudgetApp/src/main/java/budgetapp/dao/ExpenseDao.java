/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetapp.dao;

import budgetapp.domain.Expense;
import java.util.List;

/**
 *
 * @author erepo
 */
public interface ExpenseDao {

    Expense create(Expense expense);

    List<Expense> getAll();
}
