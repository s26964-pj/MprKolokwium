package com.example.s26964bank;

import org.springframework.stereotype.Service;

@Service
public class TransferService {
    private final ClientStorage clientStorage;

    public TransferService(ClientStorage clientStorage) {
        this.clientStorage = clientStorage;
    }

    public Transfer sendMoney(String clientID, double amount) {
        Transfer transfer = new Transfer();
        Client client = clientStorage.findClientByID(clientID);

        double newBalance = client.getBalance() - amount;
        System.out.println(newBalance);
        if (newBalance < 0) {
            System.out.println("Your balance is to low!");
            transfer.setNewBalance(client.getBalance());
            transfer.setTransferType(TransferType.DECLINED);
        } else {
            transfer.setNewBalance(newBalance);
            transfer.setTransferType(TransferType.ACCEPTED);
            client.setBalance(newBalance);
        }

        return transfer;
    }

    public Transfer addMoney(String clientID, double amount) {
        double newBalance;
        Transfer transfer = new Transfer();
        Client client = clientStorage.findClientByID(clientID);
        newBalance = client.getBalance() + amount;

        if (amount <= 0) {
            System.out.println("Negative value!");
            transfer.setNewBalance(client.getBalance());
            transfer.setTransferType(TransferType.DECLINED);
        } else {
            transfer.setNewBalance(newBalance);
            transfer.setTransferType(TransferType.ACCEPTED);
            client.setBalance(newBalance);
        }

        return transfer;
    }
}
