import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Character.Subset;
import java.sql.SQLException;

import javax.security.auth.Subject;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

public class Registration extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JPasswordField passwordField;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField txtRegistrationForm;
    private JLabel lblNewLabel;
    private JCheckBox showPasswordCheckbox;
    private JButton btnSubmit;
    private JButton btnReset;

    private String password = "";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Registration frame = new Registration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Registration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 852, 699);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setForeground(new Color(255, 128, 255));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_1.setBounds(141, 156, 150, 27);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Username");
        lblNewLabel_2.setForeground(new Color(255, 128, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(167, 214, 131, 27);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Password");
        lblNewLabel_3.setForeground(new Color(255, 128, 255));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_3.setBounds(175, 263, 123, 39);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("DOB");
        lblNewLabel_4.setForeground(new Color(255, 128, 255));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(167, 329, 123, 38);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Contact No");
        lblNewLabel_5.setForeground(new Color(255, 0, 255));
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(175, 400, 126, 46);
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Address");
        lblNewLabel_6.setForeground(new Color(255, 0, 255));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(126, 469, 222, 39);
        contentPane.add(lblNewLabel_6);

        textField = new JTextField();
        textField.setBackground(new Color(255, 255, 255));
        textField.setBounds(361, 144, 178, 39);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(361, 200, 178, 39);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(366, 268, 173, 39);
        contentPane.add(passwordField);

        textField_3 = new JTextField();
        textField_3.setBounds(366, 335, 173, 32);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(366, 400, 173, 35);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(366, 475, 173, 33);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        btnSubmit = new JButton("Submit");
        btnSubmit.setForeground(new Color(128, 255, 255));
        btnSubmit.setBackground(new Color(255, 128, 255));
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                Connection con = null;
                Statement stmt = null;
                System.out.println("Welcome to the store");
               
                    // Show the success message and close the current window
               // JOptionPane.showMessageDialog(temporaryLostComponent, Subject.this, "Register successful!", defaultCloseOperation);
                Login l = new Login();
                l.setVisible(true);
                dispose();
                

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StoreHardware", "root", "anand123");
                    PreparedStatement pstmt = con.prepareStatement("insert into reg1 values (?,?,?,?,?,?)");
                    pstmt.setString(1, textField.getText());
                    pstmt.setString(2, textField_1.getText());
                    pstmt.setString(3, new String(passwordField.getPassword()));
                    pstmt.setString(4, textField_3.getText());
                    pstmt.setInt(5, Integer.valueOf(textField_4.getText()));
                    pstmt.setString(6, textField_5.getText());
                    int login = pstmt.executeUpdate();
                    String sql = "select * from reg1";
                    stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getInt(5) + rs.getString(6));
                    }
                } catch (Exception e1) {
                    System.out.println(e1);
                } finally {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    if (con != null) {
                        try {
                            con.close();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
        btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnSubmit.setBounds(427, 544, 150, 39);
        contentPane.add(btnSubmit);

        txtRegistrationForm = new JTextField();
        txtRegistrationForm.setForeground(new Color(0, 128, 255));
        txtRegistrationForm.setFont(new Font("Tahoma", Font.BOLD, 20));
        txtRegistrationForm.setHorizontalAlignment(SwingConstants.CENTER);
        txtRegistrationForm.setText("Registration Form");
        txtRegistrationForm.setBounds(277, 42, 344, 58);
        contentPane.add(txtRegistrationForm);
        txtRegistrationForm.setColumns(10);

        showPasswordCheckbox = new JCheckBox("Show Password");
        showPasswordCheckbox.setFont(new Font("Tahoma", Font.BOLD, 16));
        showPasswordCheckbox.setHorizontalAlignment(SwingConstants.CENTER);
        showPasswordCheckbox.setBackground(new Color(255, 255, 255));
        showPasswordCheckbox.setBounds(567, 263, 164, 39);
        contentPane.add(showPasswordCheckbox);

        showPasswordCheckbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckbox.isSelected()) {
                    // Show the password
                    passwordField.setEchoChar((char) 0);
                } else {
                    // Hide the password
                    passwordField.setEchoChar('*'); // Replace with password character (e.g., '*')
                }
            }
        });

        btnReset = new JButton("Reset");
        btnReset.setForeground(new Color(0, 128, 255));
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnReset.setBounds(265, 544, 123, 21);
        contentPane.add(btnReset);

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear all text fields
                textField.setText("");
                textField_1.setText("");
                passwordField.setText("");
                textField_3.setText("");
                textField_4.setText("");
                textField_5.setText("");

                // Uncheck the "Show Password" checkbox
                showPasswordCheckbox.setSelected(false);
                // Hide the password
                passwordField.setEchoChar('*'); // Replace with password character (e.g., '*')
            }
        });

        lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(-13, 0, 841, 607);
        contentPane.add(lblNewLabel);
        String imagepath = "C:\\Users\\anand\\Downloads\\bg1.jpg";
        ImageIcon image = new ImageIcon(imagepath);
        lblNewLabel.setIcon(image);
    }
}
