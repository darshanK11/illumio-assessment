package com.darshan.java.main;

import javafx.scene.media.EqualizerBand;

public class Helper {

    public final static String EQ = "EQUAL";
    public final static String LEQ = "LESS_THAN_EQUAL_TO";

    public static boolean isValidPort(final String input, final String[] archived) {
        if(archived.length == 1)
            return compareArr(input, archived[0], EQ);
        return compareArr(archived[0], input, LEQ) &&
                compareArr(input, archived[0], LEQ);
    }

    public static boolean isValidIp(final String input, final String[] archived) {
        String[] inputArr = input.split("\\.");
        String[] archivedArr1 = archived[0].split("\\.");

        if(archived.length == 1) {
            return compareArr(inputArr[0], archivedArr1[0], EQ) &&
                    compareArr(inputArr[1], archivedArr1[1], EQ) &&
                    compareArr(inputArr[2], archivedArr1[2], EQ) &&
                    compareArr(inputArr[3], archivedArr1[3], EQ);
        }

        String[] archivedArr2 = archived[1].split("\\.");
        return compareArr(archivedArr1[0], inputArr[0], LEQ) && compareArr(inputArr[0], archivedArr2[0], LEQ) &&
                compareArr(archivedArr1[1], inputArr[1], LEQ) && compareArr(inputArr[1], archivedArr2[1], LEQ) &&
                compareArr(archivedArr1[2], inputArr[2], LEQ) && compareArr(inputArr[2], archivedArr2[2], LEQ) &&
                compareArr(archivedArr1[3], inputArr[3], LEQ) && compareArr(inputArr[3], archivedArr2[3], LEQ);
    }

    public static boolean compareArr(String str1, String str2, String operation) {
        if(EQ.equals(operation))
            return Integer.parseInt(str1) == Integer.parseInt(str2);
        else
            return Integer.parseInt(str1) <= Integer.parseInt(str2);
    }
}
