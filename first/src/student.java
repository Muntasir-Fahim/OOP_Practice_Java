public class student {
    String name,id;
    int cost;

    student (String n, String i, int cst){ //constructor. Must be the same name as the class
        name = n;
        id = i;
        cost = cst;
    }

    void displayInfo(){
        System.out.println(name);
        System.out.println(id);
        System.out.println(cost);
        System.out.println();
    }

    void setInfo(String n, String i, int cst){
        name = n;
        id = i;
        cost = cst;
    }
}
