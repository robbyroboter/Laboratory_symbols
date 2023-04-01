import com.sun.source.tree.IfTree;
import static java.lang.Math.*;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.lang.Character;

public class Zadanie_2 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Random rand = new Random();

        int N, des=0, chis, step=1, five=0;
        String str="";
        System.out.print("Введите размер массива ");
        N=scan.nextInt();
        char []array= new char[N];

        System.out.println("Введите символ, который есть только в 16-ой системе счисления");
        System.out.println("Ввод будет происходить до тех пор пока не будет введён правильный символ и не заполнится массив");
        for (int i=0;i<N;i++){
            array[i]=Symbol();
        }

        System.out.print("Число в шастнадцатеричном представлении: ");
        printMatr(array);
        System.out.println();

        // Перевод в десятичную запись

        for (int i=0;i<N;i++){
            chis=Character.getNumericValue(array[i]);
            des+=chis*pow(16,N-step);
            step++;
        }

        System.out.println("Число в десятичном представлении: " + des);

        //Перевод в 5-ую систему счисления

        while(des!=0){
            str+=Integer.toString(des%5);
            des/=5;
        }


        char []arrayTwo= new char[str.length()];

        step=1;

        for (int i=0;i<arrayTwo.length;i++){
            arrayTwo[i]=str.charAt(str.length()-step);
            step++;
        }

        System.out.print("Число в пятиричном представлении: ");
        printMatr(arrayTwo);
    }



    public static char Symbol(){
        char ch=' ';
        while (ch!='A'& ch!='B'& ch!='C'& ch!='D'& ch!='E'& ch!='F'& !Character.isDigit(ch)){

            String S=scan.next();
            if(S.length()==1) ch=S.charAt(0);
            else
                while (S.length()!=1){
                    System.out.println("Вы ввели не 1 символ, повторите ввод");
                    S=scan.next();
                    if (S.length()==1) ch=S.charAt(0);
                }
        }
        return ch;
    }

    public static void  printMatr(char[] array){
        System.out.println();
        for (char c : array) {
            System.out.print(c);
        }
    }
}