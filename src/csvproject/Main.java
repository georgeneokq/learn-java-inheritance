package csvproject;

import csvproject.input_models.Expense;
import csvproject.input_models.SubjectResult;
import csvproject.util.FileUtil;

public class Main {
	public static void main(String[] args) {
		FileUtil.print("Welcome to CSV writer.", true);

		inputSubjectResults();
		inputExpenses();

		FileUtil.print("The program has ended.");
	}

	private static boolean toContinue() {
		FileUtil.print("Enter 1 to enter more values, enter any other key to continue", true);
		String input = FileUtil.getStringInput();
		if(input.equals("1")) {
			return true;
		}
		return false;
	}

	private static void inputSubjectResults() {
		boolean cont;
		do {
			SubjectResult subjectResult = new SubjectResult();
			subjectResult.writeValues();
			cont = toContinue();
		} while(cont);
	}

	private static void inputExpenses() {
		boolean cont;
		do {
			Expense expense = new Expense();
			expense.writeValues();
			cont = toContinue();
		} while(cont);
	}
}
