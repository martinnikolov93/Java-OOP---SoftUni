package Ex4InterfacesAndAbstraction.Pr5Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder callSB = new StringBuilder();

        for (String number : numbers) {
            if (number.matches("[0-9]+")){
                callSB.append("Calling... ").append(number);
            } else {
                callSB.append("Invalid number!");
            }
        }


        return callSB.toString();
    }

    @Override
    public String browse() {
        StringBuilder browseSB = new StringBuilder();

        for (String url : urls) {
            if (!containsDigit(url)){
                browseSB.append("Browsing: ").append(url).append("!");
            } else {
                browseSB.append("Invalid URL!");
            }
        }

        return browseSB.toString();
    }

    private boolean containsDigit(String s) {
        boolean containsDigit = false;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }

        return containsDigit;
    }


}
