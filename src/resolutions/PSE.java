package resolutions;

import structure.ABR;
import structure.Objet;
import structure.SacADos;

/**
 * @author Pasquier, Pessey
 * @brief Classe PSE
 *
 */
public class PSE implements IResolution {
    
	/**
	 *Attributs
	 */
    private ABR bestRes;				// Le meilleur resultat trouve jusqu'a present
    private float maxWeight;			// Poids max a pas depasser
    private float minValues;			// La valeur minimum pour que la solution vaille le coup d'etre retenu

    /**
     * @brief Constrcuteur
     */
    public PSE() {
    }

    /**
	 * @brief Methode de resolution du probleme du sac a dos -  Procedure par separation et evaluation
	 * @param le sac a dos a remplir
	 */
    public void resolution(SacADos b) {
        
        this.maxWeight = b.getMaxWeight();
        this.minValues = 0;
        float maxValues = 0;
        Glouton glouton = new Glouton();		
        glouton.resolution(b);
        
        minValues = b.getValues();			// La valeur minimum est celle definie par l'algo glouton
        
        for(Objet o : b.getObjectList()) {
            maxValues += o.getValue();		// La valeur max est l'ensemble des valeurs de tous les objets
        }
        
        if (minValues < maxValues) {		// On verifie s'il est possible de faire mieux que l'algo glouton
            ABR root = new ABR();			//Creation d'un ABR pour trouver le meilleur resultat
            this.bestRes = root;
            
            buildABR(maxValues, 0, root, b);	//On construit l'ABR
            b.toEmpty();
            fillBag(bestRes, b);				//On re-remplit le sac avec la nouvelle solution, plus optimisee, trouvee avec l'ABR

        }
        
    }
    
    /**
     * @brief Methode de constrcution du PSE (methode recursive)
     * @param maxPossible la valeur maximal possible
     * @param index	Index de l'objet dans la liste sur laquelle on travaille
     * @param actualNode le noeud sur lequel on travaille 
     * @param b le sac a dos
     */
    private void buildABR(float maxPossible, int index, ABR actualNode, SacADos b) {
        
        actualNode.setLeftSon(b.getObjectList().get(index), index);		//On cree un fils gauche avec le derniere objet non traite de la liste
        actualNode.setRightSon();										//On cree un fils droit sans valeur supplementaire
        
        if (actualNode.getLeftSon().getWeight() <= b.getMaxWeight() && minValues <= actualNode.getLeftSon().getValues()) { // Si on ne depasse pas le poids limite et que la valeur actuelle est superieur a notre valeur minimale, alors
            bestRes = actualNode.getLeftSon();		//On note ce noeud comme etant le meilleur actuellemnt trouve
            minValues = bestRes.getValues();		//On redefini la valeur minimal sur celui-ci
            
        
        }
        
        if (this.maxWeight > actualNode.getWeight() && index < b.getObjectList().size() - 1) { //Si on n'a pas depasse le poid max et que il reste des objets dans la liste qui ne sont pas traites
            buildABR(maxWeight, index + 1,actualNode.getLeftSon(), b);						   //On appel la fonction de maniere recursive sur le fils gauche avec +1 dans la liste d'object pour traiter l'objet suivant
            buildABR(maxWeight, index + 1, actualNode.getRightSon(), b);					   //Idem sur le fils droit cette fois-ci
        }
    }
    
    /**
     * @brief Methode permettant de remplir le sac a dos (methode recusrsive)
     * @param node le noeud actuellement traite; en cas de 1er appel c'est le meilleur resultat trouve
     * @param b le sac a dos
     */
    private void fillBag(ABR node, SacADos b) {
    	int i = node.getIndex();
    	if (i != -1)								// -1 siginifie qu'il n'y a pas d'objet a mettre, on verifie donc qu'il y en a bien 1 a mettre
    		b.addObject(b.getObjectList().get(i));	//On ajoute l'objet a l'index i
    	
    	if (!node.isRoot())							//Si on ne se trouve pas a la racine alors on appelle a nouveau la fonction jusqu'a ce qu'on arrive a cette racine
    		fillBag(node.getParent(), b);
    }
}
