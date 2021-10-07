package application;

public class progDynamique {
	
	public static final void progDynamique(SacADos b) {
		int nbObj = b.nbObjetsInTheBag();
		int maxWeight = (int) b.getMaxWeight();
		
		int[][] mat = new int[nbObj][maxWeight+1];
		
		for(int i = 0; i < nbObj; i++) {
			for(int j = 0; j < maxWeight; j++) {
				if(b.getObjectList().get(0).getWeight() > j) {
					mat[0][j] = 0;
				}
				else {
					mat[0][j] = (int) b.getObjectList().get(0).getValue();
				}
				
				if(b.getObjectList().get(i).getWeight() > j) {
					mat[i][j] = mat[i - 1][j];
				}
				else {
					mat[i][j] = Math.max(mat[i - 1][j], mat[i - 1][(int) (j - b.getObjectList().get(i).getWeight()) + (int) b.getObjectList().get(i).getValue()]);
				}
			}
		}
	}
	
	/**
	 * TODO : 
	 * finir la méthode en récupérant les objets à l'aide du pseudo code suivant 
	 * 
	 * Et puis, de là, on récupère les objets :

		TANT QUE j > 0
		TANT QUE i > 0 ET M[i][j] EGALE M[i-1][j]
		décrémente i
		j = j - PoidsObjet[i]
		SI j > 0
		Ajoute-objet ( Objet[i] )
		décrémente i
		
	 */
	
	/** 
	 * pour les poids qui sont en float / problème de cast en int dans cette méthode 
	 * poids de tous les objets et poids du sac 
	 * - regarder celui qui a le plus de chiffre apres la virgule 
	 * - multiplier les poids de tous les objet + sac par 10 puissance nb chiffres apres la virgule 
	 * 
	 * ex : si obj1 = 0,002 alors on multiplie par 10^3 tous les poids des objets 
	 * avec ca on obtient que des entiers donc on peut manipuler les poids dans l'algo
	 * 
	 * stocker le coefficient et faire la modification avant de faire tourner l'algo 
	 * apres que l'algo ai tourné, divisier tous les poids (obj et sac) par le coef
	 */
}

