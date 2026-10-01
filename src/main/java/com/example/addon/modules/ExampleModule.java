package com.example.addon.modules;

import com.example.addon.ExampleAddon;
import net.anubis.client.module.ClientModule;

public final class ExampleModule extends ClientModule {
    public ExampleModule() {
        super("Example Module", "Does nothing, just turns on and off.", ExampleAddon.CATEGORY);
    }
}
