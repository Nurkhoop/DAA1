package Assignment_4.InterfaceSwing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import Assignment_4.Sql_work.MediaMethods;
import Assignment_4.Sql_work.CollectionMethods;
import Assignment_4.Sql_work.CompositionMethods;

public class MusicDBApp extends JFrame {
    private JTabbedPane tabbedPane;

    public MusicDBApp() {
        setTitle("Music Database Manager");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Collections", new CollectionPanel());
        tabbedPane.addTab("Musical Media", new MediaPanel());
        tabbedPane.addTab("Musical Works", new WorksPanel());

        add(tabbedPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MusicDBApp().setVisible(true));
    }
}

class CollectionPanel extends JPanel {
    private final JTable collectionTable;
    private final DefaultTableModel collectionTableModel;
    private final JTextField nameField, ownerField;
    private final CollectionMethods collectionMethods;

    public CollectionPanel() {
        collectionMethods = new CollectionMethods();
        setLayout(new BorderLayout());

        collectionTableModel = new DefaultTableModel(new String[]{"ID", "Name", "Owner"}, 0);
        collectionTable = new JTable(collectionTableModel);
        add(new JScrollPane(collectionTable), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Owner:"));
        ownerField = new JTextField();
        inputPanel.add(ownerField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Collection");
        JButton deleteButton = new JButton("Delete Collection");
        JButton updateButton = new JButton("Update Collection");

        addButton.addActionListener(e -> addCollection());
        deleteButton.addActionListener(e -> deleteCollection());
        updateButton.addActionListener(e -> updateCollection());

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputPanel, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
        loadCollections();
    }

    private void loadCollections() {
        collectionTableModel.setRowCount(0);
        collectionMethods.loadCollections(collectionTableModel);
    }

    private void addCollection() {
        collectionMethods.addCollection(nameField.getText(), ownerField.getText());
        loadCollections();
    }

    private void deleteCollection() {
        int selectedRow = collectionTable.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) collectionTableModel.getValueAt(selectedRow, 0);
            collectionMethods.deleteCollection(id);
            loadCollections();
        }
    }

    private void updateCollection() {
        int selectedRow = collectionTable.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) collectionTableModel.getValueAt(selectedRow, 0);
            collectionMethods.updateCollection(id, nameField.getText(), ownerField.getText());
            loadCollections();
        }
    }
}

class MediaPanel extends JPanel {
    private final JTable mediaTable;
    private final DefaultTableModel mediaTableModel;
    private final JTextField authorField, genreField, yearField, durationField, collectionIdField;
    private final MediaMethods mediaMethods;

    public MediaPanel() {
        mediaMethods = new MediaMethods();
        setLayout(new BorderLayout());

        mediaTableModel = new DefaultTableModel(new String[]{"ID", "Author", "Genre", "Year", "Duration", "Collection ID"}, 0);
        mediaTable = new JTable(mediaTableModel);
        add(new JScrollPane(mediaTable), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("Genre:"));
        genreField = new JTextField();
        inputPanel.add(genreField);
        inputPanel.add(new JLabel("Year:"));
        yearField = new JTextField();
        inputPanel.add(yearField);
        inputPanel.add(new JLabel("Duration:"));
        durationField = new JTextField();
        inputPanel.add(durationField);
        inputPanel.add(new JLabel("Collection ID:"));
        collectionIdField = new JTextField();
        inputPanel.add(collectionIdField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Media");
        JButton deleteButton = new JButton("Delete Media");
        JButton updateButton = new JButton("Update Media");

        addButton.addActionListener(e -> addMedia());
        deleteButton.addActionListener(e -> deleteMedia());
        updateButton.addActionListener(e -> updateMedia());

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputPanel, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
        loadMedia();
    }

    private void loadMedia() {
        mediaTableModel.setRowCount(0);
        mediaMethods.loadMedia(mediaTableModel);
    }

    private void addMedia() {
        mediaMethods.addMedia(
                authorField.getText(),
                genreField.getText(),
                Integer.parseInt(yearField.getText()),
                Integer.parseInt(durationField.getText()),
                Integer.parseInt(collectionIdField.getText())
        );
        loadMedia();
    }

    private void deleteMedia() {
        int selectedRow = mediaTable.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) mediaTableModel.getValueAt(selectedRow, 0);
            mediaMethods.deleteMedia(id);
            loadMedia();
        }
    }

    private void updateMedia() {
        int selectedRow = mediaTable.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) mediaTableModel.getValueAt(selectedRow, 0);
            mediaMethods.updateMedia(
                    id,
                    authorField.getText(),
                    genreField.getText(),
                    Integer.parseInt(yearField.getText()),
                    Integer.parseInt(durationField.getText()),
                    Integer.parseInt(collectionIdField.getText())
            );
            loadMedia();
        }
    }
}
class WorksPanel extends JPanel {
    private final JTable worksTable;
    private final DefaultTableModel worksTableModel;
    private final JTextField nameField, durationField, mediaIdField;
    private final CompositionMethods compositionMethods;

    public WorksPanel() {
        compositionMethods = new CompositionMethods();
        setLayout(new BorderLayout());

        worksTableModel = new DefaultTableModel(new String[]{"ID", "Name", "Duration", "Media ID"}, 0);
        worksTable = new JTable(worksTableModel);
        add(new JScrollPane(worksTable), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Duration:"));
        durationField = new JTextField();
        inputPanel.add(durationField);
        inputPanel.add(new JLabel("Media ID:"));
        mediaIdField = new JTextField();
        inputPanel.add(mediaIdField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Composition");
        JButton deleteButton = new JButton("Delete Composition");
        JButton updateButton = new JButton("Update Composition");

        addButton.addActionListener(e -> addComposition());
        deleteButton.addActionListener(e -> deleteComposition());
        updateButton.addActionListener(e -> updateComposition());

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputPanel, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
        loadWorks();
    }

    private void loadWorks() {
        worksTableModel.setRowCount(0);
        compositionMethods.loadWorks(worksTableModel);
    }

    private void addComposition() {
        try {
            String name = nameField.getText();
            int duration = Integer.parseInt(durationField.getText());
            int mediaId = Integer.parseInt(mediaIdField.getText());

            compositionMethods.addComposition(name, duration, mediaId);
            loadWorks();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid values for Duration and Media ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteComposition() {
        int selectedRow = worksTable.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) worksTableModel.getValueAt(selectedRow, 0);
            compositionMethods.deleteComposition(id);
            loadWorks();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a composition to delete.", "Selection Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void updateComposition() {
        int selectedRow = worksTable.getSelectedRow();
        if (selectedRow != -1) {
            try {
                int id = (int) worksTableModel.getValueAt(selectedRow, 0);
                String name = nameField.getText();
                int duration = Integer.parseInt(durationField.getText());
                int mediaId = Integer.parseInt(mediaIdField.getText());

                compositionMethods.updateComposition(id, name, duration, mediaId);
                loadWorks();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter valid values for Duration and Media ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a composition to update.", "Selection Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}