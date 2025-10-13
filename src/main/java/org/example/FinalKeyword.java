package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class FinalKeyword {
    final List<String> test = new ArrayList<>();
    public String test() {
        test.add("Hello");
        return test.get(0);
    }
    private final int amount;
    private final String currency;

    private final Date date;
    public FinalKeyword (String currency, LocalDateTime date) {
        this.amount = 5;
        this.currency = currency;
        this.date = new Date(date.getYear());
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
