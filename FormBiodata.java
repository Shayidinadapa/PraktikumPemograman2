package Pertemuan3;

import javax.swing.*;
import java.awt.*;

public class FormBiodata extends JFrame {
    private JTextField namaField;
    private JTextField noHPField;
    private JRadioButton lakiLakiRadio;
    private JRadioButton perempuanRadio;
    private JCheckBox wnaCheckBox;
    private JButton simpanButton;
    
    public FormBiodata() {
        // Set frame properties
        setTitle("Form Biodata");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null); // Using absolute positioning
        
        // Create components
        JLabel titleLabel = new JLabel("Form Biodata", JLabel.CENTER);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        titleLabel.setBounds(0, 20, 400, 30);
        
        // Nama section
        JLabel namaLabel = new JLabel("Nama:");
        namaLabel.setBounds(50, 70, 100, 25);
        namaField = new JTextField();
        namaField.setBounds(150, 70, 200, 25);
        
        // Nomor HP section
        JLabel noHPLabel = new JLabel("Nomor HP:");
        noHPLabel.setBounds(50, 100, 100, 25);
        noHPField = new JTextField();
        noHPField.setBounds(150, 100, 200, 25);
        
        // Jenis Kelamin section
        JLabel jenisKelaminLabel = new JLabel("Jenis Kelamin:");
        jenisKelaminLabel.setBounds(50, 130, 100, 25);
        
        lakiLakiRadio = new JRadioButton("Laki-Laki");
        lakiLakiRadio.setBounds(150, 130, 100, 25);
        perempuanRadio = new JRadioButton("Perempuan");
        perempuanRadio.setBounds(250, 130, 100, 25);
        
        // Group the radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(lakiLakiRadio);
        genderGroup.add(perempuanRadio);
        
        // WNA Checkbox
        wnaCheckBox = new JCheckBox("Warga Negara Asing");
        wnaCheckBox.setBounds(150, 160, 200, 25);
        
        // Simpan button
        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(150, 200, 100, 30);
        
        // Add components to frame
        add(titleLabel);
        add(namaLabel);
        add(namaField);
        add(noHPLabel);
        add(noHPField);
        add(jenisKelaminLabel);
        add(lakiLakiRadio);
        add(perempuanRadio);
        add(wnaCheckBox);
        add(simpanButton);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormBiodata form = new FormBiodata();
            form.setVisible(true);
        });
    }
}