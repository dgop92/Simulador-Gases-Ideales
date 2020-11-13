package interfaces.control;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT.SmoothCanvas;
import processing.core.PSurface;

import idealgas.GasDataMap;
import idealgas.TransformationType;
import idealgas.datarecorder.HistoryItem;
import idealgas.datarecorder.HistoryManager;
import inevaup.dialogs.InfoDialog;
import inevaup.dialogs.InfoDialog.TypeInfoDialog;
import inevaup.preferences.AppSettings;
import inevaup.resources.AppResources;
import inevaup.resources.R;
import interfaces.forms.FinalDataForm;
import interfaces.forms.InitialDataForm;
import interfaces.mainmenu.MainMenuInterface;
import simulation.SimulationWorkspace;

public class ControlInterface extends javax.swing.JFrame {
    
    private final SimulationWorkspace simulationWorkspace;
    private final AppResources appResources;
    private final HistoryManager historyManager;
    
    public ControlInterface() {
        appResources = AppResources.getResources();
        initComponents();

        simulationWorkspace = new SimulationWorkspace();
        simulationWorkspace.run();

        setToolTipTexts();
        initCustomResources();
        centreWindows();

        isobaric_radioButton.setSelected(true);
        historyManager = new HistoryManager();
    }

    private void centreWindows() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        int windownsGap = 30;
        int horizontalGap =  (int) ((dimension.getWidth() - 
            SimulationWorkspace.SKETCH_WIDTH - this.getWidth() - windownsGap) / 2);
        
        this.setLocation(horizontalGap, (int) 
            ((dimension.getHeight() - this.getHeight()) / 2));
        
        simulationWorkspace.getSurface().setLocation(
            horizontalGap + this.getWidth() + windownsGap, 
            (int) ((dimension.getHeight() - SimulationWorkspace.SKETCH_HEIGHT) / 2));
    }

    private void setToolTipTexts(){
        volume1_textField.setToolTipText("Min:"+GasDataMap.MIN_USER_VOLUME + " - " + " Max:"+GasDataMap.MAX_USER_VOLUME);
        temperature1_textField.setToolTipText("Min:"+GasDataMap.MIN_USER_TEMPERATURE + " - " + " Max:"+GasDataMap.MAX_USER_TEMPERATURE);
        pressure1_textField.setToolTipText("Min:"+GasDataMap.MIN_USER_PRESSURE + " - " + " Max:"+GasDataMap.MAX_USER_PRESSURE);
        volume2_textField.setToolTipText("Min:"+GasDataMap.MIN_USER_VOLUME + " - " + " Max:"+GasDataMap.MAX_USER_VOLUME);
        temperature2_textField.setToolTipText("Min:"+GasDataMap.MIN_USER_TEMPERATURE + " - " + " Max:"+GasDataMap.MAX_USER_TEMPERATURE);
        pressure2_textField.setToolTipText("Min:"+GasDataMap.MIN_USER_PRESSURE + " - " + " Max:"+GasDataMap.MAX_USER_PRESSURE);
    }
    
    private void initCustomResources() {
        
        header.setBackground(appResources.getColor(R.colors.dark));
        separator_layout.setBackground(appResources.getColor(R.colors.dark));
        footbar.setBackground(appResources.getColor(R.colors.dark));
        
        header_title.setForeground(appResources.getColor(R.colors.white_text));
        header_title.setFont(appResources.getFont(R.fonts.montserrat_bold, 20));
        header_title.setText(appResources.getString(R.strings.controlinterface_tittle));
        
        history_icon_button.setIcon(appResources.getIcon(R.icons.history_icon));
        pause_resume_button.setIcon(appResources.getIcon(R.icons.control_play_pause));
        play_restart_button.setIcon(appResources.getIcon(R.icons.control_reset));
        
        volume1_label.setForeground(appResources.getColor(R.colors.white_text));
        volume1_label.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        temperature1_label.setForeground(appResources.getColor(R.colors.white_text));
        temperature1_label.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        pressure1_label.setForeground(appResources.getColor(R.colors.white_text));
        pressure1_label.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        volume2_label.setForeground(appResources.getColor(R.colors.white_text));
        volume2_label.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        temperature2_label.setForeground(appResources.getColor(R.colors.white_text));
        temperature2_label.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        pressure2_label.setForeground(appResources.getColor(R.colors.white_text));
        pressure2_label.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        n_mol_label.setForeground(appResources.getColor(R.colors.white_text));
        n_mol_label.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        
        pause_button_title.setForeground(appResources.getColor(R.colors.dark));
        pause_button_title.setFont(appResources.getFont(R.fonts.montserrat_regular, 16));
        pause_button_title.setText(appResources.getString(R.strings.controlinterface_pause_resume));
        start_button_title.setForeground(appResources.getColor(R.colors.dark));
        start_button_title.setFont(appResources.getFont(R.fonts.montserrat_regular, 16));
        start_button_title.setText(appResources.getString(R.strings.controlinterface_reset_play));
        
        isobaric_radioButton.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        isobaric_radioButton.setText(appResources.getString(R.strings.controlinterface_isobaric_rb));
        isothermal_radioButton.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        isothermal_radioButton.setText(appResources.getString(R.strings.controlinterface_isothermal_rb));
        isovolumetric_radioButton.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        isovolumetric_radioButton.setText(appResources.getString(R.strings.controlinterface_isovolumetric_rb));
        adiabatic_radioButton.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        adiabatic_radioButton.setText(appResources.getString(R.strings.controlinterface_adiabatic_rb));
        
        back_arrow_button.setIcon(appResources.getIcon(R.icons.control_back_arrow));

        volume1_tittle_layout.setBackground(appResources.getColor(R.colors.primary));
        volume2_tittle_layout.setBackground(appResources.getColor(R.colors.primary));
        temperature1_tittle_layout.setBackground(appResources.getColor(R.colors.primary));
        temperature2_tittle_layout.setBackground(appResources.getColor(R.colors.primary));
        pressure1_tittle_layout.setBackground(appResources.getColor(R.colors.primary));
        pressure2_tittle_layout.setBackground(appResources.getColor(R.colors.primary));
        
        n_layout_title.setBackground(appResources.getColor(R.colors.primary));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        parent_layout = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        back_arrow_button = new javax.swing.JLabel();
        header_title = new javax.swing.JLabel();
        data_panel_1 = new javax.swing.JPanel();
        input_panel = new javax.swing.JPanel();
        V1 = new javax.swing.JPanel();
        volume1_tittle_layout = new javax.swing.JPanel();
        volume1_label = new javax.swing.JLabel();
        volume1_textField = new javax.swing.JTextField();
        T1 = new javax.swing.JPanel();
        temperature1_tittle_layout = new javax.swing.JPanel();
        temperature1_label = new javax.swing.JLabel();
        temperature1_textField = new javax.swing.JTextField();
        P1 = new javax.swing.JPanel();
        pressure1_tittle_layout = new javax.swing.JPanel();
        pressure1_label = new javax.swing.JLabel();
        pressure1_textField = new javax.swing.JTextField();
        V2 = new javax.swing.JPanel();
        volume2_tittle_layout = new javax.swing.JPanel();
        volume2_label = new javax.swing.JLabel();
        volume2_textField = new javax.swing.JTextField();
        T2 = new javax.swing.JPanel();
        temperature2_tittle_layout = new javax.swing.JPanel();
        temperature2_label = new javax.swing.JLabel();
        temperature2_textField = new javax.swing.JTextField();
        P2 = new javax.swing.JPanel();
        pressure2_tittle_layout = new javax.swing.JPanel();
        pressure2_label = new javax.swing.JLabel();
        pressure2_textField = new javax.swing.JTextField();
        data_panel_2 = new javax.swing.JPanel();
        data_panel_left_side = new javax.swing.JPanel();
        N = new javax.swing.JPanel();
        n_layout_title = new javax.swing.JPanel();
        n_mol_label = new javax.swing.JLabel();
        n_textField = new javax.swing.JTextField();
        data_panel_right_side = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        history_icon_button = new javax.swing.JLabel();
        separator_layout = new javax.swing.JPanel();
        transformation_layout = new javax.swing.JPanel();
        RadioButtons = new javax.swing.JPanel();
        isobaric_radioButton = new javax.swing.JRadioButton();
        isothermal_radioButton = new javax.swing.JRadioButton();
        isovolumetric_radioButton = new javax.swing.JRadioButton();
        adiabatic_radioButton = new javax.swing.JRadioButton();
        button_section = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        pause_button_title = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        pause_resume_button = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        start_button_title = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        play_restart_button = new javax.swing.JLabel();
        footbar = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        parent_layout.setBackground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(0, 47, 108));
        header.setPreferredSize(new java.awt.Dimension(189, 60));
        header.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 12));

        back_arrow_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons/control_back_arrow.png"))); // NOI18N
        back_arrow_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back_arrow_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OnBackMenuButton(evt);
            }
        });
        header.add(back_arrow_button);

        header_title.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        header_title.setForeground(new java.awt.Color(255, 255, 255));
        header_title.setText("Interfaz de Control");
        header.add(header_title);

        data_panel_1.setBackground(new java.awt.Color(255, 255, 255));
        data_panel_1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 20));

        input_panel.setBackground(new java.awt.Color(255, 255, 255));
        input_panel.setLayout(new java.awt.GridLayout(2, 3));

        V1.setBackground(new java.awt.Color(255, 255, 255));
        V1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        volume1_tittle_layout.setBackground(new java.awt.Color(0, 47, 108));
        volume1_tittle_layout.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        volume1_label.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        volume1_label.setForeground(new java.awt.Color(255, 255, 255));
        volume1_label.setText("V1");
        volume1_tittle_layout.add(volume1_label);

        V1.add(volume1_tittle_layout);

        volume1_textField.setBackground(new java.awt.Color(255, 255, 255));
        volume1_textField.setColumns(6);
        volume1_textField.setForeground(new java.awt.Color(0, 0, 0));
        volume1_textField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        V1.add(volume1_textField);

        input_panel.add(V1);

        T1.setBackground(new java.awt.Color(255, 255, 255));
        T1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        temperature1_tittle_layout.setBackground(new java.awt.Color(0, 47, 108));
        temperature1_tittle_layout.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        temperature1_label.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        temperature1_label.setForeground(new java.awt.Color(255, 255, 255));
        temperature1_label.setText("T1");
        temperature1_tittle_layout.add(temperature1_label);

        T1.add(temperature1_tittle_layout);

        temperature1_textField.setBackground(new java.awt.Color(255, 255, 255));
        temperature1_textField.setColumns(6);
        temperature1_textField.setForeground(new java.awt.Color(0, 0, 0));
        temperature1_textField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        T1.add(temperature1_textField);

        input_panel.add(T1);

        P1.setBackground(new java.awt.Color(255, 255, 255));
        P1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        pressure1_tittle_layout.setBackground(new java.awt.Color(0, 47, 108));
        pressure1_tittle_layout.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        pressure1_label.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pressure1_label.setForeground(new java.awt.Color(255, 255, 255));
        pressure1_label.setText("P1");
        pressure1_tittle_layout.add(pressure1_label);

        P1.add(pressure1_tittle_layout);

        pressure1_textField.setBackground(new java.awt.Color(255, 255, 255));
        pressure1_textField.setColumns(6);
        pressure1_textField.setForeground(new java.awt.Color(0, 0, 0));
        pressure1_textField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        P1.add(pressure1_textField);

        input_panel.add(P1);

        V2.setBackground(new java.awt.Color(255, 255, 255));
        V2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        volume2_tittle_layout.setBackground(new java.awt.Color(0, 47, 108));
        volume2_tittle_layout.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        volume2_label.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        volume2_label.setForeground(new java.awt.Color(255, 255, 255));
        volume2_label.setText("V2");
        volume2_tittle_layout.add(volume2_label);

        V2.add(volume2_tittle_layout);

        volume2_textField.setBackground(new java.awt.Color(255, 255, 255));
        volume2_textField.setColumns(6);
        volume2_textField.setForeground(new java.awt.Color(0, 0, 0));
        volume2_textField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        V2.add(volume2_textField);

        input_panel.add(V2);

        T2.setBackground(new java.awt.Color(255, 255, 255));
        T2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        temperature2_tittle_layout.setBackground(new java.awt.Color(0, 47, 108));
        temperature2_tittle_layout.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        temperature2_label.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        temperature2_label.setForeground(new java.awt.Color(255, 255, 255));
        temperature2_label.setText("T2");
        temperature2_tittle_layout.add(temperature2_label);

        T2.add(temperature2_tittle_layout);

        temperature2_textField.setBackground(new java.awt.Color(255, 255, 255));
        temperature2_textField.setColumns(6);
        temperature2_textField.setForeground(new java.awt.Color(0, 0, 0));
        temperature2_textField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        T2.add(temperature2_textField);

        input_panel.add(T2);

        P2.setBackground(new java.awt.Color(255, 255, 255));
        P2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        pressure2_tittle_layout.setBackground(new java.awt.Color(0, 47, 108));
        pressure2_tittle_layout.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        pressure2_label.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pressure2_label.setForeground(new java.awt.Color(255, 255, 255));
        pressure2_label.setText("P2");
        pressure2_tittle_layout.add(pressure2_label);

        P2.add(pressure2_tittle_layout);

        pressure2_textField.setBackground(new java.awt.Color(255, 255, 255));
        pressure2_textField.setColumns(6);
        pressure2_textField.setForeground(new java.awt.Color(0, 0, 0));
        pressure2_textField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        P2.add(pressure2_textField);

        input_panel.add(P2);

        data_panel_1.add(input_panel);

        data_panel_2.setBackground(new java.awt.Color(255, 255, 255));
        data_panel_2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        data_panel_left_side.setBackground(new java.awt.Color(255, 255, 255));
        data_panel_left_side.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        N.setBackground(new java.awt.Color(255, 255, 255));
        N.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        n_layout_title.setBackground(new java.awt.Color(0, 47, 108));
        n_layout_title.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        n_mol_label.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        n_mol_label.setForeground(new java.awt.Color(255, 255, 255));
        n_mol_label.setText("N");
        n_layout_title.add(n_mol_label);

        N.add(n_layout_title);

        n_textField.setBackground(new java.awt.Color(255, 255, 255));
        n_textField.setColumns(6);
        n_textField.setForeground(new java.awt.Color(0, 0, 0));
        n_textField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        N.add(n_textField);

        data_panel_left_side.add(N);

        data_panel_2.add(data_panel_left_side);

        data_panel_right_side.setBackground(new java.awt.Color(255, 255, 255));
        data_panel_right_side.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 3));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        history_icon_button.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        history_icon_button.setForeground(new java.awt.Color(255, 255, 255));
        history_icon_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons/history_icon.png"))); // NOI18N
        history_icon_button.setToolTipText("");
        history_icon_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        history_icon_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onHistoryButtonClicked(evt);
            }
        });
        jPanel35.add(history_icon_button);

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

        isobaric_radioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(isobaric_radioButton);
        isobaric_radioButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        isobaric_radioButton.setForeground(new java.awt.Color(0, 0, 0));
        isobaric_radioButton.setText("P.Isobarico");
        isobaric_radioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RadioButtons.add(isobaric_radioButton);

        isothermal_radioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(isothermal_radioButton);
        isothermal_radioButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        isothermal_radioButton.setForeground(new java.awt.Color(0, 0, 0));
        isothermal_radioButton.setText("P.Isotermico");
        isothermal_radioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RadioButtons.add(isothermal_radioButton);

        isovolumetric_radioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(isovolumetric_radioButton);
        isovolumetric_radioButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        isovolumetric_radioButton.setForeground(new java.awt.Color(0, 0, 0));
        isovolumetric_radioButton.setText("P.Isovolumetrico");
        isovolumetric_radioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RadioButtons.add(isovolumetric_radioButton);

        adiabatic_radioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(adiabatic_radioButton);
        adiabatic_radioButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        adiabatic_radioButton.setForeground(new java.awt.Color(0, 0, 0));
        adiabatic_radioButton.setText("P.Adiabatico");
        adiabatic_radioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RadioButtons.add(adiabatic_radioButton);

        transformation_layout.add(RadioButtons);

        button_section.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        pause_button_title.setBackground(new java.awt.Color(255, 255, 255));
        pause_button_title.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        pause_button_title.setForeground(new java.awt.Color(0, 0, 0));
        pause_button_title.setText("Pause/Resume");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pause_button_title, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pause_button_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        pause_resume_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons/control-play-pause.png"))); // NOI18N
        pause_resume_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pause_resume_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onPauseResumeButton(evt);
            }
        });
        jPanel12.add(pause_resume_button);

        jPanel9.add(jPanel12);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        start_button_title.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        start_button_title.setForeground(new java.awt.Color(0, 0, 0));
        start_button_title.setText("Restart/Play");
        jPanel10.add(start_button_title);

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        play_restart_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons/control-reset.png"))); // NOI18N
        play_restart_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        play_restart_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onResetStartButton(evt);
            }
        });
        jPanel31.add(play_restart_button);

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

    private void onResetStartButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onResetStartButton
        
        InitialDataForm initialdataform = new InitialDataForm(
            pressure1_textField.getText(),
            volume1_textField.getText(),
            temperature1_textField.getText(),
            n_textField.getText()
        );
        initialdataform.validate();

        TransformationType transformationType = null;

        if(isobaric_radioButton.isSelected()){
            transformationType = TransformationType.ISOBARIC;
        }else if(isothermal_radioButton.isSelected()){
            transformationType = TransformationType.ISOTHERMAL;
        }else if(isovolumetric_radioButton.isSelected()){
            transformationType = TransformationType.ISOVOLUMETRIC; 
        }else if(adiabatic_radioButton.isSelected()){
            transformationType = TransformationType.ADIABATIC;
        }

        FinalDataForm finaldataform = new FinalDataForm(
            pressure2_textField.getText(),
            volume2_textField.getText(),
            temperature2_textField.getText(),
            transformationType
        );
        finaldataform.validate();
        
        if(initialdataform.isDataValid() && finaldataform.isDataValid()){
            
            boolean isRunning = simulationWorkspace.requestStartOfSimulation(
                initialdataform.getValidatedData(), 
                finaldataform.getValidatedData(), 
                transformationType
            );
            
            if (!isRunning){

                InfoDialog particleErrorDialog = new InfoDialog(
                    this, 
                    appResources.getString(R.strings.particles_error), 
                    simulationWorkspace.runErrorMessage, 
                    TypeInfoDialog.ERROR_DIALOG
                );
                particleErrorDialog.setVisible(true);
            }else{

                saveInHistory(initialdataform.getValidatedData(),
                    finaldataform.getValidatedData(),
                transformationType);
            }
            
        }else{
            String formErrorMessages = 
                initialdataform.errorMessages +
                finaldataform.errorMessages;
            InfoDialog errorMessage= new InfoDialog(
                    this, 
                    appResources.getString(R.strings.form_error_title), 
                    formErrorMessages, 
                    TypeInfoDialog.ERROR_DIALOG);
            errorMessage.setVisible(true);
        }
        
    }//GEN-LAST:event_onResetStartButton

    private void saveInHistory(HashMap<String, Float> initialData,
        HashMap<String, Float> finalData, TransformationType transformationType){
        
        if((boolean)AppSettings.getSettings().getSetting("save_history_data")){

            boolean isSaved = historyManager.saveInputData(
                initialData, 
                finalData, 
                transformationType
            );

            if(!isSaved){
                InfoDialog saveHistoryDialog = new InfoDialog(
                    this, 
                    appResources.getString(R.strings.error_title_interface), 
                    appResources.getString(R.strings.history_error), 
                    TypeInfoDialog.ERROR_DIALOG
                );
                saveHistoryDialog.setVisible(true);
            }
        }
    }

    private void onHistoryButtonClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onHistoryButtonClicked
        
        HistoryDialog historyDialog = new HistoryDialog(null, 
            true, historyManager.getHistoryDefaultModel());
        historyDialog.setVisible(true);

        if(historyDialog.isItemSelected){
            HistoryItem historyItem = historyDialog.getSelectedHistoryItem();
            setInputDataFromHistory(historyItem.getInitialData(),
                historyItem.getFinalData(), historyItem.getTransformationType());
        }
    }//GEN-LAST:event_onHistoryButtonClicked

    private void onPauseResumeButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onPauseResumeButton
        if(!simulationWorkspace.requestPauseResumeOfSimulation()){
            InfoDialog errDialog = new InfoDialog(
                this, 
                appResources.getString(R.strings.error_title_interface), 
                appResources.getString(R.strings.pause_error), 
                TypeInfoDialog.ERROR_DIALOG);
            errDialog.setVisible(true);
        }
    }//GEN-LAST:event_onPauseResumeButton

    private void OnBackMenuButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OnBackMenuButton
        PSurface surface = simulationWorkspace.getSurface();
        SmoothCanvas smoothCanvas = (SmoothCanvas)surface.getNative();
        JFrame frame = (JFrame) smoothCanvas.getFrame();
        frame.dispose();
        MainMenuInterface mainInterface = new MainMenuInterface();
        mainInterface.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_OnBackMenuButton

    private void setInputDataFromHistory(HashMap<String, Float> initialData, 
                                HashMap<String, Float> finalData,
                                TransformationType transformationType){

        pressure1_textField.setText(String.valueOf(initialData.get("pressure")));   
        volume1_textField.setText(String.valueOf(initialData.get("volume")));   
        temperature1_textField.setText(String.valueOf(initialData.get("temperature")));   
        n_textField.setText(String.valueOf(initialData.get("n")));

        String p2,v2,t2; 
    
        p2 = String.valueOf(finalData.get("pressure"));
        if(p2.equals("0.0")){
            pressure2_textField.setText(""); 
        }else{
            pressure2_textField.setText(String.valueOf(finalData.get("pressure")));
        }
          
        v2 = String.valueOf(finalData.get("volume"));
        if(v2.equals("0.0")){
            volume2_textField.setText(""); 
        }else{
            volume2_textField.setText(String.valueOf(finalData.get("volume"))); 
        }

        t2 = String.valueOf(finalData.get("temperature")); 
        if(t2.equals("0.0")){
            temperature2_textField.setText(""); 
        }else{
            temperature2_textField.setText(String.valueOf(finalData.get("temperature")));
        } 

        switch (transformationType) {
            case ISOBARIC:
                isobaric_radioButton.setSelected(true);
                break;
            case ISOVOLUMETRIC:
                isovolumetric_radioButton.setSelected(true);
                break;
            case ISOTHERMAL:
                isothermal_radioButton.setSelected(true);
                break;
            case ADIABATIC:
                adiabatic_radioButton.setSelected(true);
                break;
        }
    }
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
    private javax.swing.JPanel N;
    private javax.swing.JPanel P1;
    private javax.swing.JPanel P2;
    private javax.swing.JPanel RadioButtons;
    private javax.swing.JPanel T1;
    private javax.swing.JPanel T2;
    private javax.swing.JPanel V1;
    private javax.swing.JPanel V2;
    private javax.swing.JRadioButton adiabatic_radioButton;
    private javax.swing.JLabel back_arrow_button;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel button_section;
    private javax.swing.JPanel data_panel_1;
    private javax.swing.JPanel data_panel_2;
    private javax.swing.JPanel data_panel_left_side;
    private javax.swing.JPanel data_panel_right_side;
    private javax.swing.JPanel footbar;
    private javax.swing.JPanel header;
    private javax.swing.JLabel header_title;
    private javax.swing.JLabel history_icon_button;
    private javax.swing.JPanel input_panel;
    private javax.swing.JRadioButton isobaric_radioButton;
    private javax.swing.JRadioButton isothermal_radioButton;
    private javax.swing.JRadioButton isovolumetric_radioButton;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel n_layout_title;
    private javax.swing.JLabel n_mol_label;
    private javax.swing.JTextField n_textField;
    private javax.swing.JPanel parent_layout;
    private javax.swing.JLabel pause_button_title;
    private javax.swing.JLabel pause_resume_button;
    private javax.swing.JLabel play_restart_button;
    private javax.swing.JLabel pressure1_label;
    private javax.swing.JTextField pressure1_textField;
    private javax.swing.JPanel pressure1_tittle_layout;
    private javax.swing.JLabel pressure2_label;
    private javax.swing.JTextField pressure2_textField;
    private javax.swing.JPanel pressure2_tittle_layout;
    private javax.swing.JPanel separator_layout;
    private javax.swing.JLabel start_button_title;
    private javax.swing.JLabel temperature1_label;
    private javax.swing.JTextField temperature1_textField;
    private javax.swing.JPanel temperature1_tittle_layout;
    private javax.swing.JLabel temperature2_label;
    private javax.swing.JTextField temperature2_textField;
    private javax.swing.JPanel temperature2_tittle_layout;
    private javax.swing.JPanel transformation_layout;
    private javax.swing.JLabel volume1_label;
    private javax.swing.JTextField volume1_textField;
    private javax.swing.JPanel volume1_tittle_layout;
    private javax.swing.JLabel volume2_label;
    private javax.swing.JTextField volume2_textField;
    private javax.swing.JPanel volume2_tittle_layout;
    // End of variables declaration//GEN-END:variables

    
}
