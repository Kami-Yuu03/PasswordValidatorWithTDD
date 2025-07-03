package lib;

public class PasswordValidator {

    /**
     *การตรวจสอบ Password ว่ามีความแข็งแรงเท่าไหร่
     * @param รับค่า password เข้ามาเก็บใน Array
     * @param ตัวแปร count เพื่อนับว่าตรงกี่เงื่อนไข
     * @param ตัวแปร minLenght เก็บจำนวน password ที่น้อยที่สุด
     * @param ตัวแปร num เก็บจำนวนเงื่อนไขตัวเลขว่าถูกกี่รอบ
     * @param ตัวแปร upchar เก็บจำนวนเงื่อนไขตัวพิมใหญ่ว่าถูกกี่รอบ
     * @param ตัวแปร lowchar เก็บจำนวนเงื่อนไขตัวพิมเล็กว่าถูกกี่รอบ
     * @param ตัวแปร other เก็บจำนวนเงื่อนไข่ตัวอักษรพิเศษว่าถูกกี่รอบ
     * @return หาก password ไม่มีค่าหรือ ว่างเปล่า ส่งค่า INVALID
     * @return หาก count เท่ากับ 1 หรือ 2 ส่งค่า WEAK
     * @return หาก count เท่ากับ 3 ส่งค่า MEDUIM
     * @return หาก count เท่ากับ 4 ส่งค่า STRONG
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