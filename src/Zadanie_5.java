import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_5 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int count=0;
        boolean isUp=true;
        System.out.print("Введите слово: ");
        String str = scan.nextLine();
        String[] arStr=str.split(" ");

        System.out.println();
        System.out.print("Аббревиатуры в слове: ");

        // Проверка аббревиатур

        for (String s : arStr) {
            for (int j = 0; j < s.length(); j++) {
                isUp = Character.isUpperCase(s.charAt(j));
            }
            if (isUp) {
                System.out.print(s + ", ");
                count++;
            }
        }

        // до enhanced
//        for (int i=0;i<arStr.length;i++){
//            for (int j=0;j<arStr[i].length();j++){
//                isUp = Character.isUpperCase(arStr[i].charAt(j));
//            }
//            if (isUp){
//                System.out.print(arStr[i]+", ");
//                count++;
//            }
//        }
        System.out.println();
        System.out.println("Количество аббревиатур: "+count);
    }
}
