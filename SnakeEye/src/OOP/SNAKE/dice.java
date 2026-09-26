package OOP.SNAKE;

public class dice {
    private int faceValue;
    private int totalFace;

    public dice(int value){
        this.totalFace = value;
    }

    public void roll(){
        faceValue = (int)(Math.random() * 6) +1;
    }

    public int getFaceValue(){
        return faceValue;
    }
}
