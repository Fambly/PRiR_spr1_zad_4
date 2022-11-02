import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Zulja extends Thread{
    static int scale = 3;
    static double Rzec = -0.69;
    static double uroj = 0.420;
    int iterMAX = 300;
    static int CUTOFF = 50;
    final static int N = 4096*scale;
    static int[][] canvas = new int[N][N];

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        Zulja thread0 = new Zulja(0);
        Zulja thread1 = new Zulja(1);
        Zulja thread2 = new Zulja(2);
        Zulja thread3 = new Zulja(3);
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();

        thread0.join();
        thread1.join();
        thread2.join();
        thread3.join();

        long endTime = System.currentTimeMillis();
        System.out.println("Obliczenia zakończone w czasie " + (endTime - startTime) + " millisekund");

        BufferedImage img = new BufferedImage(N, N, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int k = canvas[i][j];
                float level;
                if (k < CUTOFF) {
                    level = (float) k / CUTOFF;
                } else {
                    level = 0;
                }
                Color c = new Color(0, level, 0);
                img.setRGB(i, j, c.getRGB());
            }
        }
        ImageIO.write(img, "PNG", new File("żulja.png"));
        System.out.println("Wygenerowano fraktal.");
    }

    int nr;
    public Zulja(int nr) {
        this.nr = nr;
    }
    public void run(){
        int begin = 0, end = 0;
        if (nr == 0) {
            begin = 0;
            end = (N / 4) * 1;
        }
        else if (nr == 1) {
            begin = (N / 4) * 1;
            end = (N / 4) * 2;
        }
        else if (nr == 2) {
            begin = (N / 4) * 2;
            end = (N / 4) * 3;
        }
        else if (nr == 3) {
            begin = (N / 4) * 3;
            end = N;
        }
        zespolone stala = new zespolone(Rzec,uroj);
        for (int i = begin; i < end; i++) {
            for (int j = 0; j < N; j++) {
                zespolone prev = new zespolone();
                zespolone next = new zespolone(2.0*(i-(double)N/2)/((double)N/2),1.33*(j-(double)N/2)/((double)N/2));
                int k;
                for (k = 0; k < iterMAX; k++) {
                    prev = next;
                    next = next.prwstk();
                    next.dodaj(stala);
                    if (next.modulo()>2)
                        break;
                }
                canvas[i][j] = k;
            }
        }
    }
}
