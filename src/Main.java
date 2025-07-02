import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Upper Left Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700); // Larger window to accommodate components
        frame.setLayout(new BorderLayout());

        // Create top panel for input components (aligned to top-left)
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create components for top panel
        JLabel clickLabel = new JLabel("Click Me");
        clickLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField inputField1 = new JTextField(20);
        JTextField inputField2 = new JTextField(20);
        JButton actionButton = new JButton("Submit");

        // Add components to top panel
        topPanel.add(clickLabel);
        topPanel.add(inputField1);
        topPanel.add(inputField2);
        topPanel.add(actionButton);

        // Create rectangle panel
        RectanglePanel rectanglePanel = new RectanglePanel();

        // Add panels to frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(rectanglePanel, BorderLayout.CENTER);

        // Create output text area
        JTextArea outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.SOUTH);

        // Add action listener to the button
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField1.getText() + " by " + inputField2.getText();
                outputArea.setText("The map will be drawn to: " + inputText);
            }
        });

        frame.setVisible(true);
    }
}

// Custom panel to draw the rectangle
class RectanglePanel extends JPanel {
    public RectanglePanel() {
        setPreferredSize(new Dimension(600, 500)); // Set fixed size
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw a big rectangle filling the panel
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw border
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);

        // Draw dimensions text
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.BLUE);
        String dimensions = getWidth() + " x " + getHeight();
        g.drawString(dimensions, getWidth()/2 - 30, getHeight()/2);
    }
}