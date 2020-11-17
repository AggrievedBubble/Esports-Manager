/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esportsapp;

import java.awt.*;
import java.io.File;
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
	
	T object;
	
	/**
	 * Creates new form ManagementDialog
	 */
	public ManagementDialog(T obj) {
		super(EsportsGUI.getFrames()[0], true);
		
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
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        iconLabel = new javax.swing.JLabel();
        applyButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

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

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(183, 100));

        descriptionTextArea.setColumns(20);
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
        jScrollPane1.setViewportView(descriptionTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        managementPanel.add(jScrollPane1, gridBagConstraints);

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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        managementPanel.add(applyButton, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        managementPanel.add(cancelButton, gridBagConstraints);

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

	JFileChooser chooser = new JFileChooser();
	
    private void iconLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconLabelMouseClicked
        // TODO add your handling code here:
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG & PNG Images", "jpeg", "jpg", "png");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(EsportsGUI.getFrames()[0]);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			if (chooser.getSelectedFile().exists()) {
				this.iconLabel.setIcon(new ImageIcon(new ImageIcon(chooser.getSelectedFile().getAbsolutePath()).getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
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
		if (this.chooser.getSelectedFile() == null || this.chooser.getSelectedFile().exists()){
			this.object.setIcon(new ImageIcon(chooser.getSelectedFile().getAbsolutePath()));
		}

		this.object.setDescription(this.descriptionTextArea.getText());
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JPanel dragBarPanel;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel managementPanel;
    protected javax.swing.JTextField nameField;
    // End of variables declaration//GEN-END:variables
}
