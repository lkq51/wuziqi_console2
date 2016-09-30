/**
 * Created by lkq on 2016/8/26.
 */
public class QiZi {
    final static int BLACK=1;
    final static int WHITE=0;
    final static int NULL=-1;
    private int color;//0.代表白棋，1.代表黑棋,-1代表为空
    private int x;
    private int y;
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

    public String getColorName(){
        int color=getColor();
        switch (color) {
            case 0: return "白棋";
            case 1: return "黑棋";
            case -1: return "此处未落子";
        }
        return null;
    }
}
