package model;

public class OffBoard {
    private int white_count;
    private int black_count;

    public PlayerColor GameWinChecker(){
        if(white_count==15 && black_count < 15){
            return PlayerColor.WHITE;
        } else if (black_count==15 && white_count < 15) {
            return PlayerColor.BLACK;
        } else if (black_count < 15 && white_count < 15){
            return null;
        }
        else{
            throw new IllegalStateException("游戏进程出现统计问题！");
        }
    }

    private void ColorChecker(PlayerColor color){
        if(color == null){
            throw new IllegalStateException("请求的颜色为空");
        }
    }

    private void AddChecker(PlayerColor color){
        ColorChecker(color);
        if(color == PlayerColor.BLACK){
            if(black_count >= 15){
                throw new IllegalStateException("黑色不能再增加了");
            }
        }
        else{
            if(white_count >= 15){
                throw new IllegalStateException("白色不能再增加了");
            }
        }
    }

    private void RmvChecker(PlayerColor color){
        ColorChecker(color);
        if(color == PlayerColor.BLACK){
            if(black_count <=0){
                throw new IllegalStateException("黑色不能再jianshao了");
            }
        }
        else{
            if(white_count <=0){
                throw new IllegalStateException("白色不能再jianshao了");
            }
        }
    }

    public int getCount(PlayerColor color){
        ColorChecker(color);
        if(color == PlayerColor.WHITE){
            return white_count;
        }
        else{
            return black_count;
        }
    }

    public void addCount(PlayerColor color){
        //
        ColorChecker(color);
        if(color == PlayerColor.WHITE) {
            AddChecker(color);
            white_count++;
        }
        else{
            AddChecker(color);
            black_count++;
        }
    }

    public void rmvCount(PlayerColor color){
        //game is over checker
        ColorChecker(color);
        if(color == PlayerColor.WHITE) {
            RmvChecker(color);
            white_count--;
        }
        else{
            RmvChecker(color);
            black_count--;
        }
    }

}
