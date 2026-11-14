package Hospital.Main;

import java.util.Random;

public class Staff {
    int id;
    String name;
    String contact;
    Random random = new Random();

    public Staff(int id,String name, String contact) {
        this.id = id;
        //this.id = random.nextInt(1001) + 1000;
        this.name = name;
        this.contact = contact;
    }
}
