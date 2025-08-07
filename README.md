#  Large File Data Indexing and Word Search using Trie

This Java-based project reads a large text file and efficiently indexes every word using a **Trie (Prefix Tree)** data structure. Once indexed, users can **search for any word** to check if it exists in the file and how many times it appears.

---

##  Features

-  Reads large files line-by-line using `BufferedReader`
-  Uses **Trie** for fast word insertion and lookup
-  Handles punctuation and case-insensitivity
-  Interactive CLI: search for words or exit anytime
-  Shows word frequency if present in the file

---

##  How It Works

1. The program prompts for a **file name** (supports relative paths).
2. Reads the file, extracts valid words, and inserts them into the trie.
3. Accepts user input to **search words** interactively.
4. Returns the **count of each word's occurrence** or a not-found message.

---


---

##  Technologies Used

- Java 11+
- Trie Data Structure
- BufferedReader
- Scanner

---

##  Future Enhancements

- Show **suggestions** for near matches (fuzzy search)
- Export indexed data as a report
- GUI integration using JavaFX or Swing
- Add support for multiple files or file types

---

##  Notes

- Input file must be in `.txt` format.
- Words are normalized: lowercase and stripped of punctuation.
- File path must be correct, or the program will exit gracefully.
- Due to GitHub's file size limitations, the test dataset (170,000+ rows) has not been uploaded. 
  However, the project has been successfully tested on this large data file locally.

---

##  Author

**Palak Kansal**  
B.Tech CSE @ The NorthCap University  
 Linkedin: [https://www.linkedin.com/in/palak-kansal-52540322a/] 
 Email: [palakkansal137@gmail.com]
