import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
	public void insertFromCommandline() {
		Scanner scanner = new Scanner(System.in);
		setWordCount(scanner.nextInt());
		scanner.nextLine();
		int value = getWordCount();
		for(int i = 0 ; i < value ; i++){
			String scanner_target = scanner.nextLine();
			String scanner_explain = scanner.nextLine();
			Word newWord = new Word(scanner_target,scanner_explain);
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
				listofWords.add(newWord);
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
		return "Cannot find this word!";
	}

	public List<String> listOfSearching(String wordNeedToSearch) {
		List<String> newlist = new ArrayList<>();
		for(int i = 0 ; i < getWordCount() ; i++) {
			if ((listofWords.get(i).getWord_target()).startsWith(wordNeedToSearch)) newlist.add(listofWords.get(i).getWord_target() + "\n");
		}
		return newlist;
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
			res += listofWords.get(i).getWord_target() + "  |  " + listofWords.get(i).getWord_explain() + "\n";
		}
		return res;
	}
}



