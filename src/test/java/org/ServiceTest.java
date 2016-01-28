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
        String expected="morning";
        String current=service.getPartOfDay(LocalTime.of(6, 0));
        Assert.assertEquals(expected, current);
    }

    @Test
    public void testGetPartOfDayShouldReturnMorningEnd(){
        String expected="morning";
        String current=service.getPartOfDay(LocalTime.of(8, 59, 59));
        Assert.assertEquals(expected, current);
    }

    @Test
    public void testGetPartOfDayShouldReturnDayBegin(){
        String expected="day";
        String current=service.getPartOfDay(LocalTime.of(9, 0));
        Assert.assertEquals(expected, current);
    }

    @Test
    public void testGetPartOfDayShouldReturnDayEnd(){
        String expected="day";
        String current=service.getPartOfDay(LocalTime.of(18, 59, 59));
        Assert.assertEquals(expected, current);
    }

    @Test
    public void testGetPartOfDayShouldReturnEveningBegin(){
        String expected="evening";
        String current=service.getPartOfDay(LocalTime.of(19, 0));
        Assert.assertEquals(expected, current);
    }

    @Test
    public void testGetPartOfDayShouldReturnEveningEnd(){
        String expected="evening";
        String current=service.getPartOfDay(LocalTime.of(22, 59, 59));
        Assert.assertEquals(expected, current);
    }

    @Test
    public void testGetPartOfDayShouldReturnNightMiddle(){
        String expected="night";
        String current=service.getPartOfDay(LocalTime.of(0, 0, 0));
        Assert.assertEquals(expected, current);
    }

    @Test
    public void testGetPartOfDayShouldReturnNightBegin(){
        String expected="night";
        String current=service.getPartOfDay(LocalTime.of(23, 0));
        Assert.assertEquals(expected, current);
    }

    @Test
    public void testGetPartOfDayShouldReturnNightEnd(){
        String expected="night";
        String current=service.getPartOfDay(LocalTime.of(5, 59, 59));
        Assert.assertEquals(expected, current);
    }

    @Test
    public void testGetAnswerWithLocaleDefaultLocale(){
        String currentPartOfDay=service.getPartOfDay(LocalTime.now());
        String expected= ResourceBundle.getBundle("message",Locale.getDefault()).getString(currentPartOfDay);
        String current=service.getAnswerWithLocale();
        Assert.assertEquals(expected, current);
    }

    @Test
    public void testGetAnswerWithLocaleWithENLocale(){
        String currentPartOfDay=service.getPartOfDay(LocalTime.now());
        Locale oldLocale=Locale.getDefault();
        Locale.setDefault(Locale.forLanguageTag("en"));
        String expected= ResourceBundle.getBundle("message",Locale.forLanguageTag("en")).getString(currentPartOfDay);
        String current=service.getAnswerWithLocale();
        Locale.setDefault(oldLocale);
        Assert.assertEquals(expected, current);
    }

    @Test
    public void testGetAnswerWithLocaleWithCZLocale(){
        String currentPartOfDay=service.getPartOfDay(LocalTime.now());
        Locale oldLocale=Locale.getDefault();
        Locale.setDefault(Locale.forLanguageTag("cz"));
        String expected= ResourceBundle.getBundle("message",Locale.forLanguageTag("cz")).getString(currentPartOfDay);
        String current=service.getAnswerWithLocale();
        Locale.setDefault(oldLocale);
        Assert.assertEquals(expected, current);
    }
}