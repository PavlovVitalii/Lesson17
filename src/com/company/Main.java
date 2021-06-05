package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    CountFile countFile = new CountFile();
    ReadFromFile readFromFile = new ReadFromFile();
    WriteInFile write = new WriteInFile();
    CopyFile copyFile = new CopyFile();


    public static void main(String[] args) {
        Main main = new Main();

        List<String> strings = new ArrayList<>();
        strings.add("В век высоких технологий");
        strings.add("Без программ не обойтись,");
        strings.add("Программисты ежедневно");
        strings.add("Легче делают нам жизнь!");

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Роман", "+380127"));
        contacts.add(new Contact("Юрий", "+380126"));
        contacts.add(new Contact("Николай", "+380125"));
        contacts.add(new Contact("Евгений", "+380124"));
        contacts.add(new Contact("Леонид", "+380123"));

        main.write.Task17_1();
        main.readFromFile.Task17_2();

        main.write.Task17_3(strings);
        List<String> stringsInput = main.readFromFile.Task17_3();

        for (String i : stringsInput) {
            System.out.println(i);
        }

        System.out.println();

        main.write.Task17_4(contacts);
        List<Contact> contactsInput = main.readFromFile.Task17_4();

        for (Contact i : contactsInput) {
            System.out.println(i.name + " " + i.phoneNumber);

        }
        System.out.println();

        main.write.Task17_5(contacts);
        List<Contact> contacts1 = main.readFromFile.Task17_5();

        for (Contact i : contacts1) {
            System.out.println(i.name + " " + i.phoneNumber);
        }
        System.out.println();

        System.out.println("Количество файлов: "
                + main.countFile.Task17_6("C:\\Users\\Admin\\IdeaProjects\\Lesson17\\src"));

    }
    // Побайтовое чтение и запись напрямую из/в File[Input/Output]Stream
    // Время копирования фала размером 1.45 гб  очень долго за три часа примерно половину


    //Буферное (локальный байтовый массив на 4Кб) чтение и запись напрямую из/в File[Input/Output]Stream
    // Время копирования фала размером 1.45 гб  2 мин 3 сек


    //Побайтовое чтение и запись через Buffered[Input/Output]Stream
    // Время копирования фала размером 1.45 гб  2 мин 4 сек

    //Буферное (локальный байтовый массив на 4Кб) чтение и запись через Buffered[Input/Output]Stream
    // Время копирования фала размером 1.45 гб  1 мин 56 сек
}


}