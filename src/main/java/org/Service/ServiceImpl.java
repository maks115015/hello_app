package org.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by maks(avto12@i.ua) on 25.01.2016.
 */
public class ServiceImpl implements Service {

    private static final Logger logger = LoggerFactory.getLogger(ServiceImpl.class);

    private static final ServiceImpl instance = new ServiceImpl();

    private ServiceImpl(){}

    public static ServiceImpl getInstance(){
        return instance;
    }

    public String getAnswerWithLocale(){
        return getResourceBundle().getString(getPartOfDay(getCurrentTime()));
    }

    public String getPartOfDay(LocalTime currentTime){
        String partOfDay="";
        if(isTimeBeetween(LocalTime.of(6,0), LocalTime.of(9, 0), currentTime))
            partOfDay="morning";
        if(isTimeBeetween(LocalTime.of(9,0), LocalTime.of(19, 0), currentTime))
            partOfDay="day";
        if(isTimeBeetween(LocalTime.of(19,0), LocalTime.of(23, 0), currentTime))
            partOfDay="evening";
        if( (isTimeBeetween(LocalTime.of(23,0), LocalTime.of(23,59,59), currentTime))
                ||(isTimeBeetween(LocalTime.of(0, 0), LocalTime.of(6, 0), currentTime)))
            partOfDay="night";
        logger.warn("Current part of day is: {}", partOfDay);
        return partOfDay;
    }

    public boolean isTimeBeetween(LocalTime after, LocalTime before, LocalTime currentTime){
        return currentTime.plusNanos(1).isAfter(after)&currentTime.isBefore(before);
    }

    private ResourceBundle getResourceBundle(){
        ResourceBundle resourceBundle=ResourceBundle.getBundle("message", Locale.getDefault());
        logger.warn("Current locale is: {}", resourceBundle.getLocale().toString());
        return resourceBundle;
    }

    private LocalTime getCurrentTime(){
        LocalTime localTime=LocalTime.now();
        logger.warn("Current time is: {}", localTime.toString());
        return localTime;
    }
}
