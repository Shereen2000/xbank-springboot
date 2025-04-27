package com.tumiso.xbank.entities.enums.status;

public enum BankAccountStatus {
    CREATED,
    ACTIVE,              // Account is open and fully operational
    INACTIVE,            // Account exists but is dormant or not in use
    CLOSED,              // Account has been permanently closed
    SUSPENDED,           // Account is temporarily suspended (e.g., due to fraud or overdue compliance)
    FROZEN,              // All activity is locked (e.g., legal issue or investigation)
    PENDING_APPROVAL,    // Account application is submitted but not yet approved
    UNDER_REVIEW,        // Account is being manually reviewed
    RESTRICTED           // Account has limited functionality (e.g., deposit only)

}
