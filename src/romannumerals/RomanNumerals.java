package romannumerals;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class RomanNumerals {
	
	private static final Map<String, Integer> lettersToValue = createLettersToValue();
	
	private static Map<String, Integer> createLettersToValue() {
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("M", 1000);
		map.put("CM", 900);
		map.put("D", 500);
		map.put("CD", 400);
		map.put("C", 100);
		map.put("XC", 90);
		map.put("L", 50);
		map.put("XL", 40);
		map.put("X", 10);
		map.put("IX", 9);
		map.put("V", 5);
		map.put("IV", 4);
		map.put("I", 1);
		return Collections.unmodifiableMap(map);
	}
	
	private static String matchNextLetters(String string) {
		for (String letters : lettersToValue.keySet()) {
			if (string.startsWith(letters))
				return letters;
		}
		return null;
	}
	
	public static RomanNumerals parse(String string) {
		if (string == null)
			throw new NullPointerException();
		if (string.isEmpty())
			throw new NumberFormatException();
		String remaining = string;
		int integer = 0;
		while (!remaining.isEmpty()) {
			String letters = matchNextLetters(remaining);
			if (letters == null)
				throw new NumberFormatException(string);
			integer += lettersToValue.get(letters);
			remaining = remaining.substring(letters.length());
		}
		return new RomanNumerals(integer);
	}
	
	private final int integer;
	
	public RomanNumerals(int integer) {
		if (integer <= 0)
			throw new NumberFormatException(String.valueOf(integer));
		this.integer = integer;
	}
	
	@Override
	public boolean equals(Object object) {
		return object instanceof RomanNumerals
				&& ((RomanNumerals) object).integer == integer;
	}
	
	@Override
	public int hashCode() {
		return 31 * integer + 17;
	}
	
	public int toInt() {
		return integer;
	}
	
	@Override
	public String toString() {
		int remaining = integer;
		String string = "";
		for (Entry<String, Integer> entry : lettersToValue.entrySet()) {
			while (remaining >= entry.getValue()) {
				string += entry.getKey();
				remaining -= entry.getValue();
			}
		}
		return string;
	}

}
