package csvproject.input_models;

import java.io.File;

import csvproject.util.FileUtil;

/*
 * InputModel is an abstract class that defines necessary properties for a InputModel to have
 */
public abstract class InputModel {
	
	private final String FILE_BASE_PATH = System.getProperty("user.dir") + "\\csv_data\\";
	
	private String outputFileName;
	
	private String[] titles;
	
	private String[] values;
	
	protected InputModel(String outputFileName, String[] titles) {
		this.outputFileName = outputFileName;
		this.titles = titles;
		this.values = getUserValues();
	}
	
	/*
	 * Get input from user
	 */
	protected abstract String[] getUserValues();
	
	
	/*
	 * Will always append values, not overwrite
	 */
	public void writeValues() {
		// Path to write file
		String path = FILE_BASE_PATH + outputFileName;
		
		// Form a file object to handle file
		File file = new File(path);
		
		// If the file is empty, write the headers
		if(file.length() == 0) {
			String headers = "";
			for(int i = 0; i < titles.length; i++) {
				String title = titles[i];
				headers += (i < titles.length - 1) ? title + "," : title + FileUtil.lineSeparator;
			}
			
			boolean written = FileUtil.write(path, headers);
			if(!written) {
				FileUtil.print("ERROR");
			}
		}
		
		// Values to append to file, form the string before writing
		String csv = "";
		
		// Append values
		for(int i = 0; i < values.length; i++) {
			String value = values[i];
			csv += (i < values.length - 1) ? value + "," : value + FileUtil.lineSeparator;
		}
	
		boolean written = FileUtil.write(path, csv, true);
		if(!written) {
			FileUtil.print("ERROR");
		}
	}
}
