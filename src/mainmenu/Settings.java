package mainmenu;

public class Settings extends javax.swing.JPanel {

    public Settings() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        settings_content_layout = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        settings_content_layout.setBackground(new java.awt.Color(248, 249, 250));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Es settings");

        javax.swing.GroupLayout settings_content_layoutLayout = new javax.swing.GroupLayout(settings_content_layout);
        settings_content_layout.setLayout(settings_content_layoutLayout);
        settings_content_layoutLayout.setHorizontalGroup(
            settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settings_content_layoutLayout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jLabel1)
                .addContainerGap(399, Short.MAX_VALUE))
        );
        settings_content_layoutLayout.setVerticalGroup(
            settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settings_content_layoutLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel1)
                .addContainerGap(218, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settings_content_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settings_content_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel settings_content_layout;
    // End of variables declaration//GEN-END:variables
}
