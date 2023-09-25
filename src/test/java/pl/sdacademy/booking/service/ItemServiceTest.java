package pl.sdacademy.booking.service;

import org.junit.jupiter.api.Test;
import pl.sdacademy.booking.data.ItemAttributeEntity;
import pl.sdacademy.booking.data.ItemEntity;
import pl.sdacademy.booking.model.ItemDto;
import pl.sdacademy.booking.repository.ItemRepository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ItemServiceTest {

    private ItemService sut;
    @Test
    void shouldResultAllItemsInDbAsListOfDto() {
        sut = new ItemService(new TestItemRepository());

        List<ItemDto> result = sut.findItems();

        assertThat(result).hasSize(2);
        ItemDto first = result.get(0);
        // liczba ponizszych asercji sygnalizuje, ze klasa moze miec za duzo odpowiedzialnosci
        // powinna zostac podzielona na bardziej specjalistyczne klasy
        assertThat(first.getId()).isEqualTo(1L);
        assertThat(first.getName()).isEqualTo("Pierwszy");
        assertThat(first.getDescription()).isEqualTo("Przykladowy opis");
        assertThat(first.getPrice()).isEqualTo(BigDecimal.valueOf(120.0));

        assertThat(first.getAttributes()).hasSize(1)
                .contains("twarz");

        ItemDto second = result.get(1);
        assertThat(second.getAttributes()).isEmpty();
    }


}