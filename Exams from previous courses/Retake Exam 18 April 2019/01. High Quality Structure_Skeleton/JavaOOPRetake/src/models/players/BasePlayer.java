package models.players;

import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

public abstract class BasePlayer implements Player {

    /*•	username – String (If the username is null or empty, throw an IllegalArgumentException with message "Player's username cannot be null or an empty string. ")
    •	health – int -  the health of а player (if the health is below 0, throw an IllegalArgumentException with message "Player's health bonus cannot be less than zero. ")
    •	cardRepository – CardRepository repository of all user's cards.
    •	isDead – boolean – shows if player is alive(false) or dead(true).*/

    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;

    protected BasePlayer(CardRepository cardRepository, String username, int health) {
        this.cardRepository = cardRepository;
        this.setUsername(username);
        this.setHealth(health);
        this.isDead = false;
    }

    private void setUsername(String username) {

        if (username == null || username.trim().equals("")) {
            throw new IllegalArgumentException("Player's username cannot be null or an empty string. ");
        }

        this.username = username;
    }

    private void setDead(boolean dead) {
        this.isDead = dead;
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints) {

        if (healthPoints < 0) {
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero. ");
        }

        this.health = healthPoints;

    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (damagePoints < 0) {
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }

        if (this.health - damagePoints < 1) {
            this.health = 0;
            this.setDead(true);
        } else {
            this.health -= damagePoints;
        }

    }


}
