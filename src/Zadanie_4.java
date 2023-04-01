import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zadanie_4 {
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

        int count=0;
        System.out.print("Введите размер матрицы NxN: ");
        int N = scan.nextInt();
        char[][] matrix = new char[N][N];
        ArrayList<Character> bads = new ArrayList<>();

        if (N>=11){
            System.out.println("Введите элементы матрицы по 1 символу");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Symbol();
                    if (i==N-1 & j==N/2){
                        System.out.println("ОСТОРОЖНО! осталось "+N/2+" символов до полного заполнения массива");
                    }
                }
            }

            printMatr(matrix);

            int str=0, stolb=0; // Счётчик количества столбцов и строк

            for (int i=0;i<N;i++){
                for (int j=0;j<N-10;j++){

                    //Проверка строк
                    if (matrix[i][j]=='3' &&  Character.isDigit(matrix[i][j+3]) &&  matrix[i][j+5]=='2' && Character.isDigit(matrix[i][j+7])  && Character.isDigit(matrix[i][j+10])){
                        if (matrix[i][j+1]=='*' && matrix[i][j+2]=='(' && matrix[i][j+4]=='-' && matrix[i][j+6]=='*' && matrix[i][j+8]==')' && matrix[i][j+9]=='='){
                            str++;
                            Vivod(matrix,i,j,1,0);

                            // Проверка на правильность решения у строк
                            if (Character.getNumericValue(matrix[i][j+10])==3*(Character.getNumericValue(matrix[i][j+3])-2*Character.getNumericValue(matrix[i][j+7]))){
                                //System.out.println("В строчке "+i+" выражение вида '3 * (число - 2 * число) = число' разрешимо");
                                count++;
                            }
                            else if (Character.getNumericValue(matrix[i][j+10])!=3*(Character.getNumericValue(matrix[i][j+3])-2*Character.getNumericValue(matrix[i][j+7]))){
                                Zapolnenie_ArrayList(matrix,bads,i,j,1,0);
                            }
                        }
                    }



                    //Проверка столбцов
                    if (matrix[i][j]=='3' &&  Character.isDigit(matrix[j+3][i]) &&  matrix[j+5][i]=='2' && Character.isDigit(matrix[j+7][i])  && Character.isDigit(matrix[j+10][i])){
                        if (matrix[j+1][i]=='*' && matrix[j+2][i]=='(' && matrix[j+4][i]=='-' && matrix[j+6][i]=='*' && matrix[j+8][i]==')' && matrix[j+9][i]=='='){
                            stolb++;
                            Vivod(matrix,i,j,0,1);

                            // Проверка на правильность решения у столбцов
                            if (Character.getNumericValue(matrix[j+10][i])==3*(Character.getNumericValue(matrix[j+3][i])-2*Character.getNumericValue(matrix[j+7][i]))){
                                //System.out.println("В столбце "+i+" выражение вида '3 * (число - 2 * число) = число' разрешимо");
                                count++;
                            }
                            else if (Character.getNumericValue(matrix[j+10][i])!=3*(Character.getNumericValue(matrix[j+3][i])-2*Character.getNumericValue(matrix[j+7][i]))){
                                //System.out.println("В столбце "+i+" выражение вида '3 * (число - 2 * число) = число' разрешимо");
                                Zapolnenie_ArrayList(matrix,bads,i,j,0,1);
                            }
                        }
                    }
                }
            }
            System.out.println();
            System.out.println("В матрице "+ str +" строк и " + stolb +" столбцов содержат конструкцию вида '3 * (число - 2 * число) = число'");
            System.out.println("Всего разрешимых конструкций в оригинальном массиве: "+count);
        }

        else {
            // Итог
            System.out.println();
            System.out.println("Матрица не содержит конструкцию вида '3 * (число - 2 * число) = число', так как она слишком мала");
        }
    }


    // Ввод символа
    public static char Symbol() {
        char ch = ' ';
        String S = scan.next();
        if (S.length() == 1) ch = S.charAt(0);
        else
            while (S.length() != 1) {
                System.out.println("Вы ввели не 1 символ, повторите ввод данных");
                S = scan.next();
                if (S.length() == 1) ch = S.charAt(0);
            }
        return ch;
    }

    // Спец вывод

    public static void Vivod(char[][] matrix, int k, int m, int string, int column){
        System.out.println();
        if(string==1){
            System.out.println("В строчке "+k+" содержится выражение вида '3 * (число - 2 * число) = число' ");
            for (int i=m;i<=m+10;i++) System.out.print(matrix[k][i] + "\t");
            System.out.println();
        }
        else if(column==1){
            System.out.println("В столбце "+k+" содержится выражение вида '3 * (число - 2 * число) = число' ");
            for (int i=m;i<=m+10;i++) System.out.print(matrix[i][k] + "\t");
            System.out.println();
        }
    }

    public static void Zapolnenie_ArrayList(char[][] matrix, ArrayList<Character> bads,  int k, int m, int string, int column){
        System.out.println();
        int contin=1;
        if(string==1){
            for (int i=m;i<=m+10;i++){
                bads.add(matrix[k][i]);
            }
            System.out.print("Неправильное выражение: ");
            System.out.println(bads);
            while (contin==1){
                System.out.println("Введите номер символа выражения от 0 до 10 который хотели бы изменить");
                int chnge=scan.nextInt();
                System.out.println("Введите новый символ");
                char newsymb=Symbol();
                bads.set(chnge,newsymb);

                System.out.println(bads);
                System.out.println("Если хотите заменить ещё один элемент нажмите 1, если нет то 0");
                contin=scan.nextInt();
            }

            bads.clear();
        }

        else if(column==1){
            for (int i=m;i<=m+10;i++){
                bads.add(matrix[i][k]);
            }
            System.out.print("Неправильное выражение: ");
            System.out.println(bads);
            while (contin==1){
                System.out.println("Введите номер символа выражения от 0 до 10 который хотели бы изменить");
                int chnge=scan.nextInt();
                System.out.println("Введите новый символ");
                char newsymb=Symbol();
                bads.set(chnge,newsymb);

                System.out.println(bads);
                System.out.println("Если хотите заменить ещё один элемент нажмите 1, если нет то 0");
                contin=scan.nextInt();
            }

            bads.clear();
        }
    }

    //Вывод матрицы
    public static void printMatr(char[][] matrix) {
        System.out.println();
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(chars[j] + "\t");
            }
            System.out.println();
        }
    }
}
