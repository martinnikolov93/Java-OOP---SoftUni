package core;

import core.interfaces.ManagerController;
import models.battleFields.BattlefieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.MagicCard;
import models.cards.TrapCard;
import models.cards.interfaces.Card;
import models.players.Advanced;
import models.players.Beginner;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.interfaces.CardRepository;
import repositories.interfaces.PlayerRepository;

import static common.ConstantMessages.*;


public class ManagerControllerImpl implements ManagerController {

    private PlayerRepository playerRepository;
    private CardRepository cardRepository;
    private Battlefield battlefield = new BattlefieldImpl();

    public ManagerControllerImpl() {
        this.playerRepository = new PlayerRepositoryImpl();
        this.cardRepository = new CardRepositoryImpl();
    }

    @Override
    public String addPlayer(String type, String username) {

        Player player = null;

        if (type.equals("Beginner")) {
            player = new Beginner(new CardRepositoryImpl(), username);
        } else if (type.equals("Advanced")) {
            player = new Advanced(new CardRepositoryImpl(), username);
        }

        this.playerRepository.add(player);

        return String.format(SUCCESSFULLY_ADDED_PLAYER, type, username);
    }

    @Override
    public String addCard(String type, String name) {

        Card card = null;

        if (type.equals("Magic")) {
            card = new MagicCard(name);
        } else if (type.equals("Trap")) {
            card = new TrapCard(name);
        }

        this.cardRepository.add(card);

        return String.format(SUCCESSFULLY_ADDED_CARD, type, name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {

        Player player = this.playerRepository.find(username);

        Card card = this.cardRepository.find(cardName);

        player.getCardRepository().add(card);

        return String.format(SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName, username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {

        Player attacker = this.playerRepository.find(attackUser);

        Player enemy = this.playerRepository.find(enemyUser);

        battlefield.fight(attacker, enemy);

        return String.format(FIGHT_INFO, attacker.getHealth(), enemy.getHealth());
    }

    @Override
    public String report() {

        int counter = 0;

        StringBuilder sb = new StringBuilder();

        for (Player player : this.playerRepository.getPlayers()) {
            sb.append(String.format(PLAYER_REPORT_INFO, player.getUsername(), player.getHealth(), player.getCardRepository().getCards().size()));
            sb.append(System.lineSeparator());
            for (Card card : player.getCardRepository().getCards()) {
                sb.append(String.format(CARD_REPORT_INFO, card.getName(), card.getDamagePoints()));
                sb.append(System.lineSeparator());
            }
            sb.append(DEFAULT_REPORT_SEPARATOR);

            counter++;

            if (counter < this.playerRepository.getPlayers().size()){
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
