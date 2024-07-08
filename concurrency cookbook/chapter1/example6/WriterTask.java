package chapter1.example6;
import java.util.concurrent.*;
import java.util.*;
import java.util.stream.*;


/**
 * Write a description of class WriterTask here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WriterTask implements Callable<Deque<Event>>
{
    private Deque<Event> deque;
    public WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }
    
    @Override
    public Deque<Event> call() {
        deque = 
        IntStream.range(1, 100)
            .mapToObj(item -> {
                Event event = new Event();
                event.setDate(new Date());
                event.setEvent(String.format("The thread %s has generated an event",
                    Thread.currentThread().getId()));
                return event;
            })
            .collect(Collectors.toCollection(ConcurrentLinkedDeque::new));
        
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
        return deque;
    }
}
