import javax.swing.*;
import java.awt.Frame;
import java.awt.event.*;
import java.util.ArrayList;

public class Listener implements ActionListener {
    private Frame frame;
    private ArrayList<String> books = new ArrayList<>();
    private int index;

    public Listener(Frame frame) {
        this.frame = frame;
        index = 0;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object component = actionEvent.getSource();
        JButton button = new JButton();
        if (component instanceof JButton) {
            button = (JButton) component;

            if (button.getText().equalsIgnoreCase("Next")) {
                if (index < books.size() - 1) {
                    index++;
                } else {
                    index = 0;
                }
            } else if (button.getText().equalsIgnoreCase("Back")) {
                if (index > 0) {
                    index--;
                } else {
                    index = books.size() - 1;
                }
            }

            // using books array for demonstration
            frame.setTitle(books.get(index));
        }
    }
}
