package repositories;

import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {

    private List<Player> entities;

    public PlayerRepositoryImpl() {
        this.entities = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.entities.size();
    }

    @Override
    public List<Player> getPlayers() {
        return this.entities;
    }

    @Override
    public void add(Player player) {

        if (player == null){
            throw new IllegalArgumentException("Player cannot be null");
        }

        for (Player entity : entities) {
            if (player.getUsername().equals(entity.getUsername())){
                throw new IllegalArgumentException(String.format("Player %s already exists!", player.getUsername()));
            }
        }

        this.entities.add(player);
    }

    @Override
    public boolean remove(Player player) {

        if (player == null){
            throw new IllegalArgumentException("Player cannot be null");
        }

        return this.entities.remove(player);
    }

    @Override
    public Player find(String name) {

        for (Player player : entities) {
            if (name.equals(player.getUsername())){
                return player;
            }
        }

        return null;
    }
}
