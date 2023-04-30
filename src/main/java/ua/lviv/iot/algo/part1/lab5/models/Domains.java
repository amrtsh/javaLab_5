package ua.lviv.iot.algo.part1.lab5.models;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Domains {
    public Set<String> findUniqueDomain(String text) {
        Set<String> domains = new HashSet<>();
        Pattern pattern = Pattern.compile("@(\\w+\\.\\w{2,})",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String match = matcher.group();
            match = match.substring(1);
            domains.add(match);
        }
        return domains;
    }
}
