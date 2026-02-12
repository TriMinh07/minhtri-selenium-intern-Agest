package Common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UtilsDate {
	
	public static String getFutureDate(int daysToAdd) {
		LocalDate futureDate = LocalDate.now().plusDays(daysToAdd);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        
        return futureDate.format(formatter);
    }
}
 