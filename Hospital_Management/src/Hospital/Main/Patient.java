package Hospital.Main;

import java.util.*;

public class Patient {
    private String name;
    private String contact;
    private int patientId;
    private Ward currentWard;


    Random random = new Random();

    ArrayList<Doctor> assignedDoctor;
    ArrayList<Nurse> assignedNurse;

    public Patient(int id,String name, String contact) {
        this.name = name;
        this.contact = contact;
        this.patientId = id;
        //this.patientId = random.nextInt(1000)+3000;
        this.assignedDoctor = new ArrayList<>();
        this.assignedNurse = new ArrayList<>();
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public void setCurrentWard(Ward ward){
        this.currentWard = ward;
    }

    public void AssignDoctor(Doctor doctor){
        if(!assignedDoctor.contains(doctor)){
            assignedDoctor.add(doctor);
        }
    }

    public void assignNurse(Nurse nurse){
        if(!assignedNurse.contains(nurse)){
            assignedNurse.add(nurse);
        }
    }

    public void removeDoctor(){
        
    }

}
