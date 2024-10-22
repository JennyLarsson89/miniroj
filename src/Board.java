import java.util.ArrayList;

public class Board {

    public Board() {
    }

    private String a1 = " ";
    private String a2 = " ";
    private String a3 = " ";
    private String a4 = " ";
    private String a5 = " ";
    private String a6 = " ";

    private String b1 = " ";
    private String b2 = " ";
    private String b3 = " ";
    private String b4 = " ";
    private String b5 = " ";
    private String b6 = " ";

    private String c1 = " ";
    private String c2 = " ";
    private String c3 = " ";
    private String c4 = " ";
    private String c5 = " ";
    private String c6 = " ";

    private String d1 = " ";
    private String d2 = " ";
    private String d3 = " ";
    private String d4 = " ";
    private String d5 = " ";
    private String d6 = " ";

    private String e1 = " ";
    private String e2 = " ";
    private String e3 = " ";
    private String e4 = " ";
    private String e5 = " ";
    private String e6 = " ";

    private String f1 = " ";
    private String f2 = " ";
    private String f3 = " ";
    private String f4 = " ";
    private String f5 = " ";
    private String f6 = " ";

    public void displayEmptyBoard() {
        System.out.println("   +–––+–––+–––+–––+–––+–––+");
        System.out.println(" a | " + a1 + " | " + a2 + " | " + a3 + " | " + a4 + " | " + a5 + " | " + a6 + " |");
        System.out.println("   +–––+–––+–––+–––+–––+–––+");
        System.out.println(" b | " + b1 + " | " + b2 + " | " + b3 + " | " + b4 + " | " + b5 + " | " + b6 + " |");
        System.out.println("   +–––+–––+–––+–––+–––+–––+");
        System.out.println(" c | " + c1 + " | " + c2 + " | " + c3 + " | " + c4 + " | " + c5 + " | " + c6 + " |");
        System.out.println("   +–––+–––+–––+–––+–––+–––+");
        System.out.println(" d | " + d1 + " | " + d2 + " | " + d3 + " | " + d4 + " | " + d5 + " | " + d6 + " |");
        System.out.println("   +–––+–––+–––+–––+–––+–––+");
        System.out.println(" e | " + e1 + " | " + e2 + " | " + e3 + " | " + e4 + " | " + e5 + " | " + e6 + " |");
        System.out.println("   +–––+–––+–––+–––+–––+–––+");
        System.out.println(" f | " + f1 + " | " + f2 + " | " + f3 + " | " + f4 + " | " + f5 + " | " + f6 + " |");
        System.out.println("   +–––+–––+–––+–––+–––+–––+");
    }

    public void displayBoard() {

        int cols = 6;
        int rows = 6;

        ArrayList<String> cells = new ArrayList<>();

        System.out.println("     1   2   3   4   5   6");
        System.out.println("   +–––+–––+–––+–––+–––+–––+");
        System.out.print(" a | ");

        for (int i = 0; i < (cols * rows); i++) {
            cells.add(" ");

            int randomNum = (int) Math.floor(Math.random() * 5) + 1;
            if (i == randomNum) {
                cells.add(i, "x");
            }

            System.out.println(cells.get(i));

        }
    }
}


//    }
//
//    public void placeBombs() {
//        String bomb = "";
//
//        for (int i = 0; i < 5; i++) {
//
//            int randomNum = (int) Math.floor(Math.random() * 6) + 1;
//            int randomChar = (int) Math.floor(Math.random() * 6) + 1;
//
//            if (randomChar == 1) {
//                bomb = ("a" + randomNum);
//            } else if (randomChar == 2) {
//                bomb = ("b" + randomNum);
//            } else if (randomChar == 3) {
//                bomb = ("c" + randomNum);
//            } else if (randomChar == 4) {
//                bomb = ("d" + randomNum);
//            } else if (randomChar == 5) {
//                bomb = ("e" + randomNum);
//            } else if (randomChar == 6) {
//                bomb = ("f" + randomNum);
//            }
//
//        }
//    }
//}
//
//
//


