
package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kirandeep Kaur
 * @author Komalpreet Kaur Komalpreet Kaur
 */
public class WarGame extends Game{
    
   
 public WarGame() {
        super("War");
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);

        // 1) Build & shuffle deck
        GroupOfCards deck = new GroupOfCards(52);
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        for (String suit : suits) {
            for (int val = 2; val <= 14; val++) {
                deck.add(new StandardCard(val, suit));
            }
        }
        deck.shuffle();

        // 2) Deal into two hands
        GroupOfCards p1 = new GroupOfCards(26);
        GroupOfCards p2 = new GroupOfCards(26);
        boolean toggle = true;
        while (!deck.isEmpty()) {
            if (toggle) p1.add(deck.draw());
            else        p2.add(deck.draw());
            toggle = !toggle;
        }

        System.out.println("\n=== Starting War! ===\n");

        // 3) Interactive round loop
        while (!p1.isEmpty() && !p2.isEmpty()) {
            System.out.print("Enter 'y' to play next round, or 'q' to quit: ");
            String line = scanner.nextLine().trim().toLowerCase();

            if (line.equals("q")) {
                System.out.println("Game aborted by user.");
                break;
            }
            if (!line.equals("y")) {
                System.out.println("Invalid input; please enter 'y' or 'q'.");
                continue;
            }

            // Play one round
            StandardCard c1 = (StandardCard)p1.draw();
            StandardCard c2 = (StandardCard)p2.draw();
            System.out.println("Player 1 plays " + c1);
            System.out.println("Player 2 plays " + c2);

            if (c1.compareTo(c2) > 0) {
                p1.add(c1); p1.add(c2);
                System.out.println("Player 1 wins the round");
            }
            else if (c1.compareTo(c2) < 0) {
                p2.add(c1); p2.add(c2);
                System.out.println("Player 2 wins the round");
            }
            else {
                System.out.println("Tie! Both cards are discarded.");
            }

            // Show score
            System.out.printf("Score(Number of cards left) : Player1=%d  Player2=%d%n",
                              p1.count(), p2.count());
            System.out.println("---------------");
        }

        // 4) Declare winner if someone ran out of cards
        if (p1.count() > p2.count()) {
            System.out.println("\n*** Player 1 wins the game! ***");
        }
        else if (p2.count() > p1.count()) {
            System.out.println("\n*** Player 2 wins the game! ***");
        }
        else {
            System.out.println("\n*** Game ended in a draw ***");
        }

        scanner.close();
    }

    @Override
    public void declareWinner() {
        // Not used (handled at end of play())
    }
}
