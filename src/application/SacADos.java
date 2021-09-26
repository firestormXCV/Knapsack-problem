package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SacADos {
	
	private float maxWeight;
	private ArrayList<Objet> objectsList;
	
	
	//Construteur générant un sac vide
	public SacADos(float maxWeight) {
		this.maxWeight = maxWeight;
		this.objectsList = new ArrayList<Objet>();
	}
	
	public SacADos(String path, float maxWeight) {
		this.maxWeight = maxWeight;
		this.objectsList = new ArrayList<Objet>();
		
		String fileContent = readTextFile(path);
		
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
	
	
	public String toString() {
		StringBuilder bagContent = new StringBuilder();
		for(Objet o : objectsList) {
			bagContent.append(o.getName() + " ; " + o.getWeight() + " ; " + o.getValue() + "\n");
		}
		return bagContent.toString();
	}

	public float getMaxWeight() {
		return maxWeight;
	}
	
	public void addObject(Objet o) {
		this.objectsList.add(o);
	}
}