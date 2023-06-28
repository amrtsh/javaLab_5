package ua.lviv.iot.algo.part1.lab5.models;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab5.readers.Reader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DomainsTest {
    private String randomText;
    private Domains domainsFinder = new Domains();
    private Set<String> domains;
    Reader reader = new Reader();
    public void generateDomainsList(String text) {
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        randomText = reader.readFromConsole();

        domains = domainsFinder.findUniqueDomain(randomText);
    }

    @Test
    void testDomainIsAbsent() {
        String text = "Вивести унікальні назви мейл серверів з усіх електронних адрес";
        generateDomainsList(text);
        assertEquals(0, domains.size());
    }
    @Test
    void testFindDomainIsAbsent() {
        String text = "для пошти happyness@gmail.com доменом буде";
        generateDomainsList(text);
        assertEquals(1, domains.size());
    }
    @Test
    void testFindMultipleGithubUsers() {
        String text = "Maksym.Bornak.IR.2022@lpnu.ua "
                + " happyness@gmail.com"
                + "anastasiia.hlushko@ukr.net"
                + "ivanna.kochan.ir.2022@lpnu.ua";
        generateDomainsList(text);
        assertEquals(3, domains.size());
    }
}