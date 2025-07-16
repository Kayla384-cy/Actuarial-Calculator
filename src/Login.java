// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;

// import java.io.*;
// import java.util.Enumeration;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.Scanner;

// public class Login extends JFrame {
// private JTextField uname;
// private JTextField pword;
// private JPanel pnlCommand;
// private JPanel pnlDisplay;
// private JButton login;
// public apppage use;
// //public apppage thisForm;
// User user;
// private Login thisForm;
// // private ArrayList<User> userlist;

// public Login(apppage use) {

// Login Entry = (this);
// this.use = use;
// setTitle("Login");
// //super(thisForm);
// thisForm = this;

// pnlCommand = new JPanel();
// pnlDisplay = new JPanel();
// pnlDisplay.setLayout(new GridLayout(9, 5));
// pnlDisplay.setPreferredSize(new Dimension(1000, 800));

// pnlDisplay.add(new JLabel("Create a Username"));
// uname = new JTextField(3);
// pnlDisplay.add(uname);
// pnlDisplay.add(new JLabel("Create a Password"));
// pword = new JTextField(3);
// pnlDisplay.add(pword);

// login = new JButton("Login");
// pnlCommand.add(login);
// login.addActionListener(new LoginButtonListener());

// add(pnlDisplay, BorderLayout.CENTER);
// add(pnlCommand, BorderLayout.SOUTH);
// pack();
// setVisible(true);

// }

// private class LoginButtonListener implements ActionListener {
// public void actionPerformed(ActionEvent a) {
// try {
// String username = uname.getText();
// String password = pword.getText();
// ArrayList<User> us = new ArrayList<User>();
// us = Login.this.use.getuserlist();
// String userdetails = "";
// String userdet = username + " " + password;
// Boolean accepted = false;

// if (us.size() > 0) {
// ArrayList<String> usernames = new ArrayList<String>();
// ArrayList<String> users = new ArrayList<String>();
// for (User usen : us) {
// userdetails = usen.getuser();
// // String unameer = unamee.getText();
// // ArrayList<String> usernames = new ArrayList<String>();
// usernames.add(userdetails);
// // System.out.println(usernames);

// }
// // String Userdet = "";
// if (usernames.contains(userdet)) {
// // System.out.println(userdet);
// Calculator Entry = new Calculator(thisForm);
// setVisible(true);

// } else {
// JOptionPane.showMessageDialog(null, "Wrong Username or Password", "Error",
// JOptionPane.PLAIN_MESSAGE);
// ;
// }

// }

// // System.out.println(usernames);
// // JOptionPane.showMessageDialog(null, "Please try again", "Username Taken",
// // JOptionPane.PLAIN_MESSAGE);
// // break;
// // } else
// // accepted = true;

// // }
// // }

// // }

// else {
// accepted = true;
// }

// } catch (NumberFormatException i) {
// }
// }
// }
// }