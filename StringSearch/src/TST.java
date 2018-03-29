
import java.util.LinkedList;

public class TST<Value> {

	/*
	 * Bus Service Questions:
	 *  1. How many unique destinations is there in the file? 
	 *  		A: 171
	 *  
	 *  2. Is there a bus going to the destination "SOUTHSIDE"?
	 * 			A: No
	 * 
	 * 3. How many records is there about the buses going to the
	 * destination beginning with "DOWN"? 
	 * 			A: 70
	 *
	 * Google Books Common Words Questions: 
	 * 4. How many words is there in the file?
	 *  		A: 97565 
	 *  
	 * 5. What is the frequency of the word "ALGORITHM"? 
	 * 			A: 14433021
	 *  
	 * 6. Is the word "EMOJI" present? 
	 *  		A: No 
	 *  
	 * 7. IS the word "BLAH" present? 
	 * 			A: Yes
	 * 
	 * 8. How many words are there that start with "TEST"? 
	 * 			A: 39
	 */
	
	/*
	 * A Node in your trie containing a Value val and a pointer to its children
	 */
	private static class TrieNode<Value> {
		private char c; // character
		private TrieNode<Value> left, mid, right; // left, middle, and right
													// subtries
		private Value val; // value associated with string
	}

	/* a pointer to the start of your trie */
	private TrieNode<Value> root = new TrieNode();
	private int size = 0;

	/*
	 * Returns the number of words in the trie
	 */
	public int size() {
		return size;
	}

	/*
	 * returns true if the word is in the trie, false otherwise
	 */
	public boolean contains(String key) {

		if (get(key) == null)
			return false;
		else
			return true;
	}

	/*
	 * return the value stored in a node with a given key, returns null if word
	 * is not in trie
	 */
	public Value get(String key) {
		if (key == null)
			return null;
		if (key.length() == 0)
			return null;

		TrieNode<Value> n = get(root, key, 0);

		if (n == null)
			return null;
		else
			return n.val;

	}

	private TrieNode get(TrieNode n, String key, int x) {

		if (n == null)
			return null;
		if (key.length() == 0)
			return null;
		char c = key.charAt(x);

		if (c < n.c)
			return get(n.left, key, x);
		else if (c > n.c)
			return get(n.right, key, x);
		else if (x + 1 < key.length())
			return get(n.mid, key, x + 1);
		else
			return n;
	}

	/*
	 * stores the Value val in the node with the given key
	 */
	public void put(String key, Value val) {
		if (key == null)
			return;
		if (key.length() == 0)
			return;
		if (!contains(key))
			size++;
		root = put(root, key, val, 0);
	}

	private TrieNode<Value> put(TrieNode<Value> n, String key, Value val, int x) {
		char c = key.charAt(x);
		if (n == null) {
			n = new TrieNode<Value>();
			n.c = c;
		}

		if (c < n.c)
			n.left = put(n.left, key, val, x);
		else if (c > n.c)
			n.right = put(n.right, key, val, x);
		else if (x + 1 < key.length())
			n.mid = put(n.mid, key, val, x + 1);
		else
			n.val = val;
		return n;
	}

	/*
	 * returns the linked list containing all the keys present in the trie that
	 * start with the prefix passes as a parameter, sorted in alphabetical order
	 */
	public LinkedList<String> keysWithPrefix(String prefix) {

		if (prefix == null)
			return null;
		LinkedList<String> list = new LinkedList<String>();
		TrieNode<Value> n = get(root, prefix, 0);
		if (n == null)
			return list;
		if (n.val != null)
			list.add(prefix);
		getByPrefix(n.mid, new StringBuilder(prefix), list);
		return list;
	}

	private void getByPrefix(TrieNode<Value> n, StringBuilder prefix, LinkedList<String> list) {
		if (n == null)
			return;
		getByPrefix(n.left, prefix, list);

		if (n.val != null)
			list.add(prefix.toString() + n.c);
		getByPrefix(n.mid, prefix.append(n.c), list);
		prefix.deleteCharAt(prefix.length() - 1);
		getByPrefix(n.right, prefix, list);
	}
}