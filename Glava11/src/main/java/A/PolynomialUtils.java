package A;
import java.util.HashMap;
import java.util.Map;
//Романов Альберт Б762-2 Вариант 9
public class PolynomialUtils {
    public static Map<Integer, Integer> addPolynomials(Map<Integer, Integer> p1, Map<Integer, Integer> p2) {
        Map<Integer, Integer> result = new HashMap<>(p1);
        p2.forEach((degree, coefficient) -> result.merge(degree, coefficient, Integer::sum));
        return result;
    }

    public static String polynomialToString(Map<Integer, Integer> polynomial) {
        StringBuilder sb = new StringBuilder();
        polynomial.entrySet().stream()
                .sorted((e1, e2) -> e2.getKey() - e1.getKey())
                .forEach(entry -> {
                    int coeff = entry.getValue();
                    int degree = entry.getKey();
                    if (coeff != 0) {
                        if (sb.length() > 0) sb.append(" + ");
                        sb.append(coeff).append("x^").append(degree);
                    }
                });
        return sb.toString();
    }
}
