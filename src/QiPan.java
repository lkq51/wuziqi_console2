/**
 * Created by lkq on 2016/8/26.
 */
public class QiPan {
    final static private int scale_row=15;
    final static private int scale_col=15;
    static private int luozi_x;
    static private int luozi_y;
    //static QiPan qiPan;
    private int rounds=0;
    boolean iswin=false;
    private QiZi[][] qiZis=new QiZi[scale_col][scale_row];
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
                    System.out.print(" "+qiZis[i][j].getColor()+" ");
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
        if(-1<luozi_x&&luozi_x<15&&-1<luozi_y&&luozi_y<15) {
            QiZi qiZi = new QiZi(luozi_x, luozi_y);
            if (rounds%2==0){
                qiZi.setColor(QiZi.BLACK);
            }
            else {
                qiZi.setColor(QiZi.WHITE);
            }
            qiZis[qiZi.getX()][qiZi.getY()] = qiZi;
            rounds++;
        }else{
            System.out.println("请输入(1,1)-(15,15)范围内的坐标");
        }
    }

    public  Boolean ifWin(){
        return left_right() | leftBottom_rightTop() | top_Bottom() | left_right();
    }

    private Boolean leftBottom_rightTop(){
        int row=luozi_x;
        int col=luozi_y;
        int num_qizi=1;
        System.out.println(row);
        while(row>-1&&row<15&&col>-1&&col<15) {
            if (qiZis[row][col].getColor() != qiZis[luozi_x][luozi_y].getColor()) {
                break;
            } else {
                num_qizi++;
            }
            if (row>luozi_x+4||row<luozi_x-4||col>luozi_y+4||col<luozi_y-4){
                break;
            }
            row++;
            col--;
        }
        row=luozi_x;
        col=luozi_y;
        while (row>-1&&row<15&&col>-1&&col<15){
            if (qiZis[row][col].getColor() != qiZis[luozi_x][luozi_y].getColor()) {
                break;
            } else {
                num_qizi++;
            }
            if (row>luozi_x+4||row<luozi_x-4||col>luozi_y+4||col<luozi_y-4){
                break;
            }
            row--;
            col++;
        }
        return num_qizi >= 5;
    }

    private Boolean leftTop_rightBottom(){
        int row=luozi_x;
        int col=luozi_y;
        int num_qizi=1;
        while(row>-1&&row<15&&col>-1&&col<15) {
            if (qiZis[row][col].getColor() != qiZis[luozi_x][luozi_y].getColor()) {
                break;
            } else {
                num_qizi++;
            }
            if (row>luozi_x+4||row<luozi_x-4||col>luozi_y+4||col<luozi_y-4){
                break;
            }
            row--;
            col--;
        }
        row=luozi_x;
        col=luozi_y;
        while (row>-1&&row<15&&col>-1&&col<15){
            if (qiZis[row][col].getColor() != qiZis[luozi_x][luozi_y].getColor()) {
                break;
            } else {
                num_qizi++;
            }
            if (row>luozi_x+4||row<luozi_x-4||col>luozi_y+4||col<luozi_y-4){
                break;
            }
            row++;
            col++;
        }
        return num_qizi >= 5;
    }

    private Boolean left_right(){
        int row=luozi_x;
        int col=luozi_y;
        int num_qizi=0;
        while(row>-1&&row<15&&col>-1&&col<15) {
            if (qiZis[row][col].getColor() != qiZis[luozi_x][luozi_y].getColor()) {
                break;
            } else {
                num_qizi++;
            }
            if (row>luozi_x+4||row<luozi_x-4||col>luozi_y+4||col<luozi_y-4){
                break;
            }
            row--;
        }
        row=luozi_x;
        col=luozi_y;
        while (row>-1&&row<15&&col>-1&&col<15){
            if (qiZis[row][col].getColor() != qiZis[luozi_x][luozi_y].getColor()) {
                System.out.println("row"+row);
                System.out.println("col"+col);
                break;
            } else {
                num_qizi++;
            }
            if (row>luozi_x+4||row<luozi_x-4||col>luozi_y+4||col<luozi_y-4){
                break;
            }
            row++;
        }
        return num_qizi >= 5;
    }

    private Boolean top_Bottom(){
        int row=luozi_x;
        int col=luozi_y;
        int num_qizi=1;
        while(row>-1&&row<15&&col>-1&&col<15) {
            if (qiZis[row][col].getColor() != qiZis[luozi_x][luozi_y].getColor()) {
                break;
            } else {
                num_qizi++;
            }
            if (row>luozi_x+4||row<luozi_x-4||col>luozi_y+4||col<luozi_y-4){
                break;
            }
            col--;
        }
        row=luozi_x;
        col=luozi_y;
        while (row>-1&&row<15&&col>-1&&col<15){
            if (qiZis[row][col].getColor() != qiZis[luozi_x][luozi_y].getColor()) {
                break;
            } else {
                num_qizi++;
            }
            if (row>luozi_x+4||row<luozi_x-4||col>luozi_y+4||col<luozi_y-4) {
                break;
            }
            col++;
        }
        return num_qizi >= 5;
    }
}
