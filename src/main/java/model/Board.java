package model;

public class Board {
    private BoardPoint[] point = new BoardPoint[24];

    public Board(){
        for(int i=1;i<25;i++){
            point[i-1] = new BoardPoint(i);
        }

        whiteInitial();
        blackInitial();

    }

    public BoardPoint[] getPoint() {
        return point;
    }

    private void whiteInitial(){
        for(int i=1;i<25;i++){
            if(i==6){
                point[i].addCount(5,PlayerColor.WHITE);
            }
            if(i==8){
                point[i].addCount(3,PlayerColor.WHITE);
            }
            if(i==13){
                point[i].addCount(5,PlayerColor.WHITE);
            }
            if(i==24){
                point[i].addCount(2,PlayerColor.WHITE);
            }
        }
    }
    private void blackInitial(){
        for(int i=1;i<25;i++){
            if(i==19){
                point[i].addCount(5,PlayerColor.BLACK);
            }
            if(i==17){
                point[i].addCount(3,PlayerColor.BLACK);
            }
            if(i==12){
                point[i].addCount(5,PlayerColor.BLACK);
            }
            if(i==1){
                point[i].addCount(2,PlayerColor.BLACK);
            }
        }
    }



}
