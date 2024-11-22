import mods.gregtech.macerator
import mods.gregtech.extractor
import mods.gregtech.mixer
extractor.removeByInput(2, [metaitem('rubber_drop')], null)
extractor.removeByInput(2, [item('gregtech:rubber_leaves') * 16], null)
extractor.removeByInput(2, [item('gregtech:rubber_log')], null)
extractor.removeByInput(2, [item('gregtech:rubber_sapling')], null)
extractor.removeByInput(2, [item('minecraft:slime_ball')], null)
furnace.removeByInput(item('industrialforegoing:dryrubber'))
macerator.recipeBuilder()
    .inputs(item('industrialforegoing:dryrubber'))
    .outputs(ore('dustRawRubber')[0])
    .duration(5)
    .EUt(2)
    .buildAndRegister();