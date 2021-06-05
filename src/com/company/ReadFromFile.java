package com.company;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {

    public void Task17_2() {


        try (DataInputStream stream = new DataInputStream(new FileInputStream("data.bin"))) {
            int varInt = stream.readInt();
            boolean varBool = stream.readBoolean();
            char varChar = stream.readChar();
            double varDouble = stream.readDouble();
            String varString = stream.readUTF();

            System.out.println(varInt + "\n" + varBool + "\n" + varChar + "\n" + varDouble + "\n" + varString);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<String> Task17_3() {

        List<String> strings = new ArrayList<>();

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("String.bin"))) {

            while (dataInputStream.available() > 0) {
                String input = dataInputStream.readUTF();
                strings.add(input);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return strings;
    }

    public List<Contact> Task17_4(){

        List<Contact> contacts = new ArrayList<>();

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("Contact.bin"))){

            while (dataInputStream.available() > 0){
                String name = dataInputStream.readUTF();
                String phoneNumber = dataInputStream.readUTF();
                contacts.add(new Contact(name,phoneNumber));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return contacts;
    }

    public List<Contact> Task17_5() {

        List<Contact> contacts = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Contact.bin"))) {

            contacts = (List<Contact>) inputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return contacts;
    }

}
