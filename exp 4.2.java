//Aim- create a program to collect and store all the cards to assist the user in finding all the cards of a given symbol using collection interface. 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardCollection {
    private List<Card> cards;

    // Constructor to initialize the card collection
    public CardCollection() {
        cards = new ArrayList<>();
    }

    // Method to add a card to the collection
    public void addCard(Card card) {
        cards.add(card);
    }

    // Method to find all cards of a given symbol
    public List<Card> findCardsBySymbol(String symbol) {
        List<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                result.add(card);
            }
        }
        return result;
    }

    // Method to display all cards in the collection
    public void displayAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards in the collection.");
        } else {
            for (Card card : cards) {
                System.out.println(card);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection collection = new CardCollection();

        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Add Card");
            System.out.println("2. Find Cards by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter card symbol (e.g., Hearts, Spades): ");
                    String symbol = scanner.nextLine();
                    System.out.print("Enter card value (e.g., 2, J, Ace): ");
                    String value = scanner.nextLine();
                    collection.addCard(new Card(symbol, value));
                    System.out.println("Card added successfully!");
                    break;

                case 2:
                    System.out.print("Enter symbol to search for cards (e.g., Hearts, Spades): ");
                    String searchSymbol = scanner.nextLine();
                    List<Card> foundCards = collection.findCardsBySymbol(searchSymbol);
                    if (foundCards.isEmpty()) {
                        System.out.println("No cards found with the symbol " + searchSymbol);
                    } else {
                        System.out.println("Cards with symbol " + searchSymbol + ":");
                        for (Card card : foundCards) {
                            System.out.println(card);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Displaying all cards:");
                    collection.displayAllCards();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

