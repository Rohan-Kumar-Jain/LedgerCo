package main;

import main.service.PaymentService;
import main.service.UserLoanService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class Geektrust {
    static UserLoanService userLoanService;
    static PaymentService paymentService;

    public static void main(String[] args) {
        userLoanService = new UserLoanService();
        paymentService = new PaymentService();

        try {
            String filePath = args[0];
            FileInputStream fis = new FileInputStream(filePath);
            Scanner sc = new Scanner(fis);

            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                String str[] = s.split(" ");
                String bankName = str[1];
                String userName = str[2];

                if (str[0].equals("LOAN")) {
                    int prAmount = Integer.parseInt(str[3]);
                    int noOfYear = Integer.parseInt(str[4]);
                    int interestRate = Integer.parseInt(str[5]);
                    userLoanService.addLoan(bankName, userName, prAmount, noOfYear, interestRate);
                } else if (str[0].equals("BALANCE")) {
                    int emiNo = Integer.parseInt(str[3]);
                    userLoanService.printAmountPaidAndEmiLeft(bankName,userName,emiNo);
                } else {
                    int lumpSumAmount = Integer.parseInt(str[3]);
                    int emiNo = Integer.parseInt(str[4]);
                    paymentService.addPayment(bankName,userName,lumpSumAmount,emiNo);
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
