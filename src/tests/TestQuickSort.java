package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

import structure.Objet;
import structure.SacADos;
import tri.QuickSort;

public class TestQuickSort {

	@Test
	public void test() {
		
		SacADos sacTest = new SacADos("dynamique.txt", 12);
		ArrayList<Objet> list = sacTest.getObjectList();
		
		float min = 0;
		float max = list.size() - 1;
		String listBeforeGlouton = "";
		String listAfterGlouton = "";
		String listAfterGloutonBis = "";
		
		assertEquals(list.size(), 8);
		
		for(Objet o : list) {
			listBeforeGlouton += o.getName() + ", ";
		}
		
		QuickSort.QuickSort(list, min, max);

		for(Objet o : list) {
			listAfterGlouton += o.getName() + ", ";
		}
		
		assertTrue(listBeforeGlouton != listAfterGlouton);

		QuickSort.QuickSort(list, min, max);
		
		for(Objet o : list) {
			listAfterGloutonBis += o.getName() + ", ";
		}
		
		assertEquals(listAfterGlouton, listAfterGloutonBis);
	}

}
