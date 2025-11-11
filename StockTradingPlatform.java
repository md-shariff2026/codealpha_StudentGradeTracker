package codeAlpha;

import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Portfolio {
    ArrayList<Stock> ownedStocks = new ArrayList<>();
    double balance = 10000.0; // starting balance

    void buyStock(Stock stock) {
        if (balance >= stock.price) {
            ownedStocks.add(stock);
            balance -= stock.price;
            System.out.println("Bought 1 share of " + stock.name + " for $" + stock.price);
        } else {
            System.out.println("Not enough balance to buy " + stock.name);
        }
    }

    void sellStock(String stockName) {
        for (Stock s : ownedStocks) {
            if (s.name.equalsIgnoreCase(stockName)) {
                ownedStocks.remove(s);
                balance += s.price;
                System.out.println("Sold 1 share of " + s.name + " for $" + s.price);
                return;
            }
        }
        System.out.println("You don't own " + stockName);
    }

    void showPortfolio() {
        System.out.println("\n=== Your Portfolio ===");
        if (ownedStocks.isEmpty()) {
            System.out.println("No stocks owned.");
        } else {
            for (Stock s : ownedStocks) {
                System.out.println(s.name + " - $" + s.price);
            }
        }
        System.out.println("Balance: $" + balance);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Stock> availableStocks = new ArrayList<>();
        availableStocks.add(new Stock("Google", 1200.50));
        availableStocks.add(new Stock("Apple", 950.75));
        availableStocks.add(new Stock("Tesla", 700.30));
        availableStocks.add(new Stock("Amazon", 1450.90));

        Portfolio portfolio = new Portfolio();

        while (true) {
            System.out.println("\n=== Stock Trading Platform ===");
            System.out.println("1. View Available Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Stocks:");
                    for (Stock s : availableStocks) {
                        System.out.println(s.name + " - $" + s.price);
                    }
                    break;
                case 2:
                    System.out.print("Enter stock name to buy: ");
                    String buyName = scanner.nextLine();
                    boolean foundBuy = false;
                    for (Stock s : availableStocks) {
                        if (s.name.equalsIgnoreCase(buyName)) {
                            portfolio.buyStock(s);
                            foundBuy = true;
                            break;
                        }
                    }
                    if (!foundBuy)
                        System.out.println("Stock not found!");
                    break;
                case 3:
                    System.out.print("Enter stock name to sell: ");
                    String sellName = scanner.nextLine();
                    portfolio.sellStock(sellName);
                    break;
                case 4:
                    portfolio.showPortfolio();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for trading!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
