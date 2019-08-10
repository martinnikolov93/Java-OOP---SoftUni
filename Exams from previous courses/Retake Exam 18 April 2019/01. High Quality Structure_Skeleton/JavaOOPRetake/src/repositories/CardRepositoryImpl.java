package repositories;

import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.ArrayList;
import java.util.List;

public class CardRepositoryImpl implements CardRepository {
    private List<Card> entities;

    public CardRepositoryImpl() {
        this.entities = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.entities.size();
    }

    @Override
    public List<Card> getCards() {
        return this.entities;
    }

    @Override
    public void add(Card card) {

        if (card == null){
            throw new IllegalArgumentException("Card cannot be null!");
        }

        for (Card entity : entities) {
            if (card.getName().equals(entity.getName())){
                throw new IllegalArgumentException(String.format("Card %s already exists!", card.getName()));
            }
        }

        this.entities.add(card);
    }

    @Override
    public boolean remove(Card card) {

        if (card == null){
            throw new IllegalArgumentException("Card cannot be null!");
        }

        return this.entities.remove(card);
    }

    @Override
    public Card find(String name) {

        for (Card card : entities) {
            if (name.equals(card.getName())){
                return card;
            }
        }

        return null;
    }
}
