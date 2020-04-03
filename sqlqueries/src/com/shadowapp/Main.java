package com.shadowapp;

import com.shadowapp.repo.Querydao;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Это задания с запросами MYSQL");
        System.out.println("1)вывести имена людей, кот. старше 18 лет.\n" +
                "2) вывести возраст людей, кот. Содержат букву s.\n" +
                "3) вывести данные, кто из людей пишет на джава.\n" +
                "4) вывести кол-во людей, кот. занимаются php.\n" +
                "5) вывести общий возраст людей, кот. занимаются JS.\n" +
                "6) отсортировать таблицу с видами работы в обратном порядке;\n" +
                "7)* посчитать средний возраст людей по каждому виду деятельности и вывести тот средний возраст, кот. больше 33( пока нет).\n" +
                "8) из таблицы юзер вывести сколько людей с одним и тем же именем");
        exercises();
        System.out.println("Закончили");
    }

   static void exercises(){
        System.out.print("Введите номер задания, которое надо отобразить:");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        switch (number){
            case 1:
                Querydao.one();
                break;
            case 2:
                Querydao.two();
                break;
            case 3:
                Querydao.three();
                break;
            case 4:
                Querydao.four();
                break;
            case 5:
                Querydao.five();
                break;
            case 6:
                Querydao.six();
                break;
            case 8:
                Querydao.eight();
                break;
            case 0:
                return;
        }
        exercises();
    }
}
