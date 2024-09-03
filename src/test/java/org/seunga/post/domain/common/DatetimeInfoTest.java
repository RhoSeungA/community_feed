package org.seunga.post.domain.common;

import org.junit.jupiter.api.Test;
import org.seunga.Post.domain.common.DatetimeInfo;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatetimeInfoTest {
    @Test
    void givenCreated_whenUpdated_thenTimeAndStateArsUpdate(){
        //given
        DatetimeInfo datetimeInfo = new DatetimeInfo();
        LocalDateTime localDateTime = datetimeInfo.getDateTime();

        //when
        datetimeInfo.updateEditDatetime();

        // then
        assertTrue(datetimeInfo.isEdited());
        assertNotEquals(localDateTime,datetimeInfo.getDateTime());
    }
}
