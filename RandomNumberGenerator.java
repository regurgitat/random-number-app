import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    public static String generateRandomNumber(int firstDigit, int lastDigit, int length) {
        if (length < 2) throw new IllegalArgumentException("الطول يجب أن يكون ≥ 2");
        if (firstDigit < 0 || firstDigit > 9 || lastDigit < 0 || lastDigit > 9)
            throw new IllegalArgumentException("الأرقام بين 0-9");
        if (length > 10) throw new IllegalArgumentException("لا يمكن أن يزيد الطول عن 10");
        if (firstDigit == lastDigit && length > 2) throw new IllegalArgumentException("أول وآخر رقم لا يمكن أن يكونا متساويين إذا كان الطول أكبر من 2");

        List<Integer> available = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            if (i != firstDigit && i != lastDigit) available.add(i);
        }
        Collections.shuffle(available);
        StringBuilder result = new StringBuilder();
        result.append(firstDigit);
        for (int i = 0; i < length - 2; i++) result.append(available.get(i));
        result.append(lastDigit);
        return result.toString();
    }
}
