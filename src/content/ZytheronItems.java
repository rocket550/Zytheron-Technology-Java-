package content;

import mindustry.type.Item;

public class ZytheronItems {
public static Item ZTcoal, ZTcoal2, RedOre, Red, GreenOre, Green, BlueOre, Blue;

    public static void load(){
        ZTcoal = new Item("ZTcoal"){{
            alwaysUnlocked = true;
            explosiveness = 0.2f;
            charge = 0.0f;
            flammability = 1f;
            radioactivity = 0.0f;
            //color = SLPal.starOrangeColor;
        }};
        ZTcoal2 = new Item("ZTcoal2"){{
            alwaysUnlocked = true;
            explosiveness = 0.1f;
            charge = 0.0f;
            flammability = 0.2f;
            radioactivity = 0.0f;
        }};
        RedOre = new Item("RedOre"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0f;
            flammability = 0f;
            radioactivity = 0f;
        }};
        Red = new Item("Red"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0f;
            flammability = 0f;
            radioactivity = 0f;
        }};
        GreenOre = new Item("GreenOre"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0f;
            flammability = 0f;
            radioactivity = 0f;
        }};
        Green = new Item("Green"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0f;
            flammability = 0f;
            radioactivity = 0f;
        }};
        BlueOre = new Item("BlueOre"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0.5f;
            flammability = 0f;
            radioactivity = 0f;
        }};
        Blue = new Item("Blue"){{
            alwaysUnlocked = true;
            explosiveness = 0f;
            charge = 0.8f;
            flammability = 0f;
            radioactivity = 0f;
        }};
    }
}
