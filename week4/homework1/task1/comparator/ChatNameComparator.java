package week4.homework1.task1.comparator;

import week4.homework1.task1.Chat;

import java.util.Comparator;

public class ChatNameComparator implements Comparator<Chat> {
    @Override
    public int compare(Chat o1, Chat o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
