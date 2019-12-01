import jdk.nashorn.internal.parser.Scanner;

public class euromilion {
    public static void main(String[] args) {
        int[] userNum = new int[5];
        int[] userStars = new int[2];
        demanar(userNum, userStars);
    }

    // demanar usuari numeros
    public static void demanar(int[] userNum, int[] userStars) {
        System.out.println("Mètode d'escollir els números: ");
        System.out.println("1- Automàtic");
        System.out.println("2- Manual");
        System.out.println("Selecciona el mètode que vols seguir per ecollir els números");
        int accio = Integer.parseInt(System.console().readLine());
        switch (accio) {
        case 1:
            auto(userNum, userStars);
            break;
        case 2:
            manual(userNum, userStars);
            break;
        default:
            System.out.println("Error, opció incorrecte");
            break;
        }
    }

    // elecció aleatoria
    public static void auto(int[] userNum, int[] userStars) {
        num(userNum);
        stars(userStars);
        view(userNum, userStars);
        soteig(userNum, userStars);
    }

    // entrar números manualment
    public static void manual(int[] userNum, int[] userStars) {
        manNum(userNum);
        manstars(userStars);
        view(userNum, userStars);
        soteig(userNum, userStars);
    }

    // seleccionar nums aleatoriament
    public static void num(int[] userNum) {
        for (int i = 0; i < userNum.length; i++) {
            boolean repetit = true;
            while (repetit) {
                repetit = false;
                int num = (int) Math.floor(Math.random() * 50) + 1;
                for (int j = 0; j < i; j++) {
                    if (userNum[j] == num) {
                        repetit = true;
                    }
                }
                if (!repetit) {
                    userNum[i] = num;
                }
            }
        }
    }

    // seleccionar estrelles aleatoriament
    public static void stars(int[] userStars) {
        for (int i = 0; i < userStars.length; i++) {
            boolean repetit = true;
            while (repetit) {
                repetit = false;
                int num = (int) Math.floor(Math.random() * 10) + 1;
                for (int j = 0; j < i; j++) {
                    if (userStars[j] == num) {
                        repetit = true;
                    }
                }
                if (!repetit) {
                    userStars[i] = num;
                }
            }
        }
    }

    // manual numeros
    public static void manNum(int[] userNum) {
        System.out.println();
        System.out.println();
        System.out.println("SELECCIÓ DELS NÚMEROS:");
        for (int j = 0; j < userNum.length; j++) {
            boolean fi = false;
            while (!fi) {
                boolean repetit = false;
                System.out.println("Introdueix un número del 1-50 que no hagis seleccionat");
                int num = Integer.parseInt(System.console().readLine());
                for (int i = 0; i < j; i++) {
                    if (userNum[i] == num) {
                        repetit = true;
                        break;
                    }
                }
                if (!repetit && num > 0 && num <= 50) {
                    userNum[j] = num;
                    fi = true;
                } else {
                    System.out.println("Error, intorueix un número no repetit i dins del rang 1-50!");
                    System.out.println();
                }
            }
        }
    }

    // manual stars
    public static void manstars(int[] userStars) {
        System.out.println();
        System.out.println();
        System.out.println("SELECCIÓ DE LES ESTRELLES:");
        for (int j = 0; j < userStars.length; j++) {
            boolean fi = false;
            while (!fi) {
                boolean repetit = false;
                System.out.println("Introdueix l'estrella amb un número del 1-10 que no hagis seleccionat");
                int num = Integer.parseInt(System.console().readLine());
                for (int i = 0; i < j; i++) {
                    if (userStars[i] == num) {
                        repetit = true;
                        break;
                    }
                }
                if (!repetit && num > 0 && num <= 10) {
                    userStars[j] = num;
                    fi = true;
                } else {
                    System.out.println("Error, intorueix un número no repetit i dins del rang 1-10!");
                    System.out.println();
                }
            }
        }
    }

    // mostra numeros seleccionats
    public static void view(int[] userNum, int[] userStars) {
        System.out.println("Els número seleccionats són: ");
        for (int i = 0; i < userNum.length; i++) {
            System.out.print(userNum[i] + "\t");
        }
        System.out.println();
        System.out.println("Les estrelles seleccionades són: ");
        for (int i = 0; i < userStars.length; i++) {
            System.out.print(userStars[i] + "\t");
        }
        System.out.println();
    }

    // sorteig
    public static void soteig(int[] userNum, int[] userStars) {
        int nums[] = new int[userNum.length];
        int stars[] = new int[userStars.length];
        long intents = 0;
        boolean guanyat = false;
        boolean primer = false;
        boolean tercer = false;
        boolean segon = false;
        while (!guanyat) {
            for (int i = 0; i < userNum.length; i++) {
                boolean repetit = true;
                while (repetit) {
                    repetit = false;
                    int num = (int) Math.floor(Math.random() * 50) + 1;
                    for (int j = 0; j < i; j++) {
                        if (nums[j] == num) {
                            repetit = true;
                        }
                    }
                    if (!repetit) {
                        nums[i] = num;
                    }
                }
            }
            for (int i = 0; i < userStars.length; i++) {
                boolean repetit = true;
                while (repetit) {
                    repetit = false;
                    int num = (int) Math.floor(Math.random() * 10) + 1;
                    for (int j = 0; j < i; j++) {
                        if (stars[j] == num) {
                            repetit = true;
                        }
                    }
                    if (!repetit) {
                        stars[i] = num;
                    }
                }
            }
            int numTrobats = 0;
            int starsTrobades = 0;
            for (int a = 0; a < nums.length; a++) {
                for (int b = 0; b < userNum.length; b++) {
                    if (userNum[b] == nums[a]) {
                        numTrobats++;
                    }
                }
            }
            for (int a = 0; a < stars.length; a++) {
                for (int b = 0; b < userStars.length; b++) {
                    if (userStars[b] == stars[a]) {
                        starsTrobades++;
                    }
                }
            }
            intents++;
            if (numTrobats == 5 && starsTrobades == 2 && !primer) {
                System.out.println("HAS GUANYAT EL PRIMER PREMI AMB " + intents + " INTENTS");
                primer = true;
            } else if (numTrobats == 5 && starsTrobades == 1 && !segon) {
                System.out.println("HAS GUANYAT EL SEGON PREMI AMB " + intents + " INTENTS");
                segon = true;
            } else if (numTrobats ==4 && starsTrobades == 1 && !tercer) {
                System.out.println("HAS GUANYAT EL TERCER PREMI AMB " + intents + " INTENTS");
                tercer = true;
            }
            if (primer && segon && tercer){
                guanyat=true;
            }
        }
    }
}