package au.edu.parentPortal.enums;

/**
 * Created by hveluchamy on 5/10/2015.
 */
public enum ImageType {
    EVERYDAYIDEA("everydayIdea", 120, 86),
    ACTIVITIES("activities", 120, 86),
    GAME("game", 270, 180);

    private final String name;
    private final int maxWidth;
    private final int maxHeight;

    private ImageType(String name, int maxWidth, int maxHeight) {
        this.name = name;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public String getName() {
        return name;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public static ImageType getByName(String name) {
        switch(name) {
            case "everydayIdea":
                return EVERYDAYIDEA;
            case "activities":
                return ACTIVITIES;
            case "game":
                return GAME;
            default:
                return null;
        }
    }

}
