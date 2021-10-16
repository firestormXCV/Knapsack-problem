package application;

import java.util.ArrayList;

public class PSE {
    
    private ArrayList<Integer> value;
    private ABR bestRes;
    private float maxWeight;
    private float minValues;

        
    public PSE() {
    }
    
    /**
     * TODO 
     * l'objectif de l'algo est de dÃ©finir la somme des poids des objets en fonctions des objets qui sont mis dans
     * le sac 
     * 
     * fonction rÃ©cursif ? qui permettrait de faire appel Ã  la fonction sur les arbres fils 
     * changer Ã  chaque tour les noeuds courants pour toujours ajouter les objets aux fils du noeud courant 
     * dÃ©finir les bornes -> valeur borne min Ã  revoir et valeur borne max = maxeight du sac 
     */
    public void pseAlgorithm(SacADos b) {
        /*
        ArrayList<PSE> currents = new ArrayList<>();
        currents.add(this);
        float lowerBoundary = 0, higherBoundary = b.getMaxWeight();
        
        for(Objet o : b.getObjectList()) {
        
        
        
        }
        */
        
        this.maxWeight = b.getMaxWeight();
        this.minValues = 0;
        float maxValues = 0;
        
        Glouton.glouton(b);
        minValues = b.getValues();
        
        for(Objet o : b.getObjectList()) {
            maxValues += o.getValue();
        }
        
        if (minValues < maxValues) {
            ABR root = new ABR();
            this.bestRes = root;
            
            buildABR(maxValues, 0, root, b);
            b.toEmpty();
            fillBag(bestRes, b);
            //vider sac
            //remplir avec la solution
            
        }
        
    }
    
    private void buildABR(float maxPossible, int index, ABR actualNode, SacADos b) {
        
        actualNode.setLeftSon(b.getObjectList().get(index), index);
        actualNode.setRightSon();
        
        if (actualNode.getLeftSon().getWeight() <= b.getMaxWeight() && minValues <= actualNode.getLeftSon().getValues()) {
            bestRes = actualNode.getLeftSon();
            minValues = bestRes.getValues();
            
        
        }
        
        if (this.maxWeight > actualNode.getWeight() && index < b.getObjectList().size() - 1) {
            buildABR(maxWeight, index + 1,actualNode.getLeftSon(), b);
            buildABR(maxWeight, index + 1, actualNode.getRightSon(), b);
        }
    }
    
    private void fillBag(ABR node, SacADos b) {
    	int i = node.getIndex();
    	if (i != -1)
    		b.addObject(b.getObjectList().get(i));
    	
    	if (!node.isRoot())
    		fillBag(node.getParent(), b);
    }
    
    
}
