package A;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
//Романов Альберт Б762-2 Вариант 9
class PolynomialUtilsTest {
    @Test
    void testAddPolynomials() {
        Map<Integer, Integer> p1 = new HashMap<>();
        p1.put(2, 3);
        p1.put(1, 2);

        Map<Integer, Integer> p2 = new HashMap<>();
        p2.put(1, 5);
        p2.put(0, 4);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(2, 3);
        expected.put(1, 7);
        expected.put(0, 4);

        Map<Integer, Integer> result = PolynomialUtils.addPolynomials(p1, p2);
        assertEquals(expected, result);
    }

    @Test
    void testPolynomialToString() {
        Map<Integer, Integer> polynomial = new HashMap<>();
        polynomial.put(2, 3);
        polynomial.put(0, 4);

        String expected = "3x^2 + 4x^0";
        assertEquals(expected, PolynomialUtils.polynomialToString(polynomial));
    }
}

