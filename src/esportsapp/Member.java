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
import javax.swing.ImageIcon;

/**
 *
 * @author j9neave
 */
public class Member implements EsportsInterface<Member> {
	
	@Override
	public Member get() {
		return this;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public ImageIcon getIcon() {
		return this.icon;
	}
	
	@Override
	public void setIcon(ImageIcon icn) {
		this.icon = icn;
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
	public void setScore(Integer scr) {
		this.score = scr;
	}
	
	@Override 
	public Map getScores() {
		return this.scores;
	}
	
	@Override
	public void setScores(Map mp) {
		this.scores = mp;
	}
	
	public static List<Member> list = new ArrayList<>();
	private static final long serialVersionUID = 46L;
	
	String name;
	ImageIcon icon;
	String description;
	int score;
	Map<Event, Integer> scores;
	
	Team team;
	
	private Member(String name, Team team) {
		this.name = name;
		this.icon = Palette.getCurrentScheme().ICON_DEFAULT_MEMBER.getIcon();
		this.description = "";
		this.scores = new HashMap<>();
		
		
		this.team = team;
		this.score = 0;
		
	}
	
	public static Member add(String name, Team team) {
		name = name.trim();
		Member mem = new Member(name, team);
		
		mem.team.scores.put(mem, mem.score);
		Member.list.add(mem);
		
		return mem;
	}
	
	public void setScoreForEvent(Event evt, int scr) {
		this.scores.put(evt, scr);
		int total = this.scores.values().stream()
				.mapToInt(i -> i)
				.sum();
		this.score = total;
		this.team.scores.put(this, total);	
		
	}
	
}
