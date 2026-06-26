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
    }
}
