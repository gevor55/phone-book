package com.gevor.service;

import com.gevor.comparators.NameComparator;
import com.gevor.comparators.PhoneNumberComparator;
import com.gevor.comparators.SurnameComparator;
import com.gevor.domain.Record;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.gevor.Main.SCANNER;
import static com.gevor.files.FileOperations.readFileIntoRecords;
import static com.gevor.validators.PhoneBookValidator.*;

public class PhoneBookService {


    public void printValidationMessagePerRecord(List<Record> records) {
        for (int i = 0; i < records.size(); i++) {
            StringBuilder validationMessage = new StringBuilder();
            Record record = records.get(i);
            String separatorValidationResult = validateSeparator(record);
            String phoneNumberValidationResult = validatePhoneNumber(record);
            if (separatorValidationResult.isEmpty() && phoneNumberValidationResult.isEmpty()) {
                continue;
            }
            validationMessage
                    .append("line ")
                    .append(i + 1)
                    .append(": ")
                    .append(separatorValidationResult)
                    .append(separatorValidationResult.isEmpty() ? EMPTY_STRING :
                            phoneNumberValidationResult.isEmpty() ?
                                    EMPTY_STRING : COMMA)
                    .append(phoneNumberValidationResult);
            System.out.println(validationMessage);
        }

    }

    public void printAllRecordsAndValidations() throws IOException {
        List<Record> records = readFileIntoRecords();
        Comparator<Record> chosenComparator;
        main:
        while (true) {
            System.out.println("Please choose an ordering to sort: “1-Ascending” or “2-Descending“");
            int ordering = SCANNER.nextInt();
            if (ordering == 1) {
                while (true) {
                    System.out.println("Please choose criteria: “1-Name”, “2-Surname” or “3-PhoneNumberCode“");
                    int criteria = SCANNER.nextInt();
                    switch (criteria) {
                        case 1 -> {
                            chosenComparator = new NameComparator();
                            break main;
                        }
                        case 2 -> {
                            chosenComparator = new SurnameComparator();
                            break main;
                        }
                        case 3 -> {
                            chosenComparator = new PhoneNumberComparator();
                            break main;
                        }
                        default -> System.out.println("You wrote another number");
                    }
                }
            } else if (ordering == 2) {
                while (true) {
                    System.out.println("Please choose criteria: “1-Name”, “2-Surname” or “3-PhoneNumberCode“");
                    int criteria = SCANNER.nextInt();
                    switch (criteria) {
                        case 1 -> {
                            chosenComparator = new NameComparator(false);
                            break main;
                        }
                        case 2 -> {
                            chosenComparator = new SurnameComparator(false);
                            break main;
                        }
                        case 3 -> {
                            chosenComparator = new PhoneNumberComparator(false);
                            break main;
                        }
                        default -> System.out.println("You wrote another number");
                    }
                }
            } else {
                System.out.println("You wrote another word");
            }
        }

        records = records.stream().sorted(chosenComparator).collect(Collectors.toList());
        records.forEach(System.out::println);
        printValidationMessagePerRecord(records);
    }
}
