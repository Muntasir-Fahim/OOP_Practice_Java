package Hospital.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleHospitalUI extends JFrame implements ActionListener {

    private HospitalSystem hospital;

    // Simple text boxes (same style as Sir's UI)
    private JTextField idField;
    private JTextField nameField;
    private JTextField contactField;
    private JTextField extra1Field; // e.g., Building ID / Specialization / Shift / Ward ID / Nurse ID
    private JTextField extra2Field; // e.g., Fee / Doctor ID

    private JButton addBuildingBtn;
    private JButton addWardBtn;
    private JButton addDoctorBtn;
    private JButton addNurseBtn;
    private JButton admitPatientBtn;
    private JButton assignNurseBtn;
    private JButton assignDoctorBtn;
    private JButton removePatientBtn;

    private JTextArea displayArea;

    public SimpleHospitalUI(HospitalSystem hospital) {
        this.hospital = hospital;

        setTitle("Green Leaf Hospital");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        ((JComponent) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));

        // LEFT PANEL: Inputs + Action Buttons
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JPanel inputGrid = new JPanel(new GridLayout(5, 2, 5, 8));
        inputGrid.add(new JLabel("ID:"));
        idField = new JTextField(15);
        inputGrid.add(idField);

        inputGrid.add(new JLabel("Name:"));
        nameField = new JTextField(15);
        inputGrid.add(nameField);

        inputGrid.add(new JLabel("Contact:"));
        contactField = new JTextField(15);
        inputGrid.add(contactField);

        inputGrid.add(new JLabel("Extra 1 (Bldg/Spec/Shift/Ward/Nurse):"));
        extra1Field = new JTextField(15);
        inputGrid.add(extra1Field);

        inputGrid.add(new JLabel("Extra 2 (Fee / Doctor ID):"));
        extra2Field = new JTextField(15);
        inputGrid.add(extra2Field);

        leftPanel.add(inputGrid);
        leftPanel.add(Box.createVerticalStrut(10));

        JPanel buttonGrid = new JPanel(new GridLayout(4, 2, 5, 5));
        addBuildingBtn = new JButton("Add Building");
        addWardBtn = new JButton("Add Ward");
        addDoctorBtn = new JButton("Add Doctor");
        addNurseBtn = new JButton("Add Nurse");
        admitPatientBtn = new JButton("Admit Patient");
        assignNurseBtn = new JButton("Assign Nurse");
        assignDoctorBtn = new JButton("Assign Doctor");
        removePatientBtn = new JButton("Remove Patient");

        JButton[] buttons = {
                addBuildingBtn, addWardBtn, addDoctorBtn, addNurseBtn,
                admitPatientBtn, assignNurseBtn, assignDoctorBtn, removePatientBtn
        };

        for (JButton btn : buttons) {
            btn.addActionListener(this);
            buttonGrid.add(btn);
        }

        leftPanel.add(buttonGrid);
        add(leftPanel, BorderLayout.WEST);

        // RIGHT / CENTER PANEL: Display Box
        displayArea = new JTextArea(12, 32);
        displayArea.setText("Type values on the left and click a button.\n");
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        displayArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Output"));
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        try {
            if (src == addBuildingBtn) {
                int id = Integer.parseInt(idField.getText().trim());
                String name = nameField.getText().trim();
                hospital.addBuilding(id, name);
                displayArea.append("Added Building: ID=" + id + ", Name=" + name + "\n");
            } else if (src == addWardBtn) {
                int id = Integer.parseInt(idField.getText().trim());
                String name = nameField.getText().trim();
                int bldng = Integer.parseInt(extra1Field.getText().trim());
                hospital.addWard(id, name, bldng);
                displayArea.append("Added Ward: ID=" + id + ", Name=" + name + ", Bldg=" + bldng + "\n");
            } else if (src == addDoctorBtn) {
                int id = Integer.parseInt(idField.getText().trim());
                String name = nameField.getText().trim();
                String cnt = contactField.getText().trim();
                String spl = extra1Field.getText().trim();
                int fee = Integer.parseInt(extra2Field.getText().trim());
                hospital.addDoc(id, name, cnt, spl, fee);
                displayArea.append("Added Doctor: ID=" + id + ", Name=" + name + "\n");
            } else if (src == addNurseBtn) {
                int id = Integer.parseInt(idField.getText().trim());
                String name = nameField.getText().trim();
                String cnt = contactField.getText().trim();
                String sft = extra1Field.getText().trim();
                hospital.addNurse(id, name, cnt, sft);
                displayArea.append("Added Nurse: ID=" + id + ", Name=" + name + "\n");
            } else if (src == admitPatientBtn) {
                int id = Integer.parseInt(idField.getText().trim());
                String name = nameField.getText().trim();
                String cnt = contactField.getText().trim();
                int wardId = Integer.parseInt(extra1Field.getText().trim());
                int doctorId = Integer.parseInt(extra2Field.getText().trim());
                hospital.admitPatient(id, name, cnt, wardId, doctorId);
                displayArea.append("Patient has been admitted: ID=" + id + ", Name=" + name + "\n");
            } else if (src == assignNurseBtn) {
                int id = Integer.parseInt(idField.getText().trim());
                int nurseId = Integer.parseInt(extra1Field.getText().trim());
                hospital.assignNurseToPatient(id, nurseId);
                displayArea.append("Assigned Nurse " + nurseId + " to Patient " + id + "\n");
            } else if (src == assignDoctorBtn) {
                int id = Integer.parseInt(idField.getText().trim());
                int doctorId = Integer.parseInt(extra2Field.getText().trim());
                hospital.assignDoctorToPatient(id, doctorId);
                displayArea.append("Assigned Doctor " + doctorId + " to Patient " + id + "\n");
            } else if (src == removePatientBtn) {
                int id = Integer.parseInt(idField.getText().trim());
                hospital.removePatient(id);
                displayArea.append("Removed Patient: ID=" + id + "\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number in number fields!");
        }
    }
}