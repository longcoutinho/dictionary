public class DictionaryCommandline extends Dictionary {
	DictionaryManagement dictionaryManagement = new DictionaryManagement();
	public void showAllWords() {
		dictionaryManagement.printListOfWords();
	}

	public void dictionarySearcher(String wordSearching) {
		dictionaryManagement.listOfSearching("wordSearching");
	}

	public void dictionaryBasic() {
		dictionaryManagement.insertFromCommandline();
		showAllWords();
	}

	public void dictionaryAdvanced() {
		dictionaryManagement.insertFromFile();
		showAllWords();
		System.out.println(dictionaryManagement.dictionaryLookup("brother"));
		dictionarySearcher("sis");
	}

	public static void main(String[] args) {
		DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
		dictionaryCommandline.dictionaryAdvanced();
	}
}

