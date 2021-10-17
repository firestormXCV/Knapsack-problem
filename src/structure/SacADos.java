package structure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Pasquier, Pessey
 * @brief Classe SacADos
 */
public class SacADos {
	
	/**
	 * Attributs d'un sac a dos
	 */
	private float maxWeight;
	private float currentWeight; 
	private ArrayList<Objet> objectsList;		//La liste des objet possible
	private ArrayList<Objet> inTheBag;
	private float values;

	/**
	 * @brief Constructeur d'un sac a dos vide
	 * @param maxWeight poids maximal du sac
	 */
	public SacADos(float maxWeight) {
		this.maxWeight = maxWeight;
		this.currentWeight = 0;
		this.objectsList = new ArrayList<Objet>();
		this.inTheBag = new ArrayList<Objet>();
	}
	
	/**
	 * Constrcuteur d'un sac a dos
	 * @param path chemin pour aller recuperer les objets depuis un fichier texte
	 * @param maxWeight poids maximal du sac
	 */
	public SacADos(String path, float maxWeight) {
		this.maxWeight = maxWeight;
		this.objectsList = new ArrayList<Objet>();
		this.inTheBag = new ArrayList<Objet>();
		this.currentWeight = 0;
		
		objectsList = initObjList(path);
	}

	/**
	 * @brief Methode permettanr de lire le contenu d'un fichier texte
	 * @param path chemin pour aller recuperer le fichier 
	 * @return le contenu du fichier
	 */
	public String readTextFile(String path) {
		StringBuilder fileContent = new StringBuilder();
		try {
			File f = new File(path);
			BufferedReader b = new BufferedReader(new FileReader(f));
			String readLine = "";
			
			while ((readLine = b.readLine()) != null) {
				fileContent.append(readLine + "\n");
            }

		} catch (IOException e) {
	        e.printStackTrace();
	    }
		return fileContent.toString();
		
	}
	
	/**
	 * @brief Initialisation d'un objet
	 * @param obj l'objet a initialise 
	 * @return l'objet initialise
	 */
	private Objet initObj(String obj) {
		String[] objInfo = obj.split(";");
		if (objInfo.length == 3) {
			return new Objet (objInfo[0], Float.parseFloat(objInfo[1]), Float.parseFloat(objInfo[2]));
		}
		return null;
	}
	
	/**
	 * @brief Initialition d'une liste d'objet
	 * @param url lien du fichier a lire
	 * @return liste d'objet initialisee 
	 */
	private ArrayList initObjList(String url) {
		String[] file = readTextFile(url).split("\n");
		ArrayList<Objet> objectsList = new ArrayList<Objet>();
		for (String obj : file) {
			objectsList.add(initObj(obj));
		}
		return objectsList;
		
	}

	/**
	 * @brief toString du sac a dos
	 * @return chaine de caractere illustrant le sac a dos 
	 */
	public String toStringIn() {
		StringBuilder bagContent = new StringBuilder();
		bagContent.append("Poids actuel du sac à dos    : " + this.currentWeight + "\n");
		bagContent.append("Valeur actuelle du sac à dos : " + this.values + "\n");
		bagContent.append("Liste des objets dans le sac : " + "\n");

		for(Objet o : inTheBag) {
			bagContent.append("> " + o.getName() + " ; " + o.getWeight() + " ; " + o.getValue()+ " ; " + o.getRatio() + "\n");
		}
		return bagContent.toString();
	}

	/**
	 * @brief Getter de l'attribut weight
	 * @return le poids maximal du sac a dos
	 */
	public float getMaxWeight() {
		return maxWeight;
	}
	
	/**
	 * @brief Methode qui enleve tous les objets prsents dans le sac
	 */
	public void toEmpty() {
		inTheBag.removeAll(inTheBag);
		currentWeight = 0;
		values = 0;
	}
	
	/**
	 * @brief Ajout d'un objet dans le sac
	 * @param o l'objet a ajouter
	 */
	public void addObject(Objet o) {
		
		if (currentWeight + o.getWeight() <= maxWeight) {
			this.inTheBag.add(o);
			currentWeight += o.getWeight();
			values += o.getValue();
		}else 
			return;
	}

	/**
	 * @brief Getter de l'attribut currentWeight
	 * @return le poids actuel du sac
	 */
	public float getCurrentWeight() {
		return currentWeight;
	}
	
	/**
	 * @brief Getter de l'attribut objectList
	 * @return la liste des objets qui ne sont pas encore dans le sac
	 */
	public ArrayList<Objet> getObjectList(){
		return this.objectsList;
	}
	
	/**
	 * @brief Setter de l'attribut objectList
	 * @param list nouvelle liste d'objets
	 */
	public void setObjectList(ArrayList<Objet> list ) {
		this.objectsList = list;
	}
	
	/**
	 * @brief Methode retournant le nombre d'objet dans le sac
	 * @return le nombre d'objet dans le sac
	 */
	public int nbObjetsInTheBag() {
		return this.objectsList.size();
	}

	/**
	 * @brief Setter de l'attribut maxWeight
	 * @param maxWeight le nouveau poids maximal du sac
	 */
	public void setMaxWeight(float maxWeight) {
		this.maxWeight = maxWeight;
	}

	/**
	 * @brief Getter de l'attribut values
	 * @return la valeur du sac a dos 
	 */
	public float getValues() {
		return values;
	}

	/**
	 * @brief Setter de l'attribut currentWeight
	 * @param currentWeight le nouveau poids actuel du sac
	 */
	public void setCurrentWeight(float currentWeight) {
		this.currentWeight = currentWeight;
	}

	/**
	 * @brief Getter de l'attribut inTheBag
	 * @return la liste des objets presents dans le sac
	 */
	public ArrayList<Objet> getInTheBag() {
		return inTheBag;
	}
	
	
}