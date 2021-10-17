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
    private ABR bestRes;				// Le meilleur resultat trouvé jusqu'à présent
    private float maxWeight;			// Poid max a pas dépasser
    private float minValues;			// La valeur minimum pour que la solution vaille le coup d'être retenus

    /**
     * @brief Constrcuteur
     * 
     * Rien a mettre car rien a initialiser
     */
    public PSE() {
    }

    /**
	 * @brief Methode de resolution du probleme du sac a dos -  Procedure par separation et evaluation
	 * 
	 * @param le sac a dos qui est a remplir
	 */
    public void resolution(SacADos b) {
        
        this.maxWeight = b.getMaxWeight();
        this.minValues = 0;
        float maxValues = 0;
        Glouton glouton = new Glouton();		
        glouton.resolution(b);
        
        minValues = b.getValues();			// La valeur minimum est celle qu'apport l'algo glouton
        
        for(Objet o : b.getObjectList()) {
            maxValues += o.getValue();		// La valeur max est l'ensemble des valeur de tout les objets
        }
        
        if (minValues < maxValues) {		// On vérifie s'il est possible de faire mieux que l'algo glouton
            ABR root = new ABR();			//Création d'un ABR pour trouver le meilleur résultat
            this.bestRes = root;
            
            buildABR(maxValues, 0, root, b);	//On construit l'ABR
            b.toEmpty();
            fillBag(bestRes, b);				//On reremplis le sac avec la nouvelle solution la plus optimisée trouvé avec l'ABR

        }
        
    }
    
    /**
     * @brief Methode de constrcution du PSE, cette méthode est récursive
     * @param maxPossible, La valeur maximal possible
     * @param index	Index de l'objet dans la liste sur le quel on travail
     * @param actualNode le noeud sur lequel on travail actuellement
     * @param b le sac a dos
     */
    private void buildABR(float maxPossible, int index, ABR actualNode, SacADos b) {
        
        actualNode.setLeftSon(b.getObjectList().get(index), index);		//On créer un fils gauche avec le derniere objet non traité de la liste
        actualNode.setRightSon();										//On créer un fils droit avec aucune valeur supplémentaire
        
        if (actualNode.getLeftSon().getWeight() <= b.getMaxWeight() && minValues <= actualNode.getLeftSon().getValues()) { // Si on ne dépasse pas le poid limite et que la valeur actuel est suppérieur a notre valeur minimal, alors
            bestRes = actualNode.getLeftSon();		//On note ce noeud comme étant le meilleur actuellemnt trouvé
            minValues = bestRes.getValues();		//On redefinis la valeur minimal sur celle-ci
            
        
        }
        
        if (this.maxWeight > actualNode.getWeight() && index < b.getObjectList().size() - 1) { //Si on a pas dépassé le poid max et que il reste des objets dans la liste qui ne sont pas traités
            buildABR(maxWeight, index + 1,actualNode.getLeftSon(), b);						   //On appel la fonction de manière récursive sur le fils gauche avec +1 dans la liste d'object pour traiter l'objet suivant
            buildABR(maxWeight, index + 1, actualNode.getRightSon(), b);					   //Idem sur le fils droit cet fois-ci
        }
    }
    
    /**
     * @brief Methode permettant de remplir le sac a dos, cette fonction est récursive
     * @param node le noeud actuellement traité / en cas de 1er appel c'est le meilleur résultat trouvé
     * @param b le sac a dos
     */
    private void fillBag(ABR node, SacADos b) {
    	int i = node.getIndex();
    	if (i != -1)								// -1 siginifie qu'il n'y a pas d'objet a mettre, on verifie donc qu'il y en a bien 1 a mettre
    		b.addObject(b.getObjectList().get(i));	//On ajoute l'objet a l'index i
    	
    	if (!node.isRoot())							//Si on est pas a la racine alors on réappel la fonction jusqu'à ce qu'on arrive a cette racine
    		fillBag(node.getParent(), b);
    }
}
