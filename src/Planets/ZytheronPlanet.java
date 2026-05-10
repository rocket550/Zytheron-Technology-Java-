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
                // CAPA 1: El suelo (Piedra, Arena y Fondo Marino)
                new NoiseMesh(this, 15, 6, 1f, 3, 0.5f, 0.4f, 15f, 
                    Color.valueOf("808080"), Color.valueOf("f7e09a"), 4, 0.5f, 0.4f, 0.5f),
                
                // CAPA 2: El Agua Transparente
                // Usamos 0.995f de radio para que esté "pegada" al suelo
                new NoiseMesh(this, 1, 1, 0.995f, 0, 0f, 0f, 0f, 
                    Color.valueOf("2b60de").a(0.4f), // Azul con 40% de opacidad
                    Color.valueOf("1e419b").a(0.4f), 
                    2, 0.5f, 0.4f, 0.5f)
            );

            // Atmósfera celeste
            atmosphereColor = Color.valueOf("87ceeb"); 
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            
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
