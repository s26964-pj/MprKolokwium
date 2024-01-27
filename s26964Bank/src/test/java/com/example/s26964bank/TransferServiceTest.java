package com.example.s26964bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransferServiceTest {
    private TransferService transferService;

    @BeforeEach
    void setup() {
        ClientStorage clientStorage = new ClientStorage();
        transferService = new TransferService(clientStorage);
    }

    @Test
    void clientCanSendMoney() {
        //when
        Transfer transfer = transferService.sendMoney("123", 4000);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.ACCEPTED);
    }

    @Test
    void clientCanNotSendMoney() {
        //when
        Transfer transfer = transferService.sendMoney("123", 400000);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.DECLINED);
    }

    @Test
    void clientCanAddMoney() {
        //when
        Transfer transfer = transferService.addMoney("123", 4000);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.ACCEPTED);
    }

    @Test
    void clientCanNotAddMoney() {
        //when
        Transfer transfer = transferService.addMoney("123", -4000);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.DECLINED);
    }

}