package content.units;

import mindustry.type.Item;

public class ZytheronItems {
public static Item ZTcoal, ZTcoal2;

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
        Green-ore = new Item("Green-ore"){{
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
        Red-ore = new Item("Red-ore"){{
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
        Blue-ore = new Item("Blue-ore"){{
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
