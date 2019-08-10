package models.cards;

import models.cards.interfaces.Card;

public abstract class BaseCard implements Card {

    /*•	name – String (If the card name is null or empty throw an IllegalArgumentException with message "Card's name cannot be null or an empty string.")
    •	damagePoints – int (If the damage points are below zero, throw an IllegalArgumentException with message "Card's damage points cannot be less than zero.")
    •	healthPoints - int (If the health points are below zero, throw an IllegalArgumentException with message "Card's HP cannot be less than zero.")*/

    private String name;
    private int damagePoints;
    private int healthPoints;

    protected BaseCard(String name, int damagePoints, int healthPoints) {
        this.setName(name);
        this.setDamagePoints(damagePoints);
        this.setHealthPoints(healthPoints);
    }

    private void setName(String name) {

        if (name == null || name.trim().equals("")){
            throw new IllegalArgumentException("Card's name cannot be null or an empty string.");
        }

        this.name = name;
    }

    private void setHealthPoints(int healthPoints) {

        if (healthPoints < 0){
            throw new IllegalArgumentException("Card's HP cannot be less than zero.");
        }

        this.healthPoints = healthPoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDamagePoints() {
        return this.damagePoints;
    }

    @Override
    public void setDamagePoints(int damagePoints) {
        if (damagePoints < 0){
            throw new IllegalArgumentException("Card's damage points cannot be less than zero.");
        }

        this.damagePoints = damagePoints;
    }

    @Override
    public int getHealthPoints() {
        return this.healthPoints;
    }
}
