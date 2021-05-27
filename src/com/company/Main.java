package com.company;

import java.io.*;


public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.Task17_1();
        main.Task17_2();
    }

    private void Task17_1() {

        try (DataOutputStream stream = new DataOutputStream(new FileOutputStream("data.bin"))) {
            stream.write(12345);
            stream.writeBoolean(true);
            stream.writeChar('A');
            stream.writeDouble(2.5);
            stream.writeUTF("Binary");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void Task17_2() {

        try (DataInputStream stream = new DataInputStream(new FileInputStream("data.bin"))) {
            int varInt = stream.readInt();
            boolean varBool = stream.readBoolean();
            char varChar = stream.readChar();
            double varDouble = stream.readDouble();
            String varString = stream.readUTF();

            System.out.println(varInt + "\n" + varBool + "\n" + varChar + "\n" + varDouble + "\n" +  varString);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
