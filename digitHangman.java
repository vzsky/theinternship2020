import java.util.*; 

public class digitHangman {

    int[] Ans = new int[12];
    private int[] Now = new int[12];
    private Vector<Vector<Integer>> Rev = new Vector<Vector<Integer>>();
    private Vector<Integer> Guessed = new Vector<Integer>();

    void init () {
        for (int i = 0; i < 10; i++) Rev.add(new Vector<Integer>());
        for (int i = 0; i < 12; i++) Rev.get(Ans[i]).add(i);
    }

    void point () {
        int p = 0;
        for (int i = 0; i < 12; i++) p += Now[i];
        System.out.println(p);
    }

    void guess (int G) {
        if (Rev.get(G).size() == 0) Guessed.add(G);
        Rev.get(G).forEach(ind -> Now[ind] = 1);
        print();
    }

    void print () {
        for (int i = 0; i < 12; i++) {
            if (Now[i] == 0) System.out.print('_');
            else System.out.print(Ans[i]);
            System.out.print(' ');
        }
        Guessed.forEach(n -> { System.out.print(n); System.out.print(' '); });
        System.out.print('\n');
    }
    public static void main(String []args) {

        Scanner scan = new Scanner(System.in);
        digitHangman H = new digitHangman();

        for (int i = 0; i < 12; i++) H.Ans[i] = scan.nextInt();

        H.init();
        H.print();
        for (int i = 0; i < 5; i++) H.guess(scan.nextInt());
        H.point();

        scan.close();
    }
 }