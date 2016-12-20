package com.github.temarez.test01.words;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WordList extends ArrayList<WordEntry> {
	private static final long serialVersionUID = 1644478458707218003L;

	public void fromString(String str) {
		this.clear();
		String[] splitedWords = str.split("\\s");
		for(int indWord=0; indWord<splitedWords.length; indWord++) {
			WordEntry wrdEntry = new WordEntry();
			wrdEntry.word = splitedWords[indWord];
			int existingWordEntryIndex = getWordEntryIndex(wrdEntry.word);
			
			// First occurrence
			if(existingWordEntryIndex==-1) {
				wrdEntry.count = 1;
				this.add(wrdEntry);
			}
			// Already listed word
			else {
				wrdEntry = this.get(existingWordEntryIndex);
				wrdEntry.count += 1;
			}
		}
	}
	
	/** */
	public int getWordEntryIndex(String word) {
		int result = -1;
		for(int ind=0; ind<this.size(); ind++) {
			WordEntry curWordEntry = this.get(ind);
			if(curWordEntry.word.equals(word)) {
				result = ind;
				break;
			}
		}
		return result;
	}
	
	/** Sort the words list by "count" field in a descending order */
	public void sortByCountDesc() {
		Collections.sort(this, new Comparator<WordEntry>() {
		    @Override
		    public int compare(WordEntry we1, WordEntry we2) {
		    	return we2.count-we1.count;
		    }
		});
	}

}
