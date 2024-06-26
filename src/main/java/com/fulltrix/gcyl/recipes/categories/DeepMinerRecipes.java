package com.fulltrix.gcyl.recipes.categories;

import com.fulltrix.gcyl.recipes.recipeproperties.GCYLScanProperty;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.chance.output.ChancedOutputLogic;
import gregtech.api.recipes.ingredients.nbtmatch.NBTCondition;
import gregtech.api.recipes.ingredients.nbtmatch.NBTMatcher;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.util.GTUtility;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stanhebben.zenscript.annotations.Optional;

import java.util.Map;

import static com.fulltrix.gcyl.materials.GCYLMaterials.*;
import static com.fulltrix.gcyl.item.GCYLCoreItems.TOOL_DATA_DEEP_MINER;
import static com.fulltrix.gcyl.recipes.GCYLRecipeMaps.DEEP_MINER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class DeepMinerRecipes {

    public static final String RESEARCH_NBT_TAG = "minerDataResearch";

    public static final String RESEARCH_ID_NBT_TAG = "researchId";


    public static Map<String, ItemStack> minerScanMap = new Object2ObjectOpenHashMap<>();
    public static Map<ItemStack, String> infoMap = new Object2ObjectOpenHashMap<>();

    public static void init() {

        // Miner Data Stick
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(ADVANCED_CIRCUIT_BOARD)
                .input(circuit, MarkerMaterials.Tier.HV, 2)
                .input(POWER_INTEGRATED_CIRCUIT, 4)
                .input(NOR_MEMORY_CHIP, 16)
                .input(NAND_MEMORY_CHIP, 32)
                .input(wireFine, HVSuperconductor, 32)
                .output(TOOL_DATA_DEEP_MINER)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(400).EUt(400).buildAndRegister();


        createResearchRecipe("deep_rutile", OreDictUnifier.get(block, Titanium), null,TOOL_DATA_DEEP_MINER.getStackForm(), true, 300, 512, 0);
        createResearchRecipe("deep_pyrochlore", OreDictUnifier.get(block, Niobium),null, TOOL_DATA_DEEP_MINER.getStackForm(), true, 300, 512, 0);
        createResearchRecipe("deep_diamond", OreDictUnifier.get(block, Diamond), null,TOOL_DATA_DEEP_MINER.getStackForm(), true, 300, 512, 0);
        createResearchRecipe("deep_aluminium", OreDictUnifier.get(block, Aluminium),null,TOOL_DATA_DEEP_MINER.getStackForm(), true, 300, 512, 0);
        createResearchRecipe("deep_platinum", OreDictUnifier.get(block, Platinum),null, TOOL_DATA_DEEP_MINER.getStackForm(), true, 300, 1920, 0);

        createResearchRecipe("deep_salts", OreDictUnifier.get(block, Salt),HydrofluoricAcid.getFluid(16000), TOOL_DATA_DEEP_MINER.getStackForm(), true, 300, 1920, 0);

        createResearchRecipe( "deep_exotics", OreDictUnifier.get(block, Enderium), null, TOOL_DATA_DEEP_MINER.getStackForm(), true, 300, 1920, 0);


        DEEP_MINER_RECIPES.recipeBuilder()
                .notConsumable(minerScanMap.get("deep_diamond"))
                .circuitMeta(0)
                .input(SENSOR_HV)
                .input(ELECTRIC_PISTON_HV)

                .fluidInputs(DrillingFluid.getFluid(32000))
                .output(ore, Coal, 64)
                .output(ore, Diamond, 16)
                .chancedOutput(ore, Coal, 64,100,2000)
                .chancedOutput(ore, Diamond, 16,100,2000)
                .chancedOutput(ore, Coal, 64,100,500)
                .chancedOutput(ore, Diamond, 16,100,500)
                .duration(4000)
                .EUt(480)
                .temperature(2500)
                .dimension(0)
                .buildAndRegister();


        DEEP_MINER_RECIPES.recipeBuilder()
                .notConsumable(minerScanMap.get("deep_pyrochlore"))
                .circuitMeta(0)
                .input(SENSOR_HV)
                .input(ELECTRIC_PISTON_HV)

                .fluidInputs(DrillingFluid.getFluid(32000))
                .output(ore, Pyrochlore, 64)
                .output(ore, Columbite, 64)
                .chancedOutput(ore, Pyrochlore, 64,100,2000)
                .chancedOutput(ore, Columbite, 64,100,2000)
                .chancedOutput(ore, Pyrochlore, 64,100,500)
                .chancedOutput(ore, Columbite, 64,100,500)
                .duration(4000)
                .EUt(480)
                .temperature(2500)
                .dimension(0)
                .buildAndRegister();

        DEEP_MINER_RECIPES.recipeBuilder()
                .notConsumable(minerScanMap.get("deep_aluminium"))
                .circuitMeta(0)
                .input(SENSOR_HV)
                .input(ELECTRIC_PISTON_HV)

                .fluidInputs(DrillingFluid.getFluid(32000))
                .output(ore, Bauxite, 64)
                .output(ore, Aluminium, 32)
                .output(ore, Gallite, 32)
                .chancedOutput(ore, Bauxite, 64,100,2000)
                .chancedOutput(ore, Aluminium, 32,100,2000)
                .chancedOutput(ore, Aluminium, 32,100,2000)
                .chancedOutput(ore, Bauxite, 64,100,500)
                .chancedOutput(ore, Rutile, 32,100,500)
                .chancedOutput(ore, Gallite, 32,100,500)
                .duration(4000)
                .EUt(480)
                .temperature(2500)
                .dimension(0)
                .buildAndRegister();

        DEEP_MINER_RECIPES.recipeBuilder()
                .notConsumable(minerScanMap.get("deep_rutile"))
                .circuitMeta(0)
                .input(SENSOR_HV)
                .input(ELECTRIC_PISTON_HV)

                .fluidInputs(DrillingFluid.getFluid(32000))
                .output(ore, Bauxite, 64)
                .output(ore, Rutile, 32)
                .chancedOutput(ore, Bauxite, 64,100,2000)
                .chancedOutput(ore, Rutile, 32,100,2000)
                .chancedOutput(ore, Bauxite, 64,100,500)
                .chancedOutput(ore, Rutile, 32,100,500)
                .duration(4000)
                .EUt(480)
                .temperature(2500)
                .dimension(0)
                .buildAndRegister();

        DEEP_MINER_RECIPES.recipeBuilder()
                .notConsumable(minerScanMap.get("deep_platinum"))
                .circuitMeta(0)
                .input(SENSOR_EV)
                .input(ELECTRIC_PISTON_EV)

                .fluidInputs(DrillingFluid.getFluid(64000))
                .output(ore, PlatinumMetallicPowder, 64)
                .output(ore, PalladiumMetallicPowder, 64)
                .chancedOutput(ore, PlatinumMetallicPowder, 64,100,2000)
                .chancedOutput(ore, PalladiumMetallicPowder, 64,100,2000)
                .chancedOutput(ore, PlatinumMetallicPowder, 64,100,500)
                .chancedOutput(ore, PalladiumMetallicPowder, 64,100,500)
                .duration(4000)
                .EUt(1920)
                .temperature(4500)
                .dimension(0)
                .buildAndRegister();

        DEEP_MINER_RECIPES.recipeBuilder()
                .notConsumable(minerScanMap.get("deep_exotics"))
                .circuitMeta(1)
                .input(SENSOR_EV)
                .input(ELECTRIC_PISTON_EV)

                .fluidInputs(DrillingFluid.getFluid(64000))
                .output(ore, NetherStar, 16)
                .chancedOutput(ore, NetherStar, 16,100,2000)
                .chancedOutput(ore, NetherStar, 16,100,500)
                .duration(4000)
                .EUt(1920)
                .temperature(4500)
                .dimension(-1)
                .buildAndRegister();


        DEEP_MINER_RECIPES.recipeBuilder()
                .notConsumable(minerScanMap.get("deep_salts"))
                .circuitMeta(1)
                .input(SENSOR_IV)
                .input(ELECTRIC_PUMP_IV)

                .fluidInputs(DrillingFluid.getFluid(128000))
                .fluidInputs(NitricAcid.getFluid(16000))
                .fluidOutputs(Chlorine.getFluid(64000))
                .chancedFluidOutput(Chlorine.getFluid(64000), 100, 2000)
                .chancedFluidOutput(Chlorine.getFluid(64000), 100, 500)
                .duration(4000)
                .EUt(7860)
                .temperature(4500)
                .dimension(-1)
                .buildAndRegister();

        DEEP_MINER_RECIPES.recipeBuilder()
                .notConsumable(minerScanMap.get("deep_salts"))
                .circuitMeta(2)
                .input(SENSOR_IV)
                .input(ELECTRIC_PUMP_IV)

                .fluidInputs(DrillingFluid.getFluid(128000))
                .fluidInputs(NitricAcid.getFluid(16000))
                .fluidOutputs(Fluorine.getFluid(64000))
                .chancedFluidOutput(Fluorine.getFluid(64000), 100, 2000)
                .chancedFluidOutput(Fluorine.getFluid(64000), 100, 500)
                .duration(4000)
                .EUt(7860)
                .temperature(4500)
                .dimension(-1)
                .buildAndRegister();

        DEEP_MINER_RECIPES.recipeBuilder()
                .notConsumable(minerScanMap.get("deep_salts"))
                .circuitMeta(1)
                .input(SENSOR_IV)
                .input(ELECTRIC_PISTON_IV)

                .fluidInputs(DrillingFluid.getFluid(128000))
                .fluidInputs(NitricAcid.getFluid(16000))
                .output(ore, Salt, 32)
                .chancedOutput(ore, Salt, 32, 100, 2000)
                .chancedOutput(ore, Salt, 32, 100, 500)
                .output(ore, Fluorite,32)
                .chancedOutput(ore, Fluorite, 32, 100, 2000)
                .chancedOutput(ore, Fluorite, 32, 100, 500)
                .output(ore, Lepidolite, 8)
                .chancedOutput(ore, Lepidolite, 8, 100, 2000)
                .chancedOutput(ore, Lepidolite, 8, 100, 500)
                .output(ore, Spodumene, 8)
                .chancedOutput(ore, Spodumene, 8, 100, 2000)
                .chancedOutput(ore, Spodumene, 8, 100, 500)
                .duration(4000)
                .EUt(7860)
                .temperature(4500)
                .dimension(-1)
                .buildAndRegister();

        DEEP_MINER_RECIPES.recipeBuilder()
                .notConsumable(minerScanMap.get("deep_salts"))
                .circuitMeta(1)
                .input(SENSOR_IV)
                .input(ELECTRIC_PISTON_IV)

                .fluidInputs(DrillingFluid.getFluid(128000))
                .fluidInputs(NitricAcid.getFluid(16000))
                .output(ore, Salt, 32)
                .chancedOutput(ore, Salt, 32, 100, 2000)
                .chancedOutput(ore, Salt, 32, 100, 500)
                .output(ore, Fluorite,32)
                .chancedOutput(ore, Fluorite, 32, 100, 2000)
                .chancedOutput(ore, Fluorite, 32, 100, 500)
                .output(ore, Lepidolite, 8)
                .chancedOutput(ore, Lepidolite, 8, 100, 2000)
                .chancedOutput(ore, Lepidolite, 8, 100, 500)
                .output(ore, Spodumene, 8)
                .chancedOutput(ore, Spodumene, 8, 100, 2000)
                .chancedOutput(ore, Spodumene, 8, 100, 500)
                .duration(4000)
                .EUt(7860)
                .temperature(4500)
                .dimension(0)
                .buildAndRegister();

        DEEP_MINER_RECIPES.recipeBuilder()
                .notConsumable(minerScanMap.get("deep_exotics"))
                .circuitMeta(1)
                .input(SENSOR_IV)
                .input(ELECTRIC_PISTON_IV)

                .fluidInputs(DrillingFluid.getFluid(128000))
                .fluidInputs(NitricAcid.getFluid(32000))
                .output(ore, NaquadricCompound, 64)
                .chancedOutput(ore, NaquadricCompound, 64, 100, 2000)
                .chancedOutput(ore, NaquadricCompound, 64, 100, 500)
                .output(ore, EnrichedNaquadricCompound,64)
                .chancedOutput(ore, EnrichedNaquadricCompound, 64, 100, 2000)
                .chancedOutput(ore, EnrichedNaquadricCompound, 64, 100, 500)
                .output(ore, NaquadriaticCompound, 32)
                .chancedOutput(ore, NaquadriaticCompound, 32, 100, 2000)
                .chancedOutput(ore, NaquadriaticCompound, 32, 100, 500)
                .duration(4000)
                .EUt(7860)
                .temperature(5400)
                .dimension(0)
                .buildAndRegister();

        }


    public static void createResearchRecipe(@NotNull String researchId, @NotNull ItemStack researchItem, FluidStack fluid,
                                                   @NotNull ItemStack dataItem, boolean ignoreNBT, int duration,
                                                   int EUt, int CWUt) {

        NBTTagCompound compound = GTUtility.getOrCreateNbtCompound(dataItem);
        writeResearchToNBT(compound, researchId);

        dataItem.setTagCompound(compound);

        dataItem.setStackDisplayName(I18n.format("gcyl.research."+researchId));

        if (CWUt > 0) {
            RecipeBuilder<?> researchBuilder = RecipeMaps.RESEARCH_STATION_RECIPES.recipeBuilder()
                    .inputNBT(dataItem.getItem(), 1, dataItem.getMetadata(), NBTMatcher.ANY, NBTCondition.ANY)
                    .outputs(dataItem)
                    .EUt(EUt)
                    .CWUt(CWUt)
                    .totalCWU(duration);

            if (ignoreNBT) {
                researchBuilder.inputNBT(researchItem.getItem(), 1, researchItem.getMetadata(), NBTMatcher.ANY,
                        NBTCondition.ANY);
            } else {
                researchBuilder.inputs(researchItem);
            }

            researchBuilder.buildAndRegister();
        } else {
            RecipeBuilder<?> builder = RecipeMaps.SCANNER_RECIPES.recipeBuilder()
                    .inputNBT(dataItem.getItem(), 1, dataItem.getMetadata(), NBTMatcher.ANY, NBTCondition.ANY)
                    .outputs(dataItem)
                    .duration(duration)
                    .EUt(EUt);

            if (ignoreNBT) {
                builder.inputNBT(researchItem.getItem(), 1, researchItem.getMetadata(), NBTMatcher.ANY,
                        NBTCondition.ANY);
                if (fluid != null) {
                    builder.fluidInputs(fluid);
                }
            } else {
                builder.inputs(researchItem);
                if (fluid != null) {
                    builder.fluidInputs(fluid);
                }
            }

            builder.applyProperty(GCYLScanProperty.getInstance(), true);
            builder.buildAndRegister();
        }

        minerScanMap.put(researchId, dataItem);
        infoMap.put(dataItem, researchId);

    }

    @Nullable
    public static String readResearchId(@NotNull ItemStack stack) {
        NBTTagCompound compound = stack.getTagCompound();
        if (!hasResearchTag(compound)) return null;

        NBTTagCompound researchCompound = compound.getCompoundTag(RESEARCH_NBT_TAG);
        String researchId = researchCompound.getString(RESEARCH_ID_NBT_TAG);
        return researchId.isEmpty() ? null : researchId;
    }

    private static boolean hasResearchTag(@Nullable NBTTagCompound compound) {
        if (compound == null || compound.isEmpty()) return false;
        return compound.hasKey(RESEARCH_NBT_TAG, Constants.NBT.TAG_COMPOUND);
    }

    private static void writeResearchToNBT(@NotNull NBTTagCompound stackCompound, @NotNull String researchId) {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setString("researchId", researchId);
        stackCompound.setTag("minerDataResearch", compound);
    }

}
