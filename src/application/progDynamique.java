package application;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @author Pasquier, Pessey
 * @brief Classe progDynamique
 */
public class progDynamique implements IResolution {
	
	/**
	 * @brief Methode de resolution du probleme du sac a dos - Programmation dynamique
	 */
	public final void resolution(SacADos b) {
		int nbObj = b.nbObjetsInTheBag();
		int coeff = coefficient(b , b.getObjectList());
		
		castToInt(coeff, b.getObjectList(), b);
		int maxWeight = (int) b.getMaxWeight();
		
		int[][] mat = new int[nbObj][maxWeight+1];
		int i = 1;
		int j = 0;

		for(; j < b.getMaxWeight(); j++){
			if(b.getObjectList().get(0).getWeight() > j){
				mat[0][j] = 0;
			}
			else{
				mat[0][j] = (int) b.getObjectList().get(0).getValue();
			}
		}

		j=0;
		
		for(; i < nbObj; i++){
			j=0;
			for(; j < b.getMaxWeight()+1; j++){
				if(b.getObjectList().get(i).getWeight() > j){
					mat[i][j] = mat[i-1][j];
				}
				else{
					mat[i][j] = (int) Math.max(mat[i-1][j], mat[i-1][(int) ((j - b.getObjectList().get(i).getWeight()))] + b.getObjectList().get(i).getValue());
				}
			}
		}
		
		i--;
		j--;
		
		while(j != 0 && mat[i][j] == mat[i][j-1]) {
			j--;
		}

		while(j > 0){
			while(i > 0 && mat[i][j] == mat[i-1][j]){
				i--;
			}
			j = (int) (j - b.getObjectList().get(i).getWeight());
			if(j >= 0){
				b.addObject(b.getObjectList().get(i));
			}
			i--;	
		}

		castToFloat(coeff, b.getObjectList(), b);
	}
	
	/**
	 * @brief Methode permettant de trouver le coefficient par lequel on multiplie les poids des objets et du sac pour les
	 * 		  caster en entier sans perdre d'informations
	 * @param b le sac a dos 
	 * @param list la liste des objets contenus dans le sac a dos 
	 * @return le coefficient
	 */
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
	
	/**
	 * @brief Methode multipliant les poids des objets et du sac par un coefficient pour obtenir des valeurs qui 
	 * 		  pourront etre caster en entier
	 * @param coeff le coefficient 
	 * @param list la liste des objets
	 * @param b le sac
	 */
	public static void castToInt(int coeff, ArrayList<Objet> list, SacADos b) {
		for(Objet o : list) {
			o.setWeight(o.getWeight() * coeff);
		}
		b.setMaxWeight(b.getMaxWeight() * coeff);
	}
	
	/**
	 * @brief Methode divisant les poids des objets et du sac par un coefficient pour obtenir des valeurs qui 
	 * 		  pourront etre caster en float
	 * @param coeff le coefficient 
	 * @param list la liste des objets
	 * @param b le sac
	 */
	public static void castToFloat(int coeff, ArrayList<Objet> list, SacADos b) {
		try {
			for(Objet o : list) {
				o.setWeight(o.getWeight() / coeff);
			}
			b.setCurrentWeight(b.getCurrentWeight() / coeff);
		}
		catch(ArithmeticException e) {
			System.out.println("Divion par 0 impossible");
		}
		
	}
}