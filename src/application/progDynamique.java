package application;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class progDynamique {
		
	public static final void progDynamique(SacADos b) {
		int nbObj = b.nbObjetsInTheBag();
		int coeff = coefficient(b , b.getObjectList());
		
		castToInt(coeff, b.getObjectList(), b);
		int maxWeight = (int) b.getMaxWeight();
		
		int[][] mat = new int[nbObj][maxWeight+1];
		int i = 0;
		int j = 0;
		//boucle d'initialisaton de la matrice :tout mettre a 0 
		//boucle simple cf la boucle j 
		
		//faire ensuite la double blouce de i et j pour remplir le tableau 
		// i = nb objet 
		// j = poids max + 1
		
		//on peut récupérer les valeurs de i et j apres la double boucle
		// i = nb objet - 1
		//j = poids max 
		
		//boucle de récupération 
		
		for(; i < nbObj; i++) {
			for(; j < maxWeight + 1; j++) {
					if (b.getObjectList().get(i).getWeight() < j)
						continue;
				
					if(b.getObjectList().get(0).getWeight() > j) {
						mat[0][j] = 0;
					}
					else {
						mat[0][j] = (int) b.getObjectList().get(0).getValue();
					}
					
					if(b.getObjectList().get(i).getWeight() > j) {
						if (i == 0) {
							mat[i][j] = mat[i][j];
						}else
						mat[i][j] = mat[i - 1][j];
					}
					else {
						/*System.out.println(i);
						System.out.println(j);
						System.out.println(b.getObjectList().get(i).getWeight());
						System.out.println(b.getObjectList().get(i).getValue());
						System.out.println(j - b.getObjectList().get(i).getWeight() + b.getObjectList().get(i).getValue());*/
						if (i == 0)
							mat[i][j] = (int) Math.max(mat[i][j], mat[i][(int) ((j - b.getObjectList().get(i).getWeight()))] + b.getObjectList().get(i).getValue());
						else
							mat[i][j] = (int) Math.max(mat[i - 1][j], mat[i - 1][(int) ((j - b.getObjectList().get(i).getWeight()))] + b.getObjectList().get(i).getValue());
					}
					
								
			}
			
		}
		
		int i -= 1;
		while(mat[i][j] == mat[i][j-1]) {
			j--;
			while(j > 0) {
				while(i > 0 && mat[i][j] == mat[i-1][j]) 
					i--;
				j = (int) (j - b.getObjectList().get(i).getWeight());
				if(j >= 0) 
					b.addObject(b.getObjectList().get(i));
				i--;				
			}
		}
		castToFloat(coeff, b.getObjectList(), b);
	}
	
	public static int coefficient(SacADos b, ArrayList<Objet> list) {
		int coeff = 0;
		String str;
		DecimalFormat df = new DecimalFormat();
		char sep;
		
		for(Objet o : list) {
			str = df.format(o.getWeight());
			sep = df.getDecimalFormatSymbols().getDecimalSeparator();
			str = str.substring( str.indexOf(sep) + 1);
			if (coeff < str.length()) {
				coeff = str.length();
			}
		}
		
		str = df.format(b.getCurrentWeight());
		sep = df.getDecimalFormatSymbols().getDecimalSeparator();
		str = str.substring( str.indexOf(sep) + 1 );
		if (coeff < str.length()) {
			coeff = str.length();
		}
		
		return (int) Math.pow(10, coeff);
	}
	

	public static void castToInt(int coeff, ArrayList<Objet> list, SacADos b) {
		for(Objet o : list) {
			o.setWeight(o.getWeight() * coeff);
		}
		b.setMaxWeight(b.getMaxWeight() * coeff);
	}
	
	public static void castToFloat(int coeff, ArrayList<Objet> list, SacADos b) {
		try {
			for(Objet o : list) {
				o.setWeight(o.getWeight() / coeff);
			}
			b.setMaxWeight(b.getMaxWeight() / coeff);
		}
		catch(ArithmeticException e) {
			System.out.println("Divion par 0 impossible");
		}
		
	}
}