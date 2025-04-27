package com.tumiso.xbank.entities.enums;

public enum Bank {
    ABSA("ABSA", "632005"),
    NEDBANK("Nedbank", "198765"),
    STANDARD_BANK("Standard Bank", "051001"),
    FNB("FNB", "250655"),
    CAPITEC("Capitec", "470010");

    private final String bankName;
    private final String branchCode;

    Bank(String bankName, String branchCode) {
        this.bankName = bankName;
        this.branchCode = branchCode;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    @Override
    public String toString() {
        return bankName + " (Branch Code: " + branchCode + ")";
    }
}
