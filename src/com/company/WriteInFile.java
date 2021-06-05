package com.company;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteInFile {

    public void Task17_1() {
        try (DataOutputStream stream = new DataOutputStream(new FileOutputStream("data.bin"))) {
            stream.writeInt(12345);
            stream.writeBoolean(true);
            stream.writeChar('A');
            stream.writeDouble(2.5);
            stream.writeUTF("Binary");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Task17_3(List<String> strings) {

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("String.bin"))) {
            for (String i : strings) {
                dataOutputStream.writeUTF(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Task17_4(List<Contact> contacts){

        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("Contact.bin"))) {

            for (Contact i: contacts) {
                dataOutputStream.writeUTF(i.name);
                dataOutputStream.writeUTF(i.phoneNumber);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void Task17_5(List<Contact> contacts) {

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Contact.bin"))) {

            outputStream.writeObject(contacts);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
