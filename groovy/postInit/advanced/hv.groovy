import mods.gregtech.fluid_solidifier
import mods.gregtech.assembler
import mods.gregtech.circuit_assembler
import mods.gregtech.mixer
import mods.gregtech.autoclave
import mods.extendedcrafting.table_crafting;
import gregtech.api.metatileentity.multiblock.CleanroomType
autoclave.recipeBuilder()
    .outputs(ore('gemPulsatingCrystal')[0])
    .inputs(ore('gemDiamond'))
    .fluidInputs(fluid('pulsating_iron')*144)
    .EUt(480)
    .duration(1200)
    .buildAndRegister()
crafting.shapelessBuilder()
    .output(ore('gemTerrestrialArtifact')[0])
    .input(ore('gemExquisiteMalachite'),ore('gemExquisiteTanzanite'),ore('gemExquisiteOlivine'),
    ore('gemExquisiteSapphire'),ore('gemExquisiteRuby'),ore('gemExquisiteAmber'),
    ore('gemExquisiteTopaz'),ore('gemExquisiteEmerald'))
    .register()
fluid_solidifier.recipeBuilder()
    .outputs(ore('gemGalaxy')[0])
    .inputs(ore('gemTerrestrialArtifact'))
    .fluidInputs(fluid('manyullyn')*288)
    .duration(200)
    .EUt(480)
    .buildAndRegister()
assembler.removeByInput(340, [ore('plateCrackerGrahamUngraded')[0], metaitem('sensor.hv')], null)
assembler.recipeBuilder()
    .outputs(metaitem('gregtechfoodoption:food.graham_cracker'))
    .inputs(ore('plateCrackerGrahamUngraded'))
    .notConsumable(metaitem('sensor.hv'))
    .fluidInputs(fluid('galaxy')*1008)
    .EUt(480)
    .duration(100)
    .buildAndRegister()
mixer.recipeBuilder()
    .outputs(ore('dustNetherite')[0]*4)
    .inputs(ore('dustCobalt')*3,ore('dustAncientDebris'))
    .EUt(480)
    .duration(100)
    .buildAndRegister()

crafting.remove("gregtech:cleanroom")
table_crafting.shapedBuilder()
    .tierBasic()
    .output(metaitem('gregtech:cleanroom'))
    .matrix('FFF','RHR','MCM')
    .key('F',metaitem('item_filter'))
    .key('R',ore('rotorTitanium'))
    .key('H',metaitem('gregtech:hull.ev'))
    .key('M',metaitem('gregtech:electric.motor.ev'))
    .key('C',ore('circuitEv'))
    .register()
// 处理器主机

circuit_assembler.recipeBuilder()
    .outputs(item('gregtech_dingjen:computer'))
    .inputs([metaitem('circuit_board.plastic'), metaitem('circuit.assembly') * 2, ore('componentDiode') * 4, metaitem('plate.random_access_memory') * 4, ore('wireFineElectrum') * 16, ore('boltBlueAlloy') * 16])
    .EUt(360)
    .duration(400)
    .cleanroom(CleanroomType.CLEANROOM)
    .solderMultiplier(4)
    .buildAndRegister()
circuit_assembler.recipeBuilder()
    .outputs(metaitem('circuit.mainframe'))
    .inputs(ore('frameGtAluminium') * 2, item('gregtech_dingjen:computer') * 2, metaitem('component.inductor') * 8, metaitem('component.capacitor') * 16, metaitem('plate.random_access_memory') * 16, metaitem('wireGtSingleAnnealedCopper') * 16)
    .EUt(480)
    .duration(800)
    .cleanroom(CleanroomType.CLEANROOM)
    .solderMultiplier(2)
    .buildAndRegister()