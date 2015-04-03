package RealEstate;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author Shenali
 */
public class ValidateValues {
   public static void checkTelNo(JTextField txt) {
        String s = txt.getText();
        int length = s.length();
        String word = "";
        boolean onlyInt = true;
        int i = 1;
        while (onlyInt) {
            try {
                String s2 = s.substring(0, i);
                Long.parseLong(s2);
                word = s2;
                i++;
                if (i > length) {
                    onlyInt = false;
                }
            } catch (Exception e) {
                onlyInt = false;
            }
        }
        if (length > 10) {
            word = s.substring(0, 10);
        }
        txt.setText(word);
    }
    public static void checkMarks(JTextField txt) {
        String s = txt.getText();
        int length = s.length();
        String word = "";
        boolean onlyInt = true;
        int i = 1;
        while (onlyInt) {
            try {
                String s2 = s.substring(0, i);
                Long.parseLong(s2);
                word = s2;
                i++;
                if (i > length) {
                    onlyInt = false;
                }
            } catch (Exception e) {
                onlyInt = false;
            }
        }
        if (length > 2) {
            word = s.substring(0, 2);
        }
        txt.setText(word);
    }
   public static void validateString(JTextField txt) {
      
        try {
            String t = txt.getText();
            while(t.contains("'")||t.contains("\"")||t.contains(";")||t.contains(".")||t.contains(",")||t.contains("\\")) {
                String b = t.substring(0, t.length() - 1);
                t = b;
                txt.setText(b);
            }
        } catch (Exception e) {
        }
      for(char ch : txt.getText().toCharArray()){
           String t = txt.getText();
      if(Character.isDigit(ch)){
            String b = t.substring(0, t.length() - 1);
             t = b;
             txt.setText(b);


        }
    }

    
    }
   
    public static void validateLength(JTextField txt, int length) {
        String s = txt.getText();
        if (s.length() > length) {
            String s1 = s.substring(0, s.length()-1);
            txt.setText(s1);
        }
    }
    
    public static boolean checkEmail(JTextField txt) {
boolean state=true;
        String text = txt.getText();
        boolean atContains = false;
        boolean periodContains = false;
        boolean isMultipleAt = false;
        int indexOfAt = 0;
        int indexOfPeriod = 0;
        char ch[] = text.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '@') {
                if (!atContains) {
                    atContains = true;
                    indexOfAt = i;
                }else{
                    isMultipleAt=true;
                }
            }

            if (atContains) {
                if (ch[i] == '.') {
                    periodContains = true;
                    indexOfPeriod = i;
                    break;
                }
            }
        }

        if ((!periodContains) || (!atContains) || (indexOfPeriod - indexOfAt <= 1) || isMultipleAt) {
            JOptionPane.showMessageDialog(null, "Please check your E mail");
            state=false;
        }
        return state;
    }
    
     
}
