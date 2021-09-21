package com.revature.week2;

public class MemorySize {

	public String actualMemorySize(String size) {
		//to catch a NumberFormatException if presented
		try {
			//checks if the size is correct, it should be higher then 2 due to number and byte type
			if (size.length() > 2) {
				// creates String Builder
				StringBuilder sb = new StringBuilder();
				// Injects GB or MB
				sb.append(size.substring(size.length() - 2, size.length()));
				//checks if GB or MB is presented
				if (sb.toString().contains("GB") || sb.toString().contains("MB")) {
					// Injects number excluding last 2 due to being either GB or MB
					Float num = Float.parseFloat(size.substring(0, size.length() - 2));
					// Calculates the memory loss by 7% (0.07)
					num = num - (num * 0.07f);
					// If the number is lower then 1, convert it into a MB
					if (num < 1 && sb.toString().equals("GB")) {
						//pushes 3 numbers above the decimal for MB
						num = num * 1000;
						//replaces GB with MB
						sb.replace(0, sb.length(), "MB");
					}
					// rounds the number depending on MB or GB
					num = sb.toString().equals("GB") ? Math.round(num * 100.0f) / 100.0f : Math.round(num);
					// returns both strings
					return sb.toString().equals("GB") ? num.toString() + sb.toString()
							: num.toString().substring(0, num.toString().length() - 2) + sb.toString();
				}

			}
		} catch (NumberFormatException e) {
			System.err.println(e);
		}
		//returns information if not presented correctly
		return size + " is incorrect information!";
	}
}
