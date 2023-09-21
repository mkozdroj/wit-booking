package pl.sdacademy.booking.validator;

import org.junit.jupiter.api.Test;
import pl.sdacademy.booking.model.NewEventDto;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.*;

class NewEventDtoValidatorTest {

    @Test
    void name() {
        NewEventDto input = NewEventDto.builder()
                .itemName("przykład")
                .fromTime(LocalDateTime.of(2023, 9, 19, 19, 59))
                .toTime(LocalDateTime.of(2023, 9, 19, 19, 57))
                .build();
        NewEventDtoValidator.validate(input);
    }

    @Test
    void shouldCheckThatFromIsNull() {
        //GIVEN
        NewEventDto input = NewEventDto.builder()
                .itemName("przykład")
                .fromTime(null)
                .toTime(LocalDateTime.of(2023, 9, 19, 19, 57))
                .build();

        //WHEN
        List<String> result = NewEventDtoValidator.validate(input);

        //THEN
        assertThat(result).hasSize(1).contains("From is null");

    }

    @Test
    void shouldCheckThatToIsNull() {
        //GIVEN
        NewEventDto input = NewEventDto.builder()
                .itemName("przykład")
                .toTime(null)
                .fromTime(LocalDateTime.of(2023, 9, 19, 19, 57))
                .build();

        //WHEN
        List<String> result = NewEventDtoValidator.validate(input);

        //THEN
        assertThat(result).hasSize(1).contains("To is null");

    }

    @Test
    void shouldCheckThatToAndFromIsNull() {
        //GIVEN
        NewEventDto input = NewEventDto.builder()
                .itemName("przykład")
                .toTime(null)
                .fromTime(null)
                .build();

        //WHEN
        List<String> result = NewEventDtoValidator.validate(input);

        //THEN
        assertThat(result).hasSize(2).containsExactly("From is null", "To is null");

    }
    //ZADANIE  - DOKONCZENIE VALIDATORA Z TESTAMI
    //DLA CHĘTNYCH - DODATKOWA FUNKCJONALNOSC, NP MAPPER PODOBNIE DO VALIDATORA, ALE MA INNA FUNKCJONALNOSC (ENCJI DO DTO)
    //mapper OSOBNY PAKIET? CHYBA

}