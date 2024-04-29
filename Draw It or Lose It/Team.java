package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	long id;
	String name;
	
	//Players List.
	private static List<Player> players = new ArrayList<Player>();
	
	//Holds the next Player identifier.
	private static long nextPlayerId = 1;
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
	}

	/*
	 * This method will check to see if a player is already in use,
	 * if not will add a new player.  Using parameters String name.
	 */
	public Player addPlayer(String name) {
		Player player = null;
		
		//creates iterator instance to search Player List elements.
		Iterator<Player> playersIterator = players.iterator();
		
		//Loop to iterate over element of Player List.
		while(playersIterator.hasNext()) {
			Player playerInstance = playersIterator.next();
			if(playerInstance.getName().equals(name)) {
				return playerInstance;	
			}
		}
		//If player is null, add player to Player List and increment PlayerId.
		if(player == null) {
			player = new Player(nextPlayerId++, name);
			players.add(player);
		}
		return player;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
