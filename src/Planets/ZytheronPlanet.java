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
            
            // MESH: Aquí definimos el aspecto visual desde el espacio
            meshLoader = () -> new MultiMesh(
                // Capa 1: El cuerpo del planeta (Piedra y Arena)
                new NoiseMesh(this, 15, 6, 1f, 3, 0.5f, 0.4f, 15f, 
                    Color.valueOf("808080"), // Gris piedra
                    Color.valueOf("f7e09a"), // Arena claro
                    4, 0.5f, 0.4f, 0.5f),
                
                // Capa 2: Los océanos (Un poco más pequeños para que la tierra sobresalga)
                // Usamos una esfera azul semi-transparente o un HexMesh azulado
                new HexMesh(this, 5) {{
                    color1 = Color.valueOf("2b60de").a(0.8f); // Azul océano
                    color2 = Color.valueOf("1e419b").a(0.8f);
                }}
            );

            // ATMÓSFERA: Celeste
            atmosphereColor = Color.valueOf("87ceeb"); // Celeste cielo (Sky Blue)
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.35f; // Una atmósfera un poco gruesa para que luzca bien
            
            // ICONO Y UI
            iconColor = Color.valueOf("808080"); 
            landCloudColor = Color.valueOf("87ceeb").a(0.4f);

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
