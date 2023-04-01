import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Нерегламентированный ввод данных
public class Zadanie_10 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int count=0, oldOne, oldTwo, num=0;
        String maneken = "Романова;Мария;Сергеевна;ж;рус;169;40;2003;3;2;61400;Россия;Пермский;Ленинский;Пермь;Ленина;1;35;+79875584565.Киркова;Айгуль;Гизитовна;ж;кз;170;39;2001;3;2;25600;Казахстан;Астановская;Ленинский;Астана;Ленина;1;35;+9979875584565.Сизова;Татьяна;Викторовна;ж;рус;169;40;2001;2;2;61400;Россия;Пермский;Ленинский;Пермь;Ленина;1;35;+79875584565.";

//        System.out.println("Оригинальная строка");
//        System.out.println(maneken);
//        System.out.println();

        //Разделение манекенщиц на элементы массива
        String [] masStr=maneken.split("\\.");

//        System.out.println("Массив 2 строк");
//
//        for (int i=0;i<masStr.length;i++){
//            System.out.println(masStr[i]);
//        }
//        System.out.println();

        //Разделение элементов массива на отдельные массивы
        String[][] strArray = new String[masStr.length][];
        for (int i = 0; i < masStr.length; i++){
            strArray[i] = masStr[i].split(";");
        }

//        System.out.println("Как это выглядит в двумерном");
//        for (int i=0;i<masStr.length;i++){
//            System.out.println(Arrays.toString(strArray[i]));
//        }
//        System.out.println();

        // Проверка условий
        for (int i=0;i<strArray.length;i++){
            if(strArray[i][18].charAt(1)=='7' && (2023-Integer.parseInt(strArray[i][7])>=20 && 2023-Integer.parseInt(strArray[i][7])<=23)) count++;

            if (i!=strArray.length-1){
                oldOne=Integer.parseInt(strArray[i][7])+Integer.parseInt(strArray[i][8])+Integer.parseInt(strArray[i][9]);
                oldTwo=Integer.parseInt(strArray[i+1][7])+Integer.parseInt(strArray[i+1][8])+Integer.parseInt(strArray[i+1][9]);

                if (oldOne<oldTwo){
                    num=i;
                }
                else num=i+1;
            }
        }

        System.out.println("Количество манекенщиц у которых номер начинается с +7 у которых возраст в диапазане от 20 до 23: " + count);
        System.out.println("Самая младшая манекенщица:");
        System.out.println(Arrays.toString(strArray[num]));
    }
}