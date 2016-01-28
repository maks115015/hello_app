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
        if ((currentTime.getHour() >= 23 && currentTime.getHour() < 24)
                ||(currentTime.getHour() >= 0 && currentTime.getHour() < 6)) {
            partOfDay= "night";
        } else if (currentTime.getHour() >= 6 && currentTime.getHour() < 9) {
            partOfDay= "morning";
        } else if (currentTime.getHour() >= 9 && currentTime.getHour() < 19) {
            partOfDay= "day";
        } else if (currentTime.getHour() >= 19 && currentTime.getHour() < 23) {
            partOfDay= "evening";
        }
        logger.info("getPartOfDay return: {}",partOfDay);
        return partOfDay;
    }


    private ResourceBundle getResourceBundle(){
        ResourceBundle resourceBundle=ResourceBundle.getBundle("message", Locale.getDefault());
        logger.info("Current locale is: {}", resourceBundle.getLocale().toString());
        return resourceBundle;
    }

    private LocalTime getCurrentTime(){
        LocalTime localTime=LocalTime.now();
        logger.info("Current time is: {}", localTime.toString());
        return localTime;
    }
}
