package org.Service;

import java.time.LocalTime;

/**
 * Created by maks(avto12@i.ua) on 25.01.2016.
 */
public interface Service {
     String getPartOfDay(LocalTime currentTime);
     String getAnswerWithLocale();
}
