package model;

import interfaces.Expirable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExpirableProduct implements Expirable {
    private LocalDate createdAt;
    private int expireDays;

    public ExpirableProduct(String createdIn, int expireDays) {
        this.createdAt = LocalDate.parse(createdIn, DateTimeFormatter.ISO_LOCAL_DATE);
        this.expireDays = expireDays;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(createdAt.plusDays(expireDays));
    }
}
