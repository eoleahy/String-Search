import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import org.junit.Test;

public class KMPSearchTest {

	@Test
	public void testEmpty() {

		assertEquals("Empty text or pattern is invalid", -1, KMPSearch.searchFirst("", ""));
		assertEquals("Empty text or pattern is invalid", 0, KMPSearch.searchAll("", ""));
		assertFalse("Empty text or pattern isminvalid", KMPSearch.contains("", ""));
	}

	@Test
	public void testContains() {
		String testString = "goodstring";
		String pat = "ing";
		assertEquals(KMPSearch.contains(testString, pat), true);
		pat = "ok";
		assertEquals(KMPSearch.contains(testString, pat), false);
		
		pat="";
		assertEquals(KMPSearch.contains(testString, pat), false);
	}

	@Test
	public void testSearchOne() {
		String teststring = "thisisagoodstring";
		String pat = "good";
		assertEquals(KMPSearch.searchFirst(teststring, pat), 7);
		pat = "final";
		assertEquals(KMPSearch.searchFirst(teststring, pat), -1);
	}

	@Test
	public void testSearchAll() {
		String txt = "According to all known laws of aviation, " + "there is no way a bee should be able to fly "
				+ "Its wings are too small to get" + " its fat little body off the ground. "
				+ "the bee, of course, flies anyway " + "because bees don't care what humans think is impossible.";

		String pat = "bee";

		KMPSearch.searchAll(txt, pat);
	}

	public static void main(String[] args) {
//		JSONParser parser = new JSONParser();
//		Object obj;
//		try {
//			obj = parser.parse(new FileReader("BUSES_SERVICE_0.json"));
//			JSONArray jsonArr = (JSONArray) obj;
//			String jsonData = jsonArr.toString();
//			System.out.println(jsonData);
//
//			int numVehicles = KMPSearch.searchAll(jsonData, "VehicleNo");
//			System.out.println("Number of Vehicles: " + numVehicles);
//
//			if (KMPSearch.contains(jsonData, "16555"))
//				System.out.println("Contains Data for this vehicle number");
//			else
//				System.out.println("Does not contain data");
//
//			int firstHampton = KMPSearch.searchFirst(jsonData, "HAMPTON PARK");
//			System.out.println("Data found starting at index: " + firstHampton);
//
//			if (KMPSearch.contains(jsonData, "9043409"))
//				System.out.println("Data found");
//			else
//				System.out.println("No Data Found");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
	}
}
