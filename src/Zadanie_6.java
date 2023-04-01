import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Регламентированный ввод данных
public class Zadanie_6 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int N=19;
        String[] Cities ={"Пермь", "Москва", "Саратов", "Тамбов", "Грозный", "Чита", "Новокузнецк", "Томск", "Курск", "Запил", "Демидов", "Орёл", "Жуки", "Юрмола", "Архангельск", "Краснодар", "Химки", "Уфа", "Санкт-Петербург", "Красноярск"};

        System.out.println("Данные о командах:");
        //13 параметров
        System.out.println("Город команды;Относиться ли команда к ВУЗу;ВУЗ к которому относиться команда;Лига, в которой выступает команда;Название команды;Возраст капитана;Количество участников;Количество участников младше 21 года; Количество участников с музыкальным образованием;Количество участников с театральным образованием; Количество участников на настоящий момент получающих образование;Число музыкальных инструментов в собственности команды;Средняя сумма спонсорских взносов для обеспечения работы команды на год;Средний доход команды от выступлений за год.");

        String[] Team = new String[N];
        int[][] TeamCount =new int[4][Cities.length];
        String [] arStr;

        for (int i=0;i<N;i++){
            Team[i]=scan.nextLine();
        }

        for (int i=0;i<N;i++){
            arStr=Team[i].split(";");

            //Высшая лига
            switch (arStr[3]) {
                case "Высшая лига":
                    for (int j = 0; j < Cities.length; j++) {
                        if (arStr[0].equals(Cities[j])) {
                            TeamCount[0][j] = TeamCount[0][j] + 1;
                        }
                    }
                    break;

                // Премьер-лига
                case "Премьер-лига":
                    for (int j = 0; j < Cities.length; j++) {
                        if (arStr[0].equals(Cities[j])) {
                            TeamCount[1][j] = TeamCount[1][j] + 1;
                        }
                    }
                    break;

                // Первая лига
                case "Первая лига":
                    for (int j = 0; j < Cities.length; j++) {
                        if (arStr[0].equals(Cities[j])) {
                            TeamCount[2][j] = TeamCount[2][j] + 1;
                        }
                    }
                    break;
            }

            // Многа буковное условие
            if (Integer.parseInt(arStr[5])<39 && Integer.parseInt(arStr[7])<Integer.parseInt(arStr[6])*30/100 && Integer.parseInt(arStr[12])==Integer.parseInt(arStr[6])*100000 && Double.parseDouble(arStr[6])/Double.parseDouble(arStr[11])>0.6){
                for (int j=0;j<Cities.length;j++){
                    if (arStr[0].equals(Cities[j])){
                        TeamCount[3][j]=TeamCount[3][j]+1;
                    }
                }
            }
        }

        System.out.println("В условии задачи есть большое условие, которое явно не очень удобно читать при выведении списка, так что я его выведу заранее и обозначу как - BIG");
        System.out.println("Команды в которых капитан возрастом до 39 лет, количество участников младше 21 года меньше чем 30 % от общего число участников, сумма спонсорских взносов которых равна количеству человек в команде умноженных на 100000 и количество музыкальных инструментов на 1 участника более 0,6.");

        // Итог
        for (int i=0;i< Cities.length;i++){
            System.out.println();
            System.out.print(Cities[i]+": команд из высших лиг-"+TeamCount[0][i]+", премьер-лиг-"+TeamCount[1][i]+", первых лиг-"+TeamCount[2][i]+", BIG-"+TeamCount[3][i]);
        }
    }
}
