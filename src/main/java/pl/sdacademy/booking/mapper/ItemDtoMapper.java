package pl.sdacademy.booking.mapper;

import pl.sdacademy.booking.data.ItemEntity;
import pl.sdacademy.booking.model.ItemDto;

import java.util.Set;

public class ItemDtoMapper {
    public static ItemDto map(ItemEntity entity, Set<String> attributes) {
        ItemDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .attributes(attributes)
                .build();

    }
}
