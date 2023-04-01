import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Нерегламентированный ввод данных
public class Zadanie_12 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int N=3;
        String[] strArray = new String[N];

        // Регулярное выражения и их замены
        String[] Patt = {"квартира", "количество", "улица", "город"};
        String[] ZamPatt = {"кв.", "кол-во", "ул.", "г."};

        Pattern pat1;
        Matcher mat1;

        System.out.println("Напишите любые 3 любых данных об ученике:");

        for (int i=0;i<N;i++){
            strArray[i]=scan.nextLine();
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<Patt.length;j++){
                pat1=Pattern.compile(Patt[j]);
                mat1=pat1.matcher(strArray[i]);
                if (mat1.find()) strArray[i]=mat1.replaceAll(ZamPatt[j]);
            }
        }

        System.out.println();
        System.out.println("Изменённые строки");
        // Вывод изменённого массива
        for (String s : strArray) {
            System.out.println(s);
        }
    }
}

// возраст:17; пол:муж; численность семьи:5; средний балл:4.3; место учёбы:СОШ №12; место жительства: город Пермь, улица Ленина, квартира 25; количество кружков: 3.
// возраст:16; пол:жен; численность семьи:3; средний балл:4.5; место учёбы:СОШ №12; место жительства: город Пермь, улица Краснова, квартира 49; количество кружков: 5.
// возраст:17; пол:жен; численность семьи:4; средний балл:3.8; место учёбы:СОШ №12; место жительства: город Пермь, улица Гуляева, квартира 3; количество кружков: 2.