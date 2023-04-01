import com.sun.source.tree.IfTree;
import static java.lang.Math.*;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_1 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Random rand = new Random();

        int N=2,M=6, count=0;
        char [][] array= new char[N][M];

        System.out.println("Введите элементы матрицы по 1 символу");
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                array[i][j]=Symbol();
                if (array[i][j]== '+'| array[i][j]== '-' | array[i][j]== '*') count++;
            }
        }

        printMatr(array);
        System.out.println("Количество символов вида (+, -, *) в матрице: "+count);
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

    public static void  printMatr(char[][] array){
        System.out.println();
        for (int i=0; i<array.length;i++){
            for (int j=0; j<array[0].length;j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}