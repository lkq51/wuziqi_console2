/**
 * Created by lkq on 2016/8/27.
 */
public class Test {
    public static void main(String[] args) {
        QiPan qipan=new QiPan();
        Game game=new Game(qipan);
        while (!game.isOver){
            game.start();
        }
        game.over();
    }
}
