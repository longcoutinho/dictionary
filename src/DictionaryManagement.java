import javafx.util.Pair;

import java.io.*;
import java.util.*;

public class DictionaryManagement extends Dictionary {
	Map<String,String> map = new HashMap<String,String>();
	public void insertFromCommandline() {
		Scanner scanner = new Scanner(System.in);
		setWordCount(scanner.nextInt());
		scanner.nextLine();
		int value = getWordCount();
		for(int i = 0 ; i < value ; i++){
			String scanner_target = scanner.nextLine();
			String scanner_explain = scanner.nextLine();
			Word newWord = new Word(scanner_target,scanner_explain);
			map.put(scanner_target,scanner_explain);
			listofWords.add(newWord);
		}
	}

	public void insertFromFile() {
		try{
			String line;
			String[] lineparts;
			Scanner pw = new Scanner(new BufferedReader(new FileReader("dictionaries.txt")));
			int value = 0;
			while(pw.hasNext()) {
				value++;
				line = pw.nextLine();
				lineparts = line.split("\t+");
				Word newWord = new Word(lineparts[0],lineparts[1]);
				map.put(lineparts[0], lineparts[1]);
				listofWords.add(newWord);
				Collections.sort(listofWords);
			}
			setWordCount(value);
		}catch(IOException ex){
			System.out.println(ex);
		}
	}

	public String dictionaryLookup(String wordLookup) {
		for(int i = 0 ; i < getWordCount() ; i++) {
			if (listofWords.get(i).getWord_target().equals(wordLookup)) return listofWords.get(i).getWord_explain();
		}
		return "";
	}

	public String dictionaryAdvancedLookup(String wordLookup) {
		return map.get(wordLookup);
	}

	public List<String> listOfSearching(String wordNeedToSearch) {
		List<String> newlist = new ArrayList<>();
		for(int i = 0 ; i < getWordCount() ; i++) {
			if ((listofWords.get(i).getWord_target()).startsWith(wordNeedToSearch)) newlist.add(listofWords.get(i).getWord_target() + "\n");
		}
		return newlist;
	}

	public int chatnhiphan1(int L, int R , String strvalue) {
		int l = L - 1;
		int r = R + 1;
		int mid;
		while(r - l > 1) {
			mid = (l + r) / 2;
			String abc = listofWords.get(mid).getWord_target();
			String subabc = abc.substring(0, Math.min(strvalue.length() , abc.length()));
			//System.out.println(subabc + " " + strvalue);
			if (subabc.compareTo(strvalue) >= 0) r = mid;
			else l = mid;
		}
		return r + 1;
	}

	public int chatnhiphan2(int L, int R , String strvalue) {
		int l = L - 1;
		int r = R + 1;
		int mid;
		while(r - l > 1) {
			mid = (l + r) / 2;
			String abc = listofWords.get(mid).getWord_target();
			String subabc = abc.substring(0, Math.min(strvalue.length() , abc.length()));
			//System.out.println(subabc);
			if (subabc.compareTo(strvalue) > 0) r = mid;
			else l = mid;
		}
		return r;
	}

	public Pair<Integer, Integer> listOfAdvancedSearching(String wordNeedtoSearch) {
		int res1 = chatnhiphan1(0, getWordCount() - 1, wordNeedtoSearch);
		int res2 = chatnhiphan2(0, getWordCount() - 1, wordNeedtoSearch);
		Pair<Integer, Integer> pair = new Pair<Integer, Integer>(res1,res2);
		return pair;
	}

	public void dictionaryExportToFile() {
		try	{
			String str = printListOfWords();
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			writer.write(str);
			writer.close();
		}
		catch (Exception e) {
			System.out.println("Something went wrong.");
		}
	}

	public String printListOfWords() {
		String res = "";
		int value = getWordCount();
		for(int i = 0 ; i < value ; i++) {
			res += listofWords.get(i).getWord_target() + "\t" + listofWords.get(i).getWord_explain() + "\n";
		}
		return res;
	}
}



