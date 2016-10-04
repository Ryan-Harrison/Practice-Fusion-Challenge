package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import model.*;
import controller.Searcher;

public class SearchTest {
	
	int[] specs = {0,0,0,
			1,1,
			2,2,
			3,3,3,3,
			4,4};
	int[] areas = {0,0,0,
			1,2,
			3,3,
			4,4,4,4,
			5,6};
	int[] scores = {90,95,100,
			90,90,
			70,30,
			70,80,80,91,
			0,100};
	
	DocListGen docListGen = new DocListGen();
	Doctor[] doctors = docListGen.generateList(specs, areas, scores);
	Searcher searcher = new Searcher();
	
	@Test
	public void testSort0() {
		Doctor[] result = searcher.search(doctors[0], doctors);
		
		assertEquals("First result", 2, result[0].getId());
		assertEquals("Second result", 1, result[1].getId());
	}
	
	@Test
	public void testSort1() {
		Doctor[] result = searcher.search(doctors[3], doctors);
		
		assertEquals("Should be empty", 0, result.length);
	}
	
	@Test
	public void testSort2() {
		Doctor[] result = searcher.search(doctors[5], doctors);
		
		assertEquals("Should be empty", 0, result.length);
	}
	
	@Test
	public void testSort3() {
		Doctor[] result = searcher.search(doctors[7], doctors);
		
		assertEquals("First result", 8, result[0].getId());
		assertEquals("Second result", 9, result[1].getId());
	}
	
	@Test
	public void testSort4() {
		Doctor[] result = searcher.search(doctors[11], doctors);
		
		assertEquals("Should be empty", 0, result.length);
	}
}
