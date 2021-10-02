package application;

public class progDynamique {
	
	public static final void progDynamique(SacADos b) {
		int nbObj = b.nbObjetsInTheBag();
		int maxWeight = (int) b.getMaxWeight();
		
		int[][] mat = new int[nbObj][maxWeight];
		
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
}

