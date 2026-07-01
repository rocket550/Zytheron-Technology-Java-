package content;

import mindustry.type.Item;

public class ZytheronItems {
public static Item blackOre, black, redOre, red, greenOre, green, blueOre, blue;

    public static void load(){
        blackOre = new Item("blackOre"){{
            alwaysUnlocked = true;
            explosiveness = 0.2f;
            charge = 0.0f;
            flammability = 1f;
            radioactivity = 0.0f;
            //color = SLPal.starOrangeColor;
        }};
        black = new Item("black"){{
            alwaysUnlocked = true;
            explosiveness = 0.1f;
            charge = 0.0f;
            flammability = 0.2f;
            radioactivity = 0.0f;
        }};
        redOre = new Item("redOre"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0f;
            flammability = 0f;
            radioactivity = 0f;
        }};
        red = new Item("red"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0f;
            flammability = 0f;
            radioactivity = 0f;
        }};
        greenOre = new Item("greenOre"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0f;
            flammability = 0f;
            radioactivity = 0f;
        }};
        green = new Item("green"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0f;
            flammability = 0f;
            radioactivity = 0f;
        }};
        blueOre = new Item("blueOre"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0.5f;
            flammability = 0f;
            radioactivity = 0f;
        }};
        blue = new Item("blue"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0.8f;
            flammability = 0f;
            radioactivity = 0f;
        }};
    }
}
