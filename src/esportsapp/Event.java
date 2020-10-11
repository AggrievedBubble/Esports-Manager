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
public class Event {
	
	public static ArrayList<Event> EventList = new ArrayList<Event>();
	
	String EventName;
	ArrayList<Team> EventTeams = new ArrayList<Team>();
	
	
	public Event(String name) {
		this.EventName = name;
		
		//code for event panel
		
		//end of code for event panel
		
		//EsportsGUI.getEventManagementPane().addTab(this.EventName, this.EventPanel);
		
		Event.EventList.add(this);
	}
	
	
}
