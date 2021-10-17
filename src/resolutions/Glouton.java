package resolutions;

import structure.SacADos;

/**
 * @author Pasquier, Pessey
 * @brief Classe Glouton
 */
public class Glouton implements IResolution {
	
	/**
	 * @brief Methode de resolution du probleme du sac a dos - Methode approchee
	 */
	public final void resolution(SacADos bag) {
		float weight = bag.getCurrentWeight();
		for(int i = 0; i < bag.getObjectList().size(); i++) {
			bag.addObject(bag.getObjectList().get(i));
		}
	}
}
