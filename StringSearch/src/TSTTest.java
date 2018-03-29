import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

public class TSTTest {

	@Test
	public void testEmpty() {
		TST<Long> trie = new TST<>();
		assertEquals("size of an empty trie should be 0", 0, trie.size());
		assertFalse("searching an empty trie should return false", trie.contains(""));
		assertNull("getting from an empty trie should return null", trie.get(""));
	}

	@Test
	public void testPut() {

		TST<Integer> trie = new TST<>();
		trie.put("Hello", 0);
		trie.put("", 3);
		trie.put("          ", 5);
		trie.put("Welcome", 4);
		trie.put(null, null);

	}

	@Test
	public void testGet() {

		TST<Integer> trie = new TST<>();
		trie.put("Hello", 5);
		int i = trie.get("Hello");
		assertEquals(5, i);

		trie.put(" ", 3);
		i = trie.get(" ");
		assertEquals(i, 3);
		
		String key =null;
		
		assertEquals(null,trie.get(key));
		
		assertEquals(null,trie.get(""));
	}

	@Test
	public void testSize() {
		TST<Integer> trie = new TST<>();
		trie.put("Hello", 5);
		int size = trie.size();
		assertEquals(1, size);
	}

	@Test
	public void testContains() {
		TST<Integer> trie = new TST<>();
		trie.put("Hello", 1);
		boolean doesContain = trie.contains("Hello");
		assertEquals(true, doesContain);
		doesContain = trie.contains("Welcome");
		assertEquals(false, doesContain);
	}

	@Test
	public void testLinkedList() {
		TST<Integer> trie = new TST<>();
		trie.put("test", 0);
		trie.put("testing", 3);
		trie.put("tested", 5);
		trie.put("tests", 4);
		trie.put("tester", 2);

		LinkedList<String> prefixList = trie.keysWithPrefix("test");

		assertEquals("[test, tested, tester, testing, tests]", prefixList.toString());
		
		prefixList = trie.keysWithPrefix("");
		
		assertEquals("[]",prefixList.toString());
	}

//	public static void main(String[] args) {
//		int count = 1;
//		TST<Integer> trie = new TST<>();
//		JSONParser parser = new JSONParser();
//		Object obj;
//		try {
//			obj = parser.parse(new FileReader("BUSES_SERVICE_0.json"));
//			JSONArray jsonArr = (JSONArray) obj;
//			;
//			String destination;
//			for (int i = 0; i < jsonArr.size(); i++) {
//				JSONObject entry = (JSONObject) jsonArr.get(i);
//				destination = (String) entry.get("Destination");
//
//				if (!trie.contains(destination))
//					trie.put(destination, count);
//				else
//					trie.put(destination, trie.get(destination) + 1);
//				// System.out.println(destination + " " +
//				// trie.get(destination));
//			}
//			System.out.println("Unique values: " + trie.size());
//
//			System.out.println(trie.contains("SOUTHSIDE"));
//
//			String wordsWithDown = trie.keysWithPrefix("DOWN").toString();
//			String[] wordsWithDownArr = wordsWithDown.split(",");
//
//			int totalDownCount = 0;
//			for (int i = 0; i < wordsWithDownArr.length; i++) {
//				wordsWithDown = wordsWithDownArr[i].substring(1, wordsWithDownArr[i].length() - 1);
//				totalDownCount += trie.get(wordsWithDown);
//			}
//
//			System.out.println("Total Down Count: " + totalDownCount);
//
//			// PART D
//			TST<Long> tst = new TST<>();
//			Scanner s = new Scanner(new File("src/google-books-common-words.txt"));
//
//			String[] wordsArray;
//			String words;
//			while (s.hasNextLine()) {
//				words = s.nextLine();
//				wordsArray = words.split("	");
//
//				tst.put(wordsArray[0], Long.parseLong(wordsArray[1]));
//
//			}
//			System.out.println("Total Amount of words: " + tst.size());
//
//			System.out.println("Frequency of word ALGORITHM: " + tst.get("ALGORITHM"));
//
//			System.out.println("Does the file contain the word EMOJI: " + tst.contains("EMOJI"));
//
//			System.out.println("Does the file contain the word BLAH: " + tst.contains("BLAH"));
//
//			int testCount = tst.keysWithPrefix("TEST").size();
//
//			System.out.println("Words starting with TEST: " + testCount);
//		} catch (Exception e) {
//		}
//	}

}
