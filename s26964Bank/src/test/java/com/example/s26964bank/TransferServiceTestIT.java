package com.example.s26964bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class TransferServiceTestIT {
    @Autowired
    private TransferService transferService;
    @MockBean
    private ClientStorage clientStorage;

    @Test
    void clientCanSendMoney() {
        //given
        Client client = newClient();
        //when
        when(clientStorage.findClientByID(anyString())).thenReturn(client);
        Transfer transfer = transferService.sendMoney("123", 4000);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.ACCEPTED);
    }

    @Test
    void clientCanNotSendMoney() {
        //given
        Client client = newClient();
        //when
        when(clientStorage.findClientByID(anyString())).thenReturn(client);
        Transfer transfer = transferService.sendMoney("123", 4001);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.DECLINED);
    }

    @Test
    void clientCanAddMoney() {
        //given
        Client client = newClient();
        //when
        when(clientStorage.findClientByID(anyString())).thenReturn(client);
        Transfer transfer = transferService.addMoney("123", 1234);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.ACCEPTED);
    }

    @Test
    void clientCanNotAddMoney() {
        //given
        Client client = newClient();
        //when
        when(clientStorage.findClientByID(anyString())).thenReturn(client);
        Transfer transfer = transferService.addMoney("123", -1);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.DECLINED);
    }

    private Client newClient() {
        return new Client("123", "Zenek", 4000);
    }
}