package com.softwarearchetypes.accounting;

class AccountFixture {

    private final AccountingFacade facade;

    private AccountFixture(AccountingFacade facade) {
        this.facade = facade;
    }

    static AccountFixture accountingFixtureFor(AccountingFacade facade) {
        return new AccountFixture(facade);
    }

    AccountId createAssetAccount(String name) {
        AccountId id = AccountId.generate();
        facade.createAccount(CreateAccount.generateAssetAccount(id, name));
        return id;
    }

    AccountId createOffBalanceAccount(String name) {
        AccountId id = AccountId.generate();
        facade.createAccount(CreateAccount.generateOffBalanceAccount(id, name));
        return id;
    }
}
