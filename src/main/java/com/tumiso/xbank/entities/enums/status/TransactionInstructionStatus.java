package com.tumiso.xbank.entities.enums.status;

public enum TransactionInstructionStatus {

    DRAFT,        // Created but not submitted yet
    ACTIVE,       // Ready for processing (can recur or be picked up)
    HALTED,       // Temporarily paused (by user/system rule)
    CANCELLED,    // Permanently stopped
    EXPIRED,      // No longer valid (end date passed)
    COMPLETED     // Fully executed (e.g., one-time instruction processed)
}
