import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class BookOrganizer extends JFrame implements ActionListener {
    private JButton addButton, deleteButton, displayButton;
    private JTextField bookField;
    private JTextArea displayArea;
    private ArrayList<String> books;

    public BookManager() {
        // Initialize GUI components
        setLayout(new FlowLayout());

        bookField = new JTextField(20);
        add(bookField);

        addButton = new JButton("Add Book");
        addButton.addActionListener(this);
        add(addButton);

        deleteButton = new JButton("Delete Book");
        deleteButton.addActionListener(this);
        add(deleteButton);

        displayButton = new JButton("Display Books");
        displayButton.addActionListener(this);
        add(displayButton);

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false); // Display area non-editable
        add(new JScrollPane(displayArea));

        books = new ArrayList<>();

        setTitle("Book Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String bookName = bookField.getText().trim();

        if (e.getSource() == addButton) {
            if (!bookName.isEmpty()) {
                books.add(bookName);
                JOptionPane.showMessageDialog(this, "Book added!");
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a book name.");
            }
        } else if (e.getSource() == deleteButton) {
            if (books.remove(bookName)) {
                JOptionPane.showMessageDialog(this, "Book removed!");
            } else {
                JOptionPane.showMessageDialog(this, "Book not found.");
            }
        } else if (e.getSource() == displayButton) {
            Collections.sort(books);
            displayArea.setText(String.join("\n", books));
        }
    }

    public static void main(String[] args) {
        new BookManager();
    }
}
