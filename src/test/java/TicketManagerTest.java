import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    @Test
    public void shouldSortTickets() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, 15000, "ADL", "KME", 168);
        Ticket ticket2 = new Ticket(2, 65000, "BGJ", "YAO", 463); // 65000 - 2
        Ticket ticket3 = new Ticket(3, 43000, "BGJ", "YAO", 547); // 43000 - 3
        Ticket ticket4 = new Ticket(4, 47000, "ADL", "KTZ", 236);
        Ticket ticket5 = new Ticket(5, 86000, "BGJ", "YAO", 435); // 86000 - 5
        Ticket ticket6 = new Ticket(6, 52000, "MLW", "FDF", 372);
        Ticket ticket7 = new Ticket(7, 65000, "BGJ", "YAO", 645); // 65000 - 7
        Ticket ticket8 = new Ticket(8, 23000, "MLW", "FDF", 332);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket3, ticket2, ticket7, ticket5};
        Ticket[] actual = manager.findAll("BGJ", "YAO");
        Assertions.assertArrayEquals(expected, actual);
    }
}
