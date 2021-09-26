package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SacADos {
	
	private float maxWeight;
	private float currentWeight; 
	private ArrayList<Objet> objectsList;
	private ArrayList<Objet> inTheBag;

	//Construteur générant un sac vide
	public SacADos(float maxWeight) {
		this.maxWeight = maxWeight;
		this.currentWeight = 0;
		this.objectsList = new ArrayList<Objet>();
		this.inTheBag = new ArrayList<Objet>();
	}
	
	public SacADos(String path, float maxWeight) {
		this.maxWeight = maxWeight;
		this.objectsList = new ArrayList<Objet>();
		this.inTheBag = new ArrayList<Objet>();
		this.currentWeight = 0;
		
		objectsList = initObjList(path);
	}

	//voir si on créer une nouvelle classe pour les méthodes suivantes 
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
	
	private Objet initObj(String obj) {
		String[] objInfo = obj.split(";");
		//parce que lenght renvoi le nb d'éléments donc 3
		if (objInfo.length == 3) {
			return new Objet (objInfo[0], Float.parseFloat(objInfo[1]), Float.parseFloat(objInfo[2]));
		}
		return null; // return exception obj non valide
	}
		

			
	private ArrayList initObjList(String url) {
		String[] file = readTextFile(url).split("\n");
		ArrayList<Objet> objectsList = new ArrayList<Objet>();
		for (String obj : file) {
			objectsList.add(initObj(obj));
		}
		return objectsList;
		
	}
	
	
	public String toStringOut() {
		StringBuilder bagContent = new StringBuilder();
		for(Objet o : objectsList) {
			bagContent.append(o.getName() + " ; " + o.getWeight() + " ; " + o.getValue()+ " ; " + o.getRatio() + "\n");
		}
		return bagContent.toString();
	}
	
	public String toStringIn() {
		StringBuilder bagContent = new StringBuilder();
		for(Objet o : inTheBag) {
			bagContent.append(o.getName() + " ; " + o.getWeight() + " ; " + o.getValue()+ " ; " + o.getRatio() + "\n");
		}
		return bagContent.toString();
	}

	public float getMaxWeight() {
		return maxWeight;
	}
	
	public void addObject(Objet o) {
		
		if (currentWeight + o.getWeight() <= maxWeight) {
			this.inTheBag.add(o);
			currentWeight += o.getWeight();
		}else 
			return;
	}

	public float getCurrentWeight() {
		return currentWeight;
	}
	
	public ArrayList<Objet> getObjectList(){
		return this.objectsList;
	}
	
	public void setObjectList(ArrayList<Objet> list ) {
		this.objectsList = list;
	}
	
	private ArrayList<Objet> getInTheBag() {
		return inTheBag;
	}

	private void setInTheBag(ArrayList<Objet> inTheBag) {
		this.inTheBag = inTheBag;
	}
	
	
}