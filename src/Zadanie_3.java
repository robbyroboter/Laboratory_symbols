import com.sun.source.tree.IfTree;
import static java.lang.Math.*;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_3 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        int N, countLat=0, countDoubPrepin=0, countPrepin=0, countRavSkob=0, countDifSkob=0;
        int crug=0, figur=0, kvad=0;
        int y=0,x=0, num_y=0, num_x=0;

        System.out.print("Введите любое слово для пункта б): ");
        String str = scan.nextLine();
        System.out.print("Введите размер массива: ");
        N = scan.nextInt();

        char[] array = new char[N];
        System.out.println("Заполните массив посимвольно: ");
        for (int i = 0; i < N; i++) {
            array[i] = Symbol();
        }

        System.out.print("Массив: ");
        printMatr(array);
        System.out.println();
        System.out.println();

        // а,в
        for (int i = 0; i < N; i++) {
            if (array[i]>='a' && array[i]<='z') countLat++;
            if (array[i]=='.' || array[i]=='…' || array[i]==',') countPrepin++;
        }

        // б

        for (int i = 0; i < N; i++){
            int count=0;
            for (int j=0;j<str.length();j++){
                if (array[i]==str.charAt(j)) count++;
            }
            System.out.println("Символ "+array[i]+" встречается в массиве "+count+" раз");
        }
        System.out.println();
        // г(1)
        for (int i=0;i<N-1;i++){
            if((array[i]=='(' & array[i+1]==')') || (array[i]=='{' & array[i+1]=='}') || (array[i]=='[' & array[i+1]==']')) countRavSkob++;
        }

        // г(2)
        for (int i = 0; i < N; i++) {
            if (array[i]=='(')  crug++;
            if (array[i]=='[')  kvad++;
            if (array[i]=='{')  figur++;

            if (crug>0 & (array[i]==']' || array[i]=='}')){
                countDifSkob++;
                crug=0;
            }
            if (kvad>0 & (array[i]==')' || array[i]=='}')){
                countDifSkob++;
                kvad=0;
            }
            if (figur>0 & (array[i]==']' || array[i]==')')){
                countDifSkob++;
                figur=0;
            }
        }

        // д
        for (int i=0;i<N-1;i++){
            if((array[i]=='.' & array[i+1]=='.') || (array[i]==',' & array[i+1]==',') || (array[i]==':' & array[i+1]==':') || (array[i]==';' & array[i+1]==';')) countDoubPrepin++;
        }

        // e
            //Присвоение переменных

        System.out.print("Введите для пункта е) k: ");
        int k = scan.nextInt();
        System.out.print("Введите для пункта е) n: ");
        int n = scan.nextInt();

        for (int i = 0; i < N; i++) {
            if (Character.isDigit(array[i]) & y==0){
                y=Character.getNumericValue(array[i]);
                num_y=i;
                i++;
                continue;
            }

            if (Character.isDigit(array[i])){
                x=Character.getNumericValue(array[i]);
                num_x=i;
                break;
            }
        }

        System.out.println("m= "+y +", k="+ k+", x= "+x +", n="+n);

        // Просмотр условий из е)
        if (y<k & k<x & x<n){
            System.out.println("Условие m<k<x<n выполняется");
        }
        else System.out.println("Условие m<k<x<n невыполняется");

        if (Character.isDigit(array[num_y]) & Character.isDigit(array[num_y+1])  & Character.isDigit(array[num_x]) & (Character.isDigit(array[num_x+1]) & num_x+1<=N-1)){
            System.out.println("Условие: 'S(m),S(m+1),S(k),S(x),S(x+1)-цифры' - выполняется");
            int xPl, mPl;
            xPl=Character.getNumericValue(array[num_x+1]);
            mPl=Character.getNumericValue(array[num_y+1]);

            if ((y>k & mPl>k)&(k>x & k>xPl)) {
                System.out.println("Условие: 'S(m),S(m+1)>S(k); S(x),S(x+1)<S(k)' - выполняется");
            }
            else System.out.println("Условие: 'S(m),S(m+1)>S(k); S(x),S(x+1)<S(k)' - невыполняется");
        }
        else System.out.println("Условие: 'S(m),S(m+1),S(k),S(x),S(x+1)-цифры' - невыполняется");


        System.out.println("Количество строчных латинских букв: "+countLat);
        System.out.println("Количество знаков препинания: "+countPrepin);
        System.out.println("Количество пар знаков препинания стоящих рядом: "+countDoubPrepin);
        System.out.println("Количество соседних одинаковых скобок: "+countRavSkob);
        System.out.println("Количество закрытых разных скобок: "+countDifSkob);

    }

    public static char Symbol(){
        char ch=' ';
        String S=scan.next();
        if(S.length()==1) ch=S.charAt(0);
        else
            while (S.length()!=1){
                System.out.println("Вы ввели не 1 символ, повторите ввод данных");
                S=scan.next();
                if (S.length()==1) ch=S.charAt(0);
            }
        return ch;
    }
    public static void  printMatr(char[] array){
        System.out.println();
        for (char c : array) {
            System.out.print(c+", ");
        }
    }
}


