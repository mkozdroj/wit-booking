package pl.sdacademy.booking.service;

import lombok.extern.slf4j.Slf4j;
import pl.sdacademy.booking.data.ItemAttributeEntity;
import pl.sdacademy.booking.data.ItemEntity;
import pl.sdacademy.booking.mapper.ItemDtoMapper;
import pl.sdacademy.booking.model.ItemDto;
import pl.sdacademy.booking.model.NewItemDto;
import pl.sdacademy.booking.repository.ItemRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemDto> findItems() {
        log.info("findItems");
        List<ItemDto> result = new ArrayList<>();

        List<ItemEntity> itemEntities = itemRepository.findItems();
        for (ItemEntity entity : itemEntities) {
            Set<String> attributes = mapAttributes(entity.getAttributes());
            result.add(ItemDtoMapper.map(entity, attributes));
        }
        return result;
    }

    private Set<String> mapAttributes(Set<ItemAttributeEntity> itemAttributeEntities) {
        Set<String> result = new HashSet<>();
        for (ItemAttributeEntity attributeEntity : itemAttributeEntities) {
            result.add(attributeEntity.getAttributeName());
        }
        return result;
    }

    public String addItem(NewItemDto newItem) {
        Long itemsByName = itemRepository.findItemsByName(newItem.getName());
        if (itemsByName != null) {
            return "Element już istnieje.";
        }
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setName(newItem.getName());
        itemEntity.setDescription(newItem.getDescription());
        itemEntity.setPrice(newItem.getPrice());
        itemRepository.addItem(itemEntity);
        return "Element został zapisany";
    }


}
