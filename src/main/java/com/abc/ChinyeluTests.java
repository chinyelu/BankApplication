package com.abc;

import java.util.Scanner;

public class ChinyeluTests {

	public static void main(String[] Args) {

		Account Savings = new Account(Account.SAVINGS);
		Account Checkings = new Account(Account.CHECKING);

		Customer Chinyelu = new Customer("Chinyelu");
		Chinyelu.openAccount(Savings);
		Chinyelu.openAccount(Checkings);

		Savings.deposit(5000);
		Savings.withdraw(20);
		Checkings.withdraw(2000);
		Checkings.deposit(301);

		System.out.println(Chinyelu.getStatement());

		System.out.println("===============================");
		Chinyelu.transfer(2050, Savings, Checkings);
		System.out.println("===============================");

		Scanner scan = new Scanner(System.in);
		System.out.println("\npress any key to continue... ");
		scan.hasNext();

		Chinyelu.lastTransaction();
		scan.close();
	}
}
