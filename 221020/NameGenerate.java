public class NameGenerate {
    public static void main(String[] args) {
        String name_first[] = {"김","이","박","최","정","강","조","윤","장","임"};
        String name_mid[] = {"민","서","도","예","시","하","주","준","윤","예"};
        String name_last[] = {"준","윤","우","원","현","은","빈","연","진","하"};

        for(int i=0;i<10;i++){
            int r1 = (int)(Math.random()*name_first.length);
            int r2 = (int)(Math.random()*name_mid.length);
            int r3 = (int)(Math.random()*name_last.length);
            System.out.println(name_first[r1]+name_mid[r2]+name_last[r3]);
        }
    }
}
