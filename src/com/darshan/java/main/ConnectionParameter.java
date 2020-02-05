package com.darshan.java.main;

import java.util.Objects;

public class ConnectionParameter {
    private String direction;
    private String protocol;
    private String port;
    private String ipAddress;

    public String getDirection() { return direction; }
    public void setDirection(String direction) { this.direction = direction; }

    public String getProtocol() { return protocol; }
    public void setProtocol(String protocol) { this.protocol = protocol; }

    public String getPort() { return port; }
    public void setPort(String port) { this.port = port; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress;}

    public ConnectionParameter(String direction, String protocol, String port, String ipAddress) {
        this.direction = direction;
        this.protocol = protocol;
        this.port = port;
        this.ipAddress = ipAddress;
    }
}