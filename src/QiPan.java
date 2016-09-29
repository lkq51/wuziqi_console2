/**
 * Created by lkq on 2016/8/26.
 */
public class QiPan {
    final static int scale_row=15;
    final static int scale_col=15;
    static int luozi_x;
    static int luozi_y;
    //static QiPan qiPan;
    int rounds=0;
    boolean iswin=false;
    QiZi[][] qiZis=new QiZi[scale_col][scale_row];
/*  private void QiPan(){
    }

    public static QiPan getQiPan(QiPan qipan){
        if (qiPan==null) {
            qiPan = new QiPan();
        }
        return qiPan;
    }*/
    //打印出棋盘


    public static int getLuozi_x() {
        return luozi_x;
    }

    public static void setLuozi_x(int luozi_x) {
        QiPan.luozi_x = luozi_x;
    }

    public static int getLuozi_y() {
        return luozi_y;
    }

    public static void setLuozi_y(int luozi_y) {
        QiPan.luozi_y = luozi_y;
    }

    public void draw(){

        for(int i=0;i<scale_row;i++){
            for (int j=0;j<scale_col;j++){
                if(qiZis[i][j]==null)
                    System.out.print(" * ");
                else
                    System.out.print(qiZis[i][j].getColor());
            }
            System.out.println("");
        }
        System.out.println("0.代表白棋，1.代表黑棋. *代表空位");
         if (rounds%2==0){
             System.out.println("请黑棋选手落子,输入坐标(x,y)");
         }else {
             System.out.println("请白棋选手落子,输入坐标(x,y)");
         }

    }
    //放置棋子
    public void luoZi(){
        if(0<luozi_x&&luozi_x<16&&0<luozi_y&&luozi_y<16) {
            QiZi qiZi = new QiZi(luozi_x-1, luozi_y-1);
            if (rounds%2==0){
                qiZi.setColor(qiZi.BLACK);
            }
            else {
                qiZi.setColor(qiZi.WHITE);
            }
            qiZis[qiZi.getX()][qiZi.getY()] = qiZi;
            rounds++;
        }
    }

    public  Boolean ifWin(){
        boolean colsWcoln=false;
        for(int row=0;row<scale_row;row++){
            for (int col=0;col<scale_col;col++){

            }
        }
        return true;
    }

    private Boolean IfWin(){
        int row=luozi_x;
        int col=luozi_y;
        int num_qizi=1;
        while(num_qizi<5) {
            if (qiZis[row][col].getColor() != qiZis[luozi_x][luozi_y].getColor()) {

                break;
            } else {
                num_qizi++;
            }
            row++;
            col--;
        }
        return true;
    }
}
