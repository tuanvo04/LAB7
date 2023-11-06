package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;

public class TestReadFile {
	public static void main(String[] args) throws FileNotFoundException {

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		System.out.println("Before: " + list);

		MyWordCount wordCounter = new MyWordCount();
		List<WordCount> wordCounts = wordCounter.getWordCounts();
		System.out.println("After: " + wordCounts);

		Set<String> wordCounts1 = wordCounter.getUniqueWords();
		System.out.println("getUniqueWords: " + wordCounts1);

		Set<String> wordCounts2 = wordCounter.getDistinctWords();
		System.out.println("getDistinctWords: " + wordCounts2);

		Set<WordCount> wordCounts3 = wordCounter.printWordCounts();
		System.out.println("printWordCounts: " + wordCounts3);

		Set<WordCount> wordCounts4 = wordCounter.exportWordCountsByOccurence();
		System.out.println("exportWordCountsByOccurence: " + wordCounts4);

		Set<String> wordCounts5 = wordCounter.filterWords("L");
		System.out.println("filterWords L: " + wordCounts5);

		
		// test cho class MyPredicates
		// In danh sách ban đầu
		System.out.println("Danh sách ban đầu: " + list);

		// Sử dụng Even Predicate
		Predicate<Integer> evenPredicate1 = new Even();

		// Sử dụng phương thức remove để loại bỏ các số chẵn
		MyPredicates.remove(list, evenPredicate1);
		System.out.println("Danh sách sau khi loại bỏ số chẵn: " + list);

		
		
		// Tạo danh sách mới
		List<Integer> newList = new ArrayList<>();
		newList.add(1);
		newList.add(2);
		newList.add(3);
		newList.add(4);
		newList.add(5);
		newList.add(6);

		Predicate<Integer> evenPredicate2 = new Even();
		// Sử dụng phương thức retain để giữ lại các số chẵn từ danh sách mới
		MyPredicates.retain(newList, evenPredicate2);
		System.out.println("Danh sách sau khi giữ lại các số chẵn từ danh sách mới: " + newList);

		// Sử dụng phương thức collect để thu thập các số chẵn từ danh sách ban đầu
		List<Integer> evenList = new ArrayList<>(newList);
		MyPredicates.collect(evenList, evenPredicate2);
		System.out.println("Danh sách các số chẵn từ danh sách ban đầu: " + evenList);

		// Sử dụng phương thức find để tìm vị trí của số lẻ đầu tiên
		int firstOddIndex = MyPredicates.find(list, num -> num % 2 != 0);
		System.out.println("Vị trí của số lẻ đầu tiên trong danh sách: " + firstOddIndex);
	}
}