import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
		return "-1";
	}

	public void listOfSearching(String wordNeedToSearch) {
		for(int i = 0 ; i < getWordCount() ; i++) {
			System.out.println(1);
			if ((listofWords.get(i).getWord_target()).startsWith(wordNeedToSearch)) System.out.println(listofWords.get(i).getWord_target());
		}
	}

	public void printListOfWords() {
		int value = getWordCount();
		for(int i = 0 ; i < value ; i++) {
			System.out.println(listofWords.get(i).getWord_target() + "|" + listofWords.get(i).getWord_explain());
		}
	}
}



