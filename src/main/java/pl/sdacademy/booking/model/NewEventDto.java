package pl.sdacademy.booking.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class NewEventDto {
    private String itemName;
    private BigDecimal itemPrice;
    private LocalDateTime fromTime;
    private LocalDateTime toTime;

}
