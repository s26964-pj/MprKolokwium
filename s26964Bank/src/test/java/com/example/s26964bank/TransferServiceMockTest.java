package com.example.s26964bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransferServiceMockTest {

    @Mock
    ClientStorage clientStorage;
    @InjectMocks
    TransferService transferService;

    @Test
    void clientCanSendMoney() {
        //given
        Client client = newClient();
        //when
        when(clientStorage.findClientByID(anyString())).thenReturn(client);
        Transfer transfer =  transferService.sendMoney("123", 1234);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.ACCEPTED);
    }

   @Test
    void clientCanNotSendMoney() {
        //given
        Client client = newClient();
        //when
        when(clientStorage.findClientByID(anyString())).thenReturn(client);
        Transfer transfer =  transferService.sendMoney("123", 1234);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.DECLINED);
    }

    @Test
    void clientCanAddMoney() {
        //given
        Client client = newClient();
        //when
        when(clientStorage.findClientByID(anyString())).thenReturn(client);
        Transfer transfer =  transferService.addMoney("1", 1234);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.ACCEPTED);
    }

    @Test
    void clientCanNotAddMoney() {
        //given
        Client client = newClient();
        //when
        when(clientStorage.findClientByID(anyString())).thenReturn(client);
        Transfer transfer =  transferService.addMoney("1", 1234);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.DECLINED);
    }

    private Client newClient(){
        return new Client("123","Zenek",2000);
    }
}