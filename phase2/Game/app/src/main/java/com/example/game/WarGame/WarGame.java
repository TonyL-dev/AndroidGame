package com.example.game.WarGame;

import com.example.game.PlayerPackage.Player;

import java.util.ArrayList;

/**
 * WarGame class
 */
public class WarGame {

    /**
     * The last n cards played where n is the number of players
     */
    private Card[] lastCards;

    /**
     * the user
     */
    private Player newPlayer;

    /**
     * the n number of people playing
     */
    private WarPlayer[] players;

    /**
     * the number of players
     */
    private int numOfPlayers;

    /**
     * construct Wargame with deck and player
     *
     * @param newPlayer who is playing Wargame
     */
    WarGame(Player newPlayer, int numOfPlayers) {
        Deck deckOfCards = new Deck();
        this.numOfPlayers = numOfPlayers;

        players = new WarPlayer[numOfPlayers];
        lastCards = new Card[numOfPlayers];
        this.newPlayer = newPlayer;

        for (int i = 0; i < players.length; i++) {
            players[i] = new WarPlayer();
        }

        //the distribution of cards (in the 3 players case it will be uneven so some cards won't be used
        int cardsPerPlayer = deckOfCards.numOfCards() / numOfPlayers;
        for (WarPlayer player : players) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                Card nextCard = deckOfCards.getNextCard();
                player.receiveCard(nextCard);
            }
        }
    }

    /**
     * how many cards this player has left
     *
     * @return playerA's hand size
     */
    int getCardsRemaining(int player) {
        return players[player].getHand().size();
    }

    /**
     * checks if the game is over
     *
     * @return True if either player's hand is 0
     */
    Boolean checkEndGame() {
        for (WarPlayer player : players) {
            if (player.getHand().size() == 0)
                return true;
        }
        return false;
    }

    /**
     * Return the number of players
     *
     * @return returns the number of players
     */
    int getNumOfPlayers() {
        return this.numOfPlayers;
    }

    /**
     * Record the last n cards played where n is the number of players
     *
     * @param lastCardsPlayed list of n cards
     */
    private void setLastCardsPlayed(Card[] lastCardsPlayed) {
        System.arraycopy(lastCardsPlayed, 0, lastCards, 0, lastCardsPlayed.length);
    }

    /**
     * Return the last cards that were played
     *
     * @return the last cards that were played
     */
    Card[] getLastCardsPlayed() {
        return lastCards;
    }

    /**
     * Return the first player (the user)
     *
     * @return Return the first player (a.k.a the user)
     */
    WarPlayer getPlayerA() {
        return players[0];
    }

    /**
     * play out a single round of the game
     */
    void play() {

        ArrayList<Card> cardsInMiddle = new ArrayList<>();

        Card[] lastCardsPlayed = new Card[numOfPlayers];

        //simulation of each player flipping their next card
        for (int i = 0; i < players.length; i++) {
            lastCardsPlayed[i] = players[i].getNextCard();
            cardsInMiddle.add(lastCardsPlayed[i]);

        }

        //if there's a tie
        while (tieForCards(lastCardsPlayed)) {
            //check to see if players have enough cards to continue
            //if not, then clear that players hand and game will end
            WarPlayer lessThan3Cards = tryGetPlayerWithLessThanThreeCards();
            if (lessThan3Cards != null) {
                lessThan3Cards.getHand().clear();
                return;
            }

            //simulation of flipping 2 extra cards
            for (int i = 0; i < players.length; i++) {
                cardsInMiddle.add(players[i].getNextCard());
                cardsInMiddle.add(players[i].getNextCard());

                Card lastCard = players[i].getNextCard();
                cardsInMiddle.add(lastCard);
                lastCardsPlayed[i] = lastCard;
            }
        }
        setLastCardsPlayed(lastCardsPlayed);

        //determining who gets all the cards played for the round
        int highestCardIndex = largestCard(lastCardsPlayed);
        players[highestCardIndex].addCards(cardsInMiddle);
        players[highestCardIndex].addPoints(cardsInMiddle.size() / numOfPlayers);
    }

    /**
     * Check to see if there's any player that has < 3 cards in their hand
     *
     * @return null if nobody otherwise return the player that has < 3
     */
    private WarPlayer tryGetPlayerWithLessThanThreeCards() {
        for (WarPlayer player : players) {
            if (player.getHand().size() < 3)
                return player;
        }
        return null;

    }

    /**
     * Check to see if there is a tie among the last cards played
     *
     * @param cards the cards played
     * @return whether or not there is a tie
     */
    private boolean tieForCards(Card[] cards) {
        int largest = largestCard(cards);

        int count = 0;

        for (Card card : cards) {
            if (card.getDenomination() == cards[largest].getDenomination())
                count++;
        }

        return count > 1;
    }

    /**
     * Find the position of the highest card
     * Code is from: https://www.geeksforgeeks.org/c-program-find-largest-element-array/
     *
     * @param cards the last cards played
     * @return the index of the highest card played
     */
    private int largestCard(Card[] cards) {
        int i;

        // Initialize maximum element
        int max = 0;

        // Traverse array elements from second and
        // compare every element with current max
        for (i = 1; i < cards.length; i++)
            if (cards[i].getDenomination() > cards[max].getDenomination())
                max = i;

        return max;
    }

    /**
     * Finding who won the game based on who has the most number of cards left: if there is a tie
     * for the highest it will select one of them to be the winner (equivalent of doing rock-paper-
     * scissors)
     * Code is from: https://www.geeksforgeeks.org/c-program-find-largest-element-array/
     *
     * @param players the current players playing
     * @return the index of the player with the highest number of cards
     */
    private int mostNumOfCards(WarPlayer[] players) {
        int i;

        // Initialize maximum element
        int max = 0;

        // Traverse array elements from second and
        // compare every element with current max
        for (i = 1; i < players.length; i++)
            if (players[i].getPoints() > players[max].getPoints())
                max = i;

        return max;
    }


    /**
     * Prints out who won the War Game and adds points to the user
     *
     * @return String result of the game
     */
    @Override
    public String toString() {
        newPlayer.addPoints(players[0].getPoints());
        WarPlayer winner = players[mostNumOfCards(players)];

        if (winner.getPoints() == players[0].getPoints())
            return "YOU WON!!! With a score of " + players[0].getPoints();
        return "Player" + mostNumOfCards(players) + " won!!! With a score of " + winner.getPoints();
    }
}
