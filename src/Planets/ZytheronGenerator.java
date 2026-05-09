package zytheron.content;

import mindustry.maps.planet.*;
import mindustry.world.*;
import mindustry.content.*;

public class ZytheronGenerator extends PlanetGenerator {
    // Esto es lo mínimo para que funcione
    @Override
    public void generateSector(Sector sector) {
        // Por ahora, esto generará un sector vacío o básico
    }

    @Override
    public float getHeight(Vec3 position) {
        return 0; // Terreno plano
    }

    @Override
    public Color getColor(Vec3 position) {
        return Blocks.stone.mapColor; // Color de piedra por defecto
    }
}
