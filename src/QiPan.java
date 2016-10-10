/**
 * Created by lkq on 2016/8/26.
 */
public class QiPan {
    final static private int scale_row=15;//棋盘规格 行数
    final static private int scale_col=15;//棋盘规格 列数
    static private int luozi_x;           //当前落子的位置 x行
    static private int luozi_y;           //当前落子的位置 y列
    private int rounds;                 //当前的回合数=rounds/2+rounds%2
    private QiZi[][] qiZis=new QiZi[scale_col][scale_row];


    public static int getLuozi_x() {
        return luozi_x;
    }

    public static void setLuozi_x(int luozi_x) {
        QiPan.luozi_x = luozi_x-1;
    }

    public static int getLuozi_y() {
        return luozi_y;
    }

    public static void setLuozi_y(int luozi_y) {
        QiPan.luozi_y = luozi_y-1;
    }

    //初始化棋盘
    public void initialization(){
        rounds=0;
        for (int i=0;i<scale_row;i++) {
            for (int j = 0; j < scale_col; j++) {
                qiZis[i][j]=new QiZi(i,j);
                qiZis[i][j].setColor(qiZis[i][j].NULL);//设置未放棋子的位子的颜色值为NULL
            }
        }
    }
    //打印出棋盘
    public void draw(){
        for(int i=0;i<scale_row;i++){
            for (int j=0;j<scale_col;j++){
                System.out.print(" "+((qiZis[i][j].getColor()==-1)?"*":qiZis[i][j].getColor())+" ");
            }
            System.out.println("");
        }
    }
    //提示轮到谁落子
    public void luoziTips(){
        System.out.println("0.代表白棋，1.代表黑棋. *代表空位");
        System.out.println("请"+((rounds%2==0)?"白":"黑")+"棋选手落子,输入坐标(x,y)");
    }
    //放置棋子
    public void luoZi(){
        if(-1<luozi_x&&luozi_x<15&&-1<luozi_y&&luozi_y<15) {
            if (qiZis[luozi_x][luozi_y].getColor()==-1) {
                if (rounds % 2 != 0) {
                    qiZis[luozi_x][luozi_y].setColor(QiZi.BLACK);
                } else {
                    if (qiZis[luozi_x][luozi_y] == null) {
                        System.out.println("NULL");
                    }
                    qiZis[luozi_x][luozi_y].setColor(QiZi.WHITE);
                }
                rounds++;
            }else {
                System.out.print("此处已有落子    ");
                System.out.println("请"+((rounds%2==0)?"白":"黑")+"棋选手重新输入落子坐标");
            }
        }else{
            System.out.println("请输入(1,1)-(15,15)范围内的坐标");
        }
    }
    //判断是否有人取胜
    public  Boolean ifWin(){
         return left_right() | leftBottom_rightTop() | leftTop_rightBottom() | top_Bottom() | left_right();
    }
    //判断左下到右上是否已连成五子
    private Boolean leftBottom_rightTop(){
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
            row++;
            col--;
        }
        row=luozi_x-1;
        col=luozi_y+1;
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
    //判断左上到右下是否已连成五子
    private Boolean leftTop_rightBottom(){
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
            col--;
        }
        row=luozi_x+1;
        col=luozi_y+1;
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
    //判断左到右是否已连成五子
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
        row=luozi_x+1;
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
        }
        return num_qizi >= 5;
    }
    //判断上到下是否已连成五子
    private Boolean top_Bottom(){
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
            col--;
        }
        col=luozi_y+1;
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
    //取胜后的处理
    public void win(){
        System.out.println("恭喜"+qiZis[luozi_x][luozi_y].getColorName()+"选手获得胜利!");
    }
    //销毁棋盘
    public void destroy(){

    }
}
