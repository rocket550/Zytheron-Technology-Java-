package planets;

import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import mindustry.maps.planet.*;
import mindustry.world.*;
import mindustry.content.*;

public class ZytheronGenerator extends PlanetGenerator {
    
    @Override
    public Color getColor(Vec3 position) {
        // Usamos ruido de Perlin para determinar qué hay en cada parte
        float noise = Simplex.noise3d(seed, 7, 0.5, 1/22.0, position.x, position.y, position.z);
        
        if(noise < -0.1f) return Color.valueOf("2b60de"); // Océano Profundo
        if(noise < 0.0f) return Color.valueOf("f7e09a");  // Arena (Costa)
        return Color.valueOf("808080");                   // Piedra (Montañas)
    }

    @Override
    public float getHeight(Vec3 position) {
        float noise = Simplex.noise3d(seed, 7, 0.5, 1/22.0, position.x, position.y, position.z);
        // Si el ruido es bajo, es un océano (altura negativa o baja)
        return Math.max(0, noise); 
    }

    @Override
    public void generateSector(Sector sector) {
        // Por ahora lo dejamos básico, pero aquí es donde se pondrían los bloques
    }
}
