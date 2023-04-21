package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Logger {

    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
    String formattedDate = dateFormat.format(date);

        public void PrintToLog(String type, BigDecimal transactionAmt, BigDecimal newBalance) {
            File logFile = new File("log.txt");
            try (PrintWriter dataOutput = new PrintWriter(new FileOutputStream(logFile, true));) {


                dataOutput.println(formattedDate + " " +type + " $" + transactionAmt + " $" + newBalance);

            } catch (FileNotFoundException e) {
                System.out.println("file not found");
            }
        }
    }

