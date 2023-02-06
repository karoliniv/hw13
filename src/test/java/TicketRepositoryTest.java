import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {
    @Test
    public void shouldFindTickets() {
        TicketRepository repo = new TicketRepository();

        Ticket ticket1 = new Ticket(1, 15000, "ADL", "KME", 168);
        Ticket ticket2 = new Ticket(2, 65000, "BGJ", "YAO", 463); // 65000 - 2
        Ticket ticket3 = new Ticket(3, 43000, "BGJ", "YAO", 547); // 43000 - 3
        Ticket ticket4 = new Ticket(4, 47000, "ADL", "KTZ", 236);
        Ticket ticket5 = new Ticket(5, 86000, "BGJ", "YAO", 435); // 86000 - 5
        Ticket ticket6 = new Ticket(6, 52000, "MLW", "FDF", 372);
        Ticket ticket7 = new Ticket(7, 59000, "BGJ", "YAO", 645); // 59000 - 7
        Ticket ticket8 = new Ticket(8, 23000, "MLW", "FDF", 332);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveTickets() {
        TicketRepository repo = new TicketRepository();

        Ticket ticket1 = new Ticket(1, 15000, "BGJ", "KME", 168);
        Ticket ticket2 = new Ticket(2, 65000, "BGJ", "YAO", 463); // 65000 - 2
        Ticket ticket3 = new Ticket(3, 43000, "BGJ", "YAO", 547); // 43000 - 3
        Ticket ticket4 = new Ticket(4, 47000, "ADL", "KTZ", 236);
        Ticket ticket5 = new Ticket(5, 86000, "BGJ", "YAO", 435); // 86000 - 5
        Ticket ticket6 = new Ticket(6, 52000, "MLW", "FDF", 372);
        Ticket ticket7 = new Ticket(7, 59000, "BGJ", "YAO", 645); // 59000 - 7
        Ticket ticket8 = new Ticket(8, 23000, "MLW", "YAO", 332);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);

        repo.removeById(3);
        repo.removeById(4);
        repo.removeById(7);

        Ticket[] expected = {ticket1, ticket2, ticket5, ticket6, ticket8};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
