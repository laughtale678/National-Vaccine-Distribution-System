/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.CDC;

import business.Business;
import business.Organization.CDCOrganization;
import business.Organization.PHDOrganization;
import business.Organization.ProviderOrganization;
import business.UserAccount.UserAccount;
import business.Vaccine.Vaccine;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class CDCInventoryTrackingJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private CDCOrganization cdcOrganization;
    private Business business;

    /**
     * Creates new form ClinicInventoryManagementJPanel
     */
    public CDCInventoryTrackingJPanel(JPanel userProcessContainer, UserAccount account, CDCOrganization cdcOrganization, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.cdcOrganization = cdcOrganization;
        this.business = business;
        populateTbl();
    }

    private void populateTbl() {
        DefaultTableModel model = (DefaultTableModel) tblInventoryMgt.getModel();
        model.setRowCount(0);
        List<PHDOrganization> phdList = cdcOrganization.getPhdOrganizations();
        // need to modified
        for (PHDOrganization phd : phdList) {
            calculate(phd, model);
        }

    }

    private void calculate(PHDOrganization phd, DefaultTableModel model) {
        Map<Vaccine, Integer> summarizedStock = new HashMap<>();
        for (ProviderOrganization provider : phd.getProviders()) {
            Map<Vaccine, Integer> vaccineStock = provider.getVaccineInventory().getVaccineStock();
            for (Vaccine v : vaccineStock.keySet()) {
                int stock = vaccineStock.get(v);
                summarizedStock.put(v, summarizedStock.getOrDefault(v, 0) + stock);
            }
        }

        for (Vaccine vaccine : summarizedStock.keySet()) {
            Object[] row = new Object[5];
            for (Vaccine v : business.getVaccineCatalog().getVaccineList()) {
                if (v == vaccine) {
                    row[0] = phd.getName();
                    row[1] = phd.getState();
                    row[2] = v.getVaccineId();
                    row[3] = v;
                    row[4] = summarizedStock.get(v);
                }
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tblInventoryMgt = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1024, 768));

        tblInventoryMgt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblInventoryMgt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PHD", "State", "Vaccine ID", "Vaccine Name", "Stock Qty"
            }
        ));
        tblInventoryMgt.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblInventoryMgt);
        if (tblInventoryMgt.getColumnModel().getColumnCount() > 0) {
            tblInventoryMgt.getColumnModel().getColumn(0).setPreferredWidth(12);
            tblInventoryMgt.getColumnModel().getColumn(1).setPreferredWidth(8);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CDC Inventory Management");

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addGap(94, 94, 94)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(214, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblInventoryMgt;
    // End of variables declaration//GEN-END:variables
}
