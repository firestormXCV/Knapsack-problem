package application;

import java.util.ArrayList;
/**
 * @author Pasquier, Pessey
 * @brief Classe PSE
 *
 */
public class PSE implements IResolution {
    
	/**
	 *Attributs
	 */
    private ArrayList<Integer> value;
    private ABR bestRes;
    private float maxWeight;
    private float minValues;

    /**
     * @brief Constrcuteur
     */
    public PSE() {
    }

    /**
	 * @brief Methode de resolution du probleme du sac a dos -  Procedure par separation et evaluation
	 */
    public void resolution(SacADos b) {
        
        this.maxWeight = b.getMaxWeight();
        this.minValues = 0;
        float maxValues = 0;
        Glouton glouton = new Glouton();
        glouton.resolution(b);
        
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

        }
        
    }
    
    /**
     * @brief Methode de constrcution du PSE
     * @param maxPossible
     * @param index
     * @param actualNode
     * @param b le sac a dos
     */
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
    
    /**
     * @brief Methode permettant de remplir le sac a dos
     * @param node
     * @param b le sac a dos
     */
    private void fillBag(ABR node, SacADos b) {
    	int i = node.getIndex();
    	if (i != -1)
    		b.addObject(b.getObjectList().get(i));
    	
    	if (!node.isRoot())
    		fillBag(node.getParent(), b);
    }
}
