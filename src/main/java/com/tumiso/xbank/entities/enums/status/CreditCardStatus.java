package com.tumiso.xbank.entities.enums.status;

public enum CreditCardStatus {

    ACTIVE,              // Card is active and usable
    INACTIVE,            // Card exists but not yet activated
    PENDING_ACTIVATION,  // Card issued, waiting for user to activate
    BLOCKED,             // Temporarily blocked (e.g., suspicious activity)
    LOST_OR_STOLEN,      // Reported lost or stolen
    EXPIRED,             // Card has reached expiry
    CLOSED,              // Permanently closed
    SUSPENDED,           // Suspended due to payment/default issues
    LIMIT_REACHED        // Credit limit maxed out, cannot process more

}

