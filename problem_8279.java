import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {    
    public static void main(String[] args) throws Exception  {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String setup = input.readLine();
        
        while (setup !=null && setup.length() != 0) {
            int len = Integer.parseInt(setup.split(" ")[0]);
            Long steps = Long.parseLong(setup.split(" ")[1]);;
            String str = input.readLine();
            String[] strings = PrepareString(len, str);
            String outputString = SwapStrings(strings, steps);
            System.out.println(outputString);
            setup = input.readLine();
        }
        
        input.close();
    }
    
    private static String[] PrepareString(int len, String str) {
        int substringLen = len / 4;
        String[] strings = new String[4];
        int stringSpliteStep = 0;
        
        strings[0]=str.substring(stringSpliteStep, stringSpliteStep + substringLen);
        stringSpliteStep += substringLen;
        strings[1]=str.substring(stringSpliteStep, stringSpliteStep + substringLen);
        stringSpliteStep += substringLen;
        strings[2]=str.substring(stringSpliteStep, stringSpliteStep + substringLen);
        stringSpliteStep += substringLen;
        strings[3]=str.substring(stringSpliteStep, stringSpliteStep + substringLen);
        return strings;
    }
    
    private static String SwapStrings(String[] strings, Long steps){
        int index = 0;
        String[] outpputStrings = new String[4];
        
        if (steps == 0 || steps % 3 == 0) {
          return String.join("", strings);
        }
        
        Long startIndex = steps % 3;
        outpputStrings[index++] = strings[0];
        
        for (int i = 4 - startIndex.intValue(); i < 4; i++)
        {
          outpputStrings[index++] = strings[i];
        }
        
        for (int i = 1; i < 4 - startIndex.intValue(); i++) 
        {
          outpputStrings[index++] = strings[i];
        }
        
        return String.join("", outpputStrings);
    }
}