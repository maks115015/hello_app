package org;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by maks(avto12@i.ua) on 25.01.2016.
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);


    public static void main( String[] args ) {
        Service service=new ServiceImpl();
        System.out.println(service.getResourceBundle().getString("title"));
        System.out.println("________________________________________________________________________");
        System.out.println();
        logger.info(service.getAnswerWithLocale());
    }

}
