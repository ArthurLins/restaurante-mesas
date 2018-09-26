package me.arthurlins.restaurant.view.console.util;

public class MenuOption {

    private String option;
    private String description;
    private Runnable execute;

    public MenuOption(String option, String description, Runnable execute) {
        this.option = option;
        this.description = description;
        this.execute = execute;
    }

    public String getDescription() {
        return description;
    }

    public String getOption() {
        return option;
    }

    public Runnable getExecute() {
        return execute;
    }

}
