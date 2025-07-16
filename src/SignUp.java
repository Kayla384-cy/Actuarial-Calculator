import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.*;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SignUp extends JFrame {
    private JTextField FName;
    private JTextField LName;
    private JTextField Age;
    private JTextField uname;
    // private JTextField pword;
    private JPasswordField pword;
    private JCheckBox agree;
    private JPanel radioPanel;
    private JRadioButton female;
    private JRadioButton male;
    private JPanel pnlCommand;
    private JPanel pnlDisplay;
    private JButton signup;
    public apppage use;
    ButtonGroup gender = new ButtonGroup();
    User user;
    // private ArrayList<User> userlist;

    public SignUp(apppage use) {
        SignUp Entry = (this);
        this.use = use;
        setTitle("Sign Up");

        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlDisplay.setLayout(new GridLayout(14, 3));
        pnlDisplay.setPreferredSize(new Dimension(600, 400));

        pnlDisplay.add(new JLabel("Enter your first name:"));
        FName = new JTextField(3);
        pnlDisplay.add(FName);
        pnlDisplay.add(new JLabel("Enter your last name"));
        LName = new JTextField(3);
        pnlDisplay.add(LName);
        pnlDisplay.add(new JLabel("Age"));
        Age = new JTextField(1);
        pnlDisplay.add(Age);
        pnlDisplay.add(new JLabel("Gender"));
        female = new JRadioButton("F");
        male = new JRadioButton("M");
        gender.add(female);
        gender.add(male);
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(female);
        radioPanel.add(male);
        pnlDisplay.add(radioPanel);
        // pnlDisplay.add(female);
        // pnlDisplay.add(male);
        pnlDisplay.add(new JLabel("Create a Username"));
        uname = new JTextField(3);
        pnlDisplay.add(uname);
        pnlDisplay.add(new JLabel("Create a Password"));
        pword = new JPasswordField(3);
        pword.setEchoChar('*');
        pnlDisplay.add(pword);

        pnlDisplay.add(new JLabel("Do you accept the terms and conditions?"));
        agree = new JCheckBox();
        pnlDisplay.add(agree);
        // agree.addActionListener(new AgreeActionListener());
        signup = new JButton("Sign Up");
        pnlCommand.add(signup);
        signup.addActionListener(new SignupButtonListener());

        add(pnlDisplay, BorderLayout.CENTER);
        add(pnlCommand, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }

    private class SignupButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            try {
                String fname = FName.getText();
                String lname = LName.getText();

                String agetxt = Age.getText();
                Boolean ageval = false;
                // int age = 0;
                // try {
                int age = Integer.parseInt(agetxt);
                // ageval = true;
                // } catch (NumberFormatException e) {
                // }
                // if (age > 0)
                // ageval = true;
                // else {
                // JOptionPane.showMessageDialog(null, "Age Must Be a Number", "Age must be a
                // number",
                // JOptionPane.PLAIN_MESSAGE);
                // }

                String username = uname.getText();
                char[] passwordChars = pword.getPassword();
                String password = new String(passwordChars);
                Boolean checked = false;
                Boolean accepted = false;
                Boolean gen = false;

                // System.out.println(uname.getText());
                if (agree.isSelected()) {
                    checked = true;
                }
                Enumeration<AbstractButton> abstractButtons = gender.getElements();
                JRadioButton radioButton = null;

                while (abstractButtons.hasMoreElements()) {
                    radioButton = (JRadioButton) abstractButtons.nextElement();
                    if (radioButton.isSelected()) {
                        gen = true;
                        break;
                    }
                }
                // User user;

                String gendertxt = radioButton.getText();
                String unamee = "";
                // System.out.println(gendertxt);
                ArrayList<User> us = new ArrayList<User>();
                us = SignUp.this.use.getuserlist();
                // ArrayList<String> usernames = new ArrayList<String>();
                // System.out.println(us);
                // StudentEntry.this.student.addStudent(student);
                // for(int i=0;i<SignUp.this.use.getuserlist().size(); i++){
                if (us.size() > 0) {
                    ArrayList<String> usernames = new ArrayList<String>();
                    for (User usen : us) {
                        unamee = usen.getuname();
                        // String unameer = unamee.getText();
                        // ArrayList<String> usernames = new ArrayList<String>();
                        usernames.add(unamee);
                        System.out.println(usernames);

                    }

                    // for (int i = 0; i < usernames.size(); i++) {
                    if (usernames.contains(username)) {

                        System.out.println(usernames);
                        JOptionPane.showMessageDialog(null, "Please try again", "Username Taken",
                                JOptionPane.PLAIN_MESSAGE);
                        // break;
                    } else
                        accepted = true;

                    // System.out.println(unamee);
                    // if (username != unamee) {
                    // accepted = true;
                    // JOptionPane.showMessageDialog(null, "Please try again", "Username Taken",
                    // JOptionPane.PLAIN_MESSAGE);
                    // System.out.println(unamee);
                    // user = new User(fname, lname, age, gendertxt, username, password, checked);
                    // SignUp.this.use.addUser(user);
                    // JOptionPane.showMessageDialog(null, "Successfully SignedUp");

                    // else {
                    // // JOptionPane.showMessageDialog(null, "Please try again", "Username Taken",
                    // // JOptionPane.PLAIN_MESSAGE);
                    // accepted = true;
                    // // System.out.println(username);

                    // }
                    // break;
                }
                // }

                // }

                else {
                    accepted = true;
                }
                if ((accepted == true) && (checked == true) && (gen == true) && (ageval = true)) {
                    User userinfo = new User(fname, lname, age, gendertxt, username, password,
                            checked);
                    SignUp.this.use.addUser(userinfo);
                    // JOptionPane.showMessageDialog(null, "Successfully SignedUp");
                    // System.out.println(userinfo.getuser());
                    try {
                        FileWriter file = new FileWriter("UserDetails.txt", true);
                        PrintWriter outWriter = new PrintWriter(new BufferedWriter(file));
                        JOptionPane.showMessageDialog(null, "Successfully SignedUp");
                        outWriter.println(userinfo);
                        outWriter.close();
                        setVisible(false);
                    } catch (IOException io) {
                    }
                }

            } catch (

            NumberFormatException e) {

            }
            // setVisible(false);

        }
    }

}
