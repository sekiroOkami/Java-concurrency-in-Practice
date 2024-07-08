package chapter1.example6;

import java.util.Date;

/**
 * Write a description of class Event here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Event
{
    private Date date;
    private String event;
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setEvent(String string) {
        this.event = string;
    }
    
    public Date getDate() {
        return date;
    }
    
    public String getEvent() {
        return event;
    }
}
