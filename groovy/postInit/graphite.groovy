import mods.gregtech.electric_blast_furnace;
import mods.gregtech.extruder;
import mods.gregtech.alloy_smelter
import mods.gregtech.compressor
import mods.gregtech.mixer
def orePrefixes=['ingot','stick','stickLong','plate','foil','block']
for(entry in orePrefixes)
{
    electric_blast_furnace.recipeBuilder()
        .inputs(ore(entry+'RawGraphite'))
        .fluidInputs(fluid('nitrogen')*1000)
        .outputs(ore(entry+'Graphite')[0])
        .blastFurnaceTemp(1750)
        .EUt(120)
        .duration(600)
        .buildAndRegister()
}
// 长石墨杆 * 1
extruder.removeByInput(64, [metaitem('dustGraphite'), metaitem('shape.extruder.rod_long')], null)
extruder.removeByInput(24, [metaitem('dustGraphite'), metaitem('shape.extruder.foil')], null)
extruder.removeByInput(28, [metaitem('dustGraphite'), metaitem('shape.extruder.ingot')], null)
// gregtech_dingjen.material.raw_graphite条 * 1
alloy_smelter.removeByInput(7, [metaitem('nuggetRawGraphite') * 9, metaitem('shape.mold.ingot')], null)
alloy_smelter.removeByInput(7, [ore('blockRawGraphite')[0], metaitem('shape.mold.ingot')], null)
alloy_smelter.removeByInput(7, [metaitem('ingotRawGraphite'), metaitem('shape.mold.nugget')], null)
alloy_smelter.removeByInput(7, [ore('blockGraphite')[0], metaitem('shape.mold.ingot')], null)
alloy_smelter.removeByInput(7, [metaitem('nuggetGraphite') * 9, metaitem('shape.mold.ingot')], null)
alloy_smelter.removeByInput(7, [metaitem('ingotGraphite'), metaitem('shape.mold.nugget')], null)
compressor.removeByInput(2, [metaitem('ingotGraphite') * 9], null)
mixer.recipeBuilder()
    .inputs(ore('dustGraphite'))
    .fluidInputs(fluid('rubber')*144)
    .outputs(ore('dustRawGraphite')[0])
    .EUt(30)
    .duration(200)
    .buildAndRegister()