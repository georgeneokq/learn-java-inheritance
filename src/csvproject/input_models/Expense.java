package csvproject.input_models;

import csvproject.util.FileUtil;

public class Expense extends InputModel {
	private static final String outputFileName = "expenses.csv";
	
	private static final String[] titles = new String[] {
		"Name",
		"Category",
		"Amount spent"
	};
	
	public Expense() {
		super(outputFileName, titles);
	}

	/*
	 * Control how to get user values, but the result in the end is still that the superclass gets the string array
	 */
	@Override
	public String[] getUserValues() {
		String[] values = new String[titles.length];
		for(int i = 0; i < titles.length; i++) {
			FileUtil.print(titles[i] + ": ", true);
			values[i] = FileUtil.getStringInput();
		}
		return values;
	}
}
