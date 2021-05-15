import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args){
        Expression exp = new Expression();
        String line = null;
        try {
            line = new BufferedReader(new InputStreamReader(System.in)).readLine();
            if (line.matches("\\A[IVXLCDM]+[\\-\\+\\*\\/][IVXLCDM]+\\Z")){
                exp.parseRoman(line);
                System.out.println(Converter.arabicToRoman(exp.getResult()));
            }else if (line.matches("\\A[0-9]+[\\-\\+\\*\\/][0-9]+\\Z")){
                exp.parseArabic(line);
                System.out.println(exp.getResult());
            }else{
                throw new IOException(line + " is not valid expression!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
