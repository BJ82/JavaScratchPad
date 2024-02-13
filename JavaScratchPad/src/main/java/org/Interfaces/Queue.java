package org.Interfaces;

public interface Queue <T>{
     void Enque(T entry);

     T Deque();

     T getFront();

     boolean isEmpty();

     int size();

     void printQueue();
}
