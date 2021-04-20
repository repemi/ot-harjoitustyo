/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetapp;

import budgetapp.domain.Expense;
import budgetapp.ui.ExpenseCounterTextUi;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
       

        ExpenseCounterTextUi eCounter = new ExpenseCounterTextUi(reader);
        eCounter.start();

    }

}
