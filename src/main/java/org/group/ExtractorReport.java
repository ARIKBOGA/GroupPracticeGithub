package org.group;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ExtractorReport {

    public abstract Pattern getPattern();
    public abstract String getReportName();

    public String parse(String path) throws FileNotFoundException {
        String out="";
        File file = new File(path);
        Scanner scan = new Scanner(file);
        if(scan.hasNextLine()) {
           scan.nextLine();
        }else {
            return "Empty file";
        }
        while (scan.hasNextLine()) {
            String nextLine = scan.nextLine();
            Matcher matcher = getPattern().matcher(nextLine);

            boolean match = matcher.matches();
            if(match) {
                out += nextLine + "\n";
            }
        }
        return out.isBlank() ? "Empty file" : out.trim();
    }

    public void prepareAndSendReport(String path) throws FileNotFoundException {
        System.out.println("\nStarting report for " + getReportName());
        String report = parse(path);
        System.out.println(report);
        System.out.println("Sent report for " + getReportName());
    }
}
