package csvproject.input_models;

import csvproject.util.FileUtil;

public class SubjectResult extends InputModel {
	
	private static final String outputFileName = "subject_result.csv";
	
	private static final String[] titles = new String[] {
		"Subject name",
		"Marks"
	};
	
	public SubjectResult() {
		// You must call super method before anything else.
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
