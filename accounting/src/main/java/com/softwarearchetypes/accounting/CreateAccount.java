package com.softwarearchetypes.accounting;

public record CreateAccount(AccountId accountId, String name, String type) {

    public static CreateAccount generateAssetAccount(AccountId accountId) {
        return new CreateAccount(accountId, "", "ASSET");
    }

    public static CreateAccount generateAssetAccount(AccountId accountId, String name) {
        return new CreateAccount(accountId, name, "ASSET");
    }

    public static CreateAccount generateOffBalanceAccount(AccountId accountId) {
        return new CreateAccount(accountId, "", "OFF_BALANCE");
    }

    public static CreateAccount generateOffBalanceAccount(AccountId accountId, String name) {
        return new CreateAccount(accountId, name, "OFF_BALANCE");
    }

    public static CreateAccount generateAssetAccount(String name) {
        return new CreateAccount(AccountId.generate(), name, "ASSET");
    }

    public static CreateAccount generate(String type) {
        return new CreateAccount(AccountId.generate(), "", type);
    }

    public static CreateAccount generate(String name, String type) {
        return new CreateAccount(AccountId.generate(), name, type);
    }
}
