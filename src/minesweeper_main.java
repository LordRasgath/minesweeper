import tgi.TGI;

public class minesweeper_main {
    public static minesweeper_feld feld = new minesweeper_feld();
    public static boolean gewonnen = false;
    public static boolean flaggenAufBomben = false;
    public static boolean verloren = false;
    public static boolean alleFelderAufgedeckt = false;
    public static void main(String[] args) {
        feld.feldAnzeigenFüllen();
        feld.spielfeldAnzeigen();
        feld.bombenPlatzieren();
        feld.testPrintBomben();
        int fähnchenZähler = 0;
        do {
            System.out.println("Bitte gib eine X Koordinate ein( zwischen 1 und 10");
            int xKoord = TGI.nextInt();
            System.out.println("Bitte gib eine Y Koordinate ein (zwischen 1 und 9)");
            int yKoord = TGI.nextInt();
            mark:
            {
                System.out.println("Aufdecken(0), oder Fähnchen(1)");
                int aufdecken = TGI.nextInt();
                if (aufdecken == 1) {
                    if (feld.feldAnzeigen[xKoord][yKoord] == '⚑') {
                        feld.feldAnzeigen[xKoord][yKoord] = '⍁';
                        fähnchenZähler--;
                    } else {
                        feld.feldAnzeigen[xKoord][yKoord] = '⚑';
                    }
                    fähnchenZähler++;
                    if (fähnchenZähler == 10) {
                        FlaggenAufBomben();
                        gewonnen();
                    }
                    if (fähnchenZähler == 11) {
                        System.out.println("Keine Flaggen mehr übrig");
                        break mark;
                    }
                }
                if (aufdecken==0){
                    bombenUmfeld(xKoord,yKoord);
                }
                feld.spielfeldAnzeigen();
            }
            } while(!gewonnen || !verloren);
        }
    public static void bombenUmfeld(int x, int y){
        int anzahlBomben = 0;
        if (feld.feldBomben[x+1][y+1]=='X'){
            verloren = true;
        } else{
            if (feld.feldBomben[x+2][y+2]=='X'){

            }
        }

        }
    public  static void gewonnen(){
        if (alleFelderAufgedeckt || flaggenAufBomben){
            gewonnen = true;
        }

    }
    public static void FlaggenAufBomben(){
        for (int y = 0;y<8;y++){
            for (int x = 0;x<10;x++){
                if (feld.feldAnzeigen[x][y] == '⚑' && feld.feldBomben[x + 1][y + 1] == 'X') {
                    flaggenAufBomben = true;
                    break;
                }
            }
        }
    }
}