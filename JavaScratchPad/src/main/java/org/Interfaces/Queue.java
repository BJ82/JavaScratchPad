package org.Interfaces;

public interface Queue <T>{
     void Enque(T entry);

     T Deque();

     T Front();

     boolean isEmpty();

     int size();
}
