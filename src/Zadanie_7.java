import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Нерегламентированный ввод данных
public class Zadanie_7 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int count=0;
        String s="Мама мыла раму в ООО «Рама», а папа мыл машину в ЗАО «Машина».";
        StringBuffer sBuf=new StringBuffer(s);

        System.out.println("Исходная строка");
        System.out.println(sBuf);


        for (int i=sBuf.length()-2;i>=0;i--){
            if ((sBuf.charAt(i)=='О') || (sBuf.charAt(i)=='З') && (sBuf.charAt(i+1)=='О') || (sBuf.charAt(i+1)=='А') && (sBuf.charAt(i+2)=='О')){
                count=i+4;
                while (sBuf.charAt(count)!='»') count++;
                sBuf.replace(i+4, count+1, "«фирма»");
            }
        }

        System.out.println();
        System.out.println("Строка после изменения");
        System.out.println(sBuf);
    }
}