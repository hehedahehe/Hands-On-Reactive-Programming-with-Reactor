package learn.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class NewsChannel implements Subject {

    private List<Observer> observers;
    private String newsHeadLineMessage;

    public NewsChannel() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        if (obj == null) {
            throw new NullPointerException("Null Observer Passed");
        }
        if (!observers.contains(obj)) {
            observers.add(obj);
        }
    }

    @Override
    public void unregister(Observer obj) {
        if (obj == null) {
            throw new NullPointerException("Null Observer Passed");
        }
        if (observers.contains(obj)) {
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObservers() {

        for (Observer observerObj : observers) {
            observerObj.update();
        }

    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.newsHeadLineMessage;
    }


    /**
     * Post a new News
     */
    public void postNewsHeadLine(String newsHeadLine) {
        System.out.println("New News Head-Line Available : " + newsHeadLine);
        this.newsHeadLineMessage = newsHeadLine;
        notifyObservers();
    }
}