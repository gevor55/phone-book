package com.gevor;

import com.gevor.service.PhoneBookService;

import java.util.Scanner;


public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        PhoneBookService phoneBookService = new PhoneBookService();
        phoneBookService.printAllRecordsAndValidations();
    }
}
