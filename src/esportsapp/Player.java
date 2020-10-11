/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esportsapp;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Player {
	
	static ArrayList<Player> PlayerList = new ArrayList<Player>();
	
	String PlayerName;
	Team Team;
	int Score;
	
	
	public Player(String name, Team team) {
		this.PlayerName = name;
		this.Team = team;
		this.Score = 0;
		
		Player.PlayerList.add(this);
	}
	
}
