/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esportsapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author j9neave
 */
public class Event implements EsportsInterface<Event>{
	
	@Override
	public Event get() {
		return this;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
		this.panel.getNameLabel().setText(name);
	}
	
	@Override
	public ImageIcon getIcon() {
		return this.icon;
	}
	
	@Override 
	public void setIcon(ImageIcon icn) {
		this.icon = icn;
		this.panel.getIconLabel().setIcon(new ImageIcon(this.icon.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
	}
	
	@Override 
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	@Override
	public int getScore() {
		return this.score;
	}
	
	@Override
	public void setScore(int scr) {
		this.score = scr;
	}
	
	@Override
	public Map<Team, Integer> getScores() {
		return this.scores;
	}
	
	@Override 
	public void setScores(Map scr) {
		this.scores = scr;
	}
	
	public static List<Event> list = new ArrayList<Event>();
	private static final long serialVersionUID = 42;
	
	String name;
	ImageIcon icon;
	String description;
	int score;
	Map<Team, Integer> scores;
	transient ListComponent<Event> panel;
	
	private Event(String name) {
		this.name = name;
		this.icon = Palette.getCurrentScheme().ICON_DEFAULT_EVENT.getIcon();
		this.description = "";
		this.score = 0;
		this.scores = new HashMap<>();
		
	}
	
	public static Event add(String name) {
		name = name.trim();
		Event ev = new Event(name);
		
		// create panel and add to elp
		ev.panel = new ListComponent<>(ev, (lc) -> {
			ManagementDialog<Event> md = new ManagementDialog<>(Event.class, lc.get());
			md.setVisible(true);
			md.nameField.setText(md.object.getName());
		});
		
		JPanel elp = EsportsGUI.getEventsListPanel();
		elp.add(ev.panel, elp.getComponentCount() - 1);
		elp.revalidate();
		
		Event.list.add(ev);
		
		return ev;
	}
	
	public void addTeam(Team tm) {
		this.scores.put(tm, 0);
	}
	
	public void setTeamScore(Team tm, int scr) {
		this.scores.put(tm, scr);
		tm.updateScore();
	}
	
}
