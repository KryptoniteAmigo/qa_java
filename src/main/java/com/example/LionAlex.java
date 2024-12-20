package com.example;

import java.util.List;

public class LionAlex extends Lion {
    private final List<String> friends;

    public LionAlex(Feline feline) throws Exception {
        super("Самец", feline);
        this.friends = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
    }

    public List<String> getFriends() {
        return friends;
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
