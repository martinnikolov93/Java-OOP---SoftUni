import core.ManagerControllerImpl;
import core.interfaces.ManagerController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ManagerController managerController = new ManagerControllerImpl();

        Scanner scanner = new Scanner(System.in);

        String line = "";

        while (!"Exit".equals(line = scanner.nextLine())){
            String[] lineArray = line.split("\\s+");

            String command = lineArray[0];
            String secondValue = "";
            String thirdValue = "";

            if (lineArray.length == 3){
                secondValue = lineArray[1];
                thirdValue = lineArray[2];
            }

            switch (command) {
                case "AddPlayer":
                    try {
                        System.out.println(managerController.addPlayer(secondValue, thirdValue));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "AddCard":
                    try {
                        System.out.println(managerController.addCard(secondValue, thirdValue));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "AddPlayerCard":
                    try {
                        System.out.println(managerController.addPlayerCard(secondValue, thirdValue));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Fight":
                    try {
                        System.out.println(managerController.fight(secondValue, thirdValue));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Report":
                    try {
                        System.out.println(managerController.report());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }

        }
    }
}
