package content.units;

import mindustry.gen.*;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
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
            weapons.add(
                new Weapon("electron-turret") {{
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
            weapons.add(
                new Weapon("voltage-turret") {{
                    reload = 60f;
                    x = 0f;
                    y = 0f;
                    top = false;
                    mirror = false;
                    rotate = true;
                    shoot.shots = 4;
                    shoot.shotDelay = 8;
                    bullet = new BasicBulletType(1f,2f) {{
                        collides = true;
                        collidesAir = true;
                        collidesTiles = true;
                        width = 10;
                        height = 10;
                        pierceCap = 4;
                        range = 168;
                        maxRange = 168;
                        damage = 10;
                        speed = 3;
                        lifetime = 60;
                        backColor = "a9d8ff";
                        frontColor = "a9d8ff";
                        trailLength = 8;
                        trailWidth = 2;
                        trailColor = a9d8ff;
                        inaccuracy = 4;
                        pierce = true;
                        lightningLength = 7;
                        lightning = 3;
                        lightningDamage = 2;
                        lightningAngle = 0;
                        lightningColor = "a9d8ff";
                        lightningLength = 21;
                        buildingDamageMultiplier = 1;
                        shootEffect = Fx.lightningShoot;
                        status = StatusEffects.shocked;
                    }};
                }}
            );
        }};
    }
}
