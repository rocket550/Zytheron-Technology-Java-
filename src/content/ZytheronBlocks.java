package content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

//Comment test

public class ZytheronBlocks {
    public static Block

    //Transportation
    greenConveyor, basicJunction, basicRouter, basicSorter, basicInvertedSorter, basicOverflowGate, basicUnderflowGate,
    
    //Factory
    stoneficator, redfactory,

    //Ore
    volcaniteOre, greenOre, redOre, ignitionOre,

    //Turret
    bullet, dual,//Green
    trocket, silo,//Red
    candle, flame,//Fire

    //Drill
    pelletDrill, boulderDrill,

    //Wall
    greenWall, largeGreenWall,//Green
    redWall, largeRedWall,//Red

    //Logic
    script, 
    m5 ,m200 ,m600 ,m2000;//Testing messages

    
    public static void load(){

        //Item transportation

        greenConveyor = new Conveyor("greenConveyor"){{
            requirements(Category.distribution, with(ZytheronItems.green, 1));
            health = 60;
            speed = 0.035f;
            displayedSpeed = 100000f;
            buildCostMultiplier = 2f;
            //researchCost = with(ZytheronItems.Green, 10);
        }};

        basicJunction = new Junction("basicJunction"){{
            requirements(Category.distribution, with(ZytheronItems.green, 4));
            speed = 26;
            capacity = 6;
            health = 60;
            buildCostMultiplier = 6f;
        }};

        basicRouter = new Router("basicRouter"){{
            requirements(Category.distribution, with(ZytheronItems.green, 2));
            health = 60;
            buildCostMultiplier = 4f;
        }};

        basicSorter = new Sorter("basicSorter"){{
            requirements(Category.distribution, with(ZytheronItems.black, 3));
            health = 60;
            buildCostMultiplier = 3f;
        }};

        basicInvertedSorter = new Sorter("basicInvertedSorter"){{
            requirements(Category.distribution, with(ZytheronItems.black, 3));
            health = 60;
            buildCostMultiplier = 3f;
            invert = true;
        }};

        /*basicDistributor = new Router("distributor"){{
            requirements(Category.distribution, with(Items.lead, 4, Items.copper, 4));
            buildCostMultiplier = 3f;
            size = 2;
        }};*/

        basicOverflowGate = new OverflowGate("basicOverflowGate"){{
            requirements(Category.distribution, with(ZytheronItems.black, 3, ZytheronItems.green, 3));
            health = 60;
            buildCostMultiplier = 3f;
        }};

        basicUnderflowGate = new OverflowGate("basicUnderflowGate"){{
            requirements(Category.distribution, with(ZytheronItems.black, 3, ZytheronItems.green, 3));
            health = 60;
            buildCostMultiplier = 3f;
            invert = true;
        }};

        //factory
        stoneficator = new GenericCrafter("stoneficator"){{
            alwaysUnlocked = true;
            requirements(Category.crafting, new ItemStack[]{
                new ItemStack(ZytheronItems.green, 45),
            });
            size = 2;
            hasPower = false;
            hasItems = true;
            rotate = false;
            solid = true;
            envEnabled = Env.any;
            itemCapacity = 10;
            craftTime = 50;

            //consumePower(0.5f);
            consumeItem(ZytheronItems.ignition,2);
            outputItem = new ItemStack(ZytheronItems.black, 1);
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        redfactory = new GenericCrafter("redfactory"){{
            alwaysUnlocked = true;
            requirements(Category.crafting, new ItemStack[]{
                new ItemStack(ZytheronItems.green, 90),
                new ItemStack(ZytheronItems.black, 60),
            });
            size = 2;
            hasPower = true;
            hasItems = true;
            rotate = false;
            solid = true;
            envEnabled = Env.any;
            itemCapacity = 10;
            craftTime = 40;

            consumePower(1f);
            consumeItem(ZytheronItems.redOre,2);
            outputItem = new ItemStack(ZytheronItems.red, 1);
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(ZytheronColors.redColor));
        }};
         /*
        starfac = new GenericCrafter("star-factory"){{
            alwaysUnlocked = true;
            requirements(Category.crafting, new ItemStack[]{
                new ItemStack(Items.metaglass, 50),
                new ItemStack(Items.silicon, 110),
            });
            size = 2;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            rotate = false;
            solid = true;
            envEnabled = Env.any;
            itemCapacity = 1;
            craftTime = 600;

            consumePower(8f);
            outputItem = new ItemStack(SLItems.starFrag, 1);
        }};*/
        //ore
     
        greenOre = new OreBlock("greenOre", ZytheronItems.green){{
            alwaysUnlocked = true;
            oreDefault = true;
            oreScale = 9f;
            oreThreshold = 0.7f;
            //emitLight = true;
            //lightRadius = 12f;
            //lightColor = SLPal.silviriumColor;
            variants = 1;
        }};


        volcaniteOre = new OreBlock("volcaniteOre", ZytheronItems.volcanite){{
            alwaysUnlocked = true;
            oreDefault = true;
            oreScale = 5f;
            oreThreshold = 0.4f;
            //emitLight = true;
            //lightRadius = 12f;
            //lightColor = SLPal.silviriumColor;
            variants = 1;
        }};

        ignitionOre = new OreBlock("ignitionOre", ZytheronItems.ignition){{
            alwaysUnlocked = true;
            oreDefault = true;
            oreScale = 9;
            oreThreshold = 0.6f;
            //emitLight = true;
            //lightRadius = 12f;
            //lightColor = SLPal.silviriumColor;
            variants = 4;
        }};

        redOre = new OreBlock("redOre", ZytheronItems.redOre){{
            alwaysUnlocked = true;
            oreDefault = true;
            oreScale = 8f;
            oreThreshold = 0.86f;
            //emitLight = true;
            //lightRadius = 12f;
            //lightColor = SLPal.silviriumColor;
            variants = 1;
        }};

        //drills

        pelletDrill = new Drill("pelletDrill"){{
            requirements(Category.production, with(ZytheronItems.volcanite, 8));
            tier = 1;
            drillTime = 500;
            size = 1;
            //consumeLiquid(Liquids.water, 1f / 60f).boost();//Needs fix
        }};

        boulderDrill = new Drill("boulderDrill"){{
            requirements(Category.production, with( ZytheronItems.volcanite, 20, ZytheronItems.black, 12));
            tier = 2;
            drillTime = 420;
            size = 2;
            //consumeLiquid(Liquids.water, 3f / 60f).boost();Needs fix
        }};


        
        //turrets
           
        bullet = new ItemTurret("bullet"){{
            alwaysUnlocked = true;
            requirements(Category.turret, new ItemStack[]{
                new ItemStack(ZytheronItems.green, 15),
                new ItemStack(ZytheronItems.black, 15),
            });
            ammoTypes.putAll(
            ZytheronItems.green, new BasicBulletType(6f,10f){{
                ammoMultiplier = 5f;
                lifetime = 25;

                //Color
                frontColor = ZytheronColors.greenColor;
                backColor = ZytheronColors.greenColorDark;

                //Trail
                trailColor  = ZytheronColors.greenColorDark;
                trailLength = 6;

                //Size
                width = 6;
                height = 10;

                //Pierce
                pierce = pierceBuilding = true;
                pierceCap = 2;
            }});
            size = 1;
            recoil = 1f;
            reload = 50;
            inaccuracy = 4f;
            shootCone = 2f;
            maxAmmo = 12;
            rotateSpeed = 5f;
            range = 144;
            health = 300;
            flags = EnumSet.of(BlockFlag.turret);
            coolant = consumeCoolant(6f / 60);
            //shootEffect = SLFx.silviriumHit1Effect;
        }};

        dual = new ItemTurret("dual"){{
            alwaysUnlocked = true;
            requirements(Category.turret, new ItemStack[]{
                new ItemStack(ZytheronItems.green, 70),
                new ItemStack(ZytheronItems.black, 50),
            });
            ammoTypes.putAll(
            ZytheronItems.green, new BasicBulletType(6f,14f){{
                ammoMultiplier = 5f;
                lifetime = 34;

                //Color
                frontColor = ZytheronColors.greenColor;
                backColor = ZytheronColors.greenColorDark;

                //Trail
                trailColor  = ZytheronColors.greenColorDark;
                trailLength = 6;

                //Size
                width = 7;
                height = 11;

                //Pierce
                pierce = pierceBuilding = true;
                pierceCap = 2;
            }});
            size = 2;
            recoil = 1f;
            reload = 20;
            inaccuracy = 4f;
            shootCone = 2f;
            maxAmmo = 25;
            rotateSpeed = 4f;
            range = 200;
            health = 1000;
            flags = EnumSet.of(BlockFlag.turret);
            coolant = consumeCoolant(16f / 60);
            //shootEffect = SLFx.silviriumHit1Effect;

            shoot = new ShootBarrel(){{
                barrels = new float[]{
                1.5f, 0f, 0f,
                -1.5f, 0f, 0f,
                };
            }};

            recoils = 2;
            drawer = new DrawTurret(){{
                for(int i = 2; i > 0; i--){
                    int f = i;
                    parts.add(new RegionPart("-barrel-" + i){{
                        progress = PartProgress.recoil;
                        recoilIndex = f - 1;
                        under = true;
                        moveY = -2f;
                    }});
                }
            }};

        }};

        trocket = new ItemTurret("trocket"){{
            alwaysUnlocked = true;
            requirements(Category.turret, new ItemStack[]{
                new ItemStack(ZytheronItems.red, 35),
                new ItemStack(ZytheronItems.black, 20),
            });
            ammoTypes.putAll(
            ZytheronItems.red, new MissileBulletType(3f,35f){{
                ammoMultiplier = 3f;
                lifetime = 68f;

                //Color
                frontColor = ZytheronColors.redColor;
                backColor = ZytheronColors.redColorDark;

                //Size
                width = 9f;
                height = 10f;

                //Wave
                weaveScale = 2;
                weaveMag = 3;

                //Homing
                homingPower = 0.05f;
                homingRange = 80f;
                
            }});
            size = 1;
            recoil = 1f;
            reload = 60;
            inaccuracy = 1f;
            shootCone = 2f;
            maxAmmo = 5;
            rotateSpeed = 4f;
            range = 200;
            health = 300;
            flags = EnumSet.of(BlockFlag.turret);
            coolant = consumeCoolant(3f / 60);
            //shootEffect = SLFx.silviriumHit1Effect;
        }};


        silo = new ItemTurret("silo"){{
            alwaysUnlocked = true;
            requirements(Category.turret, new ItemStack[]{
                new ItemStack(ZytheronItems.red, 80),
                new ItemStack(ZytheronItems.black, 70),
            });
            ammoTypes.putAll(
            ZytheronItems.red, new MissileBulletType(4f,20f){{
                ammoMultiplier = 3f;
                lifetime = 60f;

                //Color
                frontColor = ZytheronColors.redColor;
                backColor = ZytheronColors.redColorDark;

                //Size
                width = 9f;
                height = 10f;

                //Area Damage
                splashDamageRadius = 2f * 8;
                splashDamage = 10f;

                //Wave
                weaveScale = 2;
                weaveMag = 3;

                //Homing
                homingPower = 0.05f;
                homingRange = 80f;
                
            }});
            size = 2;
            recoil = 1f;
            reload = 28;
            inaccuracy = 2f;
            shootCone = 2f;
            maxAmmo = 10;
            rotateSpeed = 3.6f;
            range = 236.8f;
            health = 1100;
            flags = EnumSet.of(BlockFlag.turret);
            coolant = consumeCoolant(14f / 60);
            //shootEffect = SLFx.silviriumHit1Effect;

            shoot = new ShootBarrel(){{
                barrels = new float[]{
                0f, 1f, 0f,
                3.3f, -1.5f, 0f,
                -3.3f, -1.5f, 0f,
                };
            }};

            recoils = 3;
            drawer = new DrawTurret(){{
                for(int i = 3; i > 0; i--){
                    int f = i;
                    parts.add(new RegionPart("-barrel-" + i){{
                        progress = PartProgress.recoil;
                        recoilIndex = f - 1;
                        under = true;
                        moveY = -2f;
                    }});
                }
            }};

        }};

            candle = new ItemTurret("candle"){{
            alwaysUnlocked = true;
            requirements(Category.turret, new ItemStack[]{
                new ItemStack(ZytheronItems.ignition, 40),
                new ItemStack(ZytheronItems.black, 15),
            });
            ammoTypes.putAll(
            ZytheronItems.ignition, new BulletType(3.35f, 20f){{
                    ammoMultiplier = 6f;
                    hitSize = 7f;
                    lifetime = 12f;
                    pierce = true;
                    collidesAir = false;
                    statusDuration = 60f * 4;
                    shootEffect = Fx.shootSmallFlame;
                    hitEffect = Fx.hitFlameSmall;
                    despawnEffect = Fx.none;
                    status = StatusEffects.burning;
                    hittable = false;
                }});
            size = 1;
            recoil = 0f;
            reload = 4.6f;
            inaccuracy = 4f;
            shootCone = 2f;
            maxAmmo = 20;
            rotateSpeed = 6f;
            range = 40;
            health = 600;
            targetAir = false;
            flags = EnumSet.of(BlockFlag.turret);
            coolant = consumeCoolant(8f / 60);
            //shootEffect = SLFx.silviriumHit1Effect;
        }};
     

        flame = new ItemTurret("flame"){{
            alwaysUnlocked = true;
            requirements(Category.turret, new ItemStack[]{
                new ItemStack(ZytheronItems.ignition, 100),
                new ItemStack(ZytheronItems.black, 80),
            });
            ammoTypes.putAll(
            ZytheronItems.ignition, new BulletType(3.35f, 28f){{
                    ammoMultiplier = 6f;
                    hitSize = 7f;
                    lifetime = 22f;
                    pierce = true;
                    collidesAir = false;
                    statusDuration = 60f * 5;
                    shootEffect = Fx.shootSmallFlame;
                    hitEffect = Fx.hitFlameSmall;
                    despawnEffect = Fx.none;
                    status = StatusEffects.burning;
                    hittable = false;
                }});
            size = 2;
            recoil = 0f;
            reload = 4f;
            inaccuracy = 4f;
            shootCone = 2f;
            maxAmmo = 35;
            rotateSpeed = 5f;
            range = 72;
            health = 1800;
            flags = EnumSet.of(BlockFlag.turret);
            targetAir = false;
            coolant = consumeCoolant(18f / 60);
            //shootEffect = SLFx.silviriumHit1Effect;
        }};
     
        //util
      
        greenWall = new Wall("greenWall"){{
            //alwaysUnlocked = true;
            requirements(Category.defense, new ItemStack[]{
                new ItemStack(ZytheronItems.green, 6),
            });
            health = 480;
            size = 1;
            //variants = 3;
        }};
        largeGreenWall = new Wall("largeGreenWall"){{
            //alwaysUnlocked = true;
            requirements(Category.defense, new ItemStack[]{
                new ItemStack(ZytheronItems.green, 24),
            });
            health = 1920;
            size = 2;
            //variants = 3;
        }};

        redWall = new Wall("redWall"){{
            //alwaysUnlocked = true;
            requirements(Category.defense, new ItemStack[]{
                new ItemStack(ZytheronItems.red, 6),
            });
            health = 600;
            size = 1;
            //variants = 3;
        }};
        largeRedWall = new Wall("largeRedWall"){{
            //alwaysUnlocked = true;
            requirements(Category.defense, new ItemStack[]{
                new ItemStack(ZytheronItems.red, 24),
            });
            health = 2400;
            size = 2;
            //variants = 3;
        }};


        //Logic

        script = new MessageBlock("script"){{
            requirements(Category.logic, with(ZytheronItems.volcanite, 6, ZytheronItems.green, 5));
        }};

        //Testing
        m5 = new MessageBlock("5"){{
            requirements(Category.logic, with(ZytheronItems.volcanite, 6, ZytheronItems.green, 5));
            maxTextLength = 5;
            maxNewlines = 24;        
        }};
        
        m200 = new MessageBlock("200"){{
            requirements(Category.logic, with(ZytheronItems.volcanite, 6, ZytheronItems.green, 5));
            maxTextLength = 600;
            maxNewlines = 24;  
        }};

        m600 = new MessageBlock("600"){{
            requirements(Category.logic, with(ZytheronItems.volcanite, 6, ZytheronItems.green, 5));
            maxTextLength = 600;
            maxNewlines = 24;  
        }};

        m2000 = new MessageBlock("2000"){{
            requirements(Category.logic, with(ZytheronItems.volcanite, 6, ZytheronItems.green, 5));
            maxTextLength = 2000;
            maxNewlines = 24;  
        }};


    }
    };
