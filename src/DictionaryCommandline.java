import javafx.util.Pair;

public class DictionaryCommandline extends Dictionary {
	DictionaryManagement dictionaryManagement = new DictionaryManagement();
	public void showAllWords() {
		System.out.println(dictionaryManagement.printListOfWords());
	}

	public void dictionarySearcher(String wordSearching) {
		Pair<Integer,Integer> newpair = dictionaryManagement.listOfAdvancedSearching(wordSearching);
		System.out.println(newpair.getKey() + " " + newpair.getValue());
	}

	public void dictionaryBasic() {
		dictionaryManagement.insertFromCommandline();
		showAllWords();
	}

	public void dictionaryAdvanced() {
		dictionaryManagement.insertFromFile();
		//showAllWords();
		//System.out.println(dictionaryManagement.dictionaryLookup("brother"));
		dictionarySearcher("");
		//dictionaryManagement.dictionaryExportToFile();
	}

	public static void main(String[] args) {
		//DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
		//dictionaryCommandline.dictionaryAdvanced();
	}
}

