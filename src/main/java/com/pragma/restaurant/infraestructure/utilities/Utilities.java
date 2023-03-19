package com.pragma.restaurant.infraestructure.utilities;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class Utilities implements IUtilities{
    private final static String ACCESS_TOKEN_SECRET = "@fCPk5z%@b393##rG2YG7hK6zQn84@$e";

    @Override
    public boolean isNumeric(String string) {
        try {
            Long.parseLong(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean validPhoneNumber(String string) {
        if(string.length() <= 13) {
            if (string.charAt(0) == '+') {
                return isNumeric(string.substring(1, string.length()));
            } else if (string.charAt(0) != '+') {
                return isNumeric(string);
            }
        }
        return false;
    }

    @Override
    public String getRol(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                .build()
                .parseClaimsJws(token.replace("Bearer ",""))
                .getBody();

        return claims.get("authorities").toString();
    }

    @Override
    public String getEmail(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                .build()
                .parseClaimsJws(token.replace("Bearer ",""))
                .getBody();

        return claims.get("sub").toString();
    }
}
