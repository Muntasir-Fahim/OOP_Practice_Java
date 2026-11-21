package Hospital.Main;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstUI extends javax.swing.JFrame {
    private JPanel testpane;
    private JTextField textField1;
    private JButton Button1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel ID;
    private JLabel Name;
    private JLabel Phone;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel Optional1;
    private JLabel Optional2;
    private JButton addBuildingButton;
    private JButton addDoctorButton;
    private JButton addNurseButton;
    private JButton admitPatientButton;
    private JButton assignDoctorButton;
    private JTextArea textArea1;

    public FirstUI() {
//        testpane = new JPanel();
//        testpane.setBackground(Color.black);
        setContentPane(testpane);
        setVisible(true);
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Green leaf Hospital");
        Button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello");
                setEnabled(false);
            }
        });
    }

}

