package com.aweperi.fraud;

public interface FraudCheckService {
    boolean isFraudulentCustomer(Integer customerId);
}
