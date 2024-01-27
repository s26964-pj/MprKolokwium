package com.example.s26964bank;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TransferServiceMockParameterizedTest {
    @Mock
    ClientStorage clientStorage;
    @InjectMocks
    TransferService transferService;

    @ParameterizedTest
    @MethodSource("inputClientCanSendMoney")
    void clientCanSendMoney(double balance) {
        //given
        Client client = newClient();
        //when
        when(clientStorage.findClientByID(anyString())).thenReturn(client);
        Transfer transfer =  transferService.sendMoney("123", balance);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.ACCEPTED);
    }

    @ParameterizedTest
    @MethodSource("inputClientCanNotSendMoney")
    void clientCanNotSendMoney(double balance) {
        //given
        Client client = newClient();
        //when
        when(clientStorage.findClientByID(anyString())).thenReturn(client);
        Transfer transfer =  transferService.sendMoney("123", balance);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.DECLINED);
    }

    @ParameterizedTest
    @MethodSource("inputClientCanAddMoney")
    void clientCanAddMoney(double balance) {
        //given
        Client client = newClient();
        //when
        when(clientStorage.findClientByID(anyString())).thenReturn(client);
        Transfer transfer =  transferService.addMoney("1", balance);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.ACCEPTED);
    }

    @ParameterizedTest
    @MethodSource("inputClientCanNotAddMoney")
    void clientCanNotAddMoney(double balance) {
        //given
        Client client = newClient();
        //when
        when(clientStorage.findClientByID(anyString())).thenReturn(client);
        Transfer transfer =  transferService.addMoney("1", balance);
        //then
        assertThat(transfer.getTransferType()).isEqualTo(TransferType.DECLINED);
    }

    public static Stream<Arguments> inputClientCanSendMoney() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(1),
                Arguments.of(3111),
                Arguments.of(4000)
        );
    }

    public static Stream<Arguments> inputClientCanNotSendMoney() {
        return Stream.of(
                Arguments.of(4001),
                Arguments.of(5213),
                Arguments.of(4223),
                Arguments.of(5000)
        );
    }
    public static Stream<Arguments> inputClientCanAddMoney() {
        return Stream.of(
                Arguments.of(1999),
                Arguments.of(5),
                Arguments.of(1),
                Arguments.of(15)
        );
    }
    public static Stream<Arguments> inputClientCanNotAddMoney() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(0),
                Arguments.of(-2),
                Arguments.of(-3)
        );
    }

    private Client newClient(){
        return new Client("123","Zenek",4000);
    }
}