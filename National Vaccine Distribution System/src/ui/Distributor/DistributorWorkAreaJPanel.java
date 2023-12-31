/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Distributor;

import business.Business;
import business.Organization.DistributorOrganization;
import business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author mac
 */
public class DistributorWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    UserAccount account;
    DistributorOrganization distributorOrganization;
    Business business;

    public DistributorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, DistributorOrganization distributorOrganization, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.distributorOrganization = distributorOrganization;
        this.business = business;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnVaccineRequest = new javax.swing.JButton();
        btnDistributorBill = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1024, 768));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Distributor Workarea");

        btnVaccineRequest.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVaccineRequest.setText("Vaccine Request ");
        btnVaccineRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaccineRequestActionPerformed(evt);
            }
        });

        btnDistributorBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDistributorBill.setText("Distributor Bills");
        btnDistributorBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistributorBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDistributorBill, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVaccineRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(355, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(btnVaccineRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnDistributorBill, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(485, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVaccineRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaccineRequestActionPerformed
        // TODO add your handling code here:
        DistributorVaccineRequestWorkArea distributorVaccineRequestWorkArea = new DistributorVaccineRequestWorkArea(userProcessContainer, business, account, distributorOrganization);
        userProcessContainer.add("DistributorVaccineRequestWorkArea", distributorVaccineRequestWorkArea);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnVaccineRequestActionPerformed

    private void btnDistributorBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistributorBillActionPerformed
        // TODO add your handling code here:
        DistributorBillingWorkArea distributorBillingWorkArea = new DistributorBillingWorkArea(userProcessContainer, business, account, distributorOrganization);
        userProcessContainer.add("DistributorBillingWorkArea", distributorBillingWorkArea);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnDistributorBillActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDistributorBill;
    private javax.swing.JButton btnVaccineRequest;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
