package week4.homework1.task1;

import week4.homework1.task1.comparator.ChatDecreasingNumberOfUsersComparator;
import week4.homework1.task1.comparator.ChatNameComparator;

import java.util.ArrayList;
import java.util.List;

/**
 * Задание 1
 * Дан список чатов.
 * Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 * Задача:
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
 * а если это количество совпадает, то по названию в алфавитном порядке.
 * - Также предоставить сортировку чатов по названию по умолчанию.
 */
public class ChatDemo {
    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("ChatName9", 1001));
        chats.add(new Chat("ChatName2", 5500));
        chats.add(new Chat("ChatName1", 120));
        chats.add(new Chat("ChatName7", 33333));
        chats.add(new Chat("ChatName4", 5));
        chats.add(new Chat("ChatName8", 1200));
        chats.add(new Chat("ChatName6", 97));
        chats.add(new Chat("ChatName3", 1200));
        chats.add(new Chat("ChatName5", 1200));

        ChatUtil.deleteChatsLessThan1000(chats);
        System.out.println(chats);

        chats.sort(new ChatDecreasingNumberOfUsersComparator().thenComparing(new ChatNameComparator()));
        System.out.println(chats);

        chats.sort(new ChatNameComparator());
        System.out.println(chats);
    }
}
