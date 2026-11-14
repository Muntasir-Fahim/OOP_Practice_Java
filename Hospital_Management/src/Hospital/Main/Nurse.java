package Hospital.Main;

import java.util.ArrayList;

public class Nurse extends Staff{
    String shift;
    ArrayList<Patient> AssignedPatient = new ArrayList<>();

    public Nurse(int id,String name, String contact,String shift) {
        super(id,name, contact);
        this.shift = shift;
    }

    public int getId(){
        return super.id;
    }
    public String getName(){
        return super.name;
    }

    public void assingedPatient(Patient patient){
        if(!AssignedPatient.contains(patient)){
            AssignedPatient.add(patient);
        }
    }
}
