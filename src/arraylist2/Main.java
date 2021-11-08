package arraylist2;

import java.util.Scanner;

public class Main {

    public static final String JAZYKOLAM = "Kmotře Petře, nepřepepřete mi toho vepře, jak mi, kmotře Petře, toho vepře přepepříte, tak si toho přepepřeného vepře sám sníte.";
    public static final String RZHRSH = "ř";
    public static final String NUMBERS = "12;345;666;777;888;9999";
    public static final String DEFAULTNAME = "      Mister          Midi         ";

    public static void main(String[] args) {
	// uncomment to see part 1 of exercise 5
        //stringsExercise();


        aldemo.al();


    }

    private static void stringsExercise() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter values. Or leave empty for default values");
        System.out.print("zadejte cisla oddelena strednikem: ");
        String numstr = scanner.nextLine();

        if (numstr.isEmpty()) {
            numstr = NUMBERS;
        }

        int[] testonly = strToNumArray(numstr);
        printArray(testonly);

        System.out.printf("Zadejte novy retezec: ");
        String textfield = scanner.nextLine();
        if (textfield.isEmpty()) {
            textfield = JAZYKOLAM;
        }
        System.out.printf("Zadejte pismeno, ktere hledate: ");
        String ch = scanner.nextLine();
        if (ch.isEmpty()) {
            ch = RZHRSH;
        }
        testonly = searchChars(ch, textfield);
        printArray(testonly);
        System.out.println("Zadejte jmeno a primene oddelene mezerou. Mezer muze byt vice nez 1: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            name = DEFAULTNAME;
        }
        String[] namesurname = parseNameSurname(name);
        String firstname = namesurname[0];
        String surname = namesurname[1];
        System.out.println(firstname + " " + surname);
    }

    //Hodi se to jako zadani B) i C) spolu?
    public static int[] strToNumArray(String numstr) {

        String[] numarr = numstr.split(";");
        int[] result = new int[numarr.length];
        for (int i = 0; i < numarr.length; i++) {
            result[i] = Integer.valueOf(numarr[i]);
        }
        return result;
    }

    public static int[] searchChars(String ch, String field) {
        ch = ch.toLowerCase(); // make the search non case-sensetive
        field = field.toLowerCase(); //same
        int pos = 0;
        String positionlist = "";
        if (field.indexOf(ch) != -1) { //check if it exists search query at all
            //algorithm
            while(true) {
                pos = field.indexOf(ch, pos);
                if (pos == -1) {
                    break;
                }
                positionlist = positionlist + String.valueOf(pos) + ";";
                pos++;
            }
            positionlist = positionlist.substring(0,positionlist.length()-1); //delete last semicolon
            int[] result = strToNumArray(positionlist); //why not to use function that i just wrote?
            return result;
        }
        return new int[0]; //return an empty array if found nothing
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static String[] parseNameSurname(String namesurname) {
        namesurname = namesurname.replaceAll("\\s{2,}", " ").trim();
        String[] result = namesurname.split(" ");
        return result;
    }
}
