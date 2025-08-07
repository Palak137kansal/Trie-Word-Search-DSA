import java.io.*;
import java.util.*;

class TrieNode {
    char data;
    TrieNode[] child;
    boolean wordEnd;
    int count;

    public TrieNode(char data) {
        this.data = data;
        this.child = new TrieNode[26];
        this.wordEnd = false;
        this.count = 0;
    }
}

public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode('/');
    }

    public TrieNode getNode(char c) {
        return new TrieNode(c);
    }

    public void insert(String s) {
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if (curr.child[index] == null) {
                curr.child[index] = getNode(ch);
            }
            curr = curr.child[index];
        }
        curr.wordEnd = true;
        curr.count++;
    }

    public int search(String s) {
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if (curr.child[index] == null) {
                return 0; 
            }
            curr = curr.child[index];
        }
        return curr.wordEnd ? curr.count : 0; 
    }

    public void read_file(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); 
                for(int i = 0; i < words.length; i++) {
                    String word = words[i].toLowerCase().replaceAll("[^a-z]", ""); 
                    if (!word.isEmpty()) {
                        insert(word); 
                    }
                }
            }
        br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Trie trie = new Trie();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file relative path to read:");
        String fileName = sc.nextLine();

        try {
            trie.read_file(fileName);
        }

        catch (IOException e) {
        System.out.println("File not found or error reading the file.");
        return;
    }
        

        while (true) {
            System.out.println("\nEnter a word to search (or type 'exit' to quit):");
            String input = sc.nextLine().toLowerCase();

            if (input.equals("exit")) {
                break;
            }

            int count = trie.search(input);

            if (count > 0) {
                System.out.println("The word '" + input + "' exists " + count + " times in the file.");
            } else {
                System.out.println("The word '" + input + "' does not exist in the file.");
            }
        }
    }
}
