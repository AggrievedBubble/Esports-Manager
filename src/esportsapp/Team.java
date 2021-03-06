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
public class Team implements EsportsInterface<Team> {
	
	@Override
	public Team get() {
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
	public void setScore(Integer scr) {
		if (scr == null) {
			this.score = 0;
			this.panel.getScoreLabel().setText("");
		} else {
			this.score = scr;
			if (scr == 0) {
				this.panel.getScoreLabel().setText("0");
			} else {
				this.panel.getScoreLabel().setText(String.valueOf(scr));
			}
		}
		
		
		
	}
	
	@Override
	public Map<Member, Integer> getScores() {
		return this.scores;
	}
	
	@Override
	public void setScores(Map mp) {
		this.scores = mp;
	}

	public static List<Team> list = new ArrayList<Team>();
	private static final long serialVersionUID = 44L;
	
	String name;
	ImageIcon icon;
	int score;
	String description;
	Map<Member, Integer> scores;
	transient ListComponent<Team> panel;
	
	private Team(String name) {
		this.name = name;
		this.icon = Palette.getCurrentScheme().ICON_DEFAULT_TEAM.getIcon();
		this.description = "";
		this.scores = new HashMap<>();
		
		this.score = 0;
		
	}
	
	public static Team add(String name) {
		name = name.trim();
		Team tm = new Team(name);
		
		tm.panel = new ListComponent<>(tm, (lc) -> {
			ManagementDialog<Team> md = new ManagementDialog<>(Team.class, tm);
			md.setVisible(true);
			md.nameField.setText(md.object.getName());
		});
		
		if (tm.score == 0) {
			tm.panel.getScoreLabel().setText("");
		} else {
			tm.panel.getScoreLabel().setText(String.valueOf(tm.score));
		}
		
		JPanel tlp = EsportsGUI.getTeamsListPanel();
		tlp.add(tm.panel, tlp.getComponentCount() - 1);
		tlp.revalidate();
		
		Team.list.add(tm);
		
		return tm;
	}
	
	public void updateScore() {
		int tot = 0;
		Boolean all_null = true;
		for (Event e : Event.list) {
			if (e.getScores().get(this) == null) {
				tot += 0;
			} else {
				tot += Integer.parseInt(String.valueOf(e.getScores().get(this)));
				all_null = false;
			}
		}
		if (all_null) {
			this.setScore(null);
		} else {
			this.setScore(tot);
		}
		
	}
	
}
