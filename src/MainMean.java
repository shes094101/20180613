import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMean extends JFrame {
    private Container cp;
    private JPanel A = new JPanel(new GridLayout(1,3,1,1));
    private JPanel B = new JPanel(new GridLayout(5,5,1,1));
    private JButton left=new JButton("<-");
    private JButton right=new JButton("->");
    private JButton end=new JButton("結束遊戲");
    private JButton x[][]=new JButton[5][5];
    private Timer t1;
    private int m =0;
    private int n =0;
    private int div=0;
    public MainMean() {
        mean();
    }
    public void mean(){
        this.setDefaultCloseOperation(3);//設定關閉視窗的按鈕
        this.setLayout(null);//設置布局為空
        this.setBounds(200, 20, 1000, 1000);//設置介面大小
        MainMean.this.setTitle("20180613");//視窗上的名字
        //this.setResizable(false);//-------------------------***********-------------------------鎖定視窗

        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3, 3));

        cp.add(A, BorderLayout.NORTH);
        cp.add(B, BorderLayout.CENTER);

        A.add(left);
        A.add(right);
        A.add(end);

        left.setFont(new Font(null,Font.BOLD,30));
        right.setFont(new Font(null,Font.BOLD,30));
        end.setFont(new Font(null,Font.BOLD,30));


        t1=new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (div){
                    case 0:
                        x [m][n].setBackground(new Color(55,251,195));
//                        x [m][n-1].setBackground(new Color(255,255,255));
                        n++;
                        if (n==4) {
                            div=1;
                            System.out.println(div);
                        }
                break;
                    case 1:
                        x [m][n].setBackground(new Color(55,251,195));
                        m++;
                        if (m==5) {
                            div=2;
                            System.out.println(div);
                        }
                        break;
//                    case 2:
//                        if (m==5){
//                        x [m][n].setBackground(new Color(55,251,195));
//                        n-=1;}
//                        if (n==0){
//                            div=3;
//                            System.out.println(div);
//                        }
//                        break;
                }

                System.out.println(m+" "+n);
            }
        });

        for (int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                x [i][j]=new JButton();
               //x[i][j].setFont(new Font(null,Font.BOLD,72));
               // x[i][j].setEnabled(false);
                B.add(x[i][j]);

            }
        }

        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.start();
            }
        });

        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.stop();
            }
        });

        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}