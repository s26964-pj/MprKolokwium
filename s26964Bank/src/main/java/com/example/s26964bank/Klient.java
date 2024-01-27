package com.example.s26964bank;

public class Klient {
    private int klientID;
    private String nazwa;
    private double saldo;

    public Klient(int klientID, String nazwa, double saldo) {
        this.klientID = klientID;
        this.nazwa = nazwa;
        this.saldo = saldo;
    }

    public int getKlientID() {
        return klientID;
    }

    public void setKlientID(int klientID) {
        this.klientID = klientID;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
