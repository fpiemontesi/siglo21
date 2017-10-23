/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public interface Subject {
    
    List<Observer> OBSERVERS = new ArrayList<>();
    
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();    
}
