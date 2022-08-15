import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static String getRandomDate(){
        long currentDate = LocalDate.now().toEpochDay();
        long randomEpochDay = ThreadLocalRandom.current().longs(currentDate - 3650, currentDate)
                .findAny().getAsLong();
        return LocalDate.ofEpochDay(randomEpochDay).format(DateTimeFormatter.ofPattern("YYYY-MM-DD"));
    }
}
