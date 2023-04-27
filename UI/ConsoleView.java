package UI;

import java.util.List;
import java.util.Scanner;

import Configs.Config;
import Core.MVP.IView;
import Core.Models.Toy;

public class ConsoleView implements IView {
    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public int getToyId() {
        System.out.print("Toy's id: ");
        return Integer.parseInt(in.nextLine());
    }

    @Override
    public String getToyNaming() {
        System.out.print("Toy's name: ");
        return in.nextLine();
    }

    @Override
    public int getToyWeight() {
        System.out.print("Toy's weight: ");
        return Integer.parseInt(in.nextLine());
    }
    /**
    @Override
    public void setToyWeight(int value) {
    System.out.printf("Toy's weight: %s\n", value);
    }
     */
    @Override
    public void showAll(List<Toy> toys) {
        System.out.println("\nAll the toys for drawing:");
        for (Toy toy : toys) {
            System.out.println(toy);
        }

    }

    @Override
    public void showGetToy(Toy toy) {
        System.out.print("\nResults for casting of lots: ");
        System.out.println(toy);
    }

    @Override
    public void loadMessage() {
        System.out.println("\nFile is loaded to current session");
    }

    @Override
    public boolean clearAllDecision() {
        boolean f = false;
        System.out.print("\nAre you sure, Did you clear all the records (y/n): ");
        if (in.nextLine().equalsIgnoreCase("Y")) {
            f = true;
        }
        return f;
    }

    @Override
    public void savedAll() {
        System.out.println("\nAll the records save to a file: " + Config.pathDb);
    }

    @Override
    public void savedItem() {
        System.out.println("\nAdded successfully to current service");
    }

    @Override
    public void saveError() {
        System.out.println("\nFailed to add current service");
    }

    @Override
    public void emptyListMessage() {
        System.out.println("Toys list is empty!");
    }

    @Override
    public int getDrawTimes() {
        System.out.print("How many times do you want to draw?: ");
        return Integer.parseInt(in.nextLine());
    }

}