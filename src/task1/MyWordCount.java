package task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "Data/fit";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> wordCounts = new ArrayList<>();

		for (String w : words) {
			// int count = count(w);
			WordCount wc = new WordCount(w, count(w));
			wordCounts.add(wc);
		}

		return wordCounts;
	}

	private int count(String w) {
		int count = 0;
		for (String word : words) {
			if (word.equals(w)) {
				count++;
			}
		}
		return count;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> arr = new HashSet<>();
		for (WordCount word : getWordCounts()) {
			if (word.getCount() == 1) {
				arr.add(word.getWord());
			}
		}

		return new HashSet<>(this.words);
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		// TODO
		Set<String> arr = new HashSet<>();
		for (String w : words) {
			if (!w.equals(w)) {
				arr.add(w);
			}
		}
		return new HashSet<>(this.words);
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {

		Set<WordCount> arr = new TreeSet<>(new Comparator<WordCount>() {
			public int compare(WordCount wc1, WordCount wc2) {

				int countComparison = Integer.compare(wc1.getCount(), wc2.getCount());
				if (countComparison == 0) {
					// If counts are equal, compare based on the words
					return wc1.getWord().compareTo(wc2.getWord());
				}
				return countComparison;
			}
		});

		arr.addAll(getWordCounts());

		for (WordCount wordCount : arr) {
			System.out.println(wordCount.getWord() + ": " + wordCount.getCount());

		}
		return arr;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount> arr = new TreeSet<>(new Comparator<WordCount>() {
			public int compare(WordCount wc1, WordCount wc2) {

				int countComparison = Integer.compare(wc2.getCount(), wc1.getCount());
				if (countComparison == 1) {
					// If counts are equal, compare based on the words
					return wc1.getWord().compareTo(wc2.getWord());
				}
				return countComparison;
			}
		});

		arr.addAll(getWordCounts());

		for (WordCount wordCount : arr) {
			System.out.println(wordCount.getWord() + ": " + wordCount.getCount());

		}
		return arr;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {

		Set<String> filteredWords = new HashSet<>();

		for (String word : words) {
			if (!word.startsWith(pattern)) {
				filteredWords.add(word);
			}
		}

		return filteredWords;
	}
}
