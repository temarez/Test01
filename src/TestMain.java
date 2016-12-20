import com.github.temarez.test01.utils.Utils;
import com.github.temarez.test01.words.WordEntry;
import com.github.temarez.test01.words.WordList;

public class TestMain {

	public static void main(String[] args) {
		if(args.length<2) {
			System.out.println("Usage: <filename> <number of top occurrences to be displayed> ");
			return;
		}
		
		String fileName = args[0];
		String fileContents = Utils.readTextFile(fileName);
		int topOccurrencesNum = Integer.parseInt(args[1]);
		
		WordList words = new WordList();
		words.fromString(fileContents);
		words.sortByCountDesc();
		
		int occurrencesToDisplay = topOccurrencesNum;
		if(words.size()<occurrencesToDisplay) {
			System.err.println(String.format("Error: Can not display top %d occurrences since there are %d occurrences totally!", topOccurrencesNum, occurrencesToDisplay));
			occurrencesToDisplay = words.size();
		}

		System.out.println(String.format("List of the top %d occurrences:", occurrencesToDisplay));
		for(int i=0; i<occurrencesToDisplay; i++) {
			WordEntry curOccur = words.get(i);
			System.out.println(curOccur);
		}
	}
}
