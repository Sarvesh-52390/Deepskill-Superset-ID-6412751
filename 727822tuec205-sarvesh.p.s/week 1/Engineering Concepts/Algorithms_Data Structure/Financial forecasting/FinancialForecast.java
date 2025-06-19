
import java.util.HashMap;
import java.util.Map;

public class FinancialForecast {


    private static Map<Integer, Double> memo = new HashMap<>();


    public static double futureValue(int year, double initialValue, double growthRate) {
        if (year == 0) return initialValue;

        
        if (memo.containsKey(year)) return memo.get(year);

        
        double value = futureValue(year - 1, initialValue, growthRate) * (1 + growthRate);
        memo.put(year, value);
        return value;
    }

    public static void main(String[] args) {
        int years = 10;
        double initialValue = 1000.0;
        double growthRate = 0.05;

        for (int i = 0; i <= years; i++) {
            System.out.printf("Year %d: %.2f\n", i, futureValue(i, initialValue, growthRate));
        }
    }
}
