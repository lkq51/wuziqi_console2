/**
 * Created by lkq on 2016/8/26.
 */
public class QiZi {
    final static int BLACK=1;
    final static int WHITE=0;
    int color;//0.代表白棋，1.代表黑棋
    int x;
    int y;
    public  QiZi(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
