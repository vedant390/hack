package com.example.cheatmenu;

import com.example.cheatmenu.modules.*;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        // Movement
        modules.add(new Fly());
        modules.add(new Speed());
        modules.add(new Sprint());
        modules.add(new Step());
        modules.add(new NoFall());
        // Visuals
        modules.add(new Fullbright());
        modules.add(new EntityGlow());
        // Utility
        modules.add(new AutoRespawn());
        modules.add(new AutoTool());
    }

    public List<Module> getModules() { return modules; }

    public List<Module> getByCategory(Module.Category category) {
        List<Module> out = new ArrayList<>();
        for (Module m : modules) if (m.getCategory() == category) out.add(m);
        return out;
    }

    public void tick() {
        for (Module m : modules) {
            if (m.isEnabled()) m.onTick();
        }
    }
}
