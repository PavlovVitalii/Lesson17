package com.company;

import java.io.File;

public class CountFile {

    int countFile = 0;

    public int Task17_6(String path) {
        File file = new File(path);


        File listDir[] = file.listFiles();

        for (int i = 0; i < listDir.length; i++) {
            if (!listDir[i].isDirectory()) {
                countFile++;
            }

            if (listDir[i].isDirectory()) {
                Task17_6(listDir[i].getPath());
            }
        }

        return countFile;
    }
}
