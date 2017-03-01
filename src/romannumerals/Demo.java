package romannumerals;

public class Demo {
	
	public static void main(String[] args) {
		System.out.println("Integers to Roman numerals:");
		for (int i = 1; i <= 100; i++) {
			System.out.format("%s: %s", i, new RomanNumerals(i));
			System.out.println();
		}
		System.out.println();
		System.out.println("Roman numerals to integers:");
		for (int i = 1; i <= 100; i++) {
			String roman = new RomanNumerals(i).toString();
			System.out.format("%s: %s", roman, RomanNumerals.parse(roman.toString()).toInt());
			System.out.println();
		}
	}

}
