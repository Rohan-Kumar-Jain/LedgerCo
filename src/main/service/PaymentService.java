package main.service;

import main.model.Payment;
import main.model.UserLoan;
import main.repository.PaymentRepository;

import java.util.ArrayList;

public class PaymentService {

    public static boolean contains(Pair pair){
        return PaymentRepository.userPaymentHashMap.containsKey(pair);
    }

    public static ArrayList<Payment> get(Pair pair){
        return PaymentRepository.userPaymentHashMap.get(pair);
    }

    public static void addPayment(String bankName, String userName, int lumpSumAmount, int emiNo){
        Pair pair = new Pair(userName, bankName);
        UserLoan userLoan = null;
        if(UserLoanService.contains(pair)){
            userLoan = UserLoanService.get(pair);
            Payment payment = new Payment(userLoan.getId(), emiNo, lumpSumAmount);

            if (!contains(pair)) {
                ArrayList<Payment> payments = new ArrayList<>();
                payments.add(payment);
                PaymentRepository.userPaymentHashMap.put(pair, payments);
            } else {
                ArrayList<Payment> payments = get(pair);
                payments.add(payment);
                PaymentRepository.userPaymentHashMap.replace(pair, payments);
            }
        }
    }
}
