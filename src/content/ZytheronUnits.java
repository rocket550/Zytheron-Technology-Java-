package content;

import arc.graphics.Color;
import mindustry.gen.*;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.type.UnitType;
//import mindustry.type.MechUnit;
//import mindustry.type.TankUnit; //You dont need these imports?
import mindustry.type.Weapon;

public class ZytheronUnits {
    public static UnitType 
    dart, //ground missile
    electron, voltage; //ground electric

    public static void load() {

        // region ground missile
        dart = new UnitType("dart") {{
            constructor = MechUnit::create;
            researchCostMultiplier = 0.5f;
            speed = 1.8f;
            hitSize = 8f;
            health = 190;
            armor = 3;
            itemCapacity = 20;
            //squareShape = true;
            //omniMovement = false;
            //rotateMoveFirst = true;
            //rotateSpeed = 3.6f;
            drownTimeMultiplier = 1.2f;

            weapons.add(
                new Weapon("dart-weapon") {{
                    reload = 30f;
                    x = 5f;
                    y = 0f;
                    shootX = 0;
                    shootY = 4;
                    top = false;
                    mirror = true;
                    rotate = false; //false for now
                    //rotateSpeed = 4.2f;
                    recoil = 1.2f;
                    shake = 1;
                    layerOffset = 0.0001f;
                    bullet = new MissileBulletType() {{
                        collides = true;
                        collidesAir = true;
                        collidesTiles = true;
                        pierceCap = 4;
                        range = 144;
                        maxRange = 144;
                        damage = 15;
                        speed = 5;
                        lifetime = 29;
                        //pierce = true;
                        //pierceCap = 4;
                        //lightningLength = 21;
                        //buildingDamageMultiplier = 1;
                        //shootEffect = Fx.lightningShoot;
                        //status = StatusEffects.shocked;
                    }};
                }}
            );
        }};







        // region ground electric
        electron = new UnitType("electron") {{
            constructor = TankUnit::create;
            researchCostMultiplier = 0.5f;
            speed = 1.8f;
            hitSize = 8f;
            health = 190;
            armor = 3;
            itemCapacity = 20;
            squareShape = true;
            omniMovement = false;
            rotateMoveFirst = true;
            rotateSpeed = 3.6f;
            drownTimeMultiplier = 1.2f;
            /*treadRects [
            {
                x = 7;
                y = -19;
                width = 14;
                height = 38;
            }
            ],*/
            weapons.add(
                new Weapon("zytheron-electron-turret") {{
                    reload = 40f;
                    x = 0f;
                    y = 0f;
                    shootX = 0;
                    shootY = 4;
                    top = false;
                    mirror = false;
                    rotate = true;
                    rotateSpeed = 4.2f;
                    recoil = 1.2f;
                    shake = 1;
                    layerOffset = 0.0001f;
                    bullet = new LightningBulletType() {{
                        collides = true;
                        collidesAir = true;
                        collidesTiles = true;
                        pierceCap = 4;
                        range = 96;
                        maxRange = 96;
                        damage = 22;
                        pierce = true;
                        pierceCap = 4;
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
            speed = 1.7f;
            hitSize = 12f;
            health = 590;
            armor = 6;
            squareShape = true;
            omniMovement = false;
            rotateMoveFirst = true;
            rotateSpeed = 2.6f;
            drownTimeMultiplier = 1.8f;
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
