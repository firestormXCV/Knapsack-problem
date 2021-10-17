package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Glouton;
import application.Objet;
import application.PSE;
import application.QuickSort;
import application.SacADos;
import application.progDynamique;

public class TestResolution {

	@Test
	public void test() {
		
		float maxVal = 0;
		
		SacADos sacGlouton = new SacADos("dynamique.txt", 10);
		SacADos sacDynamique = new SacADos("dynamique.txt", 10);
		SacADos sacPSE = new SacADos("dynamique.txt", 10);
		
		Glouton glouton = new Glouton();
        progDynamique progDynamique = new progDynamique();
		PSE pse = new PSE();
		
		assertTrue(sacGlouton.getObjectList().size() == 8);
		assertTrue(sacDynamique.getCurrentWeight() == 0);
		assertEquals((int) sacPSE.getMaxWeight(), 10);
		
		sacGlouton.setObjectList(QuickSort.QuickSort(sacGlouton.getObjectList(),(float) 0, (float) sacGlouton.getObjectList().size() - 1));
		
		for(Objet o : sacPSE.getObjectList()) {
			maxVal += o.getValue();
		}

		
		glouton.resolution(sacGlouton);
		progDynamique.resolution(sacDynamique);
		pse.resolution(sacPSE);
		
		assertTrue(sacGlouton.getCurrentWeight() <= sacGlouton.getMaxWeight());
		assertFalse(sacPSE.getValues() > maxVal);
		assertEquals(sacDynamique.getInTheBag().size(), sacPSE.getInTheBag().size());
	}

}
