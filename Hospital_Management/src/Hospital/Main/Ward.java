package Hospital.Main;

import java.util.*;

public class Ward {
    private int wardId;
    private String wardName;
    private ArrayList<Patient> assignedPatient;
    private ArrayList<Nurse> assignedNurse;

    Random random = new Random();

    public Ward(int wardId,String wardName) {
        this.wardId = wardId;
        this.wardName = wardName;
        //this.wardId = random.nextInt(100)+2000;
        assignedPatient = new ArrayList<>();
        assignedNurse = new ArrayList<>();
    }

    public int getWardId() {
        return wardId;
    }

    public String getWardName() {
        return wardName;
    }

    public void assignPatient(Patient patient){
        if(!assignedPatient.contains(patient)){
            assignedPatient.add(patient);
        }
        else System.out.println("Already added");
    }

    public void assignNurse(Nurse nurse){
        if(!assignedNurse.contains(nurse)){
            assignedNurse.add(nurse);
        }
    }

}
