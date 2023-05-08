import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ConvertToDayOfWeek {

    public static Map<String, Integer> convertToDayOfWeek(Map<String, Integer> inputDict) {
        Map<String, Integer> outputDict = new HashMap<>();
        for (Map.Entry<String, Integer> entry : inputDict.entrySet()) {
            String dateString = entry.getKey();
            int value = entry.getValue();

            LocalDate date = LocalDate.parse(dateString);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            String dayOfWeekString = dayOfWeek.toString();

            if (outputDict.containsKey(dayOfWeekString)) {
                int currentValue = outputDict.get(dayOfWeekString);
                outputDict.put(dayOfWeekString, currentValue + value);
            } else {
                outputDict.put(dayOfWeekString, value);
            }
        }
        return outputDict;
    }

    public static void main(String[] args) {
        Map<String, Integer> inputDict = new HashMap<>();
        inputDict.put("2020-01-01", 4);
        inputDict.put("2020-01-02", 4);
        inputDict.put("2020-01-03", 6);
        inputDict.put("2020-01-04", 8);
        inputDict.put("2020-01-05", 2);
        inputDict.put("2020-01-06", -6);
        inputDict.put("2020-01-07", 2);
        inputDict.put("2020-01-08", -2);

        Map<String, Integer> outputDict = convertToDayOfWeek(inputDict);
        System.out.println(outputDict);
    }
}

import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class ConvertToDayOfWeekTest {

    @Test
    public void testConvertToDayOfWeek() {
        Map<String, Integer> inputDict = new HashMap<>();
        inputDict.put("2020-01-01", 4);
        inputDict.put("2020-01-02", 4);
        inputDict.put("2020-01-03", 6);
        inputDict.put("2020-01-04", 8);
        inputDict.put("2020-01-05", 2);
        inputDict.put("2020-01-06", -6);
        inputDict.put("2020-01-07", 2);
        inputDict.put("2020-01-08", -2);

        Map<String, Integer> outputDict = ConvertToDayOfWeek.convertToDayOfWeek(inputDict);

        Map<String, Integer> expectedDict = new HashMap<>();
        expectedDict.put("Mon", -6);
        expectedDict.put("Tue", 2);
        expectedDict.put("Wed", 2);
        expectedDict.put("Thu", 4);
        expectedDict.put("Fri", 6);
        expectedDict.put("Sat", 8);
        expectedDict.put("Sun", 2);

        Assert.assertEquals(expectedDict, outputDict);
    }
}
