package org;

import java.time.LocalTime;
import java.util.ResourceBundle;

/**
 * Created by maks(avto12@i.ua) on 25.01.2016.
 */
public interface Service {
     ResourceBundle getResourceBundle();
     boolean isTimeBeetween(LocalTime after, LocalTime before, LocalTime currentTime);
     LocalTime getCurrentTime();
     String getPartOfDay();
     String getAnswerWithLocale();
}
