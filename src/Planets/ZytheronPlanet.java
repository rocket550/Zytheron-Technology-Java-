package planets;

import arc.graphics.*;
import mindustry.type.*;
import mindustry.graphics.g3d.*;
import mindustry.content.*;
import mindustry.game.*;
import mindustry.maps.planet.*;

public class ZytheronPlanet {
    public static Planet zytheron;

    public static void load() {
        zytheron = new Planet("zytheron", Planets.sun, 1f, 3) {{
            generator = new ZytheronGenerator();
            
            meshLoader = () -> new MultiMesh(
                // Capa 1: Tierra (Piedra y Arena)
                new NoiseMesh(this, 15, 6, 1f, 3, 0.5f, 0.4f, 15f, 
                    Color.valueOf("808080"), Color.valueOf("f7e09a"), 4, 0.5f, 0.4f, 0.5f),
                
                // Capa 2: Océano (Una esfera azul apenas más pequeña para que se vea el relieve)
                new NoiseMesh(this, 1, 1, 0.99f, 0, 0f, 0f, 0f, 
                    Color.valueOf("2b60de").a(0.8f), Color.valueOf("1e419b").a(0.8f), 2, 0.5f, 0.4f, 0.5f)
            );

            atmosphereColor = Color.valueOf("87ceeb"); 
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.35f;
            
            iconColor = Color.valueOf("808080"); 
            startSector = 15;
            alwaysUnlocked = true;
            accessible = true;
            
            ruleSetter = rule -> {
                rule.waveTeam = Team.crux;
                rule.lighting = true;
            };
        }};
    }
}
