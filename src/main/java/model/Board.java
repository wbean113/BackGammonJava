package model;
//whilte home:
public class Board {
    private BoardPoint[] point = new BoardPoint[24];

    public Board(){
        for(int i=1;i<25;i++){
            point[i-1] = new BoardPoint(i);
        }

        whiteInitial();
        blackInitial();

    }

    private void ColorChecker(PlayerColor color){
        if(color == null){
            throw new IllegalStateException("请求的颜色为空");
        }
    }

    public BoardPoint getPoint(int order){
        if(order<1 || order>24){
            throw new IllegalStateException("没有此棋盘点！");
        }
        else{
            return point[order-1];
        }
    }

    private void whiteInitial(){
        for(int i=1;i<25;i++){
            if(i==6){
                getPoint(i).addCount(5,PlayerColor.WHITE);
            }
            if(i==8){
                getPoint(i).addCount(3,PlayerColor.WHITE);
            }
            if(i==13){
                getPoint(i).addCount(5,PlayerColor.WHITE);
            }
            if(i==24){
                getPoint(i).addCount(2,PlayerColor.WHITE);
            }
        }
    }
    private void blackInitial(){
        for(int i=1;i<25;i++){
            if(i==19){
                getPoint(i).addCount(5,PlayerColor.BLACK);
            }
            if(i==17){
                getPoint(i).addCount(3,PlayerColor.BLACK);
            }
            if(i==12){
                getPoint(i).addCount(5,PlayerColor.BLACK);
            }
            if(i==1){
                getPoint(i).addCount(2,PlayerColor.BLACK);
            }
        }
    }

    public boolean HomeChecker(PlayerColor color){
        ColorChecker(color);
        if(color == PlayerColor.WHITE){
            for(int i=7;i<25;i++){
                if(getPoint(i).getColor()==color){
                    return false;
                }
            }
        }else{
            for(int i=18;i>0;i--){
                if(getPoint(i).getColor()==color){
                    return false;
                }
            }
        }
        return true;
    }

}
