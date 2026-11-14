package Hospital.Main;

import java.util.*;

public class Building {
    private String buildingName;
    private int buildingId;
    private ArrayList<Ward> wardList = new ArrayList<>();


    //Random random = new Random();
    public Building(int id,String buildingName) {
        this.buildingName = buildingName;
        //this.buildingId = random.nextInt(1000);
        this.buildingId = id;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void assingWard(Ward ward){
        if(!wardList.contains(ward)){
            wardList.add(ward);
        }
    }
}
