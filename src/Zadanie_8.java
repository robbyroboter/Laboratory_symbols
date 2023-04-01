import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Нерегламентированный ввод данных
public class Zadanie_8 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String s="Встретились как-то одиннадцать ребят в поле во вторник, и триста раз присели.";
        StringBuffer sBuf=new StringBuffer(s);

        System.out.println("Исходная строка");
        System.out.println(sBuf);


        for (int i=sBuf.length()-1;i>=0;i--){

            //один
            if ((sBuf.charAt(i)=='о') && (sBuf.charAt(i+1)=='д') && (sBuf.charAt(i+2)=='и') && (sBuf.charAt(i+3)=='н')){
                sBuf.replace(i, i+4, "1");
            }

            // втор
            if ((sBuf.charAt(i)=='в') && (sBuf.charAt(i+1)=='т') && (sBuf.charAt(i+2)=='о') && (sBuf.charAt(i+3)=='р')){
                sBuf.replace(i, i+4, "2");
            }

            // три
            if ((sBuf.charAt(i)=='т') && (sBuf.charAt(i+1)=='р') && (sBuf.charAt(i+2)=='и')){
                sBuf.replace(i, i+3, "3");
            }
        }

        System.out.println();
        System.out.println("Строка после изменения");
        System.out.println(sBuf);
    }
}
