package interfaces.control;

import idealgas.TransformationType;
import inevaup.dialogs.InfoDialog;
import inevaup.dialogs.InfoDialog.TypeInfoDialog;
import inevaup.resources.AppResources;
import inevaup.resources.R;
import idealgas.GasDataMap;
import forms.InitialDataForm;
import forms.FinalDataForm;



import java.util.HashMap;

import simulation.SimulationWorkspace;

public class ControlInterface extends javax.swing.JFrame {
    
    
    
    private SimulationWorkspace simulationWorkspace;
    private AppResources appResources;
    
    public ControlInterface() {
        appResources = AppResources.getAppResources();
        initComponents();
        initCustomResources();
        
        //ToolTips
        Volume_1.setToolTipText("Min:"+GasDataMap.MIN_USER_VOLUME + " - " + " Max:"+GasDataMap.MAX_USER_VOLUME);
        Temperature_1.setToolTipText("Min:"+GasDataMap.MIN_USER_TEMPERATURE + " - " + " Max:"+GasDataMap.MAX_USER_TEMPERATURE);
        Pressure_1.setToolTipText("Min:"+GasDataMap.MIN_USER_PRESSURE + " - " + " Max:"+GasDataMap.MAX_USER_PRESSURE);
        Volume_2.setToolTipText("Min:"+GasDataMap.MIN_USER_VOLUME + " - " + " Max:"+GasDataMap.MAX_USER_VOLUME);
        Temperature_2.setToolTipText("Min:"+GasDataMap.MIN_USER_TEMPERATURE + " - " + " Max:"+GasDataMap.MAX_USER_TEMPERATURE);
        Pressure_2.setToolTipText("Min:"+GasDataMap.MIN_USER_PRESSURE + " - " + " Max:"+GasDataMap.MAX_USER_PRESSURE);
        
        

        simulationWorkspace = new SimulationWorkspace();
        simulationWorkspace.run();
    }
    
    private void initCustomResources() {
        
        header_title.setForeground(appResources.getColor(R.colors.white_text));
        header_title.setFont(appResources.getFont(R.fonts.montserrat_bold, 20));
        header_title.setText(appResources.getString(R.strings.controlinterface_tittle));
        Icon_Ok.setIcon(appResources.getIcon(R.icons.control_okay));
        Volume1.setForeground(appResources.getColor(R.colors.white_text));
        Volume1.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        Temperature1.setForeground(appResources.getColor(R.colors.white_text));
        Temperature1.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        Pressure1.setForeground(appResources.getColor(R.colors.white_text));
        Pressure1.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        Volume2.setForeground(appResources.getColor(R.colors.white_text));
        Volume2.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        Temperature2.setForeground(appResources.getColor(R.colors.white_text));
        Temperature2.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        Pressure2.setForeground(appResources.getColor(R.colors.white_text));
        Pressure2.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        N_mol.setForeground(appResources.getColor(R.colors.white_text));
        N_mol.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        
        
        
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
        V1 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        Volume1 = new javax.swing.JLabel();
        Volume_1 = new javax.swing.JTextField();
        T1 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        Temperature1 = new javax.swing.JLabel();
        Temperature_1 = new javax.swing.JTextField();
        P1 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        Pressure1 = new javax.swing.JLabel();
        Pressure_1 = new javax.swing.JTextField();
        V2 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        Volume2 = new javax.swing.JLabel();
        Volume_2 = new javax.swing.JTextField();
        T2 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        Temperature2 = new javax.swing.JLabel();
        Temperature_2 = new javax.swing.JTextField();
        P2 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        Pressure2 = new javax.swing.JLabel();
        Pressure_2 = new javax.swing.JTextField();
        data_panel_2 = new javax.swing.JPanel();
        data_panel_left_side = new javax.swing.JPanel();
        N = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        N_mol = new javax.swing.JLabel();
        N_field = new javax.swing.JTextField();
        data_panel_right_side = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        Icon_Ok = new javax.swing.JLabel();
        separator_layout = new javax.swing.JPanel();
        transformation_layout = new javax.swing.JPanel();
        RadioButtons = new javax.swing.JPanel();
        Isobarico = new javax.swing.JRadioButton();
        Isotermico = new javax.swing.JRadioButton();
        Isovolumetrico = new javax.swing.JRadioButton();
        Adiabatico = new javax.swing.JRadioButton();
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

        header_title.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
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

        V1.setBackground(new java.awt.Color(255, 255, 255));
        V1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel26.setBackground(new java.awt.Color(0, 47, 108));
        jPanel26.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        Volume1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Volume1.setForeground(new java.awt.Color(255, 255, 255));
        Volume1.setText("V1");
        jPanel26.add(Volume1);

        V1.add(jPanel26);

        Volume_1.setBackground(new java.awt.Color(255, 255, 255));
        Volume_1.setColumns(6);
        Volume_1.setForeground(new java.awt.Color(0, 0, 0));
        Volume_1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Volume_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Volume_1ActionPerformed(evt);
            }
        });
        V1.add(Volume_1);

        input_panel.add(V1);

        T1.setBackground(new java.awt.Color(255, 255, 255));
        T1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel27.setBackground(new java.awt.Color(0, 47, 108));
        jPanel27.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        Temperature1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Temperature1.setForeground(new java.awt.Color(255, 255, 255));
        Temperature1.setText("T1");
        jPanel27.add(Temperature1);

        T1.add(jPanel27);

        Temperature_1.setBackground(new java.awt.Color(255, 255, 255));
        Temperature_1.setColumns(6);
        Temperature_1.setForeground(new java.awt.Color(0, 0, 0));
        Temperature_1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        T1.add(Temperature_1);

        input_panel.add(T1);

        P1.setBackground(new java.awt.Color(255, 255, 255));
        P1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel29.setBackground(new java.awt.Color(0, 47, 108));
        jPanel29.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        Pressure1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Pressure1.setForeground(new java.awt.Color(255, 255, 255));
        Pressure1.setText("P1");
        jPanel29.add(Pressure1);

        P1.add(jPanel29);

        Pressure_1.setBackground(new java.awt.Color(255, 255, 255));
        Pressure_1.setColumns(6);
        Pressure_1.setForeground(new java.awt.Color(0, 0, 0));
        Pressure_1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        P1.add(Pressure_1);

        input_panel.add(P1);

        V2.setBackground(new java.awt.Color(255, 255, 255));
        V2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel32.setBackground(new java.awt.Color(0, 47, 108));
        jPanel32.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        Volume2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Volume2.setForeground(new java.awt.Color(255, 255, 255));
        Volume2.setText("V2");
        jPanel32.add(Volume2);

        V2.add(jPanel32);

        Volume_2.setBackground(new java.awt.Color(255, 255, 255));
        Volume_2.setColumns(6);
        Volume_2.setForeground(new java.awt.Color(0, 0, 0));
        Volume_2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        V2.add(Volume_2);

        input_panel.add(V2);

        T2.setBackground(new java.awt.Color(255, 255, 255));
        T2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel33.setBackground(new java.awt.Color(0, 47, 108));
        jPanel33.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        Temperature2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Temperature2.setForeground(new java.awt.Color(255, 255, 255));
        Temperature2.setText("T2");
        jPanel33.add(Temperature2);

        T2.add(jPanel33);

        Temperature_2.setBackground(new java.awt.Color(255, 255, 255));
        Temperature_2.setColumns(6);
        Temperature_2.setForeground(new java.awt.Color(0, 0, 0));
        Temperature_2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        T2.add(Temperature_2);

        input_panel.add(T2);

        P2.setBackground(new java.awt.Color(255, 255, 255));
        P2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel34.setBackground(new java.awt.Color(0, 47, 108));
        jPanel34.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        Pressure2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Pressure2.setForeground(new java.awt.Color(255, 255, 255));
        Pressure2.setText("P2");
        jPanel34.add(Pressure2);

        P2.add(jPanel34);

        Pressure_2.setBackground(new java.awt.Color(255, 255, 255));
        Pressure_2.setColumns(6);
        Pressure_2.setForeground(new java.awt.Color(0, 0, 0));
        Pressure_2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        P2.add(Pressure_2);

        input_panel.add(P2);

        data_panel_1.add(input_panel);

        data_panel_2.setBackground(new java.awt.Color(255, 255, 255));
        data_panel_2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        data_panel_left_side.setBackground(new java.awt.Color(255, 255, 255));
        data_panel_left_side.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        N.setBackground(new java.awt.Color(255, 255, 255));
        N.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel28.setBackground(new java.awt.Color(0, 47, 108));
        jPanel28.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        N_mol.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        N_mol.setForeground(new java.awt.Color(255, 255, 255));
        N_mol.setText("N");
        jPanel28.add(N_mol);

        N.add(jPanel28);

        N_field.setBackground(new java.awt.Color(255, 255, 255));
        N_field.setColumns(6);
        N_field.setForeground(new java.awt.Color(0, 0, 0));
        N_field.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        N.add(N_field);

        data_panel_left_side.add(N);

        data_panel_2.add(data_panel_left_side);

        data_panel_right_side.setBackground(new java.awt.Color(255, 255, 255));
        data_panel_right_side.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 3));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        Icon_Ok.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Icon_Ok.setForeground(new java.awt.Color(255, 255, 255));
        Icon_Ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons/control-okay.png"))); // NOI18N
        Icon_Ok.setText("H");
        Icon_Ok.setToolTipText("Ok");
        jPanel35.add(Icon_Ok);

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

        Isobarico.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Isobarico);
        Isobarico.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Isobarico.setForeground(new java.awt.Color(0, 0, 0));
        Isobarico.setText("P.Isobarico");
        RadioButtons.add(Isobarico);

        Isotermico.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Isotermico);
        Isotermico.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Isotermico.setForeground(new java.awt.Color(0, 0, 0));
        Isotermico.setText("P.Isotermico");
        Isotermico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsotermicoActionPerformed(evt);
            }
        });
        RadioButtons.add(Isotermico);

        Isovolumetrico.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Isovolumetrico);
        Isovolumetrico.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Isovolumetrico.setForeground(new java.awt.Color(0, 0, 0));
        Isovolumetrico.setText("P.Isovolumetrico");
        RadioButtons.add(Isovolumetrico);

        Adiabatico.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Adiabatico);
        Adiabatico.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Adiabatico.setForeground(new java.awt.Color(0, 0, 0));
        Adiabatico.setText("P.Adiabatico");
        RadioButtons.add(Adiabatico);

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
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onStartButton(evt);
            }
        });
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void Volume_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Volume_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Volume_1ActionPerformed

    private void IsotermicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsotermicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IsotermicoActionPerformed

    private void onStartButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onStartButton
        InitialDataForm initialdataform = new InitialDataForm(Pressure_1.getText(),Volume_1.getText(),Temperature_1.getText(),N_field.getText());
        TransformationType transformationType;
        if(Isobarico.isSelected()){
            transformationType= idealgas.TransformationType.ISOBARIC;
            
        }else if(Isotermico.isSelected()){
            transformationType= idealgas.TransformationType.ISOTHERMAL;
                 
        }else if(Isovolumetrico.isSelected()){
            transformationType= idealgas.TransformationType.ISOVOLUMETRIC;
              
        }else if(Adiabatico.isSelected()){
            transformationType= idealgas.TransformationType.ADIABATIC;
            
        }
        FinalDataForm finaldataform = new FinalDataForm(Pressure_2.getText(),Volume_2.getText(),Temperature_2.getText(),  transformationType );
        
    }//GEN-LAST:event_onStartButton

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
    private javax.swing.JRadioButton Adiabatico;
    private javax.swing.JLabel Icon_Ok;
    private javax.swing.JRadioButton Isobarico;
    private javax.swing.JRadioButton Isotermico;
    private javax.swing.JRadioButton Isovolumetrico;
    private javax.swing.JPanel N;
    private javax.swing.JTextField N_field;
    private javax.swing.JLabel N_mol;
    private javax.swing.JPanel P1;
    private javax.swing.JPanel P2;
    private javax.swing.JLabel Pressure1;
    private javax.swing.JLabel Pressure2;
    private javax.swing.JTextField Pressure_1;
    private javax.swing.JTextField Pressure_2;
    private javax.swing.JPanel RadioButtons;
    private javax.swing.JPanel T1;
    private javax.swing.JPanel T2;
    private javax.swing.JLabel Temperature1;
    private javax.swing.JLabel Temperature2;
    private javax.swing.JTextField Temperature_1;
    private javax.swing.JTextField Temperature_2;
    private javax.swing.JPanel V1;
    private javax.swing.JPanel V2;
    private javax.swing.JLabel Volume1;
    private javax.swing.JLabel Volume2;
    private javax.swing.JTextField Volume_1;
    private javax.swing.JTextField Volume_2;
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
    private javax.swing.JPanel parent_layout;
    private javax.swing.JPanel separator_layout;
    private javax.swing.JPanel transformation_layout;
    // End of variables declaration//GEN-END:variables

    
}
