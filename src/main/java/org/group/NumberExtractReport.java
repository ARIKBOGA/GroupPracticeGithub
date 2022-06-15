package org.group;

import java.util.regex.Pattern;

public class NumberExtractReport extends ExtractorReport {

    private static final Pattern PATTERN = Pattern.compile("^\\d*$");

    @Override
    public Pattern getPattern() {
        return PATTERN;
    }

    @Override
    public String getReportName() {
        return "Phone number";
    }
}