package by.epam.learn.validator;

public class DataValidator {
	private static final String PATTERN = "((\\-)?\\d+(\\.\\d+)?\\s?){5}";
	
	public static boolean isCorrectRow(String row) {
		return row.matches(PATTERN);
	}
}
