import mods.gregtech.mixer;
import mods.gregtech.assembler;
import mods.gregtech.centrifuge;
import mods.extendedcrafting.table_crafting;
import mods.gregtech.alloy_smelter;
import mods.gregtech.brewery;
import mods.gregtech.circuit_assembler;
mixer.recipeBuilder()
    .fluidOutputs(fluid("gtfo_butter")*1000)
    .fluidInputs(fluid("gtfo_stearin")*1000,fluid("milk")*100)
    .inputs(ore("dustVanillin"))
    .EUt(30)
    .duration(20)
    .buildAndRegister();
crafting.shapedBuilder()
    .output(item('gregtech_dingjen:twilight_gem'))
    .matrix('WCW','CGC','WCW')
    .key('C',ore('circuitLv'))
    .key('W',ore('cableGtSingleNetherite'))
    .key('G',ore('gemExquisiteDiamond'))
    .register()
// 生橡胶末 * 3
centrifuge.removeByInput(5, [metaitem('rubber_drop')], null)
crafting.shapedBuilder()
    .replace()
    .output(item('extendedcrafting:table_basic'))
    .matrix('MTM','WBW','MSM')
    .key('M',item('extendedcrafting:material', 14))
    .key('T',item('extendedcrafting:material', 8))
    .key('W',metaitem('gregtech:workbench'))
    .key('B',ore('blockSteel'))
    .key('S',ore('circuitLv'))
    .register()
crafting.remove("gregtech:electronic_circuit_mv")
table_crafting.shapedBuilder()
    .tierBasic()
    //.replace()
    .output(metaitem('gregtech:circuit.good_electronic'))
    .matrix('RPR','TBT','WTW')
    .key('R',ore('componentDiode'))
    .key('P',ore('plateNetherite'))
    .key('T',ore('circuitLv'))
    .key('B',metaitem('gregtech:circuit_board.good'))
    .key('W',ore('cableGtSingleCopper'))
    .register()
brewery.recipeBuilder()
    .fluidInputs(fluid('dye_pink')*288)
    .inputs(ore('slimeball'))
    .fluidOutputs(fluid('if.pink_slime')*375)
    .EUt(30)
    .duration(20)
    .buildAndRegister();
alloy_smelter.recipeBuilder()
    .inputs(ore('ingotIron'),ore('slimeballPink')*8)
    .outputs(ore('ingotPinkSlime')[0])
    .EUt(30)
    .duration(200)
    .buildAndRegister();
// NAND芯片

circuit_assembler.recipeBuilder()
    .outputs(metaitem('circuit.nand_chip'))
    .inputs(metaitem('circuit_board.good'),
        metaitem('plate.integrated_logic_circuit'),
        metaitem('plate.random_access_memory')*2,
        ore('componentCapacitor')*2,ore('componentTransistor')*2,
        ore('wireFineAnnealedCopper')*2)
    .EUt(16)
    .duration(200)
    .buildAndRegister()

// 集成逻辑电路
circuit_assembler.recipeBuilder()
    .outputs(metaitem('circuit.basic_integrated'))
    .inputs(metaitem('circuit_board.good'),metaitem('circuit.nand_chip')*2,ore('componentResistor')*2,ore('componentCapacitor')*4,ore('componentTransistor')*2,ore('wireFineAnnealedCopper')*4)
    .EUt(16)
    .duration(400)
    .buildAndRegister()

// 进阶集成电路 
circuit_assembler.recipeBuilder()
    .outputs(metaitem('circuit.advanced_integrated'))
    .inputs(metaitem('circuit_board.good')*2,metaitem('circuit.good_integrated')*2,metaitem('plate.random_access_memory') * 2, ore('componentTransistor') * 4, ore('wireFineElectrum') * 8, ore('boltAnnealedCopper') * 8)
    .EUt(30)
    .duration(800)
    .buildAndRegister()