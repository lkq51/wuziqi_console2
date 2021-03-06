import java.util.Scanner;

/**
 * Created by lkq on 2016/8/27.
 */
public class Game {
    static private QiPan qiPan; //棋盘
    static boolean isOver=false; //游戏是否结束
    public  Game(QiPan qiPan){
        this.qiPan=qiPan;
    }


    public static boolean isOver() {
        return isOver;
    }

    public static void setIsOver(boolean isOver) {
        Game.isOver = isOver;
    }

    //开始一盘新的游戏
    public void start(){
        System.out.println("-----------------游戏开始！--------------");
        Boolean ifwin=false;
        qiPan.initialization();
        qiPan.draw();
        qiPan.luoziTips();
        while (!ifwin){
            Scanner scanner=new Scanner(System.in);
            String  XY=scanner.nextLine();
            String[] xy=XY.split(" ");
            qiPan.setLuozi_x(Integer.parseInt(xy[0]));
            qiPan.setLuozi_y(Integer.parseInt(xy[1]));
            qiPan.luoZi();
            qiPan.draw();
            if(ifwin=qiPan.ifWin()){
                qiPan.win();
            }else {
                qiPan.luoziTips();
            }
        }
        System.out.println("是否再来一局？  Y|N");
        Scanner scanner=new Scanner(System.in);
        String ifAgain=scanner.nextLine();
        if(ifAgain.equalsIgnoreCase("n")||ifAgain.equalsIgnoreCase("no")){
            isOver=true;
        }
    }

    public void over(){
        if (isOver)
            System.out.println("-------游戏结束---------");
    }
}
