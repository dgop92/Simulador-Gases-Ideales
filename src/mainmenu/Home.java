package mainmenu;

public class Home extends javax.swing.JPanel {

    public Home() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home_content_layout = new javax.swing.JPanel();
        button_menu = new javax.swing.JPanel();
        start_button = new javax.swing.JPanel();
        start_button_title = new javax.swing.JLabel();
        instructions_button = new javax.swing.JPanel();
        instructions_button_title = new javax.swing.JLabel();
        settings_button = new javax.swing.JPanel();
        settings_button_title = new javax.swing.JLabel();

        home_content_layout.setBackground(new java.awt.Color(248, 249, 250));

        button_menu.setBackground(new java.awt.Color(248, 249, 250));
        button_menu.setLayout(new java.awt.GridLayout(3, 1, 10, 15));

        start_button.setBackground(new java.awt.Color(1, 87, 155));
        start_button.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 10));

        start_button_title.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        start_button_title.setForeground(new java.awt.Color(255, 255, 255));
        start_button_title.setText("Empezar");
        start_button.add(start_button_title);

        button_menu.add(start_button);

        instructions_button.setBackground(new java.awt.Color(1, 87, 155));
        instructions_button.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 10));

        instructions_button_title.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        instructions_button_title.setForeground(new java.awt.Color(255, 255, 255));
        instructions_button_title.setText("Instrucciones");
        instructions_button.add(instructions_button_title);

        button_menu.add(instructions_button);

        settings_button.setBackground(new java.awt.Color(1, 87, 155));
        settings_button.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 10));

        settings_button_title.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        settings_button_title.setForeground(new java.awt.Color(255, 255, 255));
        settings_button_title.setText("Configuraciones");
        settings_button.add(settings_button_title);

        button_menu.add(settings_button);

        javax.swing.GroupLayout home_content_layoutLayout = new javax.swing.GroupLayout(home_content_layout);
        home_content_layout.setLayout(home_content_layoutLayout);
        home_content_layoutLayout.setHorizontalGroup(
            home_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, home_content_layoutLayout.createSequentialGroup()
                .addContainerGap(511, Short.MAX_VALUE)
                .addComponent(button_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        home_content_layoutLayout.setVerticalGroup(
            home_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_content_layoutLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(button_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(home_content_layout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(home_content_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel button_menu;
    private javax.swing.JPanel home_content_layout;
    private javax.swing.JPanel instructions_button;
    private javax.swing.JLabel instructions_button_title;
    private javax.swing.JPanel settings_button;
    private javax.swing.JLabel settings_button_title;
    private javax.swing.JPanel start_button;
    private javax.swing.JLabel start_button_title;
    // End of variables declaration//GEN-END:variables
}
