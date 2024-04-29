package com.gamingroom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	long id;
	String name;
	
	//Teams List.
	private static List<Team> teams = new ArrayList<Team>();
	
	//Holds the next Team identifier.
	private static long nextTeamId = 1;
	
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	
	//private Game() {
	//}

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
	}
	
	/*
	 * This method will check to see if a team is already in use,
	 * if not will add a new team.  Using parameters String name.
	 */
	public Team addTeam(String name) {
		Team team = null;
		
		//creates iterator instance to search Team List elements.
		Iterator<Team> teamsIterator = teams.iterator();
		
		//Loop to iterate over element of Team List.
		while(teamsIterator.hasNext()) {
			Team teamInstance = teamsIterator.next();
			if(teamInstance.getName().equals(name)) {
				return teamInstance;	
			}
		}	
		//If team = null, add team to Teams List and increment TeamId.
		if(team == null) {
			team = new Team(nextTeamId++, name);
			teams.add(team);
		}
		return team;
	}

	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
