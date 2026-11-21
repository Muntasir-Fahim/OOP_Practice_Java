package Hospital.Main;

import java.util.*;

public class Main{
    public static void main(String[] args){
        HospitalSystem hospital = new HospitalSystem("Green leaf");

        Scanner scan = new Scanner(System.in);

        //UI
       FirstUI ui = new FirstUI();
        //new SimpleHospitalUI(hospital);

        //int choice = 1;
//        while (true){
//            menu();
//            int choice = scan.nextInt();
//
//            if(choice == 1){//add building
//                System.out.print("Enter Building Id: ");
//                int id = scan.nextInt();
//                scan.nextLine();
//
//                System.out.print("Enter Building Name: ");
//                String name = scan.nextLine();
//                //scan.nextLine();
//
//                hospital.addBuilding(id,name);
//
//            }
//            else if(choice == 2){//add ward to Building
//                System.out.print("Enter Ward ID: ");
//                int id = scan.nextInt();
//                scan.nextLine();
//
//                System.out.print("Enter Ward Name: ");
//                String name = scan.nextLine();
//                //scan.nextLine();
//
//                System.out.print("Enter the Building ID in which the ward belong: ");
//                int bldng = scan.nextInt();
//                //scan.nextLine();
//
//                hospital.addWard(id,name,bldng);
//
//            }
//            else if(choice == 3){//add doc
//                System.out.println("Enter Doctor's ID: ");
//                int id = scan.nextInt();
//                scan.nextLine();
//
//                System.out.println("Enter Doctor's Name: ");
//                String name = scan.nextLine();
//                scan.nextLine();
//
//                System.out.println("Enter Doctor's Contact: ");
//                String cnt = scan.nextLine();
//                scan.nextLine();
//
//                System.out.println("Enter Doctor's Specialization: ");
//                String spl = scan.nextLine();
//                scan.nextLine();
//
//                System.out.println("Enter Doctor's fee: ");
//                int fee = scan.nextInt();
//                scan.nextLine();
//
//                hospital.addDoc(id,name,cnt,spl,fee);
//
//            }
//            else if (choice == 4) {//add nurse
//                System.out.println("Enter Nurse's ID: ");
//                int id = scan.nextInt();
//                scan.nextLine();
//                System.out.println("Enter Nurse's Name: ");
//                String name = scan.nextLine();
//                scan.nextLine();
//                System.out.println("Enter Nurse's Contact: ");
//                String cnt = scan.nextLine();
//                scan.nextLine();
//                System.out.println("Enter Nurse's suitable shift: ");
//                String sft = scan.nextLine();
//                scan.nextLine();
//
//                hospital.addNurse(id,name,cnt,sft);
//
//
//
//            }
//            else if (choice == 5) {//Admit patient
//                System.out.println("Enter Patient ID: ");
//                int id = scan.nextInt();
//                scan.nextLine();
//                System.out.println("Enter Patient Name: ");
//                String name = scan.nextLine();
//                scan.nextLine();
//                System.out.println("Enter Patient Contact: ");
//                String cnt = scan.nextLine();
//                scan.nextLine();
//                System.out.println("Enter Ward ID: ");
//                int wardId = scan.nextInt();
//                scan.nextLine();
//                System.out.println("Enter Doctor's ID: ");
//                int doctorId = scan.nextInt();
//                scan.nextLine();
//
//                hospital.admitPatient(id,name,cnt,wardId,doctorId);
//                System.out.println("Patient has been admitted");
//
//            }
//            else if (choice == 6) {
//                System.out.println("Enter Patient ID: ");
//                int id = scan.nextInt();
//                scan.nextLine();
//                System.out.println("Enter Nurse's ID: ");
//                int nurseId = scan.nextInt();
//                scan.nextLine();
//
//                hospital.assignNurseToPatient(id, nurseId);
//            }
//            else if (choice == 7) {
//                System.out.println("Enter Patient ID: ");
//                int id = scan.nextInt();
//                scan.nextLine();
//                System.out.println("Enter Doctor's ID: ");
//                int doctorId = scan.nextInt();
//                scan.nextLine();
//
//                hospital.assignDoctorToPatient(id, doctorId);
//            }
//            else if (choice == 8) {
//                System.out.println("Enter Patient ID: ");
//                int id = scan.nextInt();
//                scan.nextLine();
//
//                hospital.removePatient(id);
//            }
//
//
//            else if (choice == 0) {
//                System.out.println("Exiting.......");
//                break;
//            }
//            else System.out.println("Invalid Choice!!!\n");
//
//        }






    }
    public static void menu(){
        System.out.println("\nHospital Management");
        System.out.println("1. Add Building");
        System.out.println("2. Add Ward in Building");
        System.out.println("3. Add Doctor");
        System.out.println("4. Add Nurse");
        System.out.println("5. Admit Patient to Available Ward");
        System.out.println("6. Assign Nurse to Patient");
        System.out.println("7. Assign more Doctor to Patient");
        System.out.println("8. Discharge / Remove Patient");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }
}

