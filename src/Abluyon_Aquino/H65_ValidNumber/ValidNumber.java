package Abluyon_Aquino.H65_ValidNumber;

public class ValidNumber {

    public static void main(String[] args) {
        String[] testValues = {
            "123", "12.34", "-5.6", "1e10", "abc", "12a", "e9", "99e2.5"
        };

        for (String val : testValues) {
            System.out.println(val + " -> " + isNumber(val));
        }
    }

    public static boolean isNumber(String s) {
        s = s.trim();
        boolean num = false, dot = false, exp = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (dot || exp) return false;
                dot = true;
            } else if (c == 'e' || c == 'E') {
                if (exp || !num) return false;
                exp = true;
                num = false; // reset num for digits after exponent
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return num;
    }
}
