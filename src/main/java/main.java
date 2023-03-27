//package machine;
import java.util.Scanner;

enum State {
    BUY, FILL, TAKE, REMAINING, EXIT,
    ESPRESSO, LATTE, CAPPUCCINO,
    ADD_WATER, ADD_MILK, ADD_BEANS, ADD_CUPS,
    ACTION
}

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;
    static State State;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        while(State != State.EXIT) {
            actionMenu(scan.nextLine());
        }
    }

    public static void actionMenu(String action) {
        switch(action) {
            case "buy":
                State = State.BUY;
                break;
            case "fill":
                State = State.FILL;
                break;
            case "take":
                State = State.TAKE;
                break;
            case "remaining":
                State = State.REMAINING;
                break;
            case "exit":
                State = State.EXIT;
                break;
            case "1":
                State = State.ESPRESSO;
                break;
            case "2":
                State = State.LATTE;
                break;
            case "3":
                State = State.CAPPUCCINO;
                break;
        }

        switch(State) {
            case BUY:
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                break;
            case FILL:
                State = State.ADD_WATER;
                break;
            case ADD_WATER:
                System.out.println("Write how many ml of water you want to add:");
                water += Integer.parseInt(action);
                State = State.ADD_MILK;
                break;
            case ADD_MILK:
                System.out.println("Write how many ml of milk you want to add:");
                milk += Integer.parseInt(action);
                State = State.ADD_BEANS;
                break;
            case ADD_BEANS:
                System.out.println("Write how many grams of coffee beans you want to add:");
                beans += Integer.parseInt(action);
                State = State.ADD_CUPS;
                break;
            case ADD_CUPS:
                System.out.println("Write how many disposable cups you want to add:");
                cups += Integer.parseInt(action);
                State = State.ACTION;
                break;
            case TAKE:
                System.out.println("I gave you $" + money);
                money -= money;
                State = State.ACTION;
                break;
            case REMAINING:
                System.out.println(water + " ml of water");
                System.out.println(milk + " ml of milk");
                System.out.println(beans + " g of coffee beans");
                System.out.println(cups + " disposable cups");
                System.out.println("$" + money + " of money");
                State = State.ACTION;
                break;
            case EXIT:
                break;
            case ESPRESSO:
                if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (beans < 16) {
                    System.out.println("Sorry, not enough beans!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    water -= 250;
                    beans -= 16;
                    cups--;
                    money += 4;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                State = State.ACTION;
                break;
            case LATTE:
                if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else if (beans < 20) {
                    System.out.println("Sorry, not enough beans!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups--;
                    money += 7;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                State = State.ACTION;
                break;
            case CAPPUCCINO:
                if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else if (beans < 12) {
                    System.out.println("Sorry, not enough beans!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups--;
                    money += 6;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                State = State.ACTION;
                break;
        }

        if (State == State.ACTION) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
        }
    }
}