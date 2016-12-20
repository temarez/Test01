package com.github.temarez.test01.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {

	public static String readTextFile(String path, Charset encoding) {
		byte[] encoded;
		try {
			encoded = Files.readAllBytes(Paths.get(path));
			return new String(encoded, encoding);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String readTextFile(String path) {
		return readTextFile(path, Charset.defaultCharset());
	}
	
	public String[] splitBySpace(String text) {
		String[] words = text.split("\\s");
		return words;
	}

}
