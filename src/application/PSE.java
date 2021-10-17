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
    private ABR bestRes;				// Le meilleur resultat trouv� jusqu'� pr�sent
    private float maxWeight;			// Poid max a pas d�passer
    private float minValues;			// La valeur minimum pour que la solution vaille le coup d'�tre retenus

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
        
        if (minValues < maxValues) {		// On v�rifie s'il est possible de faire mieux que l'algo glouton
            ABR root = new ABR();			//Cr�ation d'un ABR pour trouver le meilleur r�sultat
            this.bestRes = root;
            
            buildABR(maxValues, 0, root, b);	//On construit l'ABR
            b.toEmpty();
            fillBag(bestRes, b);				//On reremplis le sac avec la nouvelle solution la plus optimis�e trouv� avec l'ABR

        }
        
    }
    
    /**
     * @brief Methode de constrcution du PSE, cette m�thode est r�cursive
     * @param maxPossible, La valeur maximal possible
     * @param index	Index de l'objet dans la liste sur le quel on travail
     * @param actualNode le noeud sur lequel on travail actuellement
     * @param b le sac a dos
     */
    private void buildABR(float maxPossible, int index, ABR actualNode, SacADos b) {
        
        actualNode.setLeftSon(b.getObjectList().get(index), index);		//On cr�er un fils gauche avec le derniere objet non trait� de la liste
        actualNode.setRightSon();										//On cr�er un fils droit avec aucune valeur suppl�mentaire
        
        if (actualNode.getLeftSon().getWeight() <= b.getMaxWeight() && minValues <= actualNode.getLeftSon().getValues()) { // Si on ne d�passe pas le poid limite et que la valeur actuel est supp�rieur a notre valeur minimal, alors
            bestRes = actualNode.getLeftSon();		//On note ce noeud comme �tant le meilleur actuellemnt trouv�
            minValues = bestRes.getValues();		//On redefinis la valeur minimal sur celle-ci
            
        
        }
        
        if (this.maxWeight > actualNode.getWeight() && index < b.getObjectList().size() - 1) { //Si on a pas d�pass� le poid max et que il reste des objets dans la liste qui ne sont pas trait�s
            buildABR(maxWeight, index + 1,actualNode.getLeftSon(), b);						   //On appel la fonction de mani�re r�cursive sur le fils gauche avec +1 dans la liste d'object pour traiter l'objet suivant
            buildABR(maxWeight, index + 1, actualNode.getRightSon(), b);					   //Idem sur le fils droit cet fois-ci
        }
    }
    
    /**
     * @brief Methode permettant de remplir le sac a dos, cette fonction est r�cursive
     * @param node le noeud actuellement trait� / en cas de 1er appel c'est le meilleur r�sultat trouv�
     * @param b le sac a dos
     */
    private void fillBag(ABR node, SacADos b) {
    	int i = node.getIndex();
    	if (i != -1)								// -1 siginifie qu'il n'y a pas d'objet a mettre, on verifie donc qu'il y en a bien 1 a mettre
    		b.addObject(b.getObjectList().get(i));	//On ajoute l'objet a l'index i
    	
    	if (!node.isRoot())							//Si on est pas a la racine alors on r�appel la fonction jusqu'� ce qu'on arrive a cette racine
    		fillBag(node.getParent(), b);
    }
}
