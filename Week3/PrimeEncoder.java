import java.util.*;

public class PrimeEncoder {

    public static List<String> getCodeForAlphabet() {
        List <String> key = new ArrayList<String>();
        List <Integer> primeList = new ArrayList<Integer>();
        int checkPrime = 1;
        boolean flag = false;
        int i = 0;
        while(i < 26)
        {
            for(int j = 1; j < primeList.size(); j++)
            {
                if(checkPrime % primeList.get(j) == 0) {
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                primeList.add(checkPrime);
                key.add((Integer.toHexString(checkPrime)).toUpperCase());
                i++;
            }
            flag = false;
            checkPrime++;
        }
        return key;
    }

    public static String hexaPrimeEncode(String name, List <String> hexaPrimeCode) {
        StringBuffer prime = new StringBuffer();
        for(int i = 0; i < name.length(); i++) {
            if(Character.getNumericValue(name.charAt(i)) >= 10 && Character.getNumericValue(name.charAt(i)) < 36) {
                prime.append(hexaPrimeCode.get(Character.getNumericValue(name.charAt(i))-10));
            }
            else {
                prime.append("Invalid_Entry");
            }
            if(i != name.length() -1) {
                prime.append(',');
            }
        }
        return prime.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> hexaPrimeCode = new ArrayList<String>();
        String name = new String();
        String primeCode = new String();

        hexaPrimeCode = getCodeForAlphabet();

        
        do {
            name = sc.nextLine();
            name.toLowerCase();
            primeCode = hexaPrimeEncode(name, hexaPrimeCode);
            System.out.println(name + ":" + primeCode);
        }while(!name.equals("exit"));
    }

    
}