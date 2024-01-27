package com.example.s26964bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientStorage {
    private List<Client> clientList = new ArrayList<>();

    public ClientStorage() {
        clientList.add(new Client("123", "Jarek", 15000));
        clientList.add(new Client("321", "Zosia", 4300));
        clientList.add(new Client("213", "Marek", 105000));
        clientList.add(new Client("312", "Marysia", 55000));
    }

    public List<Client> getAllClient() {
        return clientList;
    }

    public void registerClient(Client client) {
        clientList.add(client);
    }

    public Client findClientByID(String clientID) {
        return getAllClient()
                .stream()
                .filter(client -> client.getClientID().equals(clientID))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nie ma takiego klienta"));
    }

    @Override
    public String toString() {
        return "ClientStorage{" +
                "clientList=" + clientList +
                '}';
    }
}
