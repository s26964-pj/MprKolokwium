package com.example.s26964bank;

public class Transfer {
    private double newBalance;
    private TransferType transferType;

    public Transfer(double newBalance, TransferType transferType) {
        this.newBalance = newBalance;
        this.transferType = transferType;
    }

    public Transfer() {
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    public TransferType getTransferType() {
        return transferType;
    }

    public void setTransferType(TransferType transferType) {
        this.transferType = transferType;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "newBalance=" + newBalance +
                ", transferType=" + transferType +
                '}';
    }
}
