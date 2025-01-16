package StudiKasus03;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryApp {

    public static void main(String[] args) {
        // Frame utama
        JFrame mainFrame = new JFrame("Perpustakaan");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);

        // MenuBar dan Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem inputBukuMenu = new JMenuItem("Input Buku");
        JMenuItem exitMenu = new JMenuItem("Keluar");
        menu.add(inputBukuMenu);
        menu.add(exitMenu);
        menuBar.add(menu);
        mainFrame.setJMenuBar(menuBar);

        // Panel utama
        JPanel mainPanel = new JPanel(new CardLayout());

        // Panel untuk input buku
        JPanel inputBukuPanel = new JPanel(null);

        // Komponen input
        JLabel titleLabel = new JLabel("Judul Buku:");
        titleLabel.setBounds(20, 20, 100, 25);
        JTextField titleField = new JTextField();
        titleField.setBounds(130, 20, 200, 25);

        JLabel authorLabel = new JLabel("Penulis:");
        authorLabel.setBounds(20, 60, 100, 25);
        JTextField authorField = new JTextField();
        authorField.setBounds(130, 60, 200, 25);

        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(20, 100, 100, 25);
        JComboBox<String> genreComboBox = new JComboBox<>(new String[]{"Fiksi", "Non-Fiksi", "Ilmiah", "Sejarah"});
        genreComboBox.setBounds(130, 100, 200, 25);

        JLabel descriptionLabel = new JLabel("Deskripsi:");
        descriptionLabel.setBounds(20, 140, 100, 25);
        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setBounds(130, 140, 200, 80);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        JLabel ratingLabel = new JLabel("Rating:");
        ratingLabel.setBounds(20, 240, 100, 25);
        JSlider ratingSlider = new JSlider(0, 10, 5);
        ratingSlider.setBounds(130, 240, 200, 50);
        ratingSlider.setPaintLabels(true);
        ratingSlider.setPaintTicks(true);
        ratingSlider.setMajorTickSpacing(2);

        // Tabel untuk menampilkan data
        JTable table = new JTable(new DefaultTableModel(new String[]{"Judul", "Penulis", "Genre", "Deskripsi", "Rating"}, 0));
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(350, 20, 400, 400);

        // Tombol submit
        JButton submitButton = new JButton("Tambah Buku");
        submitButton.setBounds(130, 300, 200, 30);

        // Aksi tombol submit
        submitButton.addActionListener(e -> {
            String title = titleField.getText();
            String author = authorField.getText();
            String genre = (String) genreComboBox.getSelectedItem();
            String description = descriptionArea.getText();
            int rating = ratingSlider.getValue();

            if (!title.isEmpty() && !author.isEmpty() && genre != null && !description.isEmpty()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{title, author, genre, description, rating});
                titleField.setText("");
                authorField.setText("");
                descriptionArea.setText("");
                ratingSlider.setValue(5);
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Menambahkan komponen ke panel input buku
        inputBukuPanel.add(titleLabel);
        inputBukuPanel.add(titleField);
        inputBukuPanel.add(authorLabel);
        inputBukuPanel.add(authorField);
        inputBukuPanel.add(genreLabel);
        inputBukuPanel.add(genreComboBox);
        inputBukuPanel.add(descriptionLabel);
        inputBukuPanel.add(descriptionArea);
        inputBukuPanel.add(ratingLabel);
        inputBukuPanel.add(ratingSlider);
        inputBukuPanel.add(submitButton);
        inputBukuPanel.add(tableScrollPane);

        // Menambahkan panel ke main panel
        mainPanel.add(inputBukuPanel, "InputBuku");

        // Aksi menu
        inputBukuMenu.addActionListener(e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "InputBuku");
        });

        exitMenu.addActionListener(e -> System.exit(0));

        // Menambahkan main panel ke frame
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
}
