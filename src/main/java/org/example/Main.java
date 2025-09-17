package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){

        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);
        try {
            double rate1 = converter.getExchangeRate("USD","GBP");
            System.out.println("Exchange rate - USD to GBP: " + rate1);

            double rate2 = converter.getExchangeRate("AUD", "CAD");
            System.out.println("Exchange rate - AUD to CAD: " + rate2);

            double rate3 = converter.getExchangeRate("EUR", "JPY");
            System.out.println("Exchange rate - EUR to JPY: " + rate3);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        try {
            System.out.println("Enter base currency (e.g, GBP): ");
            String fromCurrency = scanner.nextLine();

            System.out.println("Enter target currency (e.g, CAD): ");
            String toCurrency = scanner.nextLine();

            System.out.println("Enter Amount: ");
            double amount =scanner.nextDouble();

            double rate = converter.getExchangeRate(fromCurrency, toCurrency);
            double converted = rate * amount;
            System.out.printf("%.2f %s = %.2f %s%n",
                    amount, fromCurrency.toUpperCase(), converted, toCurrency.toUpperCase());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());

        }

    }


}