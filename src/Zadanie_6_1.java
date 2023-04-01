import com.sun.source.tree.IfTree;
import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Нерегламентированный ввод данных
public class Zadanie_6_1 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int N=19;
        String[] Cities ={"Пермь", "Москва", "Саратов", "Тамбов", "Грозный", "Чита", "Новокузнецк", "Томск", "Курск", "Запил", "Демидов", "Орёл", "Жуки", "Юрмола", "Архангельск", "Краснодар", "Химки", "Уфа", "Санкт-Петербург", "Красноярск"};
        String[] VishLeague = {"вышка", "Высшая лига", "всш.л"};
        String[] PremLeague = {"прем", "Премьер-лига", "прм.л"};
        String[] PervLeague = {"перв", "Первая лига", "прв.л"};


        System.out.println("Данные о командах:");
        System.out.println("Город команды;Относиться ли команда к ВУЗу;ВУЗ к которому относиться команда;Лига, в которой выступает команда;Название команды;Возраст капитана;Количество участников;Количество участников младше 21 года; Количество участников с музыкальным образованием;Количество участников с театральным образованием; Количество участников на настоящий момент получающих образование;Число музыкальных инструментов в собственности команды;Средняя сумма спонсорских взносов для обеспечения работы команды на год;Средний доход команды от выступлений за год.");

        String[] Team = new String[N];
        int[][] TeamCount =new int[4][Cities.length];

        for (int i=0;i<N;i++){
            Team[i]=scan.nextLine();
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<VishLeague.length;j++){

                // Высшая лига
                if (Team[i].contains(VishLeague[j])){
                    for (int k=0;k<Cities.length;k++){
                        if(Team[i].contains(Cities[k])){
                            TeamCount[0][k]=TeamCount[0][k]+1;
                        }
                    }
                }

                // Премьер-лига
                if (Team[i].contains(PremLeague[j])){
                    for (int k=0;k<Cities.length;k++){
                        if(Team[i].contains(Cities[k])){
                            TeamCount[1][k]=TeamCount[1][k]+1;
                        }
                    }
                }

                // Первая лига
                if (Team[i].contains(PervLeague[j])){
                    for (int k=0;k<Cities.length;k++){
                        if(Team[i].contains(Cities[k])){
                            TeamCount[2][k]=TeamCount[2][k]+1;
                        }
                    }
                }
            }
        }


        // Итог

        for (int i=0;i< Cities.length;i++){
            System.out.println();
            System.out.print(Cities[i]+": команд из высших лиг-"+TeamCount[0][i]+", премьер-лиг-"+TeamCount[1][i]+", первых лиг-"+TeamCount[2][i]+", BIG-"+TeamCount[3][i]);
        }
    }
}