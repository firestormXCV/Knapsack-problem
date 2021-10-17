package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import resolutions.progDynamique;
import structure.SacADos;

public class TestSacADos {

	@Test
	public void test() {
		
		SacADos sacRempli = new SacADos("dynamique.txt", 12);
		SacADos sacVide = new SacADos(10);

		assertTrue(sacRempli.getObjectList().size() > 0);
		assertTrue(sacVide.getObjectList().size() == 0);
		assertTrue(sacRempli.getValues() == sacVide.getValues());
		
		progDynamique progDynamique = new progDynamique();
		progDynamique.resolution(sacRempli);

		sacRempli.toEmpty();
		assertTrue(sacRempli.getCurrentWeight() == 0);
	}

}
