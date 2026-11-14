package Hospital.Main;

import java.util.*;

public class Doctor extends Staff {
    String specialization;
    int fee;

    ArrayList<Patient> patientList = new ArrayList<>();

    public Doctor(int id,String name, String contact,String specialization, int fee) {
        super(id,name,contact);
        this.specialization = specialization;
        this.fee = fee;
    }

    public int getDocId(){
        return super.id;
    }

    public String getName(){
        return super.name;
    }

    public void assignPatient(Patient patient){
        if(!patientList.contains(patient)){
            patientList.add(patient);
        }
    }

    public void removePatient(){

    }

}
