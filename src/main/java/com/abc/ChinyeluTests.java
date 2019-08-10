package com.abc;

import java.util.*;
import java.util.spi.CalendarDataProvider;

public class ChinyeluTests {

    public static void main(String[] Args) {

        Bank b = new Bank();
        Account maxSavings = new Account(Account.MAXI_SAVINGS);


        Customer Chinyelu = new Customer("Chinyelu");
        Chinyelu.openAccount(maxSavings);

        b.addCustomer(Chinyelu);


        long todayMillis = DateProvider.getInstance().now().getTime();

        //manufacture a date a year ago to deposit an amount
        Calendar myCalendar = Calendar.getInstance();

        long year = (11l * 86400000l);
        myCalendar.setTimeInMillis(todayMillis - year);
        Date myDate = myCalendar.getTime();

        System.out.println("YEAR AGO: " + myDate);

        //deposit money at that date
        double depositAmount = 3000;
        maxSavings.testDepositAtDate(depositAmount, myDate);

        b.dailySchedule();





    }
}
