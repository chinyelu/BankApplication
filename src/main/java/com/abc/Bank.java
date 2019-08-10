package com.abc;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Bank {
    private List<Customer> customers;
    public double compoundInterest;

    public Bank() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public String customerSummary() {
        String summary = "Customer Summary";
        for (Customer c : customers)
            summary += "\n - " + c.getName() + " (" + format(c.getNumberOfAccounts(), "account") + ")";
        return summary;
    }

    // Make sure correct plural of word is created based on the number passed in:
    // If number passed in is 1 just return the word otherwise add an 's' at the end
    private String format(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }

    public double totalInterestPaid() {
        double total = 0;
        for (Customer c : customers) {
            total += c.totalInterestEarned();
        }
        return total;
    }

    public String getFirstCustomer() {
        try {
            customers = null;
            return customers.get(0).getName();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public void dailySchedule() {
        long day = 2000;//(365l * 86400000l);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                accrueInterestDaily();
                System.out.println("Interest Accrued\n" + compoundInterest);
            }
        }, 0, day);
    }

    public double accrueInterestDaily() {

        for (Customer c : customers) {
            for (Account a : c.getAccounts()) {
                compoundInterest += a.dailyInterestEarned();
            }
        }
        return compoundInterest;

    }

}

