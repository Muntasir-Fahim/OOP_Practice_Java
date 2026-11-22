package Hospital.Main;

import java.util.ArrayList;

public class HospitalSystem {
    String name;

    public HospitalSystem(String name) {
        this.name = name;
    }

    private ArrayList<Building> BuildingList = new ArrayList<>();
    private ArrayList<Doctor> DoctorList = new ArrayList<>();
    private ArrayList<Nurse> NurseList = new ArrayList<>();
    private ArrayList<Ward> WardList = new ArrayList<>();
    private ArrayList<Patient> PatientList = new ArrayList<>();

    public void addDoc(int id,String name, String contact,String specialization, int fee){
        Doctor doc = new Doctor(id,name,contact,specialization,fee);
        DoctorList.add(doc);
        //System.out.println("Successfully added "+name);
    }

    public void addNurse(int id,String name, String contact,String shift){
        Nurse nrc = new Nurse(id,name,contact,shift);
        NurseList.add(nrc);
    }

    public void addBuilding(int id,String buildingName){
        Building bld = new Building(id,buildingName);
        BuildingList.add(bld);
        //System.out.println("Added Building "+buildingName);
    }

    public void addWard(int id,String name,int blngId){
        Ward ward = new Ward(id,name);
        WardList.add(ward);
        addWardInBuiling(id,blngId);
    }

    public Doctor searchDoc(int id){
        for(Doctor doc: DoctorList){
            if(doc.getDocId() == id){
                return doc;
            }
        }
        return null;
    }
    public Ward searchWard(int id){
        for(Ward ward : WardList){
            if(ward.getWardId() == id){
                return ward;
            }
        }
        return null;
    }
    public Patient searchPatient(int id){
        for(Patient patient: PatientList){
            if(patient.getPatientId() == id){
                return patient;
            }
        }
        return null;
    }
    public Nurse searchNurse(int id){
        for (Nurse nurse: NurseList){
            if(nurse.getId() == id){
                return nurse;
            }
        }
        return null;
    }
    public Building searchBuilding(int id){
        for(Building building: BuildingList){
            if(building.getBuildingId() == id){
                return building;
            }
        }
        return null;
    }

    public void admitPatient(int patientId,String name,String contact,int wardId,int doctorId){
        Doctor doc = searchDoc(doctorId);
        Ward ward = searchWard(wardId);
        Patient patient = new Patient(patientId,name,contact);

        if(doc == null || ward == null){
            System.out.println("Admission failed. No such Doctor or Ward found....");
            return;
        }

        patient.setCurrentWard(ward);
        ward.assignPatient(patient);

        patient.AssignDoctor(doc);
        doc.assignPatient(patient);
        PatientList.add(patient);

        System.out.println("Success!!! "+name+" Admitted to "+doc.getName()+" in Ward: "+ward.getWardName());

    }

    public void assignNurseToPatient(int patientId, int nurseId){
        Patient patient = searchPatient(patientId);
        Nurse nurse = searchNurse(nurseId);

        if(patient == null || nurse == null){
            System.out.println("Failed!! No such Patient or Nurse found.....");
            return;
        }

        patient.assignNurse(nurse);
        nurse.assingedPatient(patient);

        System.out.println("Success!!! Nurse: "+nurse.getName()+" assigned to "+patient.getName());

    }

    public void assignDoctorToPatient(int patientId,int doctorId){
        Patient patient = searchPatient(patientId);
        Doctor doc = searchDoc(doctorId);

        if(patient == null || doc == null){
            System.out.println("Failed!! No such Patient or Doctor found.....");
            return;
        }

        patient.AssignDoctor(doc);
        doc.assignPatient(patient);

        System.out.println("Success!!! "+doc.getName()+" assigned to "+patient.getName());
    }

    public void addWardInBuiling(int wardId,int buildingId){
        Building bldng = searchBuilding(buildingId);
        Ward ward = searchWard(wardId);

        if(ward == null || bldng == null){
            System.out.println("Failed!! No such Building or Ward found.....");
            return;
        }

        bldng.assingWard(ward);

        System.out.println("Success!!! Ward: "+ward.getWardName()+" Added to Building: "+bldng.getBuildingName());
    }

    public void removePatient(int patientId){
        for(Patient patient : PatientList){
            if(patient.getPatientId() == patientId){
                PatientList.remove(patient);
                System.out.println("Success!!! "+patient.getName()+" Discharged");
            }
        }
    }

}
