package org;

import org.Service.Service;
import org.Service.ServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by maks(avto12@i.ua) on 25.01.2016.
 */
public class ServiceTest {

    Service service=ServiceImpl.getInstance();

    @Test
    public void testGetPartOfDayShouldReturnMorningBegin(){
        Assert.assertEquals("morning", getPartOfDayInString(6,0,0));
    }

    @Test
    public void testGetPartOfDayShouldReturnMorningEnd(){
        Assert.assertEquals("morning", getPartOfDayInString(8, 59, 59));
    }

    @Test
    public void testGetPartOfDayShouldReturnDayBegin(){
        Assert.assertEquals("day", getPartOfDayInString(9, 0, 0));
    }

    @Test
    public void testGetPartOfDayShouldReturnDayEnd(){
        Assert.assertEquals("day", getPartOfDayInString(18, 59, 59));
    }

    @Test
    public void testGetPartOfDayShouldReturnEveningBegin(){
        Assert.assertEquals("evening", getPartOfDayInString(19, 0,0));
    }

    @Test
    public void testGetPartOfDayShouldReturnEveningEnd(){
        Assert.assertEquals("evening", getPartOfDayInString(22, 59, 59));
    }

    @Test
    public void testGetPartOfDayShouldReturnNightMiddle(){
        Assert.assertEquals("night", getPartOfDayInString(0, 0, 0));
    }

    @Test
    public void testGetPartOfDayShouldReturnNightBegin(){
        Assert.assertEquals("night", getPartOfDayInString(23, 0, 0));
    }

    @Test
    public void testGetPartOfDayShouldReturnNightEnd(){
        Assert.assertEquals("night", getPartOfDayInString(5, 59, 59));
    }

    @Test
    public void testGetAnswerWithLocaleENLocale(){
        Assert.assertEquals(getExpectedAnswerForLocale(Locale.ENGLISH), service.getAnswerWithLocale());
    }

    @Test
    public void testGetAnswerWithLocaleCZLocale(){
        Assert.assertEquals(getExpectedAnswerForLocale(Locale.forLanguageTag("cz")), service.getAnswerWithLocale());
    }

    @Test
    public void testGetAnswerWithLocaleDefaultLocale(){
        Assert.assertEquals(getExpectedAnswerForLocale(Locale.getDefault()), service.getAnswerWithLocale());
    }

    private String getExpectedAnswerForLocale(Locale locale){
        Locale.setDefault(locale);
        return ResourceBundle
                .getBundle("message")
                .getString(getPartOfDayInString(LocalTime.now()));
    }

    private String getPartOfDayInString(int hour, int minute, int second){
        return service.getPartOfDay(LocalTime.of(hour, minute,second));
    }

    private String getPartOfDayInString(LocalTime localTime){
        return service.getPartOfDay(localTime);
    }
}