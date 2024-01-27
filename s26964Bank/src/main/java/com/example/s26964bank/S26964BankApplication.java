package com.example.s26964bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S26964BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(S26964BankApplication.class, args);
        execute();
    }

    private static void execute() {
        ClientStorage clientStorage = new ClientStorage();
        clientStorage.registerClient(new Client("6", "Bogumił", 5000));
        TransferService transferService = new TransferService(clientStorage);

        System.out.println(clientStorage.getAllClient().size());
        System.out.println(clientStorage.toString());
        clientStorage.registerClient(new Client("xyz","alek",15234));
        System.out.println(clientStorage.getAllClient().size());
        System.out.println(clientStorage.toString());

        System.out.println("/////////////////////////////");;

        System.out.println("1");;
        transferService.sendMoney("123", 20);
        System.out.println(clientStorage.toString());
        transferService.addMoney("321", 1500);

        System.out.println("2");;
        System.out.println(clientStorage.toString());
        transferService.sendMoney("123", 10000);
        transferService.sendMoney("6", 10);
        transferService.addMoney("312", 15);

        System.out.println("4");;
        System.out.println(clientStorage.findClientByID("6"));

        System.out.println("5");;
        transferService.sendMoney("zxczz", 20);
        System.out.println(clientStorage.toString());

    }
}
