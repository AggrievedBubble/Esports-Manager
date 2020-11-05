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
 * @author User
 */
public class Event extends javax.swing.JPanel {

	public static List<Event> list = new ArrayList<Event>();
	
	String name;
	Map<Team, Integer> teamScores;
	
	/**
	 * Creates new form Event
	 */
	private Event(String name) {
		this.teamScores = new HashMap<>();
		this.name = name;
		
		
		initComponents();
	}
	
	public static Event add(String name) {
		name = name.trim();
		Event evt = new Event(name);
		
		JPanel elp = EsportsGUI.getEventsListPanel();
		elp.add(evt, Event.list.size()); 
		elp.revalidate();
		
		Event.list.add(evt);
		
		return evt;
	}
	
	public JLabel getNameLabel() {
		return nameLabel;
	}
	
	public void addTeam(Team tm) {
		this.teamScores.put(tm, 0);
	}
	
	public void setTeamScore(Team tm, int scr) {
		this.teamScores.put(tm, scr);
		tm.updateScore();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        nameLabel = new javax.swing.JLabel();

        setBackground(Palette.getCurrentScheme().COLOR_ACTIVE.getColor());
        setMaximumSize(new java.awt.Dimension(2147483647, 35));
        setMinimumSize(new java.awt.Dimension(0, 35));
        setPreferredSize(new java.awt.Dimension(400, 35));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameLabel.setForeground(Palette.getCurrentScheme().COLOR_PRIMARY_TEXT.getColor());
        nameLabel.setText(this.name);
        nameLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(nameLabel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
		this.setBackground(Palette.getCurrentScheme().COLOR_MENU_MOUSE_OVER_BACK.getColor());
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
		this.setBackground(Palette.getCurrentScheme().COLOR_ACTIVE.getColor());
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
		JDialog md = EsportsGUI.getManagementDialog();
		EsportsGUI.setManager(this);
		md.setVisible(true);
		
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
}
