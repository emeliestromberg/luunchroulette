import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class oldListVersion {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // List of Lunch Roulette participants

        List<String> nameList = new ArrayList<>();

        // fil med namn som vi hämtar in hit. Varje rad är en person. JSON CSV
        // textfil/textredigerare på mac
        // Googla läs in fil till java. Färdig funktion? + filnamnet eller hela pathwayn
        // xx/bhbhbd/fil.namn
        // Lägg till i samma mapp som vi har programmets filer
        // Typ skapa ett objekt så läser vi igenom det med nextLine. Parce:a en fil.
        // Parse = gå igenom
        // Vajre gång vi loopar den lägger vi till en person från listan till programmet
        // med nameList.add tex

        nameList.add("Nora");
        nameList.add("Emelie");
        nameList.add("Wilja");
        nameList.add("Karin");
        nameList.add("Ulrika");
        nameList.add("Sofia");
        nameList.add("Magnus");

        List<String> topicList = new ArrayList<>();

        topicList.add("Om man fick hälsa på kungen hur som helst, vad hade du gjort då?");
        topicList.add("Om du kunde ha en tatuering i bara en vecka, vilken tatuering hade du haft då?");
        topicList.add("Om du fick tatuera den till höger om dig med vilket motiv som helst, vad hade du valt?");
        topicList.add("Tänk ut ett rim om din favoritfärg och läs upp den. Du har två minuter på dig.");
        topicList.add("Om du fick börja med en ny hobby, vad hade du gjort då?");
        topicList.add("Vad är din bästa guilty pleasure film/serie?");
        topicList.add("Vad är din största skill och vad tror du att personen till vänster om dig är hemligt bra på?");

        // The program starts here and runs until quit is entered in the main menu

        boolean playing = true;
        int round = 0;

        while (playing) {

            // Main menu: Welcome to / welcome back to Lunch Roulette + choose option

            if (round == 0) {
                System.out.println("\n\nHello and welcome to the Lunch Roulette!");
                System.out.println(
                        "This is the game where we see which three lucky people are going to have lunch together!\nHere are your options:\n");
            } else if (round > 0) {
                System.out.println("\n\nHello and welcome back to the Lunch Roulette!");
                System.out.println("What do you want to do now?\n");
            }

            System.out.println(
                    "Type 'play' to play Lunch Roulette\nType 'add' to add a person\nType 'remove' to remove a person\nType 'see list' to see participant list\nType 'quit' to stop playing\n");
            System.out.print("I want to ");
            String playerInput = scanner.nextLine();

            // Play! Get groups of three

            if (playerInput.equals("play")) {

                boolean play = true;
                while (play) {
                    System.out.println("\nAlrighty let's go.");
                    System.out.println("Here's your team and your topic to talk about:\n");
                    List<String> lunchGroupOfThree = new ArrayList<>();
                    Random random = new Random();

                    for (int i = 0; i < 3; i++) {

                        int randomInt = random.nextInt(nameList.size());
                        String randomPerson = nameList.get(randomInt);

                        lunchGroupOfThree.add(randomPerson);
                        nameList.remove(randomInt);
                    }

                    int randomIntTopics = random.nextInt(topicList.size());
                    String randomTopic = topicList.get(randomIntTopics);

                    System.out.println(lunchGroupOfThree);
                    System.out.println(randomTopic);
                    System.out.println("\nHappy lunching!\n");

                    System.out.println("Do you want to get one more group? Type yes or no");
                    String optionInput = scanner.nextLine();

                    if (optionInput.equals("no")) {
                        play = false;
                        System.out.println("\nOkay, have fun! Bye!\n");
                    } else if (optionInput.equals("yes")) {

                    }
                }
            }

            // Add a person to the list of Lunch Roulette participants

            if (playerInput.equals("add")) {

                System.out.println(
                        "\nPlease enter the names you want to add one at a time. Type 'stop' to stop adding names");
                List<String> listOfAddedNames = new ArrayList<>();

                boolean add = true;
                while (add) {
                    String addNameInput = scanner.nextLine();

                    if (addNameInput.equals("stop")) {
                        add = false;
                    } else {
                        listOfAddedNames.add(addNameInput);
                        nameList.add(addNameInput);
                    }
                }
                System.out.println("\nWelcome to the new members of the Lunch Roulette:" + listOfAddedNames + "\n");
                System.out.println("Here is the updated memberlist: " + nameList);
            }

            // Remove a person to the list of Lunch Roulette participants

            if (playerInput.equals("remove")) {
                System.out.println(
                        "\nPlease enter the names you want to remove one at a time. Type 'stop' to stop removing names");
                List<String> listOfRemovedNames = new ArrayList<>();

                boolean remove = true;
                while (remove) {
                    String removeNameInput = scanner.nextLine();
                    if (removeNameInput.equals("stop")) {
                        remove = false;
                    } else {
                        listOfRemovedNames.add(removeNameInput);
                        nameList.remove(removeNameInput);
                    }
                }
                System.out.println("\nHere are the people who are leaving the Lunch Roulette: " + listOfRemovedNames);
                System.out
                        .println("Here is your updated list of the participants of Lunch Roulette: " + nameList + "\n");
            }

            // See the list of all Lunch Roulette participants

            if (playerInput.equals("see list")) {
                System.err.println("\nHere is everyone who participates in Lunch Roulette:\n" + nameList);
            }

            // Quit the game. Shut down Lunch Roulette

            if (playerInput.equals("quit")) {
                playing = false;
                System.out.println("\nOkay, have a good day! Bye!\n");
            }

            round++;
            // else {
            // System.out.println("\nSorry, that is not an option. Put your glasses on
            // smh\n");
            // }

        }
    }
}