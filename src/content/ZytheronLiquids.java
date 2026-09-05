package content;

import arc.graphics.*;
import mindustry.type.*;

public class ZytheronLiquids {
public static Liquid rocketfuel;

    public static void load(){

        rocketfuel = new Liquid("rocketfuel", Color.valueOf("ff6000")){{
            //viscosity = 0.1f;
            flammability = 1.6f;
            explosiveness = 0.8f;
            //heatCapacity = 0.3f;
            barColor = Color.valueOf("ff6000");
            //effect = StatusEffects.tarred;
            boilPoint = 0.65f;
            //gasColor = Color.grays(0.4f);
            //canStayOn.add(water);
        }};

    }
}
