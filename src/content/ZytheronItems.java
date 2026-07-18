package content;

import mindustry.type.Item;

public class ZytheronItems {
public static Item ignition, black, redOre, red, green, blueOre, blue, transistor, processor;

    public static void load(){

        green = new Item("green"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0f;
            flammability = 0f;
            radioactivity = 0f;
            hardness = 1;
            color = ZytheronColors.greenColor;
        }};


        ignition = new Item("ignition"){{
            alwaysUnlocked = true;
            explosiveness = 0.2f;
            charge = 0.0f;
            flammability = 1f;
            radioactivity = 0.0f;
            hardness = 2;
            //
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
            hardness = 3;
            color = ZytheronColors.redColorDark;
        }};
        red = new Item("red"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0f;
            flammability = 0f;
            radioactivity = 0f;
            color = ZytheronColors.redColor;
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
        transistor = new Item("transistor"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0f;
            flammability = 0f;
            radioactivity = 0f;
        }};
        processor = new Item("processor"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0f;
            flammability = 0f;
            radioactivity = 0f;
        }};
    }
}
