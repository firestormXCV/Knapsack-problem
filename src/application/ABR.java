package application;

/**
 * @author Pasquier, Pessey
 * @brief Classe ABR
 */
public class ABR {
	
	/**
	 * Attributs d'un ABR
	 */
	private final ABR parent;
	private ABR leftSon;
	private ABR rightSon;
	
	private final int depth;
	private final float values;
	private final float weight;
	private int index;
	
	/**
	 * @brief Constructeur d'ABR
	 * @param parent ARB parent 
	 * @param values valeur de l'objet stocke dans l'ABR
	 * @param weight poids de l'objet stocke dans l'ABR
	 * @param index index de l'objet stocke dans l'ABR
	 */
	public ABR(ABR parent, float values, float weight, int index) {
		this.parent = parent;
		this.depth = parent.depth + 1;
		this.values = values;
		this.weight = weight;
		this.index = index;
		
	}
	
	/**
	 * @brief Constructeur vide d'ABR
	 */
	public ABR() {
		this.parent = this;
		this.depth = 0;
		this.values = 0;
		this.weight = 0;
	}
	
	/**
	 * @brief Setter de l'attribut rightSon
	 */
	public void setRightSon() {
		this.rightSon = new ABR(this, this.values, this.weight, -1);
	}
	
	/**
	 * @brief Setter de l'attribut leftSon
	 * @param obj objet stocke dans l'ABR
	 * @param index index de l'objet stocke dans l'ABR
	 */
	public void setLeftSon(Objet obj, int index) {
		this.leftSon = new ABR(this, this.values + obj.getValue(), this.weight + obj.getWeight(), index);
	}

	/**
	 * @brief Getter de l'attribut parent
	 * @return le parent de l'ABR 
	 */
	public ABR getParent() {
		return parent;
	}

	/**
	 * @brief Getter de l'attribut leftSon
	 * @return leftSon
	 */
	public ABR getLeftSon() {
		return leftSon;
	}

	/**
	 * @brief Getter de l'attribut rightSon
	 * @return rightSon
	 */
	public ABR getRightSon() {
		return rightSon;
	}

	/**
	 * @brief Getter de l'attribut index
	 * @return l'index de l'objet dans la liste des objets du sac
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * @brief Getter de l'attribut values
	 * @return la valeur de l'objet stocke dans l'ABR
	 */
	public float getValues() {
		return values;
	}

	/**
	 * @brief Getter de l'attribut weight
	 * @return le poids de l'objet stocke dans l'ABR
	 */
	public float getWeight() {
		return weight;
	}
	
	/**
	 * @brief Methode qui permet de vérifier si un ABR est une racine
	 * @return true si l'ABR est une racine
	 */
	public boolean isRoot() {
		if (this.depth == 0)
			return true;
		else
			return false;
	}
}
