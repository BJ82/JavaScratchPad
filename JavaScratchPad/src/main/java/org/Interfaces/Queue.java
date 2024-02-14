package org.Interfaces;

public interface Queue <T>{
     void enque(T entry);

     T deque();

     T getFront();

     boolean isEmpty();

     int size();

     void printQueue();
}
