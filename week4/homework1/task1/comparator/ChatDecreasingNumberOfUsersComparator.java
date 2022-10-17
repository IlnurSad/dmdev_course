package week4.homework1.task1.comparator;

import week4.homework1.task1.Chat;

import java.util.Comparator;

public class ChatDecreasingNumberOfUsersComparator implements Comparator<Chat> {
    @Override
    public int compare(Chat o1, Chat o2) {
        if(o1.getNumberOfUsers()> o2.getNumberOfUsers())
            return -1;
        else if(o1.getNumberOfUsers() < o2.getNumberOfUsers())
            return 1;
        else
            return 0;
    }
}
