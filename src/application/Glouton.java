package application;

import java.util.ArrayList;
import java.util.Collections;

public class Glouton implements IResolution {
		
	public final void resolution(SacADos bag) {
		float weight = bag.getCurrentWeight();
		for(int i = 0; i < bag.getObjectList().size(); i++) {
			bag.addObject(bag.getObjectList().get(i));
		}
	}
}
