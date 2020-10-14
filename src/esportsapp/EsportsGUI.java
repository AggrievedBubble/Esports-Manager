/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esportsapp;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.io.File;
import java.io.IOException;
import javax.swing.JColorChooser;

/**
 *
 * @author User
 */

public class EsportsGUI extends javax.swing.JFrame {

    /**
     * Creates new form EsportsGUI
     */
    public EsportsGUI() {
        initComponents();
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

        MainPanel = new javax.swing.JPanel();
        ODWButton = new javax.swing.JButton();
        TeamManegementPane = new javax.swing.JTabbedPane();
        Team1 = new javax.swing.JPanel();
        TeamMembersScrollPane = new javax.swing.JScrollPane();
        TeamMembersList = new javax.swing.JList<>();
        TeamEventsScrollPane = new javax.swing.JScrollPane();
        TeamEventsList = new javax.swing.JList<>();
        TeamRenameButton = new javax.swing.JButton();
        TeamAddMember = new javax.swing.JButton();
        TeamRemoveMember = new javax.swing.JButton();
        MembersLabel = new javax.swing.JLabel();
        EventsLabel = new javax.swing.JLabel();
        EventManagementPane = new javax.swing.JTabbedPane();
        Event1 = new javax.swing.JPanel();
        EventTeamsScrollPane = new javax.swing.JScrollPane();
        EventTeamsList = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        EventRenameButton = new javax.swing.JButton();
        EventAddTeam = new javax.swing.JButton();
        EventRemoveTeam = new javax.swing.JButton();
        TeamsLabel = new javax.swing.JLabel();
        TeamMembersLabel = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        NewTeamButton = new javax.swing.JMenuItem();
        NewEventButton = new javax.swing.JMenuItem();
        OptionsMenu = new javax.swing.JMenu();
        AlwaysOnTopMenuCheck = new javax.swing.JCheckBoxMenuItem();
        ColorMenuButton = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Esports Manager");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        MainPanel.setBackground(new java.awt.Color(255, 69, 0));
        java.awt.GridBagLayout MainPanelLayout = new java.awt.GridBagLayout();
        MainPanelLayout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        MainPanelLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
        MainPanel.setLayout(MainPanelLayout);

        ODWButton.setText("Open Display Window");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        MainPanel.add(ODWButton, gridBagConstraints);

        TeamManegementPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        Team1.setLayout(new java.awt.GridBagLayout());

        TeamMembersList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Member1", "Member2", "Member3", "Member4", "Member5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        TeamMembersList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TeamMembersScrollPane.setViewportView(TeamMembersList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        Team1.add(TeamMembersScrollPane, gridBagConstraints);

        TeamEventsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Event1", "Event2", "Event3", "Event4", "Event5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        TeamEventsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TeamEventsScrollPane.setViewportView(TeamEventsList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        Team1.add(TeamEventsScrollPane, gridBagConstraints);

        TeamRenameButton.setText("Rename");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        Team1.add(TeamRenameButton, gridBagConstraints);

        TeamAddMember.setText("+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        Team1.add(TeamAddMember, gridBagConstraints);

        TeamRemoveMember.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        Team1.add(TeamRemoveMember, gridBagConstraints);

        MembersLabel.setText("Members:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        Team1.add(MembersLabel, gridBagConstraints);

        EventsLabel.setText("Events:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        Team1.add(EventsLabel, gridBagConstraints);

        TeamManegementPane.addTab("Team Template", Team1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        MainPanel.add(TeamManegementPane, gridBagConstraints);

        EventManagementPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        Event1.setLayout(new java.awt.GridBagLayout());

        EventTeamsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Team1", "Team2", "Team3", "Team4", "Team5", "Team6" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        EventTeamsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        EventTeamsScrollPane.setViewportView(EventTeamsList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        Event1.add(EventTeamsScrollPane, gridBagConstraints);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Member1", "Member2", "Member3", "Member4", "Member5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        Event1.add(jScrollPane1, gridBagConstraints);

        EventRenameButton.setText("Rename");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        Event1.add(EventRenameButton, gridBagConstraints);

        EventAddTeam.setText("+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        Event1.add(EventAddTeam, gridBagConstraints);

        EventRemoveTeam.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        Event1.add(EventRemoveTeam, gridBagConstraints);

        TeamsLabel.setText("Teams:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        Event1.add(TeamsLabel, gridBagConstraints);

        TeamMembersLabel.setText("Team Members:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        Event1.add(TeamMembersLabel, gridBagConstraints);

        EventManagementPane.addTab("Event Template", Event1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        MainPanel.add(EventManagementPane, gridBagConstraints);

        getContentPane().add(MainPanel);

        FileMenu.setText("File");

        NewTeamButton.setText("New Team");
        NewTeamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewTeamButtonActionPerformed(evt);
            }
        });
        FileMenu.add(NewTeamButton);

        NewEventButton.setText("New Event");
        NewEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewEventButtonActionPerformed(evt);
            }
        });
        FileMenu.add(NewEventButton);

        Menu.add(FileMenu);

        OptionsMenu.setText("Options");

        AlwaysOnTopMenuCheck.setText("Always On Top");
        AlwaysOnTopMenuCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlwaysOnTopMenuCheckActionPerformed(evt);
            }
        });
        OptionsMenu.add(AlwaysOnTopMenuCheck);

        ColorMenuButton.setText("Change Background Color");
        ColorMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorMenuButtonActionPerformed(evt);
            }
        });
        OptionsMenu.add(ColorMenuButton);

        Menu.add(OptionsMenu);

        setJMenuBar(Menu);

        setSize(new java.awt.Dimension(736, 519));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NewTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewTeamButtonActionPerformed
        // TODO add your handling code here:
		String name = JOptionPane.showInputDialog(this, "Team Name:");
		
		if (name == null || name.equals("")) {
			return;
		} else {
			Boolean[] name_taken = {false};
			Team.TeamList.forEach((t) -> {
				if (t.TeamName.equals(name)) {
					JOptionPane.showMessageDialog(this, "Team Name \"%\" is already in use".replace("%", name));
					name_taken[0] = true;
					return;
				}
			});
			if (!name_taken[0]) new Team(name);
			
		}
		
    }//GEN-LAST:event_NewTeamButtonActionPerformed

    private void NewEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewEventButtonActionPerformed
        // TODO add your handling code here:
		String name = JOptionPane.showInputDialog(this, "Event Name:");
		
		if (name == null || name.equals("")) {
			return;
		} else {
			Boolean[] name_taken = {false};
			Event.EventList.forEach((e) -> {
				if (e.EventName.equals(name)) {
					JOptionPane.showMessageDialog(this, "Event Name \"%\" is already in use".replace("%", name));
					name_taken[0] = true;
					return;
				}
			});
			if (!name_taken[0]) new Event(name);
			
		}
    }//GEN-LAST:event_NewEventButtonActionPerformed

    private void ColorMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorMenuButtonActionPerformed
        // TODO add your handling code here:
		Color selected_color = JColorChooser.showDialog(this, "Choose Background Color", Color.decode("0xFF4500"));
		MainPanel.setBackground(selected_color);
    }//GEN-LAST:event_ColorMenuButtonActionPerformed

    private void AlwaysOnTopMenuCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlwaysOnTopMenuCheckActionPerformed
        // TODO add your handling code here:
		this.setAlwaysOnTop(AlwaysOnTopMenuCheck.isSelected());
    }//GEN-LAST:event_AlwaysOnTopMenuCheckActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EsportsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EsportsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EsportsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EsportsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EsportsGUI().setVisible(true);
            }
        });
		
		//create default team and event
		//new Team("Team1");
		//new Event("Event1");
		
    }
	
	//returns the teams tabbed pane to the Team constructor
	public static JTabbedPane getTeamManagementPane() {
		return TeamManegementPane;
	}
	
	//returns the events tabbed pane to the Event constructor
	public static JTabbedPane getEventManagementPane() {
		return EventManagementPane;
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem AlwaysOnTopMenuCheck;
    private javax.swing.JMenuItem ColorMenuButton;
    private javax.swing.JPanel Event1;
    private javax.swing.JButton EventAddTeam;
    public static javax.swing.JTabbedPane EventManagementPane;
    private javax.swing.JButton EventRemoveTeam;
    private javax.swing.JButton EventRenameButton;
    private javax.swing.JList<String> EventTeamsList;
    private javax.swing.JScrollPane EventTeamsScrollPane;
    private javax.swing.JLabel EventsLabel;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel MembersLabel;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenuItem NewEventButton;
    private javax.swing.JMenuItem NewTeamButton;
    private javax.swing.JButton ODWButton;
    private javax.swing.JMenu OptionsMenu;
    private javax.swing.JPanel Team1;
    private javax.swing.JButton TeamAddMember;
    private javax.swing.JList<String> TeamEventsList;
    private javax.swing.JScrollPane TeamEventsScrollPane;
    public static javax.swing.JTabbedPane TeamManegementPane;
    private javax.swing.JLabel TeamMembersLabel;
    private javax.swing.JList<String> TeamMembersList;
    private javax.swing.JScrollPane TeamMembersScrollPane;
    private javax.swing.JButton TeamRemoveMember;
    private javax.swing.JButton TeamRenameButton;
    private javax.swing.JLabel TeamsLabel;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
