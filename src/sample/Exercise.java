package sample;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class Exercise {

	WebDriver driver;

	By value1 = By.id("txt_val1");
	By value2 = By.id("txt_val2");
	By value3 = By.id("txt_val3");
	By value4 = By.id("txt_val4");
	By value5 = By.id("txt_val5");
	By totalValue = By.id("txt_ttl_val");

	public Exercise(WebDriver driver) {
		this.driver = driver;
	}

	// Get the value of the text boxes

	public String getValueOfTextBox(By value) {

		String valueOfTextBox = driver.findElement(value).getAttribute("value");
		return valueOfTextBox;
	}

	// Check values displayed or not

	public Boolean checkValuePresentOnScreen(By value) {

		if (driver.findElement(value).isDisplayed())
			return true;
		return false;

	}
	// Check whether the value in a text box is greater than zero.

	public Boolean valueGreaterThanZero(By value) {

		Double valueInDouble = this.getValueOfTextBoxInDouble(value);
		if (valueInDouble > 0)
			return true;
		return false;

	}

	// Check whether the expected value matches the actual value of a text box

	public Boolean valueMatches(By value, Double expectedValue) {

		Double actualValueInDouble = this.getValueOfTextBoxInDouble(value);
		Double expectedValueInDouble = expectedValue;

		if (actualValueInDouble == expectedValueInDouble)
			return true;
		return false;

	}

	// Get the value of the text box in double.

	public Double getValueOfTextBoxInDouble(By value) {

		String valueOfTextBox = this.getValueOfTextBox(value);
		valueOfTextBox = valueOfTextBox.replace("$", "").replace(",", "");
		Double actualValueInDouble = Double.parseDouble(valueOfTextBox);

		return actualValueInDouble;

	}

	// Check whether the total balance matches the sum of values

	public Boolean totalBalanceMatchesSum() {

		Double sum = this.getValueOfTextBoxInDouble(value1) + this.getValueOfTextBoxInDouble(value2)
				+ this.getValueOfTextBoxInDouble(value3) + this.getValueOfTextBoxInDouble(value4)
				+ this.getValueOfTextBoxInDouble(value5);

		Double totalBalance = this.getValueOfTextBoxInDouble(totalValue);
		if (sum == totalBalance)
			return true;
		return false;

	}

	// Check whether the values are formatted as currencies

	public Boolean verifyCurrency(By value) {

		String valueOfTextBox = this.getValueOfTextBox(value);
		char currency = valueOfTextBox.charAt(0);
		if (currency == '$')

			return true;
		return false;

	}

}
