package pl.sdacademy.booking.service;

import pl.sdacademy.booking.data.ItemAttributeEntity;
import pl.sdacademy.booking.data.ItemEntity;
import pl.sdacademy.booking.repository.ItemRepository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestItemRepository implements ItemRepository {


    @Override
    public List<ItemEntity> findItems() {
        Set<ItemAttributeEntity> attributes = new HashSet<>();
        ItemAttributeEntity firstAttribute = new ItemAttributeEntity();
        firstAttribute.setId(1L);
        firstAttribute.setAttributeName("twarz");
        attributes.add(firstAttribute);
        ItemEntity first = new ItemEntity();
        first.setId(1l);
        first.setName("Pierwszy");
        first.setDescription("Przykladowy opis");
        first.setPrice(BigDecimal.valueOf(120.0));
        first.setAttributes(attributes);
        ItemEntity second = new ItemEntity();
        second.setId(2l);
        second.setName("Drugi");
        second.setDescription("drugi opis");
        second.setAttributes(new HashSet<>());
        first.setPrice(BigDecimal.valueOf(120.0));
        return List.of(first, second);
    }

    @Override
    public void addItem(ItemEntity item) {

    }

    @Override
    public Long findItemsByName(String name) {
        return null;
    }
}