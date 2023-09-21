package pl.sdacademy.booking.validator;

import org.hibernate.grammars.hql.HqlParser;
import pl.sdacademy.booking.model.NewEventDto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NewEventDtoValidator {
    //najcześciej zwracana jest lista komunikatów (stringów)

    public static List<String> validate(NewEventDto newEventDto) {
        List<String> result = new ArrayList<>();
        if (newEventDto.getFromTime() == null) {
            result.add("From is null");
        }

        if (newEventDto.getToTime() == null) {
            result.add("To is null");
        }
        if (newEventDto.getFromTime() != null && newEventDto.getToTime() != null) {
            Duration duration = Duration.between(newEventDto.getFromTime(), newEventDto.getToTime());

            if (duration.isNegative()) {
                result.add("To is before from");
            }
            if (duration.toMinutes() > 30L) {
                result.add("Event is too long");
            }
            // - tutaj zaczyna się moja część
            LocalDateTime now = LocalDateTime.now();
            if (newEventDto.getFromTime().isBefore(now)) {
                result.add("From is from the past");
            }
            if (newEventDto.getFromTime().isBefore(now)) {
                result.add("To is from the past");
            }
            if (newEventDto.getFromTime().getHour() < 8 || newEventDto.getFromTime().getHour() > 16
                    || newEventDto.getToTime().getHour() < 8 || newEventDto.getToTime().getHour() > 16) {
                result.add("Selected hours are outside the opening hours (8:00 - 16:00)");
            }
            if (newEventDto.getItemName() == null) {
                result.add("You didn't select the item");
            }


            // czy daty nie są null albo empty - ok
            // czy from i to są odwrócone - OK
            // czy nie ma daty z przeszłości - OK
            // czy przypada na godziny pracy  od 8 do 16 (założenie)
            // maksymalna określona długość sesji
            // item name is null
           
        }

        return result;
    }


}
