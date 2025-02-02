package Assignment_4;

import Assignment_4.Main_body.Collection;
import Assignment_4.Main_body.MusicalMedia;
import Assignment_4.Main_body.MusicalWork;

import javax.swing.*;
import java.awt.*;

public class MusicCollectionApp extends JFrame {
    private Collection collection;
    private DefaultListModel<String> albumListModel;
    private DefaultListModel<String> workListModel;

    // Элементы интерфейса
    private JTextField collectionNameField;
    private JTextField ownerNameField;
    private JTextField albumAuthorField;
    private JTextField albumGenreField;
    private JTextField albumYearField;
    private JTextField workNameField;
    private JTextField workDurationField;
    private JList<String> albumList;
    private JList<String> workList;
    private JTextArea outputArea;

    public MusicCollectionApp() {
        collection = new Collection("Моя музыкальная коллекция", "Иван Иванов");

        // Настройка окна
        setTitle("Музыкальная Коллекция");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Панель ввода данных
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Название коллекции:"));
        collectionNameField = new JTextField(collection.getName());
        inputPanel.add(collectionNameField);

        inputPanel.add(new JLabel("Владелец коллекции:"));
        ownerNameField = new JTextField(collection.getOwnerName());
        inputPanel.add(ownerNameField);

        inputPanel.add(new JLabel("Автор альбома:"));
        albumAuthorField = new JTextField();
        inputPanel.add(albumAuthorField);

        inputPanel.add(new JLabel("Жанр альбома:"));
        albumGenreField = new JTextField();
        inputPanel.add(albumGenreField);

        inputPanel.add(new JLabel("Год альбома:"));
        albumYearField = new JTextField();
        inputPanel.add(albumYearField);

        inputPanel.add(new JLabel("Название произведения:"));
        workNameField = new JTextField();
        inputPanel.add(workNameField);

        inputPanel.add(new JLabel("Продолжительность произведения:"));
        workDurationField = new JTextField();
        inputPanel.add(workDurationField);

        add(inputPanel, BorderLayout.NORTH);

        // Списки для отображения альбомов и произведений
        albumListModel = new DefaultListModel<>();
        albumList = new JList<>(albumListModel);
        albumList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane albumScrollPane = new JScrollPane(albumList);
        add(albumScrollPane, BorderLayout.WEST);

        workListModel = new DefaultListModel<>();
        workList = new JList<>(workListModel);
        workList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane workScrollPane = new JScrollPane(workList);
        add(workScrollPane, BorderLayout.CENTER);

        // Панель для кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));

        JButton addAlbumButton = new JButton("Добавить альбом");
        addAlbumButton.addActionListener(e -> addAlbum());
        buttonPanel.add(addAlbumButton);

        JButton addWorkButton = new JButton("Добавить произведение");
        addWorkButton.addActionListener(e -> addWork());
        buttonPanel.add(addWorkButton);

        JButton searchButton = new JButton("Поиск произведения");
        searchButton.addActionListener(e -> searchWork());
        buttonPanel.add(searchButton);

        JButton removeAlbumButton = new JButton("Удалить альбом");
        removeAlbumButton.addActionListener(e -> removeAlbum());
        buttonPanel.add(removeAlbumButton);

        add(buttonPanel, BorderLayout.EAST);

        // Панель для вывода информации
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        add(outputScrollPane, BorderLayout.SOUTH);
    }

    // Добавить альбом в коллекцию
    private void addAlbum() {
        String author = albumAuthorField.getText();
        String genre = albumGenreField.getText();
        int year = Integer.parseInt(albumYearField.getText());

        MusicalMedia album = new MusicalMedia(author, genre, year);
        collection.addMedia(album);
        albumListModel.addElement("Альбом: " + author + " (" + year + ")");
        outputArea.append("Альбом добавлен: " + author + "\n");
    }

    // Добавить музыкальное произведение
    private void addWork() {
        String name = workNameField.getText();
        int duration = Integer.parseInt(workDurationField.getText());

        MusicalWork work = new MusicalWork(name, duration);
        MusicalMedia selectedAlbum = albumList.getSelectedValue() != null ? collection.getMedia().get(albumList.getSelectedIndex()) : null;

        if (selectedAlbum != null) {
            selectedAlbum.addWork(work);
            workListModel.addElement(name + " (" + duration + " сек)");
            outputArea.append("Произведение добавлено: " + name + "\n");
        } else {
            outputArea.append("Выберите альбом для добавления произведения.\n");
        }
    }

    // Поиск произведения по названию
    private void searchWork() {
        String title = workNameField.getText();
        MusicalWork foundWork = collection.searchWork(title);
        if (foundWork != null) {
            outputArea.append("Найдено произведение: " + foundWork.getName() +
                    " в альбоме: " + foundWork.getMusicalMedia().getAuthor() + "\n");
        } else {
            outputArea.append("Произведение не найдено.\n");
        }
    }

    // Удалить выбранный альбом
    private void removeAlbum() {
        int selectedIndex = albumList.getSelectedIndex();
        if (selectedIndex != -1) {
            MusicalMedia selectedAlbum = collection.getMedia().get(selectedIndex);
            collection.removeMedia(selectedAlbum);
            albumListModel.remove(selectedIndex);
            outputArea.append("Альбом удален.\n");
        } else {
            outputArea.append("Выберите альбом для удаления.\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MusicCollectionApp app = new MusicCollectionApp();
            app.setVisible(true);
        });
    }
}
