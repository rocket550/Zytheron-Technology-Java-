package content;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.UnitSorts;
import mindustry.entities.bullet.*;
import mindustry.entities.part.RegionPart;
import mindustry.gen.*;
import mindustry.graphics.Layer;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.LiquidTurret;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.blocks.units.Reconstructor;
import mindustry.world.consumers.*;
import arc.graphics.*;
import arc.struct.EnumSet;
import arc.util.Time;
import arc.math.Interp;
import arc.math.Mathf;
import mindustry.type.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;


public class ZytheronBlocks {
    public static Block
    //liqsilvfac,silvingfac,starfac,
    //silvFacT1, silvFacT2, silvFacT3, silvFacT4,starFacT1,
    //silvOre,
    bullet;
    //decoy;
    
    public static void load(){
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
        
        silvingfac = new GenericCrafter("silvirium-ingot-factory"){{
            alwaysUnlocked = true;
            requirements(Category.crafting, new ItemStack[]{
                new ItemStack(SLItems.silvirium, 100),
                new ItemStack(Items.metaglass, 10),
                new ItemStack(Items.silicon, 50),
            });
            size = 2;
            hasPower = true;
            hasItems = true;
            rotate = false;
            solid = true;
            envEnabled = Env.any;
            itemCapacity = 16;
            craftTime = 600;

            consumePower(0.5f);
            consumeItem(SLItems.silvirium,4);
            outputItem = new ItemStack(SLItems.silviriumIng, 1);
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};
        
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
      /*
        silvOre = new OreBlock("ore-silvirium", SLItems.silvirium){{
            alwaysUnlocked = true;
            status = SLStatusEffects.disrupted;
            statusDuration = 300f;
            speedMultiplier = 0.6f;
            oreDefault = true;
            oreScale = 9f;
            oreThreshold = 0.7f;
            emitLight = true;
            lightRadius = 12f;
            lightColor = SLPal.silviriumColor;
            variants = 2;
        }};*/
        //turrets
           
        bullet = new ItemTurret("bullet"){{
            alwaysUnlocked = true;
            requirements(Category.turret, new ItemStack[]{
                new ItemStack(ZytheronItems.Green, 15),
            });
            ammoTypes.putAll(
            ZytheronItems.Green, new BasicBulletType(2f,11f){{
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
