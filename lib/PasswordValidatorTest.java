package lib;

public class PasswordValidatorTest{
    
    public static void run() {
        System.out.println("--- Running Password Validator Tests ---");
        
        // Test Case 1: รหัสผ่านสั้นควรจะ INVALID
        PasswordStrength result1 = PasswordValidator.validate("123");
        if (result1 == PasswordStrength.INVALID) {
            System.out.println("Test Case 1 Passed: Short password is INVALID.");
        } else {
            System.out.println("Test Case 1 FAILED: Expected INVALID but got " + result1);
        }

        // Test Case 2: รหัสผ่านที่มีแต่ตัวเลขควรจะ WEAK
        PasswordStrength result2 = PasswordValidator.validate("12345678");
        if (result2 == PasswordStrength.WEAK) {
            System.out.println("Test Case 2 Passed: Only Number password is WEAK.");
        } else {
            System.out.println("Test Case 2 FAILED: Expected WEAK but got " + result2);
        }

        // Test Case 3: รหัสผ่านที่มีแต่ตัวพิมใหญ่ควรจะ WEAK
        PasswordStrength result3 = PasswordValidator.validate("ABCDEFGH");
        if (result3 == PasswordStrength.WEAK) {
            System.out.println("Test Case 3 Passed: Only Upper password is WEAK.");
        } else {
            System.out.println("Test Case 3 FAILED: Expected WEAK but got " + result3);
        }
        // Test Case 4: รหัสผ่านที่มีแต่ตัวพิมเล็กควรจะ WEAK
        PasswordStrength result4 = PasswordValidator.validate("abcdefgh");
        if (result4 == PasswordStrength.WEAK) {
            System.out.println("Test Case 4 Passed: Only Lower password is WEAK.");
        } else {
            System.out.println("Test Case 4 FAILED: Expected WEAK but got " + result4);
        }
        // Test Case 5: รหัสผ่านที่มี2ลักษณะควรจะ WEAK
        PasswordStrength result5 = PasswordValidator.validate("asdw1234");
        if (result5 == PasswordStrength.WEAK) {
            System.out.println("Test Case 5 Passed: 2 Style password is WEAK.");
        } else {
            System.out.println("Test Case 5 FAILED: Expected WEAK but got " + result5);
        }
        // Test Case 6: รหัสผ่านที่มี3ลักษณะควรจะ MEDIUM
        PasswordStrength result6 = PasswordValidator.validate("asdw12AS");
        if (result6 == PasswordStrength.MEDIUM) {
            System.out.println("Test Case 6 Passed: 3 Style password is MEDIUM.");
        } else {
            System.out.println("Test Case 6 FAILED: Expected MEDIUM but got " + result6);
        }
        // Test Case 7: รหัสผ่านที่มี4ลักษณะควรจะ STRONG
        PasswordStrength result7 = PasswordValidator.validate("as12AS*/");
        if (result7 == PasswordStrength.STRONG) {
            System.out.println("Test Case 7 Passed: 4 Style password is STRONG.");
        } else {
            System.out.println("Test Case 7 FAILED: Expected STRONG but got " + result7);
        }
        System.out.println("--------------------------------");
    }
}
