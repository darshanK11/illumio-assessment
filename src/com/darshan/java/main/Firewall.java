package com.darshan.java.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Firewall {
    private Set<ConnectionParameter> connectionParameters;

    public Set<ConnectionParameter> getRules() { return connectionParameters; }

    public Firewall(final String filePath) throws IOException {
        this.connectionParameters = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parameters = line.split(",");
            getRules().add(
                    new ConnectionParameter(
                            parameters[0],
                            parameters[1],
                            parameters[2],
                            parameters[3]
                    )
            );
        }
    }

    public boolean accept_packet(final String direction, final String protocol, final int port, final String ipAddress) {
        ConnectionParameter connectionParameters = new ConnectionParameter(direction, protocol, String.valueOf(port), ipAddress);
        Iterator<ConnectionParameter> ruleIterator = getRules().iterator();
        while (ruleIterator.hasNext()) {
            if (connectionParameters.equals(ruleIterator.next()))
                return true;
        }
        return false;
    }
}
