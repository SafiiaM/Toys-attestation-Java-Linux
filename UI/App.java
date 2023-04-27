package UI;

import Configs.Config;
import Core.MVP.Presenter;
import Core.Models.Toy;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class App {
    public static void buttonClick() {
        Presenter presenter = new Presenter(new ConsoleView(), Config.pathDb);
        presenter.loadFromFile();

        String command;

        while (true) {

            command = prompt("""

                    1 - Add a toy to drawing
                    2 - Delete a toy from drawing 
                    3 - Make drawing (show results)
                    4 - Show toys for drawing 
                    5 - Clear all the records
                    6 - Save all the records to a file 
                    7 - Load all the records from a file 
                    8 - Exit
                    Make your choice:\s""");
            if (command.equals("8")) {
                return;
            }
            try {
                switch (command) {
                    case "1" -> presenter.putForDrawing();
                    case "2" -> presenter.deleteFromDrawing();
                    case "3" ->
                            presenter.getDrawing();
                    case "4" -> presenter.showAll();
                    case "5" -> presenter.clearAll();
                    case "6" -> presenter.saveToFile();
                    case "7" -> presenter.loadFromFile();
                    default -> System.out.println("\n Command is not found!");
                }
            } catch (Exception e) {
                System.out.println("Error. " + e.getMessage());
            }
        }
    }

    private static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private static Toy toyCreate() {
        int id = Integer.parseInt(prompt("Toy's id: "));
        String name = prompt("Toy's name: ");
        String weight = prompt("Toy's weight: ");
        return (new Toy(id, name, Integer.parseInt(weight)));
    }
}
