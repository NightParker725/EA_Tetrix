public class BST {
    private Player nroot;


    public void addScoreRegistryA(Player node){
        if(nroot == null){
            nroot = node;
        }else{
            addScoreRegistryA(nroot, node);
        }
    }

    private void addScoreRegistryA(Player ncurrent, Player node){
        if(node.getName().compareTo(ncurrent.getName()) < 0){
            if(ncurrent.getLeft()==null) {
                ncurrent.setLeft(node);
            }
            else{
                addScoreRegistryA(ncurrent.getLeft(),node);
            }
        }else if(node.getName().compareTo(ncurrent.getName()) > 0){
            if(ncurrent.getRight()==null) {
                ncurrent.setRight(node);
            }
            else{
                addScoreRegistryA(ncurrent.getRight(),node);
            }
        }else{
            return;
        }

    }


    public void getMinA(){
        getMinA(nroot);
    }
    private void getMinA(Player ncurrent){
        if(ncurrent.getLeft() == null){
            System.out.println(ncurrent.getName());
        }
        else{
            getMinA(ncurrent.getLeft());
        }
    }


    public void getMaxA(){
        getMaxA(nroot);
    }
    private void getMaxA(Player ncurrent){
        if(ncurrent.getRight() == null){
            System.out.println(ncurrent.getName());
        }
        else{
            getMaxA(ncurrent.getRight());
        }
    }



    public void alphabeticalOrder()
    {
        alphabeticalOrder(nroot);
    }
    private void alphabeticalOrder(Player ncurrent){
        if(ncurrent == null){
            return;
        }
        alphabeticalOrder(ncurrent.getLeft());
        System.out.println(" " + ncurrent.getName() + " " + ncurrent.getScore());
        alphabeticalOrder(ncurrent.getRight());
    }



    public Player searchByName(String goal){
        return searchByName(nroot,goal);
    }
    private Player searchByName(Player ncurrent, String goal){
        if(ncurrent == null){
            System.out.println("Not found");
            return null;
        }
        if(ncurrent.getName().equals(goal)){
            return ncurrent;
        }
        if(goal.compareTo(ncurrent.getName()) < 0){
            return searchByName(ncurrent.getLeft(), goal);
        }
        else{
            return searchByName(ncurrent.getRight(), goal);
        }
    }


}
