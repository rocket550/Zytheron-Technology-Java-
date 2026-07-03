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

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class ZytheronBlocks {
    public static Block
    greenConveyor, basicJunction, basicRouter, basicSorter, basicInvertedSorter, basicOverflowGate, basicUnderflowGate,
    stoneficator,
    //silvFacT1, silvFacT2, silvFacT3, silvFacT4,starFacT1,
    greenOre, redOre, blackOre,
    bullet,
    pelletDrill, boulderDrill;
    //decoy;
    
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
            requirements(Category.distribution, with(ZytheronItems.black, 2, ZytheronItems.green, 2));
            health = 60;
            buildCostMultiplier = 3f;
        }};

        basicInvertedSorter = new Sorter("basicInvertedSorter"){{
            requirements(Category.distribution, with(ZytheronItems.black, 2, ZytheronItems.green, 2));
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
            consumeItem(ZytheronItems.blackOre,2);
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

        blackOre = new OreBlock("blackOre", ZytheronItems.blackOre){{
            alwaysUnlocked = true;
            oreDefault = true;
            oreScale = 11f;
            oreThreshold = 0.8f;
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
            size = 1;
            //consumeLiquid(Liquids.water, 3f / 60f).boost();
        }};


        
        //turrets
           
        bullet = new ItemTurret("bullet"){{
            alwaysUnlocked = true;
            requirements(Category.turret, new ItemStack[]{
                new ItemStack(ZytheronItems.green, 15),
            });
            ammoTypes.putAll(
            ZytheronItems.green, new BasicBulletType(2f,11f){{
                lifetime = 51;
                width = 6;
                height = 10;
                //pierce = pierceBuilding = true;
                //pierceCap = 2;
                /*frontColor = SLPal.silviriumColor;
                backColor = SLPal.silviriumColor;
                status = SLStatusEffects.disrupted;
                trailColor  = SLPal.silviriumColor;
                trailLength = 6;
                statusDuration = 300;*/
            }});
            size = 1;
            recoil = 1f;
            reload = 30f;
            inaccuracy = 0f;
            shootCone = 2f;
            maxAmmo = 10;
            rotateSpeed = 5f;
            range = 100f;
            health = 240;
            flags = EnumSet.of(BlockFlag.turret);
            //coolant = consume(new ConsumeLiquid(SLliquids.liquidSilvirium, 0.05f));
            //shootEffect = SLFx.silviriumHit1Effect;
        }};
        };
        //util
      /*
        decoy = new Wall("decoy"){{
            alwaysUnlocked = true;
            requirements(Category.effect, new ItemStack[]{
                new ItemStack(Items.silicon, 80),
                new ItemStack(Items.copper, 50),
                new ItemStack(Items.graphite, 30)
            });
            health = 100;
            priority = 8;
            flags = EnumSet.of(BlockFlag.all);
            variants = 3;
        }};*/
    }
