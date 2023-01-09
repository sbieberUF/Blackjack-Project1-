
import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {

        boolean stillPlaying = true;
        int gameNum = 0; // number of games
        int playerWins = 0; // number of wins by player
        int dealerWins = 0; // number of wins by dealer
        int tiedGames = 0; // number of games tied

        Scanner scnr = new Scanner(System.in);

        P1Random range = new P1Random(); // uses P1Random to generate random card that is dealt

        while(stillPlaying) { // starts new game, keeps running while stillPlaying is true

            boolean sameGame = true; // menu will print while sameGame is true
            int card; // card number
            int playerValue = 0; // value of player's hand
            int dealerValue = 0; // value of dealer's hand

            gameNum++; // starts game at #1, increases by 1 while stillPlaying = true;
            System.out.println("START GAME #" + gameNum);
            System.out.println("");


            card = range.nextInt(13) + 1;

            // deals card to player
            if(card == 1) {
                System.out.println("Your card is a ACE!");
                playerValue += 1; // player receives card with value 1, value is added to variable playerValue
            }
            else if(card == 11) {
                System.out.println("Your card is a JACK!"); // all face cards have a value of 10, if player receives this card, 10 is added to playerValue
                playerValue += 10;
            }
            else if(card == 12) {
                System.out.println("Your card is a QUEEN!");
                playerValue += 10;
            }
            else if(card == 13) {
                System.out.println("Your card is a KING!");
                playerValue += 10;
            }
            else {
                System.out.println("Your card is a " + card + "!");
                playerValue += card; // card number is added to player's hand value
            }

            // value of player's hand
            System.out.println("Your hand is: " + playerValue);
            System.out.println("");



            while(sameGame) { // keeps menu printing while sameGame is true
                // menu
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println("");
                System.out.print("Choose an option: ");

                int menu = scnr.nextInt();

                System.out.println("");

                switch(menu) {
                    case 1: // gives player another card
                        card = range.nextInt(13) + 1;

                        if(card == 1) {
                            System.out.println("Your card is a ACE!");
                            playerValue += 1;
                        }
                        else if(card == 11) {
                            System.out.println("Your card is a JACK!");
                            playerValue += 10;
                        }
                        else if(card == 12) {
                            System.out.println("Your card is a QUEEN!");
                            playerValue += 10;
                        }
                        else if(card == 13) {
                            System.out.println("Your card is a KING!");
                            playerValue += 10;
                        }
                        else {
                            System.out.println("Your card is a " + card + "!");
                            playerValue += card; // card number is added to playerValue
                        }

                        System.out.println("Your hand is: " + playerValue);
                        System.out.println("");

                        if(playerValue == 21) {
                            System.out.println("BLACKJACK! You win!");
                            System.out.println("");
                            playerWins++;
                            sameGame = false;
                        }
                        else if(playerValue > 21) {
                            System.out.println("You exceeded 21! You lose.");
                            System.out.println("");
                            dealerWins++;
                            sameGame = false;
                        }

                        break;



                    case 2: // player holds their hand while dealer gets card
                        dealerValue = range.nextInt(11) + 16;

                        System.out.println("Dealer's hand: " + dealerValue);
                        System.out.println("Your hand is: " + playerValue);
                        System.out.println("");

                        if(dealerValue > 21) {
                            System.out.println("You win!");
                            playerWins++; // increases playerWins by 1
                        }
                        else if(dealerValue == playerValue) {
                            System.out.println("It's a tie! No one wins!");
                            tiedGames++;
                        }
                        else if(dealerValue > playerValue) {
                            System.out.println("Dealer wins!");
                            dealerWins++;
                        }
                        else {
                            System.out.println("You win!");
                            playerWins++;
                        }

                        System.out.println("");

                        sameGame = false;

                        break;



                    case 3: // prints stats when input #3
                        double playerWinPercent = (playerWins/(double)(gameNum - 1) * 100);
                        System.out.println("Number of Player wins: " + playerWins);
                        System.out.println("Number of Dealer wins: " + dealerWins);
                        System.out.println("Number of tie games: " + tiedGames);
                        System.out.println("Total # of games played is: " + (gameNum - 1));
                        System.out.println("Percentage of Player wins: " + playerWinPercent + "%");
                        System.out.println("");

                        break;



                    case 4: // if input #4, ends game
                        sameGame = false;
                        stillPlaying = false;

                        break;

                    default: // any input that is not #1-4 will print the following:
                        System.out.println("Invalid input!");
                        System.out.println("Please enter an integer value between 1 and 4.");
                        System.out.println("");
                }

            }

        }
    }
}
