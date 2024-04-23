package ru.netology.javaqa.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

//compare
class AviaSoulsTest {
    @Test
    public void shouldSortSeveralTickets() {
        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("Сочи", "Москва", 15_500, 9, 13);
        Ticket ticket2 = new Ticket("Москва", "Екатеринбург", 25_000, 13, 18);
        Ticket ticket3 = new Ticket("Сочи", "Екатеринбург", 28_000, 10, 15);
        Ticket ticket4 = new Ticket("Москва", "Сочи", 16_000, 12, 15);
        Ticket ticket5 = new Ticket("Сочи", "Москва", 15_000, 11, 14);
        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);

        Ticket[] expected = {ticket5, ticket1};
        Ticket[] actual = service.search("Сочи", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortOneTicket() {
        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("Сочи", "Москва", 15_500, 9, 13);
        Ticket ticket2 = new Ticket("Москва", "Екатеринбург", 25_000, 13, 18);
        Ticket ticket3 = new Ticket("Сочи", "Екатеринбург", 28_000, 10, 15);
        Ticket ticket4 = new Ticket("Москва", "Сочи", 16_000, 12, 15);
        Ticket ticket5 = new Ticket("Сочи", "Москва", 15_000, 11, 14);
        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);

        Ticket[] expected = {ticket2};
        Ticket[] actual = service.search("Москва", "Екатеринбург");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortZeroTickets() {
        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("Сочи", "Москва", 15_500, 9, 13);
        Ticket ticket2 = new Ticket("Москва", "Екатеринбург", 25_000, 13, 18);
        Ticket ticket3 = new Ticket("Сочи", "Екатеринбург", 28_000, 10, 15);
        Ticket ticket4 = new Ticket("Москва", "Сочи", 16_000, 12, 15);
        Ticket ticket5 = new Ticket("Сочи", "Москва", 15_000, 11, 14);
        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = service.search("Москва", "Владивосток");

        Assertions.assertArrayEquals(expected, actual);
    }

    //comparator
    @Test
    public void shouldSortSeveralTicketsViaComparator() {
        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("Сочи", "Москва", 15_500, 9, 13);
        Ticket ticket2 = new Ticket("Москва", "Екатеринбург", 25_000, 13, 18);
        Ticket ticket3 = new Ticket("Сочи", "Екатеринбург", 28_000, 10, 15);
        Ticket ticket4 = new Ticket("Москва", "Сочи", 16_000, 12, 15);
        Ticket ticket5 = new Ticket("Сочи", "Москва", 15_000, 11, 14);
        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5, ticket1};
        Ticket[] actual = service.searchAndSortBy("Сочи", "Москва", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortOneTicketViaComparator() {
        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("Сочи", "Москва", 15_500, 9, 13);
        Ticket ticket2 = new Ticket("Москва", "Екатеринбург", 25_000, 13, 18);
        Ticket ticket3 = new Ticket("Сочи", "Екатеринбург", 28_000, 10, 15);
        Ticket ticket4 = new Ticket("Москва", "Сочи", 16_000, 12, 15);
        Ticket ticket5 = new Ticket("Сочи", "Москва", 15_000, 11, 14);
        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket2};
        Ticket[] actual = service.searchAndSortBy("Москва", "Екатеринбург", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortZeroTicketsViaComparator() {
        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("Сочи", "Москва", 15_500, 9, 13);
        Ticket ticket2 = new Ticket("Москва", "Екатеринбург", 25_000, 13, 18);
        Ticket ticket3 = new Ticket("Сочи", "Екатеринбург", 28_000, 10, 15);
        Ticket ticket4 = new Ticket("Москва", "Сочи", 16_000, 12, 15);
        Ticket ticket5 = new Ticket("Сочи", "Москва", 15_000, 11, 14);
        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = service.searchAndSortBy("Москва", "Владивосток", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }


}