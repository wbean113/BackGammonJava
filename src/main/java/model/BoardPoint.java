package model;

public class BoardPoint {
    private int count;
    private PlayerColor color;
    private int order;

    public int getCount(){
        return this.count;
    }
    public PlayerColor getColor(){
        return this.color;
    }
    public int getOrder(){
        return this.order;
    }

    public BoardPoint(int order){
        this.order=order;
    }

    //public void setCount(int count) {
        //if(count>15||count<0){
        //   throw new IllegalStateException("You can't set that amount of men on one BoardPoint");
        //}
        //this.count = count;
    //}

    private void setColor(PlayerColor color){
        this.color=color;
    }

    private boolean addCheck(PlayerColor incomingcolor){
        if(this.color==incomingcolor || this.color == null){
            if(this.count>=15){
                return false;
            }
            return true;
        }
        else{
            return false;
        }
    }

    private boolean removeCheck(){
        if(this.count<=0){
            return false;
        }
        return true;
    }

    public void addCount(int add,PlayerColor incomingcolor){
        if (incomingcolor == null) {
            throw new IllegalArgumentException("增加棋子时必须指定颜色");
        }
        if(add<0||add>(15-this.count)){
            throw new IllegalStateException("Fail to add for inllegal request!");
        }
        for(int i=0;i<add;i++){
            addCount(incomingcolor);
        }
    }

    private void addCount(PlayerColor incomingcolor){
        if (!addCheck(incomingcolor)) {
            throw new IllegalStateException("添加的颜色有冲突，或者当前无法添加");
        }
        this.count++;
        if(this.color==null){
            this.color =incomingcolor;
        }
    }

    public void rmvCount(int rmv){
        if(rmv<0||rmv>this.count){
            throw new IllegalStateException("Fail to remove for inllegal request!");
        }
        for(int i=0;i<rmv;i++){
            rmvCount();
        }
    }

    private void rmvCount() {
        if (!removeCheck()) {
            throw new IllegalStateException("this boardpoint is empty!");
        }
        count--;
        if(this.count==0){
            this.color=null;
        }
    }


}
