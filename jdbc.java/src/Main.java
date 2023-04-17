import javax.swing.plaf.nimbus.State;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;


public class Main implements ActionListener {
    // LOGIN GUI
    private static JLabel intro;
    private static JLabel userLabel;
    private static  JTextField userText;
    private static JLabel pwLabel;
    private static JPasswordField pwText;
    private static JButton btn;
    private static JLabel message;
    private static JLabel register;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        intro = new JLabel("Welcome to University XYZ");
        intro.setBounds(100, 20, 300, 25);
        panel.add(intro);

        userLabel = new JLabel("Username");
        userLabel.setBounds(50, 60, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(120, 60, 165, 25);
        panel.add(userText);

        pwLabel = new JLabel("Password");
        pwLabel.setBounds(50, 90, 80, 25);
        panel.add(pwLabel);

        pwText = new JPasswordField();
        pwText.setBounds(120, 90, 165, 25);
        panel.add(pwText);

        btn = new JButton("Login");
        btn.setBounds(160, 120, 80, 25);
        btn.addActionListener(new Main());
        panel.add(btn);

        message = new JLabel("");
        message.setBounds(150, 150, 300, 25);
        panel.add(message);
        message.setText("");

        register = new JLabel("First time users, Register here");
        register.setBounds(100, 180, 200, 25);
        panel.add(register);

        userLabel = new JLabel("Username");
        userLabel.setBounds(50, 200, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(120, 200, 165, 25);
        panel.add(userText);

        pwLabel = new JLabel("Password");
        pwLabel.setBounds(50, 230, 80, 25);
        panel.add(pwLabel);

        pwText = new JPasswordField();
        pwText.setBounds(120, 230, 165, 25);
        panel.add(pwText);

        btn = new JButton("Register");
        btn.setBounds(160, 260, 80, 25);
        btn.addActionListener(new Main());
        panel.add(btn);

        message = new JLabel("");
        message.setBounds(150, 150, 300, 25);
        panel.add(message);
        message.setText("");

        frame.setVisible(true);



        // DATABASE CONNECTION
        String url = "jdbc:mysql://localhost::3300/Students";
        String username = "user";
        String password = "1234";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String query = "select * from percentage";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getInt(1));
        }
        statement.close();
        connection.close();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = pwText.getText();

        if(user.equals("user") && password.equals("1234")) {
            message.setText("Login Successful!");
        } else {
            message.setText("Invalid Login");
        }
    }
}