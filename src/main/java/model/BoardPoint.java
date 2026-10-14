package model;

public class BoardPoint {
    private int count;
    private PlayerColor color;

    public int getCount(){
        return this.count;
    }
    public PlayerColor getColor(){
        return this.color;
    }

    public void setCount(int count) {
        if(count>15||count<0){
            throw new IllegalStateException("You can't set that amount of men on one BoardPoint");
        }
        this.count = count;
    }

    public boolean addCheck(){
        if(this.count>=15){
            return false;
        }
        return true;
    }

    public boolean removeCheck(){
        if(this.count<=0){
            return false;
        }
        return true;
    }

    public void addCount(int add){
        if(add<0||add>(15-this.count)){
            throw new IllegalStateException("Fail to add for inllegal request!");
        }
        for(int i=0;i<add;i++){
            addCount();
        }
    }

    public void addCount(){
        if (!addCheck()) {
            throw new IllegalStateException("this boardpoint is full!");
        }
        this.count++;
    }

    public void rmvCount(int rmv){
        if(rmv<0||rmv>this.count){
            throw new IllegalStateException("Fail to remove for inllegal request!");
        }
        for(int i=0;i<rmv;i++){
            rmvCount();
        }
    }

    public void rmvCount() {
        if (!removeCheck()) {
            throw new IllegalStateException("this boardpoint is empty!");
        }
        count--;
    }
}
