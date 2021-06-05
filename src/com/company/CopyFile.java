package com.company;

import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class CopyFile {


    public void Task17_B1(String fromFile, String inFile) throws IOException {

        Instant start = Instant.now();

        try (InputStream inputStream = new FileInputStream(fromFile);
             OutputStream outputStream = new FileOutputStream(inFile)) {
            while (true) {
                int readByte = inputStream.read();
                if (readByte == -1) {
                    break;
                }
                outputStream.write(readByte);
            }
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        showTime(timeElapsed);

    }

    public void Task17_B2(String fromFile, String inFile) throws IOException {

        Instant start = Instant.now();
        try (InputStream inputStream = new FileInputStream(fromFile);
             OutputStream outputStream = new FileOutputStream(inFile)) {

            byte[] chunk = new byte[4096];

            while (true) {
                int readByte = inputStream.read(chunk);
                if (readByte == -1) {
                    break;
                }

                outputStream.write(chunk);
            }

        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        showTime(timeElapsed);
    }

    public void Task17_B3(String fromFile, String inFile) throws IOException {

        Instant start = Instant.now();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fromFile));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(inFile))) {

            while (true) {
                int read = bufferedInputStream.read();
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(read);
            }
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        showTime(timeElapsed);
    }

    public void Task17_B4(String fromFile, String inFile) throws IOException {

        Instant start = Instant.now();
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(fromFile));
             OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(inFile))) {

            byte[] chunk = new byte[4096];

            while (true) {
                int read = inputStream.read();
                if (read == -1) {
                    break;
                }
                outputStream.write(read);
            }
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        showTime(timeElapsed);

    }

    private void showTime(long timeMs) {
        int hour = 0;
        int min = 0;
        int sec = 0;
        if (timeMs >= 3600000){
            hour = (int)(timeMs / 3600000);
            min = (int) (timeMs % 3600000) / 60000;
            sec = (int) ((timeMs % 3600000) % 60000) / 1000;
        }
        if (timeMs >= 60000) {
            min = (int) timeMs / 60000;
            sec = (int) (timeMs % 60000) / 1000;
        }
        if (timeMs < 60000) {
            sec = (int) timeMs / 1000;
        }
        System.out.printf("Время копирования файла: %d часов. %d мин. %d сек.", hour,min, sec);
    }


}
