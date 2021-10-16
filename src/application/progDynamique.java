package application;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class progDynamique implements IResolution {
	
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
			b.setCurrentWeight(b.getCurrentWeight() / coeff);
		}
		catch(ArithmeticException e) {
			System.out.println("Divion par 0 impossible");
		}
		
	}
}