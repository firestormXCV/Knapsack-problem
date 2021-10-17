package structure;

/**
 * @author Pasquier, Pessey
 * @brief Classe Objet
 */
public class Objet {
	
	/**
	 * Attributs d'un objet 
	 */
	private String name;
	private float weight;
	private float value;
	private boolean isInTheBag;
	private float ratio;
	
	/**
	 * @brief Constructeur d'un Objet
	 * @param name nom de l'objet
	 * @param weight poids de l'objet
	 * @param value valeur de l'objet
	 */
	public Objet(String name, float weight, float value) {
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.isInTheBag = false;
		this.ratio = value/weight;
	}

	/**
	 * @brief Getter de l'attribut name 
	 * @return le nom de l'objet 
	 */
	public String getName() {
		return name;
	}

	/**
	 * @brief Getter de l'attribut weight
	 * @return le poids de l'objet
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * @brief Getter de l'attribut value
	 * @return la valeur de l'objet 
	 */
	public float getValue() {
		return value;
	}
	
	/**
	 * @brief Getter de l'attribut ratio
	 * @return le rapport entre la valeur et le poids de l'objet 
	 */
	public float getRatio() {
		return ratio;
	}

	/**
	 * @brief Setter de l'attribut weight
	 * @param weight le nouveau poids de l'objet 
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}
		
}
