package com.zerobase.fastlms.util;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class RequestUtils {
    public static String getUserAgent(HttpServletRequest request) {
        return request.getHeader("User-Agent");
    }

    public static String getUserIp(HttpServletRequest request) throws UnknownHostException {
        String userIp = request.getHeader("X-Forwarded-For");

        if (userIp == null || userIp.isEmpty() || "unknown".equalsIgnoreCase(userIp)) {
            userIp = request.getHeader("Proxy-Client-IP");
        }
        if (userIp == null || userIp.isEmpty() || "unknown".equalsIgnoreCase(userIp)) {
            userIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (userIp == null || userIp.isEmpty() || "unknown".equalsIgnoreCase(userIp)) {
            userIp = request.getHeader("HTTP_CLIENT_IP");
        }
        if (userIp == null || userIp.isEmpty() || "unknown".equalsIgnoreCase(userIp)) {
            userIp = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (userIp == null || userIp.isEmpty() || "unknown".equalsIgnoreCase(userIp)) {
            userIp = request.getHeader("X-Real-IP");
        }
        if (userIp == null || userIp.isEmpty() || "unknown".equalsIgnoreCase(userIp)) {
            userIp = request.getHeader("X-RealIP");
        }
        if (userIp == null || userIp.isEmpty() || "unknown".equalsIgnoreCase(userIp)) {
            userIp = request.getRemoteAddr();
        }

        if (userIp.equals("0:0:0:0:0:0:0:1") || userIp.equals("127.0.0.1")) {
            InetAddress address = InetAddress.getLocalHost();
            userIp = address.getHostName() + "/" + address.getHostAddress();
        }

        return userIp;
    }
}
