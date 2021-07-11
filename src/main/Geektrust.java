package main;

import main.service.PaymentService;
import main.service.UserLoanService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class Geektrust {

    public static void main(String[] args) {
        try {
            String filePath = args[0];
            FileInputStream fis = new FileInputStream(filePath);
            Scanner sc = new Scanner(fis);

            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                String str[] = s.split(" ");
                String bankName = str[1];
                String userName = str[2];
                str[0] = str[0].toUpperCase();

                if (str[0].equals("LOAN")) {
                    int prAmount = Integer.parseInt(str[3]);
                    int noOfYear = Integer.parseInt(str[4]);
                    int interestRate = Integer.parseInt(str[5]);
                    UserLoanService.addLoan(bankName, userName, prAmount, noOfYear, interestRate);
                } else if (str[0].equals("BALANCE")) {
                    int emiNo = Integer.parseInt(str[3]);
                    UserLoanService.printAmountPaidAndEmiLeft(bankName,userName,emiNo);
                } else if(str[0].equals("PAYMENT")) {
                    int lumpSumAmount = Integer.parseInt(str[3]);
                    int emiNo = Integer.parseInt(str[4]);
                    PaymentService.addPayment(bankName,userName,lumpSumAmount,emiNo);
                } else{
                    throw new Exception("Invalid input!!");
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
