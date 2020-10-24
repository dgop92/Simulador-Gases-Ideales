package interfaces.control;

import idealgas.TransformationType;
import inevaup.dialogs.InfoDialog;
import inevaup.dialogs.InfoDialog.TypeInfoDialog;

import java.util.HashMap;
import simulation.SimulationWorkspace;

public class ControlInterface extends javax.swing.JFrame {

    private SimulationWorkspace simulationWorkspace;

    public ControlInterface() {
        initComponents();

        simulationWorkspace = new SimulationWorkspace();
        simulationWorkspace.run();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        parent_layout = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        header_title = new javax.swing.JLabel();
        data_panel_1 = new javax.swing.JPanel();
        input_panel = new javax.swing.JPanel();
        V2 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        V3 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        V4 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        V5 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        V6 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        V7 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        data_panel_2 = new javax.swing.JPanel();
        data_panel_left_side = new javax.swing.JPanel();
        V8 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        data_panel_right_side = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        separator_layout = new javax.swing.JPanel();
        transformation_layout = new javax.swing.JPanel();
        RadioButtons = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        button_section = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        footbar = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        parent_layout.setBackground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(0, 47, 108));
        header.setPreferredSize(new java.awt.Dimension(189, 60));
        header.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        header_title.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        header_title.setForeground(new java.awt.Color(255, 255, 255));
        header_title.setText("Interfaz de Control");
        header_title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onHeaderButton(evt);
            }
        });
        header.add(header_title);

        data_panel_1.setBackground(new java.awt.Color(255, 255, 255));
        data_panel_1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 20));

        input_panel.setBackground(new java.awt.Color(255, 255, 255));
        input_panel.setLayout(new java.awt.GridLayout(2, 3));

        V2.setBackground(new java.awt.Color(255, 255, 255));
        V2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel26.setBackground(new java.awt.Color(0, 47, 108));
        jPanel26.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("V2");
        jPanel26.add(jLabel13);

        V2.add(jPanel26);

        jTextField12.setBackground(new java.awt.Color(255, 255, 255));
        jTextField12.setColumns(6);
        jTextField12.setForeground(new java.awt.Color(0, 0, 0));
        jTextField12.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        V2.add(jTextField12);

        input_panel.add(V2);

        V3.setBackground(new java.awt.Color(255, 255, 255));
        V3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel27.setBackground(new java.awt.Color(0, 47, 108));
        jPanel27.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("V2");
        jPanel27.add(jLabel16);

        V3.add(jPanel27);

        jTextField15.setBackground(new java.awt.Color(255, 255, 255));
        jTextField15.setColumns(6);
        jTextField15.setForeground(new java.awt.Color(0, 0, 0));
        jTextField15.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        V3.add(jTextField15);

        input_panel.add(V3);

        V4.setBackground(new java.awt.Color(255, 255, 255));
        V4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel29.setBackground(new java.awt.Color(0, 47, 108));
        jPanel29.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("V2");
        jPanel29.add(jLabel17);

        V4.add(jPanel29);

        jTextField16.setBackground(new java.awt.Color(255, 255, 255));
        jTextField16.setColumns(6);
        jTextField16.setForeground(new java.awt.Color(0, 0, 0));
        jTextField16.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        V4.add(jTextField16);

        input_panel.add(V4);

        V5.setBackground(new java.awt.Color(255, 255, 255));
        V5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel32.setBackground(new java.awt.Color(0, 47, 108));
        jPanel32.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("V2");
        jPanel32.add(jLabel18);

        V5.add(jPanel32);

        jTextField17.setBackground(new java.awt.Color(255, 255, 255));
        jTextField17.setColumns(6);
        jTextField17.setForeground(new java.awt.Color(0, 0, 0));
        jTextField17.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        V5.add(jTextField17);

        input_panel.add(V5);

        V6.setBackground(new java.awt.Color(255, 255, 255));
        V6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel33.setBackground(new java.awt.Color(0, 47, 108));
        jPanel33.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("V2");
        jPanel33.add(jLabel19);

        V6.add(jPanel33);

        jTextField18.setBackground(new java.awt.Color(255, 255, 255));
        jTextField18.setColumns(6);
        jTextField18.setForeground(new java.awt.Color(0, 0, 0));
        jTextField18.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        V6.add(jTextField18);

        input_panel.add(V6);

        V7.setBackground(new java.awt.Color(255, 255, 255));
        V7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel34.setBackground(new java.awt.Color(0, 47, 108));
        jPanel34.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("V2");
        jPanel34.add(jLabel20);

        V7.add(jPanel34);

        jTextField19.setBackground(new java.awt.Color(255, 255, 255));
        jTextField19.setColumns(6);
        jTextField19.setForeground(new java.awt.Color(0, 0, 0));
        jTextField19.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        V7.add(jTextField19);

        input_panel.add(V7);

        data_panel_1.add(input_panel);

        data_panel_2.setBackground(new java.awt.Color(255, 255, 255));
        data_panel_2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        data_panel_left_side.setBackground(new java.awt.Color(255, 255, 255));
        data_panel_left_side.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        V8.setBackground(new java.awt.Color(255, 255, 255));
        V8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel28.setBackground(new java.awt.Color(0, 47, 108));
        jPanel28.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("V2");
        jPanel28.add(jLabel14);

        V8.add(jPanel28);

        jTextField13.setBackground(new java.awt.Color(255, 255, 255));
        jTextField13.setColumns(6);
        jTextField13.setForeground(new java.awt.Color(0, 0, 0));
        jTextField13.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        V8.add(jTextField13);

        data_panel_left_side.add(V8);

        data_panel_2.add(data_panel_left_side);

        data_panel_right_side.setBackground(new java.awt.Color(255, 255, 255));
        data_panel_right_side.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 3));

        jPanel35.setBackground(new java.awt.Color(0, 47, 108));
        jPanel35.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("H");
        jPanel35.add(jLabel21);

        data_panel_right_side.add(jPanel35);

        data_panel_2.add(data_panel_right_side);

        separator_layout.setBackground(new java.awt.Color(0, 47, 108));

        javax.swing.GroupLayout separator_layoutLayout = new javax.swing.GroupLayout(separator_layout);
        separator_layout.setLayout(separator_layoutLayout);
        separator_layoutLayout.setHorizontalGroup(
            separator_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separator_layoutLayout.setVerticalGroup(
            separator_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        transformation_layout.setBackground(new java.awt.Color(255, 255, 255));
        transformation_layout.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        RadioButtons.setBackground(new java.awt.Color(255, 255, 255));
        RadioButtons.setLayout(new java.awt.GridLayout(2, 2, 10, 10));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton1.setText("P.Isobarico");
        RadioButtons.add(jRadioButton1);

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton2.setText("P.Isotermico");
        RadioButtons.add(jRadioButton2);

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton3.setText("P.Isovolumetrico");
        RadioButtons.add(jRadioButton3);

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton4.setText("P.Adiabatico");
        RadioButtons.add(jRadioButton4);

        transformation_layout.add(RadioButtons);

        button_section.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Pause/Resume");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons/control-play-pause.png"))); // NOI18N
        jPanel12.add(jLabel3);

        jPanel9.add(jPanel12);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Restart/Play");
        jPanel10.add(jLabel6);

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons/control-reset.png"))); // NOI18N
        jPanel31.add(jLabel5);

        jPanel10.add(jPanel31);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        button_section.add(jPanel8);

        footbar.setBackground(new java.awt.Color(0, 47, 108));

        javax.swing.GroupLayout footbarLayout = new javax.swing.GroupLayout(footbar);
        footbar.setLayout(footbarLayout);
        footbarLayout.setHorizontalGroup(
            footbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        footbarLayout.setVerticalGroup(
            footbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout parent_layoutLayout = new javax.swing.GroupLayout(parent_layout);
        parent_layout.setLayout(parent_layoutLayout);
        parent_layoutLayout.setHorizontalGroup(
            parent_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parent_layoutLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(parent_layoutLayout.createSequentialGroup()
                .addGroup(parent_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separator_layout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transformation_layout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(footbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(parent_layoutLayout.createSequentialGroup()
                        .addGroup(parent_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(data_panel_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(data_panel_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(button_section, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        parent_layoutLayout.setVerticalGroup(
            parent_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parent_layoutLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(data_panel_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(data_panel_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(separator_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transformation_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_section, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(footbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent_layout, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent_layout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onHeaderButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onHeaderButton
        // Este metodo solo es de testeo
        
        HashMap<String, Float> initialData = new HashMap<>();
        initialData.put("pressure", 60000f);
        initialData.put("volume", 91f);
        initialData.put("temperature", 400f);
        initialData.put("n", 25f);

        HashMap<String, Float> finalData = new HashMap<>();
        finalData.put("pressure", 0f);
        finalData.put("volume", 128f);
        finalData.put("temperature", 0f);
        
        //esto tambien inicia la trasnformacion
        boolean isRunning = simulationWorkspace.requestStartOfSimulation(initialData, finalData, TransformationType.ISOBARIC);
        if (!isRunning){
            InfoDialog particleErrorDialog = new InfoDialog(null, "Numero de particles exedidas", 
                simulationWorkspace.runErrorMessage, TypeInfoDialog.ERROR_DIALOG);
            particleErrorDialog.setVisible(true);
        }

    }//GEN-LAST:event_onHeaderButton

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControlInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RadioButtons;
    private javax.swing.JPanel V2;
    private javax.swing.JPanel V3;
    private javax.swing.JPanel V4;
    private javax.swing.JPanel V5;
    private javax.swing.JPanel V6;
    private javax.swing.JPanel V7;
    private javax.swing.JPanel V8;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel button_section;
    private javax.swing.JPanel data_panel_1;
    private javax.swing.JPanel data_panel_2;
    private javax.swing.JPanel data_panel_left_side;
    private javax.swing.JPanel data_panel_right_side;
    private javax.swing.JPanel footbar;
    private javax.swing.JPanel header;
    private javax.swing.JLabel header_title;
    private javax.swing.JPanel input_panel;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JPanel parent_layout;
    private javax.swing.JPanel separator_layout;
    private javax.swing.JPanel transformation_layout;
    // End of variables declaration//GEN-END:variables
}
