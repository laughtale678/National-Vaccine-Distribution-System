/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Admin;

import business.Organization.CDCOrganization;
import business.Organization.ClinicOrganization;
import business.Organization.Organization;
import business.Organization.OrganizationDirectory;
import business.Organization.PHDOrganization;
import business.Organization.ProviderOrganization;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class ManageOrganizationJPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private JPanel userProcessContainer;

    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageOrganizationJPanel(JPanel userProcessContainer, OrganizationDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        populateTable();
        populateCmbOrganization();
    }

    private void populateCmbOrganization() {
        cmbOrganizations.removeAllItems();
        for (Organization.Type type : Organization.Type.values()) {
            if (!type.getValue().equals(Organization.Type.Admin.getValue())) {
                cmbOrganizations.addItem(type);
            }
        }
    }

    private void populateParentOrganizationCombo(Organization.Type selectedType) {
        cmbParentOrganization.removeAllItems();

        //Organization.Type selectedType = (Organization.Type) cmbOrganizations.getSelectedItem();
        if (selectedType == Organization.Type.Clinic) {
            for (Organization organization : directory.getOrganizationList()) {
                if (organization instanceof ProviderOrganization) {
                    cmbParentOrganization.addItem(organization);
                }
            }
        } else if (selectedType == Organization.Type.Provider) {
            for (Organization organization : directory.getOrganizationList()) {
                if (organization instanceof PHDOrganization) {
                    cmbParentOrganization.addItem(organization);
                }
            }
        } else if (selectedType == Organization.Type.PHD) {
            for (Organization organization : directory.getOrganizationList()) {
                if (organization instanceof CDCOrganization) {
                    cmbParentOrganization.addItem(organization);
                }
            }
        }
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblOrganizations.getModel();

        model.setRowCount(0);

        for (Organization organization : directory.getOrganizationList()) {
            Object[] row = new Object[4];
            row[0] = organization.getOrganizationID();
            row[1] = organization.getName();
            row[2] = organization.getType().getValue();
            if (organization instanceof ClinicOrganization) {
                row[3] = ((ClinicOrganization) organization).getParentProvider();
            } else if (organization instanceof ProviderOrganization) {
                row[3] = ((ProviderOrganization) organization).getParentPHD();
            } else if (organization instanceof PHDOrganization) {
                row[3] = ((PHDOrganization) organization).getParentCDC();
            } else {
                row[3] = "-";
            }
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOrganizationAdd = new javax.swing.JLabel();
        lblSelectOrgType1 = new javax.swing.JLabel();
        cmbParentOrganization = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrganizations = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        cmbOrganizations = new javax.swing.JComboBox();
        lblSelectOrgType = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblOrganizationList = new javax.swing.JLabel();
        lblSelectOrgType2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblSelectOrgType3 = new javax.swing.JLabel();
        txtState = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1024, 768));

        lblOrganizationAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblOrganizationAdd.setText("Add Organization:");

        lblSelectOrgType1.setText("Select Parent Organization:");

        cmbParentOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbParentOrganizationActionPerformed(evt);
            }
        });

        tblOrganizations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Type", "Parent Organization"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOrganizations);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        cmbOrganizations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationsActionPerformed(evt);
            }
        });

        lblSelectOrgType.setText("Select Organization Type:");

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Manage Organizations");

        lblOrganizationList.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblOrganizationList.setText("Organization List:");

        lblSelectOrgType2.setText("        Organization Name:");

        lblSelectOrgType3.setText("State:");

        txtState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnBack)
                        .addGap(29, 29, 29)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrganizationAdd)
                            .addComponent(lblOrganizationList)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSelectOrgType, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSelectOrgType2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblSelectOrgType3)
                                        .addComponent(lblSelectOrgType1)))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName)
                                    .addComponent(cmbOrganizations, 0, 209, Short.MAX_VALUE)
                                    .addComponent(cmbParentOrganization, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtState))))))
                .addContainerGap(215, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(lblOrganizationList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblOrganizationAdd)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectOrgType2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectOrgType)
                    .addComponent(cmbOrganizations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectOrgType1)
                    .addComponent(cmbParentOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSelectOrgType3)
                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAdd)
                .addContainerGap(290, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbParentOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbParentOrganizationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbParentOrganizationActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:

        // Check if organization type is selected
        if (cmbOrganizations.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Please select an organization type.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if organization name is entered
        String organizationName = txtName.getText().trim();
        if (organizationName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the organization name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if organization state is entered if type is PHD
        Organization.Type type = (Organization.Type) cmbOrganizations.getSelectedItem();
        String stateName = txtState.getText().trim();
        if (type == Organization.Type.PHD) {
            if (stateName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the state name for PHD.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        //Create organization
        if (type == Organization.Type.CDC || type == Organization.Type.Distributor) {
            // These types do not require parent organization
            directory.createOrganization(type, organizationName);
        } else {
            // Check if a valid parent organization is selected
            Organization parentOrganization = (Organization) cmbParentOrganization.getSelectedItem();
            if (parentOrganization == null) {
                JOptionPane.showMessageDialog(null, "Please select a valid parent organization.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Now create the organization and handle parent relationship
            Organization organization = directory.createOrganization(type, parentOrganization, organizationName);
            //for PHD organization set state
            if (type == Organization.Type.PHD) {
                ((PHDOrganization) organization).setState(stateName);
            }
        }

        populateTable();
        JOptionPane.showMessageDialog(null, "Created successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);
        cmbOrganizations.setSelectedItem(null);
        cmbParentOrganization.setSelectedItem(null);
        txtName.setText("");
        txtState.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void cmbOrganizationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationsActionPerformed
        // TODO add your handling code here:
        Organization.Type selectedType = (Organization.Type) cmbOrganizations.getSelectedItem();
        populateParentOrganizationCombo(selectedType);
        if (selectedType == Organization.Type.CDC || selectedType == Organization.Type.Distributor) {
            cmbParentOrganization.setEnabled(false);
        } else {
            cmbParentOrganization.setEnabled(true);
        }
        if (selectedType == Organization.Type.PHD) {
            txtState.setEnabled(true);
        } else {
            txtState.setEnabled(false);
        }
    }//GEN-LAST:event_cmbOrganizationsActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox cmbOrganizations;
    private javax.swing.JComboBox cmbParentOrganization;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrganizationAdd;
    private javax.swing.JLabel lblOrganizationList;
    private javax.swing.JLabel lblSelectOrgType;
    private javax.swing.JLabel lblSelectOrgType1;
    private javax.swing.JLabel lblSelectOrgType2;
    private javax.swing.JLabel lblSelectOrgType3;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblOrganizations;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtState;
    // End of variables declaration//GEN-END:variables
}
