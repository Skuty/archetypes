package com.softwarearchetypes.accounting.postingrules;

import java.util.List;

import com.softwarearchetypes.accounting.Transaction;

public interface PostingCalculator {

    //IF posting rules are outside the main accounting model
    //calculator should return ExecuteTransactionCommand instead
    List<Transaction> calculate(TargetAccounts accounts, PostingContext context);
}