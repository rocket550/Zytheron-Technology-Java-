package example;

import arc.Core;
import arc.Events;
import arc.util.Log;
import arc.util.Time;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;
//melis: Troket, you forget the imports
import content.units.ZytheronUnits;

public class ZytheronTechnology extends Mod{

    public ZytheronTechnology(){
    Events.on(ClientLoadEvent.class, e -> {
            Time.runTask(30f, () -> {
                BaseDialog dialog = new BaseDialog("Hello message");
                dialog.cont.add("Welcome to Zytheron").row();
                dialog.cont.image(Core.atlas.find("zytheron-icon")).pad(40f).row();
                dialog.cont.button("Close", dialog::hide).size(150f,75f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        //and the load
        ZytheronUnits.load();
    }

}
