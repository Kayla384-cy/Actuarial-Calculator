import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class apppage extends JPanel {
    // private JTextField FName;
    // private JTextField LName;
    private JButton cmdlogin;
    private JButton cmdSignUp;
    private JTextField uname;
    // private JTextField pword;
    private JPasswordField pword;
    private JButton cmdExit;
    private apppage thisForm;
    private JPanel pnlHeader;
    private JPanel pnlCommand;
    private JPanel pnlDisplay;
    private ArrayList<User> userlist;
    private DefaultTableModel model;
    User user;

    // private ArrayList<Person> plist;

    public apppage() {
        super(new BorderLayout(40, 40));
        thisForm = this;

        pnlHeader = new JPanel();
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();

        pnlHeader.setSize(new Dimension(20, 20));
        pnlDisplay.setSize(new Dimension(50, 50));

        pnlCommand.setSize(new Dimension(20, 20));

        JLabel welcomeLabel = new JLabel("Welcome! Please log in below.", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setForeground(Color.black);
        pnlHeader.add(welcomeLabel);

        userlist = loadUser("UserDetails.txt");

        String[] columnNames = { "First Name",
                "Last Name", "Age", "Gender",
                "Username", "Password" };
        model = new DefaultTableModel(columnNames, 0);

        pnlDisplay.add(new JLabel("Enter your Username"));
        uname = new JTextField(12);
        pnlDisplay.add(uname, BorderLayout.NORTH);
        pnlDisplay.add(new JLabel("Enter Password"));
        pword = new JPasswordField(12);
        pword.setEchoChar('*');
        pnlDisplay.add(pword, BorderLayout.SOUTH);

        cmdlogin = new JButton("Login");
        cmdlogin.addActionListener(new LoginButtonListener());
        pnlDisplay.add(cmdlogin);

        JLabel SignupPrompt = new JLabel("Don't have an account? Sign Up Here", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setForeground(Color.black);
        pnlCommand.add(SignupPrompt);

        cmdSignUp = new JButton("Sign Up");
        cmdSignUp.addActionListener(new SignUpButtonListener());

        pnlCommand.add(cmdSignUp);

        add(pnlHeader, BorderLayout.NORTH);
        add(pnlDisplay, BorderLayout.CENTER);
        add(pnlCommand, BorderLayout.SOUTH);
        // pnlCommand.setLocation(20, 50);
        // setVisible(true);
        // pack();

    }

    private static void ShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("ACT SCI Calc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 400));
        JLabel label = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.blue, 3);
        label.setBorder(border);
        frame.add(label);
        // ImageIcon image = new ImageIcon("logo.png");
        // frame.setIconImage(image.getImage());

        // Create and set up the content pane.
        apppage newContentPane = new apppage();
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);

        // Display the window.
        frame.setVisible(true);
        frame.pack();
    }

    // private void addToTable(User s)
    // {
    // String[] item={s.getfname(),""+s.getlname(),""+ s.getage(),""+
    // s.getgender(),""+ s.getuname(),""+s.getpword(),""+s.getagree()};
    // model.addRow(item);
    // }

    public void addUser(User s) {
        userlist.add(s);
        // addToTable(s);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ShowGUI();
            }
        });
    }

    public ArrayList<User> loadUser(String ufile) {
        Scanner uscan = null;
        ArrayList<User> ulist = new ArrayList<User>();
        try {
            uscan = new Scanner(new File(ufile));
            while (uscan.hasNext()) {
                String[] nextLine = uscan.nextLine().split(" ");
                String fname = nextLine[0];
                String lname = nextLine[1];
                int age = Integer.parseInt(nextLine[2]);
                String gender;
                if (nextLine[3].equals("female"))
                    gender = "female";
                else
                    gender = "male";
                String uname = nextLine[4];
                String pword = nextLine[5];
                boolean agree = false;
                if (nextLine[6].equals("0"))
                    agree = false;
                else
                    agree = true;
                User u = new User(fname, lname, age, gender, uname, pword, agree);
                ulist.add(u);

            }
            uscan.close();
        } catch (IOException e) {
        } catch (NumberFormatException nfe) {
        }
        return ulist;
    }

    public ArrayList<User> getuserlist() {
        return userlist;
    }

    // private class LoginButtonListener implements ActionListener
    // {
    // public void actionPerformed(ActionEvent e){
    // check if username and password match in arraylist
    // }
    // }

    private class SignUpButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent s) {
            SignUp Entry = new SignUp(thisForm);
        }
    }

    private class LoginButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent l) {
            // Login Entry = new Login(thisForm);
            try {
                String username = uname.getText();
                // String password = pword.getText();
                char[] passwordChars = pword.getPassword();
                String password = new String(passwordChars);
                ArrayList<User> us = new ArrayList<User>();
                us = getuserlist();
                String userdetails = "";
                String userdet = username + " " + password;
                Boolean accepted = false;

                if (us.size() > 0) {
                    ArrayList<String> usernames = new ArrayList<String>();
                    ArrayList<String> users = new ArrayList<String>();
                    for (User usen : us) {
                        userdetails = usen.getuser();
                        // String unameer = unamee.getText();
                        // ArrayList<String> usernames = new ArrayList<String>();
                        usernames.add(userdetails);
                        // System.out.println(usernames);

                    }
                    // String Userdet = "";
                    if (usernames.contains(userdet)) {
                        // System.out.println(userdet);
                        Calculator Entry = new Calculator(thisForm);
                        // JFrame frame = new JFrame(" ");
                        // frame.add(Entry);
                        // frame.setVisible(true);
                        // setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Username or Password", "Error",
                                JOptionPane.PLAIN_MESSAGE);
                        ;
                    }

                }

                // System.out.println(usernames);
                // JOptionPane.showMessageDialog(null, "Please try again", "Username Taken",
                // JOptionPane.PLAIN_MESSAGE);
                // break;
                // } else
                // accepted = true;

                // }
                // }

                // }

                else {
                    accepted = true;
                }
                setVisible(false);

            } catch (NumberFormatException i) {
            }
        }
    }

}
