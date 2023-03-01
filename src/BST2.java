import java.util.ArrayList;
public class BST2 {

    private Player sroot;

    public void addScoreRegistryB(Player node){
        if(sroot == null){
            sroot = node;
        }else{
            addScoreRegistryB(sroot, node);
        }
    }
    private void addScoreRegistryB(Player scurrent, Player node){
        if(node.getScore() < scurrent.getScore()){
            if(scurrent.getLeft()==null) {
                scurrent.setLeft(node);
            }
            else{
                addScoreRegistryB(scurrent.getLeft(),node);
            }
        }else if(node.getScore() > scurrent.getScore()){
            if(scurrent.getRight()==null) {
                scurrent.setRight(node);
            }
            else{
                addScoreRegistryB(scurrent.getRight(),node);
            }
        }else{
            //nothing
        }

    }
    public void getMinB(){
        getMinB(sroot);
    }
    private void getMinB(Player scurrent){
        if(scurrent.getLeft() == null){
            System.out.println(scurrent.getScore());
        }
        else{
            getMinB(scurrent.getLeft());
        }
    }
    public void getMaxB(){
        getMaxB(sroot);
    }
    private void getMaxB(Player scurrent){
        if(scurrent.getRight() == null){
            System.out.println(scurrent.getScore());
        }
        else{
            getMaxB(scurrent.getRight());
        }
    }

    public void top5() {
        ArrayList<Player> topPlayers = new ArrayList<>();
        top5(sroot, topPlayers);
        System.out.println("Top 5 players:");
        for(Player player : topPlayers) {
            System.out.println(player.getName() + " " + player.getScore());
        }
    }

    private void top5(Player scurrent, ArrayList<Player> topPlayers) {
        if(scurrent == null || topPlayers.size() == 5) {
            return;
        }
        top5(scurrent.getRight(), topPlayers);
        if(topPlayers.size() < 5) {
            topPlayers.add(scurrent);
            top5(scurrent.getLeft(), topPlayers);
        }
    }


    public Player searchByScore(int goal){
        return searchByScore(sroot,goal);
    }
    private Player searchByScore(Player scurrent, int goal){
        if(scurrent == null){
            System.out.println("Not found");
            return null;
        }
        if(scurrent.getScore() == goal){
            return scurrent;
        }
        if(goal < scurrent.getScore()){
            return searchByScore(scurrent.getLeft(), goal);
        }
        else{
            return searchByScore(scurrent.getRight(), goal);
        }
    }
}
