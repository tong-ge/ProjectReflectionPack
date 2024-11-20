import mods.gregtech.bender;
import mods.gregtech.extractor;
import mods.gregtech.fluid_solidifier;
import mods.gregtech.compressor;
import mods.gregtech.extruder;
import mods.gregtech.electrolyzer;
import mods.gregtech.electric_blast_furnace;
import mods.gregtech.circuit_assembler;
import mods.extendedcrafting.table_crafting;
// Hot Graham Cracker Dough Chunk * 1
bender.removeByInput(45, [metaitem('gregtechfoodoption:matter_graham_hot_crushed'), metaitem('circuit.integrated').withNbt(['Configuration': 1])], null)
print(ore == null)
extractor.recipeBuilder()
    .inputs(ore('dustMatterGraham')*16)
    .outputs(ore('dustWheat')[0]*3)
    .fluidOutputs(fluid('gtfo_butter')*2000)
    .EUt(96)
    .duration(400)
    .buildAndRegister();
//crafting.removeByOutput(ore('blockGlowstone'));
fluid_solidifier.removeByInput(7, [metaitem('shape.mold.block')], [fluid('glowstone') * 576])
compressor.removeByInput(2, [item('minecraft:glowstone_dust') * 4], null)
extruder.recipeBuilder()
    .outputs(item('minecraft:glowstone'))
    .inputs(ore('dustGlowstone')*4)
    .notConsumable(metaitem('shape.extruder.block'))
    .EUt(120)
    .duration(150)
    .buildAndRegister()

// 镁粉 * 1
electrolyzer.removeByInput(30, [metaitem('dustMagnalium') * 3], null)
electrolyzer.removeByInput(30, [metaitem('dustSapphire') * 5], null)
electrolyzer.removeByInput(30, [metaitem('dustGreenSapphire') * 5], null)
// 铂粉 * 3
electrolyzer.removeByInput(60, [metaitem('dustCooperite') * 6], null)
electrolyzer.recipeBuilder()
    .inputs(ore('dustCooperite')*6)
    .outputs(ore('dustMetallicPlatinum')[0]*6,ore('dustMetallicPalladium')[0]*4,ore('dustNickel')[0],ore('dustSulfur')[0])
    .EUt(30)
    .duration(1296)
    .buildAndRegister()
electric_blast_furnace.recipeBuilder()
    .inputs(ore('dustMetallicPlatinum')*3)
    .outputs(ore('nuggetPlatinum')[0]*2)
    .EUt(120)
    .duration(600)
    .blastFurnaceTemp(2700)
    .buildAndRegister()

circuit_assembler.recipeBuilder()
    .outputs(item('gregtech_dingjen:micro_assembly'))//MV
    .inputs(metaitem('circuit_board.plastic'),
        metaitem('circuit.microprocessor')*2,
        ore('componentInductor')*2,
        ore('componentCapacitor')*4,
        metaitem('plate.random_access_memory') * 2,
        ore('wireFineRedAlloy')*4)
    .EUt(90)
    .duration(400)
    .buildAndRegister()
circuit_assembler.recipeBuilder()
    .outputs(item('gregtech_dingjen:micro_computer'))//HV
    .inputs(metaitem('circuit_board.plastic'),
        item('gregtech_dingjen:micro_assembly')*2,
        ore('componentDiode')*2,
        metaitem('plate.random_access_memory') * 2,
        ore('wireFineElectrum')*8,
        ore('boltBlueAlloy')*8)
    .EUt(90)
    .duration(400)
    .buildAndRegister()
// 工作站
circuit_assembler.recipeBuilder()
    .outputs(metaitem('circuit.workstation'))//EV
    .inputs(
        ore('frameGtAluminium')*2,
        item('gregtech_dingjen:micro_computer')*2,
        ore('componentInductor')*4,
        ore('componentCapacitor')*8,
        metaitem('plate.random_access_memory') * 8,
        ore('wireGtSinglePlatinum')*16
    )
    .EUt(120)
    .duration(800)
    .solderMultiplier(4)
    .buildAndRegister()
    /*
table_crafting.shapedBuilder()
    .tierAdvanced()
    //.replace()
    .output(metaitem('gregtech:circuit.workstation'))
    .matrix('AWRWA','SDHDS','RHBHR','SDHDS','AWRWA')
    .key('B',metaitem('gregtech:circuit_board.plastic'))
    .key('R',metaitem('gregtech:plate.random_access_memory'))
    .key('H',ore('circuitHv'))
    .key('A',ore('stickBlueAlloy'))
    .key('W',ore('wireGtSingleElectrum'))
    .key('S',ore('wireGtSingleTin'))
    .key('D',ore('componentDiode'))
    .register()*/

// 微型处理器 

circuit_assembler.recipeBuilder()
    .outputs(metaitem('circuit.microprocessor'))
    .inputs(metaitem('circuit_board.plastic'), metaitem('plate.central_processing_unit'), ore('componentResistor') * 2, ore('componentCapacitor') * 2, ore('componentTransistor') * 2, ore('wireFineCopper') * 2)
    .EUt(60)
    .duration(200)
    .buildAndRegister()