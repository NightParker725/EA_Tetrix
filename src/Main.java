import java.util.Scanner;
public class Main {
    public static final Scanner lector = new Scanner (System.in);
    public static void main(String[] args) {
        BST treeA = new BST();
        BST2 treeB = new BST2();
        int i;
        System.out.println("Welcome to the registry of EA Tetrix");
        do{
            System.out.println("Please, choose an option: ");
            System.out.println("1. Add registry");
            System.out.println("2. Search registry by score");
            System.out.println("3. Player by alphabetical order");
            System.out.println("4. See Top 5 scores");
            System.out.println("5. Exit.");
            i = lector.nextInt();
            lector.nextLine();
            int score;
            String name;
            switch (i){
                case 1:
                    System.out.println("Type your user name: ");
                    name = lector.nextLine();
                    System.out.println("Type your Score: ");
                    score = lector.nextInt();
                    lector.nextLine();
                    Player playerA = new Player(name, score);
                    Player playerB = new Player(name, score);
                    treeA.addScoreRegistryA(playerA);
                    treeB.addScoreRegistryB(playerB);
                    break;
                case 2:
                    System.out.println("Type your score to search: ");
                    score = lector.nextInt();
                    lector.nextLine();
                    Player search = treeB.searchByScore(score);
                    if(search == null){

                    }
                    else {
                        System.out.println("The score " + search.getScore() + " exist in the registry with the name " + search.getName());
                    }
                    break;
                case 3:
                    treeA.alphabeticalOrder();
                    break;
                case 4:
                    treeB.top5();
                    break;
                case 5:
                    System.out.println("Thanks for using the system.");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }while(i != 5);

    }
}