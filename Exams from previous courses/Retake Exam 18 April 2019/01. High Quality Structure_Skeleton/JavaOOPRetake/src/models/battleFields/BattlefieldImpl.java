package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.interfaces.Player;

import java.util.List;

public class BattlefieldImpl implements Battlefield {

  /*  •	If one of the users is dead, throw new IllegalArgumentException with message "Player is dead!"
    •	If the player is a beginner, increase his health with 40 points and increase all damage points of all cards for the user with 30.
    •	Before the fight, both players get bonus health points from their deck.
    •	Attacker attacks first and after that the enemy attacks. If one of the players is dead you should stop the fight.*/


    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {

        if (attackPlayer.isDead() || enemyPlayer.isDead()){
            throw new IllegalArgumentException("Player is dead!");
        }

        applyBonusesIfBeginner(attackPlayer);
        applyBonusesIfBeginner(enemyPlayer);

        setBonusHealthPointsFromDeck(attackPlayer);
        setBonusHealthPointsFromDeck(enemyPlayer);

        processFight(attackPlayer, enemyPlayer);
    }

    private void processFight(Player attackPlayer, Player enemyPlayer) {

        while (true) {
            int attackerDamagePoints = getPlayerDamagePoints(attackPlayer);

            enemyPlayer.takeDamage(attackerDamagePoints);

            if (enemyPlayer.isDead()) {
                return;
            }

            int enemyDamagePoints = getPlayerDamagePoints(enemyPlayer);

            attackPlayer.takeDamage(enemyDamagePoints);

            if (attackPlayer.isDead()) {
                return;
            }
        }
    }

    private int getPlayerDamagePoints(Player player) {

        List<Card> cards = player.getCardRepository().getCards();

        int sum = 0;

        for (Card card : cards) {
            sum += card.getDamagePoints();
        }

        return sum;
    }

    private void setBonusHealthPointsFromDeck (Player player){
        int sum = 0;

        List<Card> cards = player.getCardRepository().getCards();

        for (Card card : cards) {
            sum += card.getHealthPoints();
        }

        player.setHealth(player.getHealth() + sum);
    }

    private void applyBonusesIfBeginner(Player player) {
        if (player.getClass().getSimpleName().equals("Beginner")){

            player.setHealth(player.getHealth() + 40);

            List<Card> cards = player.getCardRepository().getCards();

            for (Card card : cards) {
                card.setDamagePoints(card.getDamagePoints() + 30);
            }
        }
    }
}
