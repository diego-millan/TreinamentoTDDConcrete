package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RouterManager {

    List<String> existingRoutes = Arrays.asList("/posts", "/comment","/users/{user_id}");

    public boolean isValid(String url) {

        boolean isValidRoute = false;

        if (isValidUrl(url)) {

            String[] urlSplit = url.split("/");
            for(String route : existingRoutes) {
                String[] routeSplit = route.split("/");

                if (routeSplit.length == urlSplit.length) {
                    for(int i = 0; i < routeSplit.length; ++i) {
                        if (!isValidParameter(routeSplit[i],urlSplit[i]) && !urlSplit[i].equals(routeSplit[i])) {
                            break;
                        }
                    }

                    isValidRoute = true;
                    break;
                }
            }
        }

        return isValidRoute;
    }

    private boolean isValidParameter(String routeSubstring, String urlSubstring) {
        Pattern p = Pattern.compile("([a-z]|[0-9])+");
        Matcher m = p.matcher(urlSubstring);
        return m.matches() && routeSubstring.startsWith("{") && routeSubstring.endsWith("}");
    }

    private boolean isValidUrl(String url) {
        boolean isValid = false;
        if (url != null) {
            Pattern patternWithParameters = Pattern.compile("([/][a-z]+)+([/][0-9]|[a-z])+");
            Matcher matcherWithParameters = patternWithParameters.matcher(url);
            isValid = matcherWithParameters.matches();
        }
        return isValid;
    }
}
