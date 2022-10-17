package week4.homework1.task1;

import java.util.List;
import java.util.ListIterator;

public final class ChatUtil {

    private ChatUtil() {
    }

    public static void deleteChatsLessThan1000(List<Chat> chats) {
        ListIterator<Chat> chatsIterator = chats.listIterator();
        while (chatsIterator.hasNext()) {
            Chat nextValue = chatsIterator.next();
            if (nextValue.getNumberOfUsers() < 1000) {
                chatsIterator.remove();
            }
        }
    }
}
