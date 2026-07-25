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
    stoneficator,

    //Ore
    greenOre, redOre, ignitionOre,

    //Turret
    bullet,dual,//Green
    trocket,//Red
    candle,//Fire

    //Drill
    pelletDrill, boulderDrill,

    //Wall
    greenWall, largeGreenWall;
    
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

        
        //unit factory
        /*
          Its a comment, for now
          silvFacT1 = new UnitFactory("silvirium-molder"){{
            alwaysUnlocked = true;
            requirements(Category.units, new ItemStack[]{
                new ItemStack(SLItems.silvirium, 200),
                new ItemStack(Items.lead, 40),
                new ItemStack(Items.silicon, 70)
            });
            size = 2;
            health = 220;
            consumePower(0f);
            consumeLiquid(SLliquids.liquidSilvirium, 0.5f);
            plans.addAll(
                new UnitPlan(
                    SLUnits.silvirror, 1200,
                    new ItemStack[]{
                      new ItemStack(SLItems.silvirium, 30),
                      new ItemStack(Items.silicon, 20)
                    }
                ),
                new UnitPlan(
                    SLUnits.silvone, 1200,
                    new ItemStack[]{
                      new ItemStack(SLItems.silvirium, 20),
                      new ItemStack(Items.silicon, 10)
                    }
                ),
                new UnitPlan(
                    SLUnits.silvioros, 1200,
                    new ItemStack[]{
                      new ItemStack(SLItems.silvirium, 20),
                      new ItemStack(Items.silicon, 10)
                    }
                ),
                new UnitPlan(
                    SLUnits.silvanon, 900,
                    new ItemStack[]{
                        new ItemStack(SLItems.silvirium, 25),
                        new ItemStack(SLItems.silviriumIng, 10),
                    }
                )
            );
        }};
        silvFacT2 = new Reconstructor("silvirium-remolder"){{
            alwaysUnlocked = true;
            requirements(Category.units, new ItemStack[]{
                new ItemStack(SLItems.silvirium, 200),
                new ItemStack(Items.metaglass, 40),
                new ItemStack(Items.silicon, 70),
                new ItemStack(Items.metaglass, 50)
            });
            size = 3;
            consumePower(0f);
            health = 495;
            consumeItems(new ItemStack[]{
                new ItemStack(SLItems.silvirium, 80),
                new ItemStack(Items.silicon, 40),
            });
            constructTime = 900f;
            addUpgrade(SLUnits.silvirror, SLUnits.silvokeor);
        }};
        
        silvFacT3 = new Reconstructor("silvirium-regrower"){{
            alwaysUnlocked = true;
            requirements(Category.units, new ItemStack[]{
                new ItemStack(SLItems.silvirium, 200),
                new ItemStack(Items.metaglass, 40),
                new ItemStack(Items.silicon, 70),
                new ItemStack(Items.metaglass, 50)
            });
            size = 4;
            consumePower(0f);
            health = 880;
            consumeItems(new ItemStack[]{
                new ItemStack(SLItems.silvirium, 200),
                new ItemStack(Items.silicon, 150),
            });
            constructTime = 1800f;
            addUpgrade(SLUnits.silvokeor, SLUnits.silvbane);
        }};
        
        silvFacT4 = new Reconstructor("silvirium-reforge"){{
            alwaysUnlocked = true;
            requirements(Category.units, new ItemStack[]{
                new ItemStack(SLItems.silvirium, 200),
                new ItemStack(Items.metaglass, 40),
                new ItemStack(Items.silicon, 70),
                new ItemStack(Items.metaglass, 50)
            });
            size = 5;
            consumePower(0f);
            health = 1375;
            consumeItems(new ItemStack[]{
                new ItemStack(SLItems.silvirium, 1200),
                new ItemStack(Items.silicon, 400),
            });
            constructTime = 2400f;
            addUpgrade(SLUnits.silvbane, SLUnits.silvruner);
        }};
        
        starFacT1 = new UnitFactory("star-molder"){{
            alwaysUnlocked = true;
            requirements(Category.units, new ItemStack[]{
                new ItemStack(SLItems.silvirium, 200),
                new ItemStack(Items.lead, 40),
                new ItemStack(Items.silicon, 70)
            });
            size = 2;
            health = 220;
            consumePower(0f);
            plans.addAll(
                new UnitPlan(
                    SLUnits.star1, 0,
                    new ItemStack[]{
                      new ItemStack(SLItems.starFrag, 30),
                      new ItemStack(Items.silicon, 20)
                    }
                )
            );
        }};*/
        //factory
      /*
        liqsilvfac = new GenericCrafter("liquid-silvirium-factory"){{
            alwaysUnlocked = true;
            requirements(Category.crafting, new ItemStack[]{
                new ItemStack(SLItems.silvirium, 200),
                new ItemStack(Items.metaglass, 40),
                new ItemStack(Items.silicon, 70),
                new ItemStack(SLItems.silviriumIng, 50)
            });
            outputLiquid = new LiquidStack(SLliquids.liquidSilvirium, 0.25f);
            size = 2;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            rotate = false;
            solid = true;
            outputsLiquid = true;
            envEnabled = Env.any;
            liquidCapacity = 12f;
            craftTime = 60;
            lightLiquid = SLliquids.liquidSilvirium;

            consumePower(0.5f);
            consumeItem(SLItems.silvirium);
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawLiquidRegion(SLliquids.liquidSilvirium){{
                suffix = "-liquid";
                }},
                new DrawRegion("-rot"){{
                        layer = 40.4f;
                        rotateSpeed = 10f;
                }},
                new DrawSoftParticles(){{
                        color = SLPal.silviriumColor;
                        color2 = SLPal.silviriumColor;
                        alpha = 0.3f;
                        particles = 7;
                        particleLife = 70f;
                        particleRad = 4f;
                        particleSize = 3f;
                        fadeMargin = 0.2f;
                        rotateScl = 0.1f;
                        particleInterp = Interp.one;
                }},
                new DrawRegion("-top"){{
                        layer = 40.5f;
                }}
            );
        }};
        */
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
            craftTime = 120;

            //consumePower(0.5f);
            consumeItem(ZytheronItems.ignition,2);
            outputItem = new ItemStack(ZytheronItems.black, 1);
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
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
            variants = 4;
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
            variants = 4;
        }};

        //drills

        pelletDrill = new Drill("pelletDrill"){{
            requirements(Category.production, with(ZytheronItems.green, 8));
            tier = 1;
            drillTime = 1300;
            size = 1;
            //consumeLiquid(Liquids.water, 1f / 60f).boost();
        }};

        boulderDrill = new Drill("boulderDrill"){{
            requirements(Category.production, with(ZytheronItems.black, 12, ZytheronItems.green, 20));
            tier = 2;
            drillTime = 300;
            size = 2;
            //consumeLiquid(Liquids.water, 3f / 60f).boost();
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
                lifetime = 25;
                //speed=6;
                width = 6;
                height = 10;
                //pierce = pierceBuilding = true;
                //pierceCap = 2;
                frontColor = ZytheronColors.greenColor;
                backColor = ZytheronColors.greenColorDark;
                //status = SLStatusEffects.disrupted;
                trailColor  = ZytheronColors.greenColorDark;
                trailLength = 6;
                //statusDuration = 300;
            }});
            size = 1;
            recoil = 1f;
            reload = 25;
            inaccuracy = 4f;
            shootCone = 2f;
            maxAmmo = 12;
            rotateSpeed = 5f;
            range = 144;
            health = 300;
            flags = EnumSet.of(BlockFlag.turret);
            //coolant = consume(new ConsumeLiquid(SLliquids.liquidSilvirium, 0.05f));
            //shootEffect = SLFx.silviriumHit1Effect;
        }};

        dual = new ItemTurret("dual"){{
            alwaysUnlocked = true;
            requirements(Category.turret, new ItemStack[]{
                new ItemStack(ZytheronItems.green, 110),
                new ItemStack(ZytheronItems.black, 80),
            });
            ammoTypes.putAll(
            ZytheronItems.green, new BasicBulletType(6f,10f){{
                lifetime = 25;
                //speed=6;
                width = 6;
                height = 10;
                //pierce = pierceBuilding = true;
                //pierceCap = 2;
                frontColor = ZytheronColors.greenColor;
                backColor = ZytheronColors.greenColorDark;
                //status = SLStatusEffects.disrupted;
                trailColor  = ZytheronColors.greenColorDark;
                trailLength = 6;
                //statusDuration = 300;
            }});
            size = 2;
            recoil = 1f;
            reload = 10;
            inaccuracy = 4f;
            shootCone = 2f;
            maxAmmo = 25;
            rotateSpeed = 4f;
            range = 200;
            health = 1000;
            flags = EnumSet.of(BlockFlag.turret);
            //coolant = consume(new ConsumeLiquid(SLliquids.liquidSilvirium, 0.05f));
            //shootEffect = SLFx.silviriumHit1Effect;

            shoot = new ShootBarrel(){{
                barrels = new float[]{
                1.5f, 0f, 0f,
                -1.5f, 0f, 0f,
                };
            }};

            recoils = 3;
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
            ZytheronItems.red, new MissileBulletType(3f,25){{
                ammoMultiplier = 1f;
                lifetime = 68;
                //speed=6;
                width = 10;
                height = 12;
                //pierce = pierceBuilding = true;
                //pierceCap = 2;
                frontColor = ZytheronColors.redColor;
                backColor = ZytheronColors.redColorDark;
                //status = SLStatusEffects.disrupted;
                //trailColor  = ZytheronColors.greenColorDark;
                //trailLength = 6;
                //statusDuration = 300;

                //Wave
                weaveScale = 4;
                weaveMag = 4;

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
            //coolant = consume(new ConsumeLiquid(SLliquids.liquidSilvirium, 0.05f));
            //shootEffect = SLFx.silviriumHit1Effect;
        }};

            candle = new ItemTurret("candle"){{
            alwaysUnlocked = true;
            requirements(Category.turret, new ItemStack[]{
                new ItemStack(ZytheronItems.ignition, 40),
                new ItemStack(ZytheronItems.black, 15),
            });
            ammoTypes.putAll(
            ZytheronItems.ignition, new BulletType(3.35f, 20f){{
                    ammoMultiplier = 3f;
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
            recoil = 1f;
            reload = 3.5f;
            inaccuracy = 4f;
            shootCone = 2f;
            maxAmmo = 20;
            rotateSpeed = 5f;
            range = 40;
            health = 600;
            flags = EnumSet.of(BlockFlag.turret);
            //coolant = consume(new ConsumeLiquid(SLliquids.liquidSilvirium, 0.05f));
            //shootEffect = SLFx.silviriumHit1Effect;
        }};
     
     
        //util
      
        greenWall = new Wall("greenWall"){{
            //alwaysUnlocked = true;
            requirements(Category.effect, new ItemStack[]{
                new ItemStack(ZytheronItems.green, 8),
            });
            health = 480;
            size = 1;
            //variants = 3;
        }};
        largeGreenWall = new Wall("largeGreenWall"){{
            //alwaysUnlocked = true;
            requirements(Category.effect, new ItemStack[]{
                new ItemStack(ZytheronItems.green, 32),
            });
            health = 1920;
            size = 2;
            //variants = 3;
        }};
    }
    };
