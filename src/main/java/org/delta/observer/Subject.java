package org.delta.observer;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
