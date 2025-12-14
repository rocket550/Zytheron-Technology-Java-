package content.units;

import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class ZytheronUnits {
    public static UnitType electron, voltage;

    public static void load() {
        // region ground attack

        electron = new UnitType("electron") {
            {
                constructor = TankUnit::create;
                researchCostMultiplier = 0.5f;
                speed = 0.8f;
                hitSize = 8f;
                health = 190;
                weapons.add(new Weapon("electron-turret") {
                    {
                        reload = 40f;
                        x = 0f;
                        y = 0f;
                        top = false;
                        mirror = false;
                        rotate = true;
                        bullet = new LightningBulletType() {
                            {
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
                            }
                        };
                    }
                });
            }
        };
    }
}
