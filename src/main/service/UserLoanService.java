package main.service;

import main.model.Payment;
import main.model.UserLoan;
import main.repository.UserLoanRepository;

import java.util.ArrayList;

public class UserLoanService {

    public static boolean contains(Pair pair){
        return UserLoanRepository.userLoanHashMap.containsKey(pair);
    }

    public static UserLoan get(Pair pair){
        return UserLoanRepository.userLoanHashMap.get(pair);
    }

    public static void addLoan(String bankName, String userName, int prAmount, int noOfYear, int interestRate){
        Pair pair = new Pair(userName, bankName);
        if (!contains(pair)) {
            int amount = (prAmount * noOfYear * interestRate) / 100 + prAmount;
            int emiAmount = (int) Math.ceil((float) amount / (12 * noOfYear));
            UserLoan userLoan = new UserLoan(userName, bankName, amount, emiAmount);
            UserLoanRepository.userLoanHashMap.put(pair, userLoan);
        } else {
            UserLoan userLoan = get(pair);
            int amount = userLoan.getTotalAmount() + (prAmount * noOfYear * interestRate) / 100 + prAmount;
            int emiAmount = userLoan.getEmiAmount() + (int) Math.ceil((float) amount / (12 * noOfYear));
            userLoan.setEmiAmount(emiAmount);
            userLoan.setTotalAmount(amount);
            UserLoanRepository.userLoanHashMap.replace(pair, userLoan);
        }
    }

    public static void printAmountPaidAndEmiLeft(String bankName, String userName, int currentEmiNo){
        Pair pair = new Pair(userName, bankName);
        int lumpSumAmount = 0;
        if (contains(pair)) {
            if (PaymentService.contains(pair)) {
                ArrayList<Payment> payments = PaymentService.get(pair);
                for (int i = 0; i < payments.size(); i++) {
                    Payment payment = payments.get(i);
                    if (payment.getMonth() <= currentEmiNo) {
                        lumpSumAmount = lumpSumAmount + payment.getAmountPaid();
                    }
                }
            }
            UserLoan userLoan = get(pair);
            int amountTillThisEmi = userLoan.getEmiAmount() * currentEmiNo + lumpSumAmount;
            int amountLeft = userLoan.getTotalAmount() - amountTillThisEmi;
            int emiLeft = (int) Math.ceil((float) amountLeft / userLoan.getEmiAmount());
            System.out.println(bankName + " " + userName + " " + amountTillThisEmi + " " + emiLeft);
        }
    }
}
