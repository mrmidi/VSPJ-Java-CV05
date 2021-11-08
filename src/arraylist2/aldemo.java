package arraylist2;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.Scanner;

public class aldemo {

    public static ArrayList<Function> functions = new ArrayList<Function>(); //let's make it global variable

    public static void al() {
        addDefaultValues();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        String choice = "";
        showMenu();
        int count = 0;
        do {

            System.out.print("> ");
            choice = scanner.nextLine().toLowerCase();
            switch (choice) {
                case "1":
                    //print everything
                    for (int i = 0; i < functions.size(); i++) {
                        System.out.println((i+1) + ". "+ functions.get(i));
                    }
                    break;
                case "2":
                    //print all lines
                    count = 0;
                    for (int i = 0; i < functions.size(); i++) {
                        if (functions.get(i).getType().equals("line")) {
                            count++;
                            System.out.println((count) + ". "+ functions.get(i));
                        }
                    }
                    break;
                case "3":
                    //print all quadratics
                    count = 0;
                    for (int i = 0; i < functions.size(); i++) {
                        if (functions.get(i).getType().equals("quadratic")) {
                            count++;
                            System.out.println((count) + ". "+ functions.get(i));
                        }
                    }
                    break;
                case "4":
                    //add new line
                    System.out.printf("Enter x: ");
                    Double x = scanner2.nextDouble();
                    System.out.printf("Enter y: ");
                    Double y = scanner2.nextDouble();
                    Function_Line l = new Function_Line(x, y);
                    if (!functions.contains(l)) {
                        functions.add(l);
                    } else {
                        System.out.println("You can add only unique lines!");
                    }
                    break;
                case "5":
                    //add new quadratic
                    System.out.printf("Enter a: ");
                    Double a = scanner2.nextDouble();
                    System.out.printf("Enter b: ");
                    Double b = scanner2.nextDouble();
                    System.out.printf("Enter b: ");
                    Double c = scanner2.nextDouble();
                    Function_Quadratic q = new Function_Quadratic(a, b, c);
                    if (!functions.contains(q)) {
                        functions.add(q);
                    } else {
                        System.out.println("You can add only unique quadratics!");
                    }
                    break;

                default:
                    showMenu();
                    System.out.println("Unknown command");
                    break;
            }

        } while (!choice.equals("q"));

    }

    private static void addDefaultValues() {
        Function_Line l1 = new Function_Line(1,2);
        Function_Line l2 = new Function_Line(3, 4);
        Function_Quadratic q1 = new Function_Quadratic(1,2,3);
        Function_Quadratic q2 = new Function_Quadratic(4,5,6);
        functions.add(l1);
        functions.add(l2);
        functions.add(q1);
        functions.add(q2);


    }

    private static void showMenu() {

        System.out.println("==== program menu =====");
        System.out.println("1. Print all objects");
        System.out.println("2. Print all lines");
        System.out.println("3. Print all quadratics");
        System.out.println("4. Add new line");
        System.out.println("5. Add new quadratic");
        System.out.println("Q. End program");
    }

}
