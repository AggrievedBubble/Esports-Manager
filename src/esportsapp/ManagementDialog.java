/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esportsapp;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author User
 * @param <T>
 */
public class ManagementDialog<T extends EsportsInterface> extends javax.swing.JDialog {

	private int posX;
	private int posY;
	
	Class<T> type;
	T object;
	
	JFileChooser chooser = new JFileChooser();
	
	private java.util.List<Member> awaiting_removal = new ArrayList<>();
	private java.util.List<Member> temp_members = new ArrayList<>();
	private ListComponent<Member> focussed_member_comp = null;
	private Map<EsportsInterface, ImageIcon> images_to_update = new HashMap();
	private Map<EsportsInterface, String> names_to_update = new HashMap();
	
	/**
	 * Creates new form ManagementDialog
	 */
	public ManagementDialog(Class<T> t, T obj) {
		super(EsportsGUI.getFrames()[0], true);
		
		this.type = t;
		this.object = obj;
		
		initComponents();
		this.setLocationRelativeTo(null);
		
		this.open();
	}
	
	private void open() {
		EsportsGUI.getComponentResizer().registerComponent(this);
		this.nameField.setText(this.object.getName());
		this.descriptionTextArea.setText(this.object.getDescription());
		this.iconLabel.setIcon(new ImageIcon(this.object.getIcon().getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		CardLayout card = (CardLayout)genericPanel.getLayout();
		card.show(genericPanel, this.type.getName());
		
		if (this.type.getName().equals("esportsapp.Event")) {
			
			//event prep
			
			addPanelScrollPane.getViewport().setOpaque(false);
			addPanelScrollPane.getVerticalScrollBar().setUnitIncrement(16);
			participantsPanelScrollPane.getViewport().setOpaque(false);
			participantsPanelScrollPane.getVerticalScrollBar().setUnitIncrement(16);
			addPanel.setVisible(false);
			java.util.List<Team> not_participating = new ArrayList<>();
			Team.list.stream()
				.map((t) -> (t))
				.forEach((t) -> {
					
					ListComponent<Team> comp = new ListComponent<>(t, (lc) -> {
						if (not_participating.contains(t)) {
							participantsPanelList.add(lc);
							addPanelList.remove(lc);
							not_participating.remove(t);
						} else {
							if (addPanel.isVisible()) {
								participantsPanelList.remove(lc);
								addPanelList.add(lc);
								not_participating.add(t);
							} else {
								String proposed_score = JOptionPane.showInputDialog(this, "What did Team \"" + lc.object.getName() + "\" score in this Event?").trim();
								if (proposed_score == null || proposed_score.equals("")) return;
								if (isInteger(proposed_score)) {
									this.object.getScores().put(lc.object, proposed_score);
									lc.getScoreLabel().setText(proposed_score);
								} else {
									JOptionPane.showMessageDialog(this, "\"" + proposed_score + "\" is not recognised as an integer");
								}
							}
						}
						addPanel.revalidate();
						addPanel.repaint();
						addPanelList.revalidate();
						addPanelList.repaint();
						participantsPanel.revalidate();
						participantsPanel.repaint();
						participantsPanelList.revalidate();
						participantsPanelList.repaint();
						
						applyButton.setEnabled(true);
					});
					
					if (this.object.getScores().get(t) == null) {
						comp.getScoreLabel().setText("");
					} else {
						comp.getScoreLabel().setText(String.valueOf(this.object.getScores().get(t)));
					}
					
					if (!this.object.getScores().containsKey(t)) {
						not_participating.add(t);
						addPanelList.add(comp);
						addPanelList.revalidate();
						addPanelList.repaint();
					} else {
						participantsPanelList.add(comp);
						participantsPanelList.revalidate();
						participantsPanelList.repaint();
					}
					
					
				});
		} else if (this.type.getName().equals("esportsapp.Team")) {
			
			//team prep
			
			membersListScrollPane.getViewport().setOpaque(false);
			membersListScrollPane.getVerticalScrollBar().setUnitIncrement(16);
			memberDescriptionScrollPane.getViewport().setOpaque(false);
			memberDescriptionScrollPane.getVerticalScrollBar().setUnitIncrement(16);
			
			for (Member m : new ArrayList<Member>(this.object.getScores().keySet())) {
				ListComponent<Member> member_lc = new ListComponent<>(m, (lc) -> {
				
				if (focussed_member_comp != null) {
					focussed_member_comp.setBackground(Palette.getCurrentScheme().COLOR_ACTIVE.getColor());
					focussed_member_comp.object.setDescription(memberDescriptionArea.getText());
				}
				
				lc.requestFocus();
				focussed_member_comp = lc;
				focussed_member_comp.setBackground(Palette.getCurrentScheme().COLOR_MENU_SELECTED_BACK.getColor());
				memberDescriptionArea.setText(lc.object.getDescription());
				
			});
			
			member_lc.getScoreLabel().setText("");
			membersListPanel.add(member_lc);
			membersListPanel.revalidate();
			membersListPanel.repaint();
			}
					
		} else if (this.type.getName().equals("esportsapp.Member")) {
			
			//member prep
			
			/*
			I originally planned to have a separate management dialog
			for members but then i decided to integrate member management
			into the team management dialog
			*/
			
		}
	}
	
	public static boolean isInteger(String str) {
    if (str == null) {
        return false;
    }
    int length = str.length();
    if (length == 0) {
        return false;
    }
    int i = 0;
    if (str.charAt(0) == '-') {
        if (length == 1) {
            return false;
        }
        i = 1;
    }
    for (; i < length; i++) {
        char c = str.charAt(i);
        if (c < '0' || c > '9') {
            return false;
        }
    }
    return true;
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

        mainPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        dragBarPanel = new javax.swing.JPanel();
        managementPanel = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        descriptionScrollPane = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        iconLabel = new javax.swing.JLabel();
        genericPanel = new javax.swing.JPanel();
        eventGenericLayeredPanel = new javax.swing.JLayeredPane();
        participantsListLabel = new javax.swing.JLabel();
        addPanelToggle = new javax.swing.JToggleButton();
        addPanel = new javax.swing.JPanel();
        addPanelScrollPane = new javax.swing.JScrollPane();
        addPanelList = new javax.swing.JPanel();
        participantsPanel = new javax.swing.JPanel();
        participantsPanelScrollPane = new javax.swing.JScrollPane();
        participantsPanelList = new javax.swing.JPanel();
        teamGenericPanel = new javax.swing.JPanel();
        membersListLabel = new javax.swing.JLabel();
        addRemoveMembersButtonPanel = new javax.swing.JPanel();
        removeMemberButton = new javax.swing.JButton();
        addMemberButton = new javax.swing.JButton();
        membersListScrollPane = new javax.swing.JScrollPane();
        membersListPanel = new javax.swing.JPanel();
        memberCustomizationPanel = new javax.swing.JPanel();
        memberCustomizationLabel = new javax.swing.JLabel();
        memberChangeIconButton = new javax.swing.JButton();
        memberDescriptionScrollPane = new javax.swing.JScrollPane();
        memberDescriptionArea = new javax.swing.JTextArea();
        memberChangeNameButton = new javax.swing.JButton();
        memberGenericPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(200, 300));
        setModal(true);
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(400, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        mainPanel.setBackground(Palette.getCurrentScheme().COLOR_MAIN.getColor());
        mainPanel.setLayout(new java.awt.GridBagLayout());

        closeButton.setBackground(Palette.getCurrentScheme().COLOR_MAIN.getColor());
        closeButton.setIcon(Palette.getCurrentScheme().ICON_CLOSE.getIcon());
        closeButton.setBorder(null);
        closeButton.setBorderPainted(false);
        closeButton.setFocusable(false);
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButtonMouseExited(evt);
            }
        });
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        mainPanel.add(closeButton, gridBagConstraints);

        dragBarPanel.setFocusable(false);
        dragBarPanel.setOpaque(false);
        dragBarPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                dragBarPanelMouseDragged(evt);
            }
        });
        dragBarPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dragBarPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout dragBarPanelLayout = new javax.swing.GroupLayout(dragBarPanel);
        dragBarPanel.setLayout(dragBarPanelLayout);
        dragBarPanelLayout.setHorizontalGroup(
            dragBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        dragBarPanelLayout.setVerticalGroup(
            dragBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        mainPanel.add(dragBarPanel, gridBagConstraints);

        managementPanel.setBackground(Palette.getCurrentScheme().COLOR_ACTIVE.getColor());
        managementPanel.setLayout(new java.awt.GridBagLayout());

        nameField.setBackground(Palette.getCurrentScheme().COLOR_INPUT_BACK.getColor());
        nameField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameField.setForeground(Palette.getCurrentScheme().COLOR_PRIMARY_TEXT.getColor());
        nameField.setText("Name");
        nameField.setBorder(null);
        nameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameFieldKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        managementPanel.add(nameField, gridBagConstraints);

        descriptionScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        descriptionScrollPane.setPreferredSize(new java.awt.Dimension(183, 100));

        descriptionTextArea.setColumns(10);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setRows(4);
        descriptionTextArea.setTabSize(4);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setPreferredSize(new java.awt.Dimension(164, 100));
        descriptionTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descriptionTextAreaKeyTyped(evt);
            }
        });
        descriptionScrollPane.setViewportView(descriptionTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        managementPanel.add(descriptionScrollPane, gridBagConstraints);

        iconLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        managementPanel.add(iconLabel, gridBagConstraints);

        genericPanel.setOpaque(false);
        genericPanel.setLayout(new java.awt.CardLayout());

        eventGenericLayeredPanel.setLayout(new java.awt.GridBagLayout());

        participantsListLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        participantsListLabel.setForeground(Palette.getCurrentScheme().COLOR_PRIMARY_TEXT.getColor()
        );
        participantsListLabel.setText("Participating Teams");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        eventGenericLayeredPanel.add(participantsListLabel, gridBagConstraints);

        addPanelToggle.setBackground(Palette.getCurrentScheme().COLOR_MENU_BACK.getColor());
        addPanelToggle.setForeground(Palette.getCurrentScheme().COLOR_MENU_FRONT.getColor());
        addPanelToggle.setText("+ / ‒");
        addPanelToggle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addPanelToggle.setContentAreaFilled(false);
        addPanelToggle.setFocusable(false);
        addPanelToggle.setMinimumSize(new java.awt.Dimension(35, 19));
        addPanelToggle.setPreferredSize(new java.awt.Dimension(35, 19));
        addPanelToggle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                addPanelToggleItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        eventGenericLayeredPanel.add(addPanelToggle, gridBagConstraints);

        addPanel.setBackground(Palette.getCurrentScheme().COLOR_MAIN.getColor());
        addPanel.setLayout(new java.awt.GridLayout(1, 0));

        addPanelScrollPane.setBorder(null);
        addPanelScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        addPanelScrollPane.setToolTipText("");
        addPanelScrollPane.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        addPanelScrollPane.setOpaque(false);

        addPanelList.setOpaque(false);
        addPanelList.setLayout(new javax.swing.BoxLayout(addPanelList, javax.swing.BoxLayout.Y_AXIS));
        addPanelScrollPane.setViewportView(addPanelList);

        addPanel.add(addPanelScrollPane);

        eventGenericLayeredPanel.setLayer(addPanel, javax.swing.JLayeredPane.POPUP_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 20, 20);
        eventGenericLayeredPanel.add(addPanel, gridBagConstraints);

        participantsPanel.setOpaque(false);
        participantsPanel.setLayout(new java.awt.GridLayout(1, 0));

        participantsPanelScrollPane.setBorder(null);
        participantsPanelScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        participantsPanelScrollPane.setToolTipText("");
        participantsPanelScrollPane.setOpaque(false);

        participantsPanelList.setBorder(javax.swing.BorderFactory.createLineBorder(Palette.getCurrentScheme().COLOR_MAIN.getColor()
        ));
        participantsPanelList.setOpaque(false);
        participantsPanelList.setLayout(new javax.swing.BoxLayout(participantsPanelList, javax.swing.BoxLayout.Y_AXIS));
        participantsPanelScrollPane.setViewportView(participantsPanelList);

        participantsPanel.add(participantsPanelScrollPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        eventGenericLayeredPanel.add(participantsPanel, gridBagConstraints);

        genericPanel.add(eventGenericLayeredPanel, "card5");
        eventGenericLayeredPanel.getAccessibleContext().setAccessibleName("esportsapp.Event");

        teamGenericPanel.setOpaque(false);
        teamGenericPanel.setLayout(new java.awt.GridBagLayout());

        membersListLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        membersListLabel.setForeground(Palette.getCurrentScheme().COLOR_PRIMARY_TEXT.getColor()
        );
        membersListLabel.setText("Members");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        teamGenericPanel.add(membersListLabel, gridBagConstraints);

        addRemoveMembersButtonPanel.setOpaque(false);
        addRemoveMembersButtonPanel.setLayout(new java.awt.GridBagLayout());

        removeMemberButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_BACK.getColor());
        removeMemberButton.setForeground(Palette.getCurrentScheme().COLOR_PRIMARY_TEXT.getColor());
        removeMemberButton.setText("‒");
        removeMemberButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        removeMemberButton.setContentAreaFilled(false);
        removeMemberButton.setFocusable(false);
        removeMemberButton.setPreferredSize(new java.awt.Dimension(30, 25));
        removeMemberButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeMemberButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeMemberButtonMouseExited(evt);
            }
        });
        removeMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMemberButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        addRemoveMembersButtonPanel.add(removeMemberButton, gridBagConstraints);

        addMemberButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_BACK.getColor());
        addMemberButton.setForeground(Palette.getCurrentScheme().COLOR_PRIMARY_TEXT.getColor());
        addMemberButton.setText("+");
        addMemberButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addMemberButton.setContentAreaFilled(false);
        addMemberButton.setFocusPainted(false);
        addMemberButton.setPreferredSize(new java.awt.Dimension(30, 25));
        addMemberButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMemberButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMemberButtonMouseExited(evt);
            }
        });
        addMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        addRemoveMembersButtonPanel.add(addMemberButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        teamGenericPanel.add(addRemoveMembersButtonPanel, gridBagConstraints);

        membersListScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        membersListScrollPane.setOpaque(false);

        membersListPanel.setOpaque(false);
        membersListPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        membersListPanel.setLayout(new javax.swing.BoxLayout(membersListPanel, javax.swing.BoxLayout.Y_AXIS));
        membersListScrollPane.setViewportView(membersListPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        teamGenericPanel.add(membersListScrollPane, gridBagConstraints);

        memberCustomizationPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(Palette.getCurrentScheme().COLOR_SEPARATOR.getColor(), 2), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        memberCustomizationPanel.setOpaque(false);
        memberCustomizationPanel.setLayout(new java.awt.GridBagLayout());

        memberCustomizationLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        memberCustomizationLabel.setForeground(Palette.getCurrentScheme().COLOR_PRIMARY_TEXT.getColor()
        );
        memberCustomizationLabel.setText("Member Customization");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        memberCustomizationPanel.add(memberCustomizationLabel, gridBagConstraints);

        memberChangeIconButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_BACK.getColor());
        memberChangeIconButton.setForeground(Palette.getCurrentScheme().COLOR_PRIMARY_TEXT.getColor());
        memberChangeIconButton.setText("Change Icon");
        memberChangeIconButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        memberChangeIconButton.setContentAreaFilled(false);
        memberChangeIconButton.setPreferredSize(new java.awt.Dimension(75, 25));
        memberChangeIconButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                memberChangeIconButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                memberChangeIconButtonMouseExited(evt);
            }
        });
        memberChangeIconButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberChangeIconButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        memberCustomizationPanel.add(memberChangeIconButton, gridBagConstraints);

        memberDescriptionArea.setColumns(20);
        memberDescriptionArea.setLineWrap(true);
        memberDescriptionArea.setRows(5);
        memberDescriptionArea.setWrapStyleWord(true);
        memberDescriptionArea.setPreferredSize(new java.awt.Dimension(0, 0));
        memberDescriptionArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                memberDescriptionAreaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                memberDescriptionAreaKeyTyped(evt);
            }
        });
        memberDescriptionScrollPane.setViewportView(memberDescriptionArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        memberCustomizationPanel.add(memberDescriptionScrollPane, gridBagConstraints);

        memberChangeNameButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_BACK.getColor());
        memberChangeNameButton.setForeground(Palette.getCurrentScheme().COLOR_PRIMARY_TEXT.getColor());
        memberChangeNameButton.setText("Change Name");
        memberChangeNameButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        memberChangeNameButton.setContentAreaFilled(false);
        memberChangeNameButton.setPreferredSize(new java.awt.Dimension(80, 25));
        memberChangeNameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                memberChangeNameButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                memberChangeNameButtonMouseExited(evt);
            }
        });
        memberChangeNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberChangeNameButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        memberCustomizationPanel.add(memberChangeNameButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        teamGenericPanel.add(memberCustomizationPanel, gridBagConstraints);

        genericPanel.add(teamGenericPanel, "esportsapp.Team");

        memberGenericPanel.setOpaque(false);
        memberGenericPanel.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("jLabel2");
        memberGenericPanel.add(jLabel2, new java.awt.GridBagConstraints());

        genericPanel.add(memberGenericPanel, "esportsapp.Member");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        managementPanel.add(genericPanel, gridBagConstraints);

        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new java.awt.GridBagLayout());

        cancelButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_BACK.getColor());
        cancelButton.setForeground(Palette.getCurrentScheme().COLOR_PRIMARY_TEXT.getColor());
        cancelButton.setText("Cancel");
        cancelButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancelButton.setContentAreaFilled(false);
        cancelButton.setFocusable(false);
        cancelButton.setPreferredSize(new java.awt.Dimension(50, 25));
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelButtonMouseExited(evt);
            }
        });
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        buttonPanel.add(cancelButton, gridBagConstraints);

        applyButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_BACK.getColor());
        applyButton.setForeground(Palette.getCurrentScheme().COLOR_PRIMARY_TEXT.getColor());
        applyButton.setText("Apply");
        applyButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        applyButton.setContentAreaFilled(false);
        applyButton.setEnabled(false);
        applyButton.setFocusable(false);
        applyButton.setPreferredSize(new java.awt.Dimension(50, 25));
        applyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                applyButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                applyButtonMouseExited(evt);
            }
        });
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        buttonPanel.add(applyButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        managementPanel.add(buttonPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        mainPanel.add(managementPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(mainPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseEntered
        // TODO add your handling code here:
        closeButton.setIcon(Palette.getCurrentScheme().ICON_CLOSE_MOUSE_OVER.getIcon());
        closeButton.setBackground(Palette.getCurrentScheme().COLOR_CLOSE_MOUSE_OVER.getColor());
    }//GEN-LAST:event_closeButtonMouseEntered

    private void closeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseExited
        // TODO add your handling code here:
        closeButton.setIcon(Palette.getCurrentScheme().ICON_CLOSE.getIcon());
        closeButton.setBackground(Palette.getCurrentScheme().COLOR_MAIN.getColor());
    }//GEN-LAST:event_closeButtonMouseExited

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void dragBarPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragBarPanelMouseDragged
        // TODO add your handling code here:
        Rectangle rectangle = this.getBounds();
        this.setBounds(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY, rectangle.width, rectangle.height);
    }//GEN-LAST:event_dragBarPanelMouseDragged

    private void dragBarPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragBarPanelMousePressed
        // TODO add your handling code here:
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_dragBarPanelMousePressed

    private void applyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applyButtonMouseEntered
        // TODO add your handling code here:
		applyButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_MOUSE_OVER_BACK.getColor());
		applyButton.setForeground(Palette.getCurrentScheme().COLOR_MENU_MOUSE_OVER_FRONT.getColor());
    }//GEN-LAST:event_applyButtonMouseEntered

    private void applyButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applyButtonMouseExited
        // TODO add your handling code here:
		applyButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_BACK.getColor());
		applyButton.setForeground(Palette.getCurrentScheme().COLOR_MENU_FRONT.getColor());
    }//GEN-LAST:event_applyButtonMouseExited

    private void cancelButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseEntered
        // TODO add your handling code here:
		cancelButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_MOUSE_OVER_BACK.getColor());
		cancelButton.setForeground(Palette.getCurrentScheme().COLOR_MENU_MOUSE_OVER_FRONT.getColor());
    }//GEN-LAST:event_cancelButtonMouseEntered

    private void cancelButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseExited
        // TODO add your handling code here:
		cancelButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_BACK.getColor());
		cancelButton.setForeground(Palette.getCurrentScheme().COLOR_MENU_FRONT.getColor());
    }//GEN-LAST:event_cancelButtonMouseExited
	
    private void iconLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconLabelMouseClicked
        // TODO add your handling code here:
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG & PNG Images", "jpeg", "jpg", "png");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(EsportsGUI.getFrames()[0]);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			if (chooser.getSelectedFile().exists()) {
				this.iconLabel.setIcon(new ImageIcon(new ImageIcon(chooser.getSelectedFile().getAbsolutePath()).getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
				images_to_update.put(this.object, new ImageIcon(chooser.getSelectedFile().getAbsolutePath()));
				this.applyButton.setEnabled(true);
			}
	    }
    }//GEN-LAST:event_iconLabelMouseClicked

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        // TODO add your handling code here:
		if (!this.nameField.getText().equals("")) {
			this.object.setName(this.nameField.getText());
		} else {
			JOptionPane.showMessageDialog(this, "Name cannot be empty!");
			return;
		}
		
		this.object.setDescription(this.descriptionTextArea.getText());
		
		images_to_update.forEach((obj, img) -> {
			obj.setIcon(img);
		});
		
		names_to_update.forEach((obj, name) -> {
			obj.setName(name);
		});
		
		if (this.type.getName().equals("esportsapp.Event")) {
		
			/*
			apply code for event dialogs
			*/
			
			for (Component tc : addPanelList.getComponents()) {
				ListComponent<Team> tlc = (ListComponent<Team>)tc;
				this.object.getScores().remove(tlc.object.get());
				tlc.object.updateScore();
			}
			
			for (Component tc : participantsPanelList.getComponents()) {
				ListComponent<Team> tlc = (ListComponent<Team>) tc;
				if (!this.object.getScores().containsKey(tlc.object)) this.object.getScores().put(tlc.object, 0);
				tlc.object.updateScore();
			}
			
		} else if (this.type.getName().equals("esportsapp.Team")) {
			
			/*
			apply code for team dialog (currently handles members too)
			*/
			
			awaiting_removal.clear();
			temp_members.clear();
			
		} else if (this.type.getName().equals("esportsapp.Member")) {
			
			/*
			apply code for member dialog (redundant)
			*/
			
		}
			
		this.applyButton.setEnabled(false);
    }//GEN-LAST:event_applyButtonActionPerformed

    private void nameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyTyped
        // TODO add your handling code here:
		this.applyButton.setEnabled(true);
    }//GEN-LAST:event_nameFieldKeyTyped

    private void descriptionTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descriptionTextAreaKeyTyped
        // TODO add your handling code here:
        this.applyButton.setEnabled(true);
    }//GEN-LAST:event_descriptionTextAreaKeyTyped

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
		for (Member m : temp_members) {
			Member.list.remove(m);
		}
		for (Member m : awaiting_removal) {
			Member.list.add(m);
			this.object.getScores().put(m, m.getScore());
		}
		temp_members.clear();
		awaiting_removal.clear();
		this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addPanelToggleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_addPanelToggleItemStateChanged
        // TODO add your handling code here:
		addPanel.setVisible(addPanelToggle.isSelected());
		if (addPanelToggle.isSelected()) {
			addPanelToggle.setBackground(Palette.getCurrentScheme().COLOR_MAIN.getColor());
			addPanelToggle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		} else {
			addPanelToggle.setBackground(Palette.getCurrentScheme().COLOR_MENU_BACK.getColor());
			addPanelToggle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		}
    }//GEN-LAST:event_addPanelToggleItemStateChanged

    private void memberChangeIconButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberChangeIconButtonActionPerformed
        // TODO add your handling code here:
		if (focussed_member_comp != null) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG & PNG Images", "jpeg", "jpg", "png");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(EsportsGUI.getFrames()[0]);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				if (chooser.getSelectedFile().exists()) {
					this.focussed_member_comp.getIconLabel().setIcon(new ImageIcon(new ImageIcon(chooser.getSelectedFile().getAbsolutePath()).getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
					images_to_update.put(focussed_member_comp.object, new ImageIcon(chooser.getSelectedFile().getAbsolutePath()));
					this.applyButton.setEnabled(true);
				}
			}
		}
		
    }//GEN-LAST:event_memberChangeIconButtonActionPerformed

    private void memberChangeNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberChangeNameButtonActionPerformed
        // TODO add your handling code here:
		if (focussed_member_comp != null) {
			String proposedName = JOptionPane.showInputDialog(this, "Please enter a name:").trim();
			if (proposedName == null || proposedName.equals("")) return;
			boolean nameTaken = false;
			for (Member m : temp_members) {
				if (m.getName().equals(proposedName.trim())) {
					JOptionPane.showMessageDialog(this, "Member name \"" + proposedName + "\" is already used in this team");
					nameTaken = true;
				}
			}
			String name = proposedName.trim();
			if (!nameTaken) {
				names_to_update.put(focussed_member_comp.object, name);
				focussed_member_comp.getNameLabel().setText(name);

				applyButton.setEnabled(true);
			}
		}
    }//GEN-LAST:event_memberChangeNameButtonActionPerformed

    private void removeMemberButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMemberButtonMouseEntered
        // TODO add your handling code here:
		removeMemberButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_MOUSE_OVER_BACK.getColor());
		removeMemberButton.setForeground(Palette.getCurrentScheme().COLOR_MENU_MOUSE_OVER_FRONT.getColor());
    }//GEN-LAST:event_removeMemberButtonMouseEntered

    private void removeMemberButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMemberButtonMouseExited
        // TODO add your handling code here:
		removeMemberButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_BACK.getColor());
		removeMemberButton.setForeground(Palette.getCurrentScheme().COLOR_MENU_FRONT.getColor());
    }//GEN-LAST:event_removeMemberButtonMouseExited

    private void removeMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMemberButtonActionPerformed
        // TODO add your handling code here:
		if (focussed_member_comp != null) {
			awaiting_removal.add(focussed_member_comp.object);
			Member.list.remove(focussed_member_comp.object);
			membersListPanel.remove(focussed_member_comp);
			membersListPanel.revalidate();
			membersListPanel.repaint();
			temp_members.remove(focussed_member_comp.object);
			this.object.getScores().remove(focussed_member_comp.object);
			focussed_member_comp = null;
			applyButton.setEnabled(true);
			memberDescriptionArea.setText("");
		}
    }//GEN-LAST:event_removeMemberButtonActionPerformed

    private void addMemberButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMemberButtonMouseEntered
        // TODO add your handling code here:
		addMemberButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_MOUSE_OVER_BACK.getColor());
		addMemberButton.setForeground(Palette.getCurrentScheme().COLOR_MENU_MOUSE_OVER_FRONT.getColor());
    }//GEN-LAST:event_addMemberButtonMouseEntered

    private void addMemberButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMemberButtonMouseExited
        // TODO add your handling code here:
		addMemberButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_BACK.getColor());
		addMemberButton.setForeground(Palette.getCurrentScheme().COLOR_MENU_FRONT.getColor());
    }//GEN-LAST:event_addMemberButtonMouseExited

    private void addMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberButtonActionPerformed
        // TODO add your handling code here:
		String proposedName = JOptionPane.showInputDialog(this, "Please enter a name:").trim();
		if (proposedName == null || proposedName.equals("")) return;
		boolean nameTaken = false;
		for (Member m : new ArrayList<Member>(this.object.getScores().keySet())) {
			if (m.getName().equals(proposedName)) {
				JOptionPane.showMessageDialog(this, "Member name \"" + proposedName + "\" is already used in this Team");
				nameTaken = true;
			}
		}
		
		if (!nameTaken) {
			String name = proposedName.trim();
			Member new_member = Member.add(name, (Team)this.object.get());
			temp_members.add(new_member);
			ListComponent<Member> member_lc = new ListComponent<>(new_member, (lc) -> {
				
				if (focussed_member_comp != null) {
					focussed_member_comp.setBackground(Palette.getCurrentScheme().COLOR_ACTIVE.getColor());
					focussed_member_comp.object.setDescription(memberDescriptionArea.getText());
				}
				
				lc.requestFocus();
				focussed_member_comp = lc;
				focussed_member_comp.setBackground(Palette.getCurrentScheme().COLOR_MENU_SELECTED_BACK.getColor());
				memberDescriptionArea.setText(lc.object.getDescription());
				
			});
			
			member_lc.getScoreLabel().setText("");
			membersListPanel.add(member_lc);
			membersListPanel.revalidate();
			membersListPanel.repaint();
			applyButton.setEnabled(true);
		}
    }//GEN-LAST:event_addMemberButtonActionPerformed

    private void memberChangeIconButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberChangeIconButtonMouseEntered
        // TODO add your handling code here:
		memberChangeIconButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_MOUSE_OVER_BACK.getColor());
		memberChangeIconButton.setForeground(Palette.getCurrentScheme().COLOR_MENU_MOUSE_OVER_FRONT.getColor());
    }//GEN-LAST:event_memberChangeIconButtonMouseEntered

    private void memberChangeIconButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberChangeIconButtonMouseExited
        // TODO add your handling code here:
		memberChangeIconButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_BACK.getColor());
		memberChangeIconButton.setForeground(Palette.getCurrentScheme().COLOR_MENU_FRONT.getColor());
    }//GEN-LAST:event_memberChangeIconButtonMouseExited

    private void memberChangeNameButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberChangeNameButtonMouseEntered
        // TODO add your handling code here:
		memberChangeNameButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_MOUSE_OVER_BACK.getColor());
		memberChangeNameButton.setForeground(Palette.getCurrentScheme().COLOR_MENU_MOUSE_OVER_FRONT.getColor());
    }//GEN-LAST:event_memberChangeNameButtonMouseEntered

    private void memberChangeNameButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberChangeNameButtonMouseExited
        // TODO add your handling code here:
		memberChangeNameButton.setBackground(Palette.getCurrentScheme().COLOR_MENU_BACK.getColor());
		memberChangeNameButton.setForeground(Palette.getCurrentScheme().COLOR_MENU_FRONT.getColor());
    }//GEN-LAST:event_memberChangeNameButtonMouseExited

    private void memberDescriptionAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memberDescriptionAreaKeyTyped
        // TODO add your handling code here:
		applyButton.setEnabled(true);
    }//GEN-LAST:event_memberDescriptionAreaKeyTyped

    private void memberDescriptionAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memberDescriptionAreaKeyReleased
        // TODO add your handling code here:
		if (focussed_member_comp != null) focussed_member_comp.object.setDescription(memberDescriptionArea.getText());
    }//GEN-LAST:event_memberDescriptionAreaKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMemberButton;
    private javax.swing.JPanel addPanel;
    private javax.swing.JPanel addPanelList;
    private javax.swing.JScrollPane addPanelScrollPane;
    private javax.swing.JToggleButton addPanelToggle;
    private javax.swing.JPanel addRemoveMembersButtonPanel;
    private javax.swing.JButton applyButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JScrollPane descriptionScrollPane;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JPanel dragBarPanel;
    private javax.swing.JLayeredPane eventGenericLayeredPanel;
    private javax.swing.JPanel genericPanel;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel managementPanel;
    private javax.swing.JButton memberChangeIconButton;
    private javax.swing.JButton memberChangeNameButton;
    private javax.swing.JLabel memberCustomizationLabel;
    private javax.swing.JPanel memberCustomizationPanel;
    private javax.swing.JTextArea memberDescriptionArea;
    private javax.swing.JScrollPane memberDescriptionScrollPane;
    private javax.swing.JPanel memberGenericPanel;
    private javax.swing.JLabel membersListLabel;
    private javax.swing.JPanel membersListPanel;
    private javax.swing.JScrollPane membersListScrollPane;
    protected javax.swing.JTextField nameField;
    private javax.swing.JLabel participantsListLabel;
    private javax.swing.JPanel participantsPanel;
    private javax.swing.JPanel participantsPanelList;
    private javax.swing.JScrollPane participantsPanelScrollPane;
    private javax.swing.JButton removeMemberButton;
    private javax.swing.JPanel teamGenericPanel;
    // End of variables declaration//GEN-END:variables
}
