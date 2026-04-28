package content.units;

import arc.graphics.Color;
import mindustry.gen.*;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class ZytheronUnits {
    public static UnitType electron, voltage;

    public static void load() {
        // region ground attack
        electron = new UnitType("electron") {{
            constructor = TankUnit::create;
            researchCostMultiplier = 0.5f;
            speed = 0.8f;
            hitSize = 8f;
            health = 190;
            squareShape = true;
            omniMovement = false;
            rotateMoveFirst = true;
            weapons.add(
                new Weapon("zytheron-electron-turret") {{
                    reload = 40f;
                    x = 0f;
                    y = 0f;
                    top = false;
                    mirror = false;
                    rotate = true;
                    bullet = new LightningBulletType() {{
                        collides = true;
                        collidesAir = true;
                        collidesTiles = true;
                        pierceCap = 4;
                        range = 96;
                        maxRange = 96;
                        damage = 22;
                        pierce = true;
                        lightningLength = 21;
                        buildingDamageMultiplier = 1;
                        shootEffect = Fx.lightningShoot;
                        status = StatusEffects.shocked;
                    }};
                }}
            );
        }};

        voltage = new UnitType("voltage") {{
            constructor = TankUnit::create;
            researchCostMultiplier = 0.5f;
            speed = 0.7f;
            hitSize = 8f;
            health = 590;
            squareShape = true;
            omniMovement = false;
            rotateMoveFirst = true;
            weapons.add(
                new Weapon("zytheron-voltage-turret") {{
                    reload = 60f;
                    x = 0f;
                    y = 0f;
                    top = false;
                    mirror = false;
                    rotate = true;
                    shoot.shots = 4;
                    shoot.shotDelay = 8;
                    // Se agregan parámetros de velocidad (3f) y daño (10f) al constructor
                    bullet = new BasicBulletType(3f, 10f) {{
                        collides = true;
                        collidesAir = true;
                        collidesTiles = true;
                        width = 10;
                        height = 10;
                        pierceCap = 4;
                        lifetime = 60;
                        backColor = Color.valueOf("a9d8ff");
                        frontColor = Color.valueOf("a9d8ff");
                        trailLength = 8;
                        trailWidth = 2;
                        trailColor = Color.valueOf("a9d8ff");
                        inaccuracy = 4;
                        pierce = true;
                        lightning = 3;
                        lightningDamage = 2;
                        lightningColor = Color.valueOf("a9d8ff");
                        lightningLength = 7;
                        buildingDamageMultiplier = 1;
                        shootEffect = Fx.lightningShoot;
                        status = StatusEffects.shocked;
                    }};
                }}
            );
        }};
    }
}
