package com.example.game.WarGame;

import com.example.game.Player;

import java.util.ArrayList;

/**
 * WarGame class
 */
public class WarGame {

    private Card[] lastCards;
    private Player newPlayer;
    private WarPlayer[] players;

    private int numOfPlayers = 2;

    /**
     * construct Wargame with deck and player
     *
     * @param newPlayer who is playing Wargame
     */

    //hahsdhashdhisahidashhdas
    WarGame(Player newPlayer) {
        Deck deckOfCards = new Deck();

        players = new WarPlayer[numOfPlayers];
        lastCards = new Card[numOfPlayers];
        this.newPlayer = newPlayer;

        for (int i = 0; i < players.length; i++) {
            players[i] = new WarPlayer();
        }

        int cardsPerPlayer = deckOfCards.numOfCards() / numOfPlayers;
        for (WarPlayer player : players) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                Card nextCard = deckOfCards.getNextCard();
                player.receiveCard(nextCard);
            }
        }
    }

    /**
     * how many cards playerA have left
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
     * Record the last card of playerA and playerB
     *
     */
    private void setLastCardsPlayed(Card[] lastCardsPlayed) {
        System.arraycopy(lastCardsPlayed, 0, lastCards, 0, lastCardsPlayed.length);
    }

    /**
     * @return lastCards
     */
    Card[] getLastCardsPlayed() {
        return lastCards;
    }

    /**
     * get playerA
     *
     * @return playerA
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

        for (int i = 0; i < players.length; i++){
            lastCardsPlayed[i] = players[i].getNextCard();
            cardsInMiddle.add(lastCardsPlayed[i]);

        }

        //if there's a tie
        while (tieForCards(lastCardsPlayed)) {
            //check to see if players have enough cards to continue
            //if not, give all of their cards to the other player
            WarPlayer lessThan3Cards = tryGetPlayerWithLessThanThreeCards();
            if (lessThan3Cards != null) {
                lessThan3Cards.getHand().clear();
                return;
            }

            for (int i = 0; i < players.length; i++){
                cardsInMiddle.add(players[i].getNextCard());
                cardsInMiddle.add(players[i].getNextCard());

                Card lastCard = players[i].getNextCard();
                cardsInMiddle.add(lastCard);
                lastCardsPlayed[i] = lastCard;
            }
        }
        setLastCardsPlayed(lastCardsPlayed);

        int highestCardIndex = largestCard(lastCardsPlayed);
        players[highestCardIndex].addCards(cardsInMiddle);
        players[highestCardIndex].addScore(cardsInMiddle.size() / numOfPlayers);
    }

    private WarPlayer tryGetPlayerWithLessThanThreeCards(){
        for (WarPlayer player : players) {
            if (player.getHand().size() < 3)
                return player;
        }
        return null;

    }

    private boolean tieForCards(Card[] cards){
        int largest = largestCard(cards);

        int count = 0;

        for (Card card : cards) {
            if (card.getDenomination() == cards[largest].getDenomination())
                count++;
        }

        return count > 1;
    }

    // Method to find maximum in Card[]
    private int largestCard(Card[] cards)
    {
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

    // Method to find maximum in arr[]
    private int mostNumOfCards(WarPlayer[] players)
    {
        int i;

        // Initialize maximum element
        int max = 0;

        // Traverse array elements from second and
        // compare every element with current max
        for (i = 1; i < players.length; i++)
            if (players[i].getScore() > players[max].getScore())
                max = i;

        return max;
    }



    /**
     * Prints out who won the War Game and adds points to the Player
     *
     * @return String result of the game
     */
    @Override
    public String toString() {
        newPlayer.addPoints(players[0].getScore());
//        if (playerA.getScore() < playerB.getScore()) {
//            return ("Player B won!!! With a score of " + playerB.getScore() *
//                    newPlayer.getMultiplier() + "\nYou have a score of " + playerA.getScore()
//                    * newPlayer.getMultiplier());
//        } else if (playerA.getScore() > playerB.getScore()) {
//            return ("You won!!! With a score of " + playerA.getScore() * newPlayer.getMultiplier()
//                    + "\nPlayer B has a score of " + playerB.getScore() * newPlayer.getMultiplier());
//        } else {
//            return ("TIED---");
//        }

        WarPlayer winner = players[mostNumOfCards(players)];
        return "Player" + mostNumOfCards(players) + " won!!! With a score of " + winner.getScore();
    }
}
