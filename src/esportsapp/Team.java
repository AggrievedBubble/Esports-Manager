/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esportsapp;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author User
 */
public class Team {
	
	public static ArrayList<Team> TeamList = new ArrayList<Team>();
	
	String TeamName;
	ArrayList<Player> TeamMembers = new ArrayList<Player>();
	int TeamScore = 0;
	
	//code to init team panel elements
	
	//end of code to init team panel elements
			
	public Team(String name) {
		this.TeamName = name;
		this.TeamScore = 0;
		
		//code for team panel
		
		//end of code for team panel
		
		//EsportsGUI.getTeamManagementPane().addTab(this.TeamName, this.TeamPanel);
		
		Team.TeamList.add(this);
    }

}
