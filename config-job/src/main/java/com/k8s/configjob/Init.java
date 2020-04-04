package com.k8s.configjob;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Init {

    private static final String POD_IP = System.getenv("POD_IP");

    public static void main(String[] args) throws IOException {
        File file = new File("logs/log.log");
        file.getParentFile().mkdirs();
        file.createNewFile();
        try (BufferedWriter output = new BufferedWriter(new FileWriter(file, true))) {
            output.append("Job: ").append(POD_IP).append("\n");
        } catch (Exception ignored) {
            System.out.println("");
        }
    }

}
