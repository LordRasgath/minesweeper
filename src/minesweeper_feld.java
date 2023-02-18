import tgi.TGI;

public class minesweeper_feld {
    public static char[][] feldBomben = new char[12][10];
    public static char [][] feldAnzeigen = new char[10][8];
    public static void feldAnzeigenFüllen(){
            for (int x = 0;x<10;x++){
                for (int y = 0;y<8;y++){
                    feldAnzeigen[x][y] = '⍁';
                }
            }
    }
    public static void spielfeldAnzeigen() {
        //Ausgabe des Spielfeldes
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x <10; x++) {
                System.out.print(feldAnzeigen[x][y]);


            }
                System.out.println("");


        }
    }
    public static void bombenPlatzieren(){
        for (int x = 0;x<10;x++){
            int xZufall = TGI.erzeugeZufallsZahlZwischen(1,10);
            int yZufall = TGI.erzeugeZufallsZahlZwischen(1,8);
            if (feldBomben[xZufall][yZufall]=='X'){
                continue;
            }else {
                feldBomben[xZufall][yZufall] = 'X';
            }
        }
        for (int x = 0;x<12;x++){
            feldBomben[x][0] = '-';
            feldBomben[x][9] = '-';

        }
        for (int y = 0;y<10;y++){
            feldBomben[0][y] = '-';
            feldBomben[11][y] = '-';

        }
    }
    public static void testPrintBomben(){
        for (int y = 0;y<10;y++){
            for (int x = 0;x<12;x++){
                System.out.print(feldBomben[x][y]);
            }
            System.out.println("");
        }
    }
}
