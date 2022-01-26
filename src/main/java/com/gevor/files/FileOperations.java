package com.gevor.files;

import com.gevor.Main;
import com.gevor.domain.Record;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.gevor.Main.SCANNER;

public class FileOperations {

    public static final String SPACE = " ";
    public static final String FILES_PHONE_BOOK_1 = "files/phone-book1.txt";
    public static final String FILES_PHONE_BOOK_2 = "files/phone-book2.txt";
    public static final String FILES_PHONE_BOOK_3 = "files/phone-book3.txt";

    public static BufferedReader getFile() {
        while (true) {
            InputStream is;
            System.out.println("Find the files here");
            System.out.println("1- File Path - " + FILES_PHONE_BOOK_1);
            System.out.println("2- File Path - " + FILES_PHONE_BOOK_2);
            System.out.println("3- File Path - " + FILES_PHONE_BOOK_3);
            int number = SCANNER.nextInt();
            String filePath;
            switch (number) {
                case 1:
                    filePath = FILES_PHONE_BOOK_1;
                    break;
                case 2:
                    filePath = FILES_PHONE_BOOK_2;
                    break;
                case 3:
                    filePath = FILES_PHONE_BOOK_3;
                    break;
                default:
                    continue;
            }
            is = Main.class.getClassLoader().getResourceAsStream(filePath);
            return new BufferedReader(new InputStreamReader(is));
        }
    }

    public static List<Record> readFileIntoRecords() throws IOException {
        BufferedReader br = getFile();
        String line;
        List<Record> records = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            Record record = new Record(line);
            if (line.trim().length() == 0) {
                records.add(record);
                continue;
            }
            String[] fields = line.trim().split(SPACE);

            if (fields.length == 4) {
                record.setName(fields[0]);
                record.setSurname(fields[1]);
                record.setSeparator(fields[2]);
                record.setPhoneNumber(fields[3]);
            } else if (fields.length == 3) {
                record.setName(fields[0]);
                record.setSurname(fields[1]);
                record.setPhoneNumber(fields[2]);
            } else if (fields.length == 2) {
                record.setName(fields[0]);
                record.setSurname(fields[1]);
            } else if (fields.length == 1) {
                record.setName(fields[0]);
            }
            records.add(record);
        }
        return records;
    }
}
