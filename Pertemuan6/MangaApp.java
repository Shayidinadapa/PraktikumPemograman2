package Pertemuan6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MangaApp extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextArea descriptionOutput;

    public MangaApp() {
        // Set up the main frame
        setTitle("Manga Book Manager");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem addItem = new JMenuItem("Add Manga");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add menu items
        menu.add(addItem);
        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Create table model and table
        tableModel = new DefaultTableModel(new String[]{"Judul Buku", "Penulis", "Bahasa", "Genre", "Status"}, 0);
        table = new JTable(tableModel);

        // Add ActionListener for menu items
        addItem.addActionListener(e -> openMangaForm());
        exitItem.addActionListener(e -> System.exit(0));

        // Set layout
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Create description output area
        descriptionOutput = new JTextArea(2, 20);
        descriptionOutput.setEditable(false);
        descriptionOutput.setLineWrap(true);
        descriptionOutput.setWrapStyleWord(true);
        descriptionOutput.setBackground(new Color(240, 255, 240)); // Light green background
        descriptionOutput.setForeground(new Color(0, 100, 0)); // Dark green text
        add(new JScrollPane(descriptionOutput), BorderLayout.SOUTH);
    }

    private void openMangaForm() {
        JFrame formFrame = new JFrame("Add Manga");
        formFrame.setSize(400, 400);
        formFrame.setLayout(new GridLayout(9, 2));

        // Create input fields
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        
        // Updated language options
        String[] languageOptions = {"Inggris", "Indonesia", "Cina", "Jepang", "Korea"};
        JComboBox<String> languageComboBox = new JComboBox<>(languageOptions);
        
        // Updated genre options
        String[] genreOptions = {"Comedy", "Action", "Slice of Life", "Romance", "School"};
        JComboBox<String> genreComboBox = new JComboBox<>(genreOptions);
        
        String[] statusOptions = {"Ongoing", "Completed", "Dropped"};
        JComboBox<String> statusComboBox = new JComboBox<>(statusOptions);

        JTextArea descriptionArea = new JTextArea(3, 20);

        // Radio buttons for cover type
        JRadioButton digitalCover = new JRadioButton("Digital");
        JRadioButton physicalCover = new JRadioButton("Physical");
        ButtonGroup coverGroup = new ButtonGroup();
        coverGroup.add(digitalCover);
        coverGroup.add(physicalCover);

        JButton createButton = new JButton("Create");

        // Add components to form
        formFrame.add(new JLabel("Judul Buku:"));
        formFrame.add(titleField);
        formFrame.add(new JLabel("Penulis:"));
        formFrame.add(authorField);
        formFrame.add(new JLabel("Bahasa:"));
        formFrame.add(languageComboBox);
        formFrame.add(new JLabel("Genre:"));
        formFrame.add(genreComboBox);
        formFrame.add(new JLabel("Status:"));
        formFrame.add(statusComboBox);
        formFrame.add(new JLabel("Deskripsi:"));
        formFrame.add(new JScrollPane(descriptionArea));
        formFrame.add(new JLabel("Cover Type:"));
        formFrame.add(digitalCover);
        formFrame.add(physicalCover);
        formFrame.add(createButton);

        // Create action for button
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add data to table
                String title = titleField.getText();
                String author = authorField.getText();
                String language = (String) languageComboBox.getSelectedItem();
                String genre = (String) genreComboBox.getSelectedItem();
                String status = (String) statusComboBox.getSelectedItem();
                String description = descriptionArea.getText();

                tableModel.addRow(new Object[]{title, author, language, genre, status});
                
                // Display the summary in the output area
                String summary = String.format("Judul: %s, Penulis: %s, Bahasa: %s, Genre: %s, Status: %s",
                        title, author, language, genre, status);
                descriptionOutput.setText(summary + "\nDeskripsi: " + description);
                
                formFrame.dispose(); // Close form
            }
        });

        formFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MangaApp app = new MangaApp();
            app.setVisible(true);
        });
    }
}





