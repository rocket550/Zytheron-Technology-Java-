package zytheron.content;

import arc.func.*;
import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.game.*;
import mindustry.graphics.*;
import mindustry.graphics.g3d.*;
import mindustry.graphics.g3d.PlanetGrid.*;
import mindustry.maps.planet.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.content.*; // Importante para Planets.sun
import mindustry.world.meta.*;

// ERROR 1 CORREGIDO: Todo debe estar dentro de una clase
public class ZytheronPlanet {
    
    public static Planet zytheron; // Cambiado a minúscula por convención, pero puede ser Zytheron

    public static void load() {
        // ERROR 2 y 3 CORREGIDOS: Se cerró la comilla, se agregó la coma y se usó el nombre de variable correcto
        zytheron = new Planet("zytheron", Planets.sun, 1f, 3) {{
            
            // Generador (Asegúrate de que la clase ZytheronGenerator exista)
            generator = new ZytheronGenerator();
            
            // Visuales
            meshLoader = () -> new HexMesh(this, 5);
            atmosphereColor = Color.valueOf("32a852"); 
            iconColor = Color.valueOf("32a852");
            
            // Configuración de campaña
            startSector = 15;
            alwaysUnlocked = true;
            accessible = true; // Añadido para que puedas clickearlo
            
            // Reglas
            ruleSetter = rule -> {
                rule.waveTeam = Team.crux;
                rule.lighting = true; 
            };
        }};
    }
}
