package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	
	/*
	 * Holds the next player identifier.
	 */
	private static long nextPlayerId = 1;
	
	/*
	 * Holds the next Team identifier.
	 */
	private static long nextTeamId = 1;
	
	/*
	 * Ensures that only one instance of GameService exists.
	 */
	private static GameService service = null;
	
	//Default constructor
	private GameService() {
		
	}
	
	/*
	 * Checks if GameService already exists.
	 */
	public static GameService getInstance() {
		if(service == null) {
			service = new GameService();
		}
		return service;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;
		
		/*
		 * Creates an iterator to search through the elements of games list.
		 */
		Iterator<Game> gamesIterator = games.iterator();
		
		/*
		 * Loop to iterate over games list.
		 */
		while(gamesIterator.hasNext()) {
			Game gameInstance = gamesIterator.next();
			if(gameInstance.getName().equals(name)) {
				return gameInstance;
			}
		}
		
		

		// if game not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		
		/*
		 * Creates an iterator to search through the elements of games list.
		 */
		Iterator<Game> gamesIterator = games.iterator();
		
		/*
		 * Loop to iterate over games list. If gameId already exists,
		 * return that instance.
		 */
		while(gamesIterator.hasNext()) {
			Game gameInstance = gamesIterator.next();
			if(gameInstance.getId() == id) {
				return gameInstance;
			}
		}
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;
		
		/*
		 * Creates an iterator to search through the elements of games list.
		 */
		Iterator<Game> gamesIterator = games.iterator();
		
		/*
		 * Loop that uses iterator to look for already existing game
		 * if game name already exists, return that instance.
		 */
		while(gamesIterator.hasNext()) {
			Game gameInstance = gamesIterator.next();
			if(gameInstance.getName().equals(name)) {
				game = gameInstance;
			}
		}
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	/*
	 * Returns the next player ID.
	 */
	public static long getNextPlayerId() {
		return nextPlayerId;
	}
	
	/*
	 * Returns the next Team ID
	 */
	public static long getNextTeamId() {
		return nextTeamId;
	}
}
