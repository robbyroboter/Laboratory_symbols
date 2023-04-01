import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Нерегламентированный ввод данных
public class Zadanie_11 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int N=3;
        String[] strArray = new String[N];

        // Регулярные выражения и их замены
        String[] PattOne = {"Ра", "РА", "ра", "рА"};
        String[] ZamPattOne = {"Ро", "Ро", "ро", "ро"};
        String[] PattTwo = {";", "/", "-", "_"};
        String[] ZamPattTwo = {",", ".", "(", ")"};
        String[] PattThree = {"один", "два", "три", "четыре"};
        String[] ZamPattThree = {"1", "2", "3", "4"};

        Pattern pat1, pat2, pat3;
        Matcher mat1, mat2,mat3;

        System.out.println("Напишите любые 3 строки:");

        for (int i=0;i<N;i++){
            strArray[i]=scan.nextLine();
        }

        //Нахождение и замена регулярных выражений

        //PattOne, ZamPattOne
        for (int i=0;i<N;i++){
            for (int j=0;j<PattOne.length;j++){
                pat1=Pattern.compile(PattOne[j]);
                mat1=pat1.matcher(strArray[i]);
                if (mat1.find()) strArray[i]=mat1.replaceAll(ZamPattOne[j]);
            }
        }

        //PattTwo, ZamPattTwo
        for (int i=0;i<N;i++){
            for (int j=0;j<PattTwo.length;j++){
                pat2=Pattern.compile(PattTwo[j]);
                mat2=pat2.matcher(strArray[i]);
                if (mat2.find()) strArray[i]=mat2.replaceAll(ZamPattTwo[j]);
            }
        }

        //PattThree, ZamPattThree
        for (int i=0;i<N;i++){
            for (int j=0;j<PattThree.length;j++){
                pat3=Pattern.compile(PattThree[j]);
                mat3=pat3.matcher(strArray[i]);
                if (mat3.find()) strArray[i]=mat3.replaceAll(ZamPattThree[j]);
            }
        }

        System.out.println();
        System.out.println("Изменённые строки");
        // Вывод нового массива
        for (String s : strArray) {
            System.out.println(s);
        }
    }
}

// Раман в теплице рАзу срезал для Разы/ Раза была разового цвета/ Раза очень была благодарна РАману
// Встретились одиннадцать ребят в поле в два часа дня; и сделали триста приседаний; выпив четыре бутылки лимонада/
// Рамантик написал один стих -О моей любимой_; после этого сломал ваз -три_ на счастье