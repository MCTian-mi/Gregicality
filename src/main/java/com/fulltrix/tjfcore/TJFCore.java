package com.fulltrix.tjfcore;

import com.fulltrix.tjfcore.item.TJFHeatingCoil;
import com.fulltrix.tjfcore.item.TJFMetaBlocks;
import com.fulltrix.tjfcore.machines.TJFTileEntities;
import gregtech.GTInternalTags;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import java.io.IOException;

import static com.fulltrix.tjfcore.item.TJFMetaBlocks.HEATING_COIL;
import static gregtech.api.GregTechAPI.HEATING_COILS;

@Mod(modid = TJFCore.MODID, name = TJFCore.NAME, version = TJFCore.VERSION,
        dependencies = GTInternalTags.DEP_VERSION_STRING)
public class TJFCore {
    public static final String MODID = Tags.MODID;
    public static final String NAME = Tags.MODNAME;
    public static final String VERSION = Tags.VERSION;
    @SidedProxy(modId = MODID, clientSide = "com.fulltrix.tjfcore.ClientProxy", serverSide = "com.fulltrix.tjfcore.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        proxy.preInit();
        TJFMetaBlocks.init();
        TJFTileEntities.init();

        for (TJFHeatingCoil.CoilType type : TJFHeatingCoil.CoilType.values()) {
            HEATING_COILS.put(HEATING_COIL.getState(type), type);
        }
    }

    @EventHandler
    // load "Do your mod setup. Build whatever data structures you care about." (Remove if not needed)
    public void init(FMLInitializationEvent event) throws IOException {
        proxy.onLoad();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        //CommonProxy.postInit();
    }

    @EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
    }

    static {
        FluidRegistry.enableUniversalBucket();
    }
}
