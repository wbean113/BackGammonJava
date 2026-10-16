package model;

import java.util.Random;

public class Dice {
    private int count_1;
    private int count_2;
    private Random random = new Random();

    public Dice(){
        count_1=count_2=0;//0 表示尚未掷骰，先roll才有点数
    }

    public int getCount_1(){
        return count_1;
    }
    public int getCount_2(){
        return count_2;
    }

    public void roll(){
        count_1 = random.nextInt(6)+1;
        count_2 = random.nextInt(6)+1;
    }

}
