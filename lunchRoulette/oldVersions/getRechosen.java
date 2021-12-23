package oldVersions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.io.*;

public class getRechosen {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // List of Lunch Roulette participants

        List<String> nameListPlay = new ArrayList<>();
        List<String> nameList = new ArrayList<>();

        int numberOfPlyers = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(
                    "/Users/emelie.stromberg/Desktop/Coding/VSCode/lunchRoulette/main/textFiles/ParticipantsLunchRoulette.txt"));
            String s;

            while ((s = br.readLine()) != null) {
                nameList.add(s);
                nameListPlay.add(s);
                numberOfPlyers++;
            }
            br.close();

        } catch (Exception ex) {
            return;
        }

        // List and collection of topics

        List<String> topicList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(
                    "/Users/emelie.stromberg/Desktop/Coding/VSCode/lunchRoulette/main/textFiles/topicsLunchRoulette.txt"));
            String s;

            while ((s = br.readLine()) != null) {
                topicList.add(s);
            }
            br.close();

        } catch (Exception ex) {
            return;
        }

        // START OF ROULETTE
        // The program starts here and runs until quit is entered in the main menu

        boolean playing = true;
        int round = 0;

        while (playing) {

            // Main menu: Welcome to / welcome back to Lunch Roulette + choose option

            if (round == 0) {
                System.out.println("\n\nHello and welcome to the Lunch Roulette, Cloud Teams!");
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
                    System.out.println("\nAlrighty let's go!");
                    System.out.println("Here's your team and your topic to talk about:\n");
                    List<String> lunchGroupOfThree = new ArrayList<>();
                    Random random = new Random();

                    for (int i = 0; i < 3; i++) {

                        int randomInt = random.nextInt(nameListPlay.size());
                        String randomPerson = nameListPlay.get(randomInt);

                        lunchGroupOfThree.add(randomPerson);
                        nameListPlay.remove(randomInt);
                    }

                    int randomIntTopics = random.nextInt(topicList.size());
                    String randomTopic = topicList.get(randomIntTopics);

                    for (int i = 0; i < lunchGroupOfThree.size() - 1; i++) {
                        String namePlayed = lunchGroupOfThree.get(i);
                        System.out.print(namePlayed + ", ");
                    }
                    System.out.println(lunchGroupOfThree.get(lunchGroupOfThree.size() - 1));

                    System.out.println(randomTopic);
                    System.out.println("\nHappy lunching!\n");

                    System.out.println("Do you want to get one more group? Type yes or no");
                    String optionInput = scanner.nextLine();

                    if (optionInput.equals("no")) {
                        play = false;
                        System.out.println("\nOkay, have fun!\n");
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
                        try {
                            BufferedWriter bw = new BufferedWriter(new FileWriter(
                                    "/Users/emelie.stromberg/Desktop/Coding/VSCode/lunchRoulette/main/textFiles/ParticipantsLunchRoulette.txt"));
                            for (int i = 0; i < nameList.size(); i++) {
                                String addName = nameList.get(i);
                                bw.write(addName + "\n");
                            }
                            bw.close();

                        } catch (Exception ex) {
                            return;
                        }
                    } else {
                        listOfAddedNames.add(addNameInput);
                        nameList.add(addNameInput);
                        nameListPlay.add(addNameInput);
                    }
                }

                System.out.print("\nWelcome to the new members of the Lunch Roulette: ");
                for (int i = 0; i < listOfAddedNames.size() - 1; i++) {
                    String newName = listOfAddedNames.get(i);
                    System.out.print(newName + ", ");
                }
                System.out.println(listOfAddedNames.get(listOfAddedNames.size() - 1));
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
                        try {
                            BufferedWriter bw = new BufferedWriter(new FileWriter(
                                    "/Users/emelie.stromberg/Desktop/Coding/VSCode/lunchRoulette/main/textFiles/ParticipantsLunchRoulette.txt"));
                            for (int i = 0; i < nameList.size(); i++) {
                                String addName = nameList.get(i);
                                bw.write(addName + "\n");
                            }
                            bw.close();

                        } catch (Exception ex) {
                            return;
                        }

                    } else {
                        listOfRemovedNames.add(removeNameInput);
                        nameList.remove(removeNameInput);
                    }
                }
                System.out.print("\nHere are the people who are leaving the Lunch Roulette: ");
                for (int i = 0; i < listOfRemovedNames.size() - 1; i++) {
                    String newName = listOfRemovedNames.get(i);
                    System.out.print(newName + ", ");
                }
                System.out.println(listOfRemovedNames.get(listOfRemovedNames.size() - 1));
            }

            // See the list of all Lunch Roulette participants

            if (playerInput.equals("see list")) {
                System.out.println("\nThere are " + numberOfPlyers + " people who participates in Lunch Roulette:\n");

                for (int i = 0; i < nameList.size(); i++) {
                    String name = nameList.get(i);
                    System.out.println(name);
                }

            }

            // Quit the game. Shut down Lunch Roulette

            if (playerInput.equals("quit")) {
                playing = false;
                System.out.println("\nOkay, have a good day! Bye!\n");
            }

            round++;

        }
    }
}