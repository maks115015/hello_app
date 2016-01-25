package org.Service;

import java.time.LocalTime;

/**
 * Created by maks(avto12@i.ua) on 25.01.2016.
 */
public interface Service {
     boolean isTimeBeetween(LocalTime after, LocalTime before, LocalTime currentTime);
     String getPartOfDay();
     String getAnswerWithLocale();
}
