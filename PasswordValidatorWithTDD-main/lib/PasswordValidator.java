package lib;

public class PasswordValidator {

    /**
     *การตรวจสอบ Password ว่ามีความแข็งแรงเท่าไหร่
     * @param รับค่า password เข้ามาเก็บใน Array
     * @return ส่งค่าPasswordStrenghคืนกลับ
     */
    // TODO: แก้ไข return type ของเมธอดนี้ให้ถูกต้อง
    public static PasswordStrength validate(String password) { // Function Type ให้เป็น PasswordStrength 
        // ส่วนของ Implementation ที่คุณต้องเขียน
        int count = 0, minLength = 8;
        int num = 0, upchar = 0, lowchar = 0, other = 0;
        if (password == null || password.length() < minLength)
            return PasswordStrength.INVALID;
        
        /*int count = 0 ;
        for(char c : password.toCharArray()){
            if(Character.isLowerCase(c))
                count++ ;
        }
        if (count == password.length())
            return PasswordStrength.WEAK;
        */
        
        char charArray[] = password.toCharArray();
        for(int i = 0 ; i < password.length() ; i++){
            if((charArray[i] >= '0') && (charArray[i] <= '9'))
                num++;
            else if((charArray[i] >= 'A') && (charArray[i] <= 'Z'))
                upchar++;
            else if((charArray[i] >= 'a') && (charArray[i] <= 'z'))
                lowchar++;
            else other++;
        }
        
        if (num != 0) count++;
        if (upchar != 0) count++;
        if (lowchar != 0) count++;
        if (other != 0) count++;
        
        if ((count == 1) || (count == 2)) return PasswordStrength.WEAK;
        if (count == 3) return PasswordStrength.MEDIUM;
        if (count == 4) return PasswordStrength.STRONG;
        
        return PasswordStrength.WEAK ; // TODO: การคืนค่านี้ถูกต้องหรือไม่?
    }
}