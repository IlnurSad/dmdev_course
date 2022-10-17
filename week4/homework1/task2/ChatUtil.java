package week4.homework1.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public final class ChatUtil {

    private ChatUtil() {

    }

    public static List<User> convertChatsToUsersListOver18(List<Chat> chats) {
        List<User> result = new ArrayList<>();
        ListIterator<Chat> chatsIterator = chats.listIterator();
        while (chatsIterator.hasNext()) {
            Chat nextChat = chatsIterator.next();
            List<User> users = nextChat.getUsers();
            ListIterator<User> usersIterator = users.listIterator();
            while (usersIterator.hasNext()) {
                User nextUser = usersIterator.next();
                if (nextUser.getAge() >= 18) {
                    result.add(nextUser);
                }
            }
        }
        return result;
    }

    public static int calculatingTheAverageAge(List<User> users) {
        int averageAge;
        int sumAge = 0;
        int countUsers = 0;
        ListIterator<User> usersIterator = users.listIterator();
        while (usersIterator.hasNext()) {
            User nextUser = usersIterator.next();
            sumAge += nextUser.getAge();
            countUsers++;
        }
        averageAge = sumAge / countUsers;
        return averageAge;
    }
}
