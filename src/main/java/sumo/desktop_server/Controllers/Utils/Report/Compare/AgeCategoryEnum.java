package sumo.desktop_server.Controllers.Utils.Report.Compare;

import java.util.Arrays;

public enum AgeCategoryEnum {
    YOUNGSTER("Młodzik",5),
    CADET("Kadet",3),
    YOUTH("Mlodziezowiec",2),
    SENIOR("Senior",1);

    private final String text;
    private final int atomicNumber;
    AgeCategoryEnum(String text, int value) {
        this.text = text;
        this.atomicNumber = value;
    }

    public String getText() {
        return this.text;
    }

    public static AgeCategoryEnum fromText(String text) throws IllegalArgumentException {
        return Arrays.stream(values())
                .filter(bl -> bl.text.equals(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + text));
    }
    

}
