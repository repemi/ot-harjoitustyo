/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetApp;

import budgetApp.ui.ExpenseCounter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        ExpenseCounter eCounter = new ExpenseCounter(reader);
        eCounter.start();

    }

}
