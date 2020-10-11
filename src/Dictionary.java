import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	private int wordCount;
	public List<Word> listofWords = new ArrayList<Word>();

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}
}

