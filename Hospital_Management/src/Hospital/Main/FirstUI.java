package Hospital.Main;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstUI extends JFrame implements ActionListener{
    private JPanel testpane;
    private JTextField idField;
    private JButton addWardButton;
    private JTextField phoneField;
    private JTextField nameField;
    private JLabel ID;
    private JLabel Name;
    private JLabel Phone;
    private JTextField optionalField1;
    private JTextField optionalField2;
    private JLabel Optional1;
    private JLabel Optional2;
    private JButton addBuildingButton;
    private JButton addDoctorButton;
    private JButton addNurseButton;
    private JButton admitPatientButton;
    private JButton assignDoctorButton;
    private JTextArea outputArea;
    private JButton assignNurseButton;
    private JButton removePatientButton;


    public FirstUI() {
//        testpane = new JPanel();
//        testpane.setBackground(Color.black);
        setContentPane(testpane);
        setVisible(true);
        setSize(450, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Green leaf Hospital");
        //outputArea.setText("Output Will be shown here.....");
        outputArea.setEditable(false);
        addWardButton.addActionListener(this);
        addBuildingButton.addActionListener(this);
        addDoctorButton.addActionListener(this);
        addNurseButton.addActionListener(this);
        admitPatientButton.addActionListener(this);
        assignDoctorButton.addActionListener(this);


        //pack();
    }

    HospitalSystem hospital = new HospitalSystem("Green leaf Hospital");

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addBuildingButton){
            int id =  Integer.parseInt(idField.getText());
            String name = nameField.getText();

            hospital.addBuilding(id, name);

            outputArea.append("\n"+"Building "+ name +" Added Successfully!" + "\n");
        }
        else if(e.getSource() == addWardButton){
            int id =  Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int buildingId =  Integer.parseInt(optionalField1.getText());
            hospital.addWard(id, name, buildingId);

            outputArea.append("\n"+"Ward "+name +" Added in "+ hospital.searchBuilding(buildingId).getBuildingName() +" Successfully!" + "\n");
        }
        else if (e.getSource() == addDoctorButton) {
            int id =  Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String phone = phoneField.getText();
            String spec =  optionalField1.getText();
            int fee = Integer.parseInt(optionalField2.getText());

            hospital.addDoc(id,name,phone,spec,fee);

            outputArea.append("\n"+name +" ,"+spec+" Specialist Added Successfully!" + "\n");

        }
        else if (e.getSource() == addNurseButton) {
            int id =  Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String phone = phoneField.getText();
            String shift =  optionalField1.getText();

            hospital.addNurse(id,name,phone,shift);

            outputArea.append("\n" + "Nurse "+name +" Added Successfully!" + "\n");


        }
        else if (e.getSource() == admitPatientButton) {
            int id =  Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String phone = phoneField.getText();
            int wardId =  Integer.parseInt(optionalField1.getText());
            int doctorId = Integer.parseInt(optionalField2.getText());

            hospital.admitPatient(id,name,phone,wardId,doctorId);

            outputArea.append("\n" + name + "Admitted in "+ hospital.searchWard(wardId).getWardName() +" Successfully!  " + "Referred by " + hospital.searchDoc(doctorId).getName() + "\n");

        }
        else if (e.getSource() == assignDoctorButton) {
            int id =  Integer.parseInt(idField.getText());
            int doctorId = Integer.parseInt(optionalField2.getText());

            hospital.assignDoctorToPatient(id, doctorId);

            outputArea.append("\n"+ hospital.searchDoc(doctorId).getName() + " will take care " +hospital.searchPatient(id).getName()+" too from now" + "\n");
        }
        else if(e.getSource() == assignNurseButton){
            int id =  Integer.parseInt(idField.getText());
            int nurseId = Integer.parseInt(optionalField2.getText());

            hospital.assignNurseToPatient(id,nurseId);

            outputArea.append("\n"+"Nurse " + hospital.searchNurse(nurseId).getName() + " assigned to "+hospital.searchPatient(id).getName()+" Successfully!" + "\n");

        }

        else if(e.getSource() == removePatientButton){
            int id =  Integer.parseInt(idField.getText());
            hospital.removePatient(id);

            outputArea.append("\n" + hospital.searchPatient(id).getName()+" is discharged successfully!" + "\n");
        }


    }

}

