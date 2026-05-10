package planets;

import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.noise.*; // IMPORTANTE: Para Simplex
import mindustry.maps.planet.*;
import mindustry.type.*; // IMPORTANTE: Para Sector
import mindustry.world.*;
import mindustry.content.*;

public class ZytheronGenerator extends PlanetGenerator {
    
    @Override
    public Color getColor(Vec3 position) {
        // Usamos la semilla del planeta (this.planet.seed)
        float noise = Simplex.noise3d(this.planet.seed, 7, 0.5, 1/22.0, position.x, position.y, position.z);
        
        if(noise < -0.1f) return Color.valueOf("2b60de"); // Océano
        if(noise < 0.0f) return Color.valueOf("f7e09a");  // Arena
        return Color.valueOf("808080");                   // Piedra
    }

    @Override
    public float getHeight(Vec3 position) {
        float noise = Simplex.noise3d(this.planet.seed, 7, 0.5, 1/22.0, position.x, position.y, position.z);
        return Math.max(0, noise); 
    }

    @Override
    public void generateSector(Sector sector) {
        // Por ahora vacío para que compile
    }
}
