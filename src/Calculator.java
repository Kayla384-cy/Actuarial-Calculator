
//package con.mycompany.notepad;
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

import javax.swing.filechooser.*;

public class Calculator extends JFrame {
    private JPanel pnlCommand;
    private JPanel pnlDisplay;
    private JPanel pnlSimpleInterest;
    private JPanel pnlNotepad;
    private JPanel pnlCompoundInterest;
    private JPanel pnlButtons;
    private JButton cmdSimpleInterest;
    private JButton cmdNotepad;
    private JButton cmdCompoundInterest;
    private JButton cmdLogout;
    public apppage calc;
    private Calculator thisForm;

    private JTextField Principal;
    private JTextField Interest;
    private JTextField Time;
    private JTextField ans;
    private JButton Calc;
    private JMenuBar menu;
    private JMenu file;
    private JMenuItem New;
    private JMenuItem Open;
    private JMenuItem Save;
    private JTextArea area;

    public Calculator(apppage calc) {
        Calculator Entry = (this);
        this.calc = calc;
        // thisForm = this;
        setTitle("Calculator");

        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlSimpleInterest = new JPanel();
        pnlNotepad = new JPanel();
        pnlCompoundInterest = new JPanel();
        pnlButtons = new JPanel();
        pnlButtons.setBackground(Color.MAGENTA);

        // pnlDisplay.setLayout(new BoxLayout(pnlDisplay, BoxLayout.Y_AXIS));
        pnlDisplay.setLayout(new GridLayout(9, 5));
        pnlDisplay.setPreferredSize(new Dimension(500, 400));

        add(pnlDisplay, BorderLayout.CENTER);
        add(pnlCommand, BorderLayout.SOUTH);
        pnlDisplay.add(pnlButtons, BorderLayout.EAST);
        pnlDisplay.add(pnlSimpleInterest, BorderLayout.CENTER);
        pnlDisplay.add(pnlNotepad, BorderLayout.CENTER);
        pnlDisplay.add(pnlCompoundInterest, BorderLayout.CENTER);
        pnlDisplay.add(pnlButtons);

        cmdSimpleInterest = new JButton("Simple Interest");
        pnlButtons.add(cmdSimpleInterest);
        cmdSimpleInterest.addActionListener(new SimpleInterestListener());
        cmdNotepad = new JButton("Notepad");
        pnlButtons.add(cmdNotepad);
        cmdNotepad.addActionListener(new NotepadListener());
        cmdCompoundInterest = new JButton("Compund Interest");
        pnlButtons.add(cmdCompoundInterest);

        cmdLogout = new JButton("Logout");
        cmdLogout.addActionListener(new LogoutButtonListener());
        pnlButtons.add(cmdLogout);

        JFrame frame = new JFrame(" ");
        frame.add(pnlDisplay);
        frame.pack();
        frame.setVisible(true);

        Principal = new JTextField(12);
        Interest = new JTextField(12);
        Time = new JTextField(12);
        ans = new JTextField(12);
        Calc = new JButton("Calculate");

        menu = new JMenuBar();
        file = new JMenu("File");
        New = new JMenuItem("New");
        Open = new JMenuItem("Open");
        Save = new JMenuItem("Save");
        area = new JTextArea();

        // pack();
        // setVisible(true);
    }

    private class SimpleInterestListener implements ActionListener {
        public void actionPerformed(ActionEvent s) {
            try {
                pnlSimpleInterest.setBackground(Color.red);
                pnlSimpleInterest.setPreferredSize(new Dimension(100, 100));
                // pnlSimpleInterest.setVisible(true);
                pnlSimpleInterest.add(new JLabel("Principal"));
                // JTextField Principal = new JTextField(12);
                pnlSimpleInterest.add(Principal);
                pnlSimpleInterest.add(new JLabel("Interest"));
                /// JTextField Interest = new JTextField(12);
                pnlSimpleInterest.add(Interest);
                pnlSimpleInterest.add(new JLabel("Time"));
                // JTextField Time = new JTextField(12);
                pnlSimpleInterest.add(Time);
                // JButton Calc = new JButton("Calculate");
                pnlSimpleInterest.add(Calc);
                Calc.addActionListener(this);
                // JTextField ans = new JTextField(12);
                pnlSimpleInterest.add(ans);
                double T;
                String princtxt = Principal.getText();
                double princ = Double.parseDouble(princtxt);
                String intetxt = Interest.getText();
                double inte = Double.parseDouble(intetxt);
                String Ttxt = Time.getText();

                T = Double.parseDouble(Ttxt);

                double SI = princ * (inte / 100) * T;
                String si = Double.toString(SI);
                System.out.println(si);

                if (s.getActionCommand().equals("Calculate")) {
                    ans.setText(si);
                    System.out.println(princ);
                }
            } catch (NumberFormatException e) {

            }

        }
    }

    private class NotepadListener implements ActionListener {
        public void actionPerformed(ActionEvent n) {
            pnlNotepad.setBackground(Color.red);

            pnlNotepad.setPreferredSize(new Dimension(50, 50));
            // {pnlNotepad.setVisible(true);
            // setLayout(new GridLayout(100, 100));
            // setText("Start Here...");
            // s//etVisible(true);
            // pnlDisplay.setSize(50, 50);}
            // JMenuBar menu = new JMenuBar();
            // JMenu file = new JMenu("File");
            // JMenuItem New = new JMenuItem("New");
            New.addActionListener(this);
            // JMenuItem Open = new JMenuItem("Open");
            Open.addActionListener(this);
            // JMenuItem Save = new JMenuItem("Save");
            Save.addActionListener(this);
            // Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
            // ActionEvent.CTRL_MASK));
            menu.add(file);
            file.add(New);
            file.add(Open);
            file.add(Save);
            // JTextArea area = new JTextArea();
            area.setFont(new Font("Times New Roman", Font.PLAIN, 15));
            // area.setText("Start Here...");
            area.setEditable(true);
            String Data = area.getText();
            pnlNotepad.add(area, BorderLayout.CENTER);
            pnlNotepad.add(menu, BorderLayout.NORTH);
            // pnlNotepad.setJMenuBar(menu);
            pnlNotepad.setVisible(true);
            // JFrame frame = new JFrame(" ");
            // frame.add(pnlNotepad);
            // frame.pack();
            // frame.setVisible(true);}

            if (n.getActionCommand().equals("New"))
                area.setText("  ");
            else if (n.getActionCommand().equals("Open")) {
                JFileChooser chooser = new JFileChooser("C:/Users/kayla/Documents/Act sci/src/Notes");
                // chooser.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt");
                chooser.addChoosableFileFilter(restrict);
                // File filer = chooser.getSelectedFile();
                int result = chooser.showOpenDialog(pnlNotepad);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File filer = chooser.getSelectedFile();
                    try {
                        // Reading the file
                        FileReader reader = new FileReader(filer);
                        BufferedReader br = new BufferedReader(reader);
                        area.read(br, null);
                        // Closing the file after reading
                        // Clearing the memory
                        br.close();
                        area.requestFocus();

                    } catch (Exception e) {
                        System.out.print(e);
                    }
                }
            } else if (n.getActionCommand().equals("Save")) {
                JFileChooser SaveAs = new JFileChooser();
                SaveAs.setApproveButtonText("Save");
                int actionDialog = SaveAs.showOpenDialog(pnlNotepad);
                if (actionDialog != JFileChooser.APPROVE_OPTION) {
                    return;
                }

                try {
                    FileWriter fileName = new FileWriter(SaveAs.getSelectedFile() + ".txt");
                    // BufferedWriter outFile = null;
                    PrintWriter outWriter = new PrintWriter(new BufferedWriter(fileName));
                    // outFile = new BufferedWriter(new FileWriter(fileName));
                    outWriter.println(Data);
                    outWriter.close();
                    System.out.println("yes");

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }
    // public void Save(String fileName) {
    // try {
    // OutputStreamWriter out =
    // new OutputStreamWriter(openFileOutput(fileName, 0));
    // out.write(EditText1.);
    // out.close();
    // Toast.makeText(this, "Note Saved!", Toast.LENGTH_SHORT).show();
    // } catch (Throwable t) {
    // Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
    // }
    // }

    private class LogoutButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public double SIMPLE(double P, double I, double T) {
        double SI = P * (I / 100) * T;
        return SI;
    }

}
