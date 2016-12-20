package com.github.temarez.test01.words;

public class WordEntry {
	
	public String word;
	public int count;

	public WordEntry() {
		word = "";
		count = 0;
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%d", word, count);
	}

}
