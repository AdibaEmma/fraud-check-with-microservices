package com.aweperi.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudCheckServiceImpl implements FraudCheckService {
    @Override
    public boolean isFraudulentCustomer(Integer customerId) {
        return false;
    }
}
