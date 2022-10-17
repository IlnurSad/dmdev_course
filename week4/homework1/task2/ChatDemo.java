package week4.homework1.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Задание 2
 * Дан список чатов с предыдущего задания, только вместо поля “количество пользователей” будет список объектов типа Пользователь,
 * который имеет 3 поля: id (целочисленный идентификатор), имя и возраст.
 * Задача:
 * - Преобразовать список чатов в один список пользователей всех чатов, возраст которых больше 18 лет
 * - С помощью итератора посчитать средний возраст всех оставшихся пользователей.
 */
public class ChatDemo {
    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>();

        List<User> users1 = new ArrayList<>();
        users1.add(new User(1, "Коля", 32));
        users1.add(new User(2, "Миша", 15));
        users1.add(new User(3, "Ваня", 77));
        users1.add(new User(4, "Даша", 21));
        chats.add(new Chat("ChatName1", users1));

        List<User> users2 = new ArrayList<>();
        users2.add(new User(1, "Маша", 26));
        users2.add(new User(2, "Катя", 27));
        users2.add(new User(3, "Олег", 11));
        chats.add(new Chat("ChatName2", users2));

        List<User> users3 = new ArrayList<>();
        users3.add(new User(1, "Артур", 35));
        users3.add(new User(2, "Динар", 13));
        users3.add(new User(3, "Алина", 55));
        users3.add(new User(4, "Ильдар", 18));
        users3.add(new User(5, "Лилия", 8));
        chats.add(new Chat("ChatName3", users3));

        List<User> result = ChatUtil.convertChatsToUsersListOver18(chats);
        System.out.println(result);
        System.out.println(ChatUtil.calculatingTheAverageAge(result));
    }
}
