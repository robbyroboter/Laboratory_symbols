import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Нерегламентированный ввод данных
public class Zadanie_9 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int count=0;
        boolean est=false;
        String s="ОООааааООО и АААоооААА сидели на трубе, 1 упало другое пропало БББбббБББ осталось на трубе";
        StringBuffer sBuf=new StringBuffer(s);

        System.out.println("Исходная строка");
        System.out.println(sBuf);


        for (int i=0;i<sBuf.length()-1;i++){

            //коменты ООО
            if (((sBuf.charAt(i)=='О') && (sBuf.charAt(i+1)=='О') && (sBuf.charAt(i+2)=='О'))){
                count=i+3;
                while (sBuf.charAt(count)!='О') count++;
                if (((sBuf.charAt(count)=='О') && (sBuf.charAt(count+1)=='О') && (sBuf.charAt(count+2)=='О')) ){
                    sBuf.delete(i,count+3);
                    est=true;
                }
            }

            //коменты ООО
            else if (((sBuf.charAt(i)=='А') && (sBuf.charAt(i+1)=='А') && (sBuf.charAt(i+2)=='А'))){
                count=i+3;
                while (sBuf.charAt(count)!='А') count++;
                if (((sBuf.charAt(count)=='А') && (sBuf.charAt(count+1)=='А') && (sBuf.charAt(count+2)=='А')) ){
                    sBuf.delete(i,count+3);
                    est=true;
                }
            }

            //коменты ООО
            else if (((sBuf.charAt(i)=='Б') && (sBuf.charAt(i+1)=='Б') && (sBuf.charAt(i+2)=='Б'))){
                count=i+3;
                while (sBuf.charAt(count)!='Б') count++;
                if (((sBuf.charAt(count)=='Б') && (sBuf.charAt(count+1)=='Б') && (sBuf.charAt(count+2)=='Б')) ){
                    sBuf.delete(i,count+3);
                    est=true;
                }
            }
        }

        System.out.println();
        if (!est) System.out.println("Комментариев вида ААА...ААА, ООО...ООО, БББ...БББ в тексте нет");
        else {
            System.out.println("Строка после изменения");
            System.out.println(sBuf);
        }

    }
}