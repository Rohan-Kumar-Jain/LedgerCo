package main.repository;

import main.service.Pair;
import main.model.Payment;

import java.util.ArrayList;
import java.util.HashMap;

public class PaymentRepository {
    public static HashMap<Pair, ArrayList<Payment>> userPaymentHashMap = new HashMap<>();
}
