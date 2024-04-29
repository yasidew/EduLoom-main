package com.ds.edustack.notification;

public class UIDGenerator {
    private static int emailCounter = 0;

    public static String generateEmailUID() {
        return generateUID("EID", ++emailCounter);
    }

    private static String generateUID(String prefix, int counter) {
        return String.format("%s%04d", prefix, counter);
    }
}
